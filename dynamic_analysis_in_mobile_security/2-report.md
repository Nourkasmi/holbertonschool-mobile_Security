# Task 2 - Android Cryptography Challenge: Report

## Objective
Intercept and decrypt encrypted data processed by an Android application to extract a hidden flag.

## Tools Used
- JADX (static decompilation)
- Python3 (cryptographic simulation)
- ADB (Android Debug Bridge)

## Step-by-Step Process

### 1. Static Analysis with JADX
Decompiled the APK using JADX:
- Package: `com.holberton.task3`
- Main logic found in: `MainActivityKt.java`

### 2. Identifying the Cryptographic Functions
Three key functions were identified in `MainActivityKt.java`:

#### `performslowDecryption()`
```java
public static final String performslowDecryption() {
    byte[] decoded = Base64.getDecoder().decode(
        "cVZaW1dDQllZTFdRW1xeUlBbX21CWFtHalRZXUJFRFhNX1ZcbllGQ15cUUNSRFpcVks="
    );
    return xorDecrypt(new String(decoded, UTF_8), String.valueOf(slowRecursive(150)));
}
```
This function:
- Base64 decodes a hardcoded encrypted string
- Uses the result of `slowRecursive(150)` as the XOR key

#### `slowRecursive(int n)`
```java
public static final long slowRecursive(int i) {
    return i <= 1 ? i : slowRecursive(i - 1) + slowRecursive(i - 2);
}
```
This is a recursive Fibonacci function. It is intentionally slow
(exponential time complexity) to delay decryption — hence the name.

#### `xorDecrypt(String encryptedFlag, String key)`
XORs each character of the encrypted string with the corresponding
character of the key (cycling through the key if needed).

### 3. Cryptographic Analysis

| Component | Details |
|-----------|---------|
| Encoding | Base64 |
| Cipher | XOR |
| Key | String representation of Fibonacci(150) |
| Key weakness | Hardcoded, deterministic, derived from known algorithm |

### 4. Decryption Process
Simulated the full decryption in Python:

**Step 1 - Base64 decode:**