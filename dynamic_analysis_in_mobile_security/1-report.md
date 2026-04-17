# Task 1 - Hooking Native Functions in Android: Report

## Objective
Extract the hidden flag from a native function (`getSecretMessage`) in an Android APK using dynamic and static analysis techniques.

## Tools Used
- JADX (static decompilation)
- APKTool (APK decompilation and repackaging)
- Frida + Frida Gadget (dynamic instrumentation)
- ADB (Android Debug Bridge)
- aarch64-linux-gnu-objdump (ARM64 disassembly)
- Python3 (flag decryption simulation)

## Step-by-Step Process

### 1. Static Analysis with JADX
Decompiled the APK using JADX to identify the target class and method:
- Package: `com.holberton.task2_d`
- Native method: `getSecretMessage()` declared in `MainActivity.java`
- Native library: `libnative-lib.so` loaded via `System.loadLibrary("native-lib")`

### 2. APK Patching with Frida Gadget
Since the device was not rooted, frida-server could not be used directly.
Instead, the APK was patched to embed the Frida Gadget:
- Decompiled APK with APKTool
- Downloaded `frida-gadget-16.2.1-android-arm64.so`
- Injected gadget loader into `MainActivity.smali` static constructor
- Set `android:extractNativeLibs="true"` in `AndroidManifest.xml`
- Rebuilt, zipaligned, and signed with `apksigner`
- Reinstalled the patched APK via ADB

### 3. Frida Gadget Limitation
The Frida Gadget failed to create a socket on the non-rooted device:
This prevented live hooking via the listen/script interaction modes.

### 4. Static Analysis of Native Library
Switched to static analysis of `libnative-lib.so` using ARM64 disassembly:
- Identified encrypted data at binary offset `0x570` (49 bytes)
- Identified a custom function `lit` called during decryption loop

### 5. Reverse Engineering the Decryption Algorithm
Disassembled the `getSecretMessage` function and found:
- It loads 49 encrypted bytes from offset `0x570`
- For each byte at index `i`, it calls `lit(i % 10)` and subtracts the result

Disassembled the `lit` function and identified it as a **Fibonacci number generator**:
- `lit(0)` = 0, `lit(1)` = 1, `lit(n)` = `lit(n-1)` + `lit(n-2)`
- Fibonacci sequence for indices 0-9: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]

### 6. Flag Decryption
Simulated the decryption in Python:
```python
def lit(n):
    if n <= 1:
        return n
    a, b = 0, 1
    for i in range(2, n + 1):
        a, b = b, a + b
    return b

for i, byte in enumerate(encrypted_data):
    decrypted = byte - lit(i % 10)
```

## Flag