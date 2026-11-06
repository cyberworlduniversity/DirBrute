# 🔍 DirBrute — Directory Brute Force Tool

> **For authorized security testing and CTF challenges only.**  
> Never use this tool against systems you do not have explicit written permission to test.

---

## 📌 Overview

**DirBrute** is a fast, multithreaded Java tool for discovering hidden directories and files on web servers. It helps penetration testers and security researchers identify exposed admin panels, backup files, configuration pages, and other sensitive paths.

---

## ✨ Features

| Feature | Details |
|---|---|
| ⚡ Multithreading | Configurable thread count for high-speed scanning |
| 📄 Wordlist Support | Load any custom `.txt` wordlist |
| 🔎 Status Code Detection | Detects `200 OK`, `301/302 Redirect`, `403 Forbidden` |
| 🎨 Color Output | Color-coded terminal output for quick analysis |
| ⏱️ Timeout Control | Configurable per-request timeout |
| 📊 Summary Report | Clean results summary at end of scan |

---

## 🛠️ Requirements

- **Java 11** or higher
- No external dependencies (uses only Java standard library)

---

## 🚀 Build Instructions

### Linux / macOS
```bash
chmod +x build.sh
./build.sh
```

### Windows
```bat
build.bat
```

### Maven (any OS)
```bash
mvn --batch-mode package
```

The JAR is created in `target/`. You can also use the included `build.sh` or `build.bat` scripts.

---

## 💻 Usage

```bash
java -jar DirBrute.jar <url> <wordlist> [threads] [timeout_ms]
```

### Arguments

| Argument | Required | Default | Description |
|---|---|---|---|
| `<url>` | ✅ Yes | — | Target base URL (e.g. `http://example.com`) |
| `<wordlist>` | ✅ Yes | — | Path to wordlist file |
| `[threads]` | ❌ No | `20` | Number of concurrent threads |
| `[timeout_ms]` | ❌ No | `3000` | Request timeout in milliseconds |

---

## 📖 Examples

```bash
# Basic scan with defaults
java -jar DirBrute.jar http://example.com wordlists/common.txt

# Fast scan with 50 threads
java -jar DirBrute.jar http://example.com wordlists/common.txt 50

# Custom timeout (5 seconds)
java -jar DirBrute.jar http://example.com wordlists/common.txt 20 5000

# Scan a specific subdirectory
java -jar DirBrute.jar http://example.com/api/ wordlists/common.txt 30 2000
```

---

## 🗂️ Sample Output

```
  ____  _      ____             _
 |  _ \(_)_ __| __ ) _ __ _   _| |_ ___
 | | | | | '__|  _ \| '__| | | | __/ _ \
 | |_| | | |  | |_) | |  | |_| | ||  __/
 |____/|_|_|  |____/|_|   \__,_|\__\___|

  Directory Brute Force Tool  v1.0

[*] Target   : http://example.com/
[*] Wordlist : wordlists/common.txt (150 entries)
[*] Threads  : 20
[*] Timeout  : 3000ms
[*] Starting scan...

[200 FOUND]     http://example.com/admin
[403 FORBIDDEN] http://example.com/backup
[301 REDIRECT]  http://example.com/login -> http://example.com/login/

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 Scan Complete
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
 Total checked : 150 / 150
 Interesting   : 3
 Time elapsed  : 4.32s

 Results:
  [200] http://example.com/admin
  [403] http://example.com/backup
  [301] http://example.com/login -> http://example.com/login/
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

---

## 📁 Project Structure

```
DirBrute/
├── main/
│   └── main/java/com/dirbrute/
│       └── DirBrute.java       # Main scanner
├── wordlists/
│   └── common.txt              # Built-in wordlist (150+ paths)
├── manifest.txt                # JAR manifest
├── pom.xml                     # Maven build (optional)
├── build.sh                    # Linux/macOS build script
├── build.bat                   # Windows build script
└── README.md                   # This file
```

---

## 📋 Wordlist Format

Plain text file, one path per line. Lines starting with `#` are treated as comments.

```
# This is a comment
admin
login
backup
api/v1
```

---

## ⚠️ Legal Disclaimer

This tool is intended **strictly for**:
- Authorized penetration testing
- Bug bounty programs (within scope)
- CTF (Capture The Flag) challenges
- Testing your own servers/applications

**Unauthorized use against systems you do not own or have written permission to test is illegal and unethical.**  
The author takes no responsibility for misuse of this tool.

---

## 👤 Author

**hemanathan115**  
GitHub: [github.com/hemanathan115](https://github.com/hemanathan115)
