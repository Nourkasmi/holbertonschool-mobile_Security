# Task 3 - Revealing Hidden Functions: Report

## Objective
Locate and invoke a hidden function in an Android application that is never called during normal execution, in order to extract a secret flag.

## Tools Used
- JADX (static decompilation)
- Python3 (flag decryption simulation)
- ADB (Android Debug Bridge)

## Step-by-Step Process

### 1. Static Analysis with JADX
Decompiled the APK using JADX:
- Package: `com.holberton.task4_d`
- Main files: `MainActivity.java`, `MainActivityKt.java`

### 2. Identifying the Hidden Function
In `MainActivityKt.java`, a suspicious method was found with an obfuscated name:

```java