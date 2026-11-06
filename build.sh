#!/bin/bash
# ─── DirBrute Build Script ────────────────────────────────────
echo "[*] Compiling DirBrute..."
mkdir -p out

javac -d out main/java/com/dirbrute/DirBrute.java

if [ $? -ne 0 ]; then
    echo "[!] Compilation failed."
    exit 1
fi

echo "[*] Packaging JAR..."
jar cfm DirBrute.jar manifest.txt -C out .

echo ""
echo "[+] Build successful! Run with:"
echo "    java -jar DirBrute.jar <url> <wordlist> [threads] [timeout_ms]"
echo ""
echo "Example:"
echo "    java -jar DirBrute.jar http://example.com wordlists/common.txt 20 3000"
