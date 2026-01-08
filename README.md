# Nyxis Loader - Sketchware Pro Edition 🚀

<div align="center">

![Platform](https://img.shields.io/badge/platform-Sketchware%20Pro-blue)
![Version](https://img.shields.io/badge/version-1.0-green)
![Build](https://img.shields.io/badge/build-ready-success)

**Advanced Android Game Library Injector**

*Build directly on your Android device with Sketchware Pro!*

[📱 Join Discussion](https://t.me/indradiscussion) • [💬 Contact Dev](https://t.me/iinddra)

</div>

---

## ✨ Features

- 🚀 **Easy Build**: Compile directly in Sketchware Pro on Android
- 📥 **Auto Download**: Downloads libraries from GitHub automatically
- 🔐 **Root & Virtual**: Supports both rooted and non-root devices
- 🎮 **CODM Ready**: Optimized for Call of Duty Mobile
- 🎨 **Premium UI**: Modern dark theme with Nyxis branding
- 💬 **Community**: Direct Telegram integration

## 📱 Requirements

- **Sketchware Pro** (latest version)
- Android 5.0+ device
- Internet connection

## 📥 Import to Sketchware Pro

### Method 1: Manual Import (Recommended)

1. **Download Project Files**
   - Download all files from this repository
   - Or clone: `git clone https://github.com/chrisiverrr266-bot/Nyxis-Loader-Sketchware.git`

2. **Open Sketchware Pro**
   - Tap **+** (New Project)
   - Select **"Import Project"**

3. **Create New Project First**
   - App Name: **Nyxis Loader**
   - Package Name: **com.nyxis.loader**
   - Min SDK: **21 (Android 5.0)**
   - Target SDK: **34**

4. **Import Files**
   - Copy `activity_main.xml` → Design View or XML
   - Copy `MainActivity.java` → Logic View
   - Copy `NativeInjector.java` → Add as new Java file
   - Import `colors.xml`, `strings.xml`, `styles.xml` → Resources

### Method 2: Direct Code Input

1. **Create New Project in Sketchware Pro**
   - App Name: `Nyxis Loader`
   - Package: `com.nyxis.loader`

2. **Design the Layout**
   - Switch to XML view
   - Paste contents of `activity_main.xml`

3. **Add Java Logic**
   - Go to Logic View
   - Paste `MainActivity.java` code
   - Add `NativeInjector.java` as custom class

4. **Add Resources**
   - Add colors from `colors.xml`
   - Add strings from `strings.xml`
   - Set theme from `styles.xml`

5. **Set Permissions in AndroidManifest**
   - INTERNET
   - WRITE_EXTERNAL_STORAGE
   - READ_EXTERNAL_STORAGE

## 🔨 Building the APK

### In Sketchware Pro:

1. **Check for Errors**
   - Tap **Run** icon
   - Fix any red errors shown

2. **Build APK**
   - Tap **Menu** (3 dots)
   - Select **"Build APK"**
   - Wait for compilation

3. **Find Your APK**
   - Location: `/storage/emulated/0/sketchware/mysc/Nyxis Loader/app/build/outputs/apk/debug/`
   - Or check notification for direct install

### Build Time:
- First build: 5-10 minutes
- Subsequent builds: 2-3 minutes

## 📱 Using the App

1. **Install APK** on your device
2. **Grant Permissions** when prompted
3. **Tap "INJECT LIBRARY"**
   - Downloads `libNyxisCheat.so` from GitHub
   - Automatically injects into Call of Duty Mobile
4. **Connect via Telegram**
   - Support button → Discussion group
   - Contact button → Direct message

## 📂 Project Structure

```
Nyxis-Loader-Sketchware/
├── project/
│   ├── MainActivity.java          # Main app logic
│   ├── NativeInjector.java       # Injection code
│   ├── activity_main.xml         # UI layout
│   ├── AndroidManifest.xml       # App manifest
│   ├── colors.xml                # Color resources
│   ├── strings.xml               # String resources
│   └── styles.xml                # App theme
├── SKETCHWARE_GUIDE.md           # Detailed import guide
└── README.md                     # This file
```

## 🎯 Customization

### Change Library URL

In `MainActivity.java`, line 15:
```java
private static final String LIB_URL = "YOUR_GITHUB_RAW_URL";
```

### Change Target Game

In `MainActivity.java`, line 16:
```java
private static final String GAME_PACKAGE = "your.game.package";
```

### Change Telegram Links

In `MainActivity.java`, lines 17-18:
```java
private static final String TELEGRAM_DISCUSSION = "https://t.me/yourgroup";
private static final String TELEGRAM_CONTACT = "https://t.me/yourusername";
```

### Customize Colors

Edit `colors.xml`:
```xml
<color name="nyxis_green">#00FF88</color>  <!-- Change this -->
<color name="nyxis_dark">#0a0a0a</color>   <!-- And this -->
```

## 🐛 Troubleshooting

### Sketchware Build Errors

**Error: "Cannot resolve symbol R"**
- Solution: Make sure all resources are properly imported
- Rebuild project: Menu → Clean → Build

**Error: "Package does not exist"**
- Solution: Check package name matches everywhere
- Should be `com.nyxis.loader`

**Error: "Missing permissions"**
- Solution: Add permissions in AndroidManifest.xml
- Use Sketchware's permission manager

### Runtime Errors

**App crashes on start**
- Check logcat in Sketchware
- Ensure all IDs match between XML and Java

**Download fails**
- Check internet permission
- Verify GitHub URL is correct

**Injection fails**
- Root access required for best results
- Try on rooted device or virtual environment

## 📖 Additional Resources

- **Sketchware Pro Guide**: See `SKETCHWARE_GUIDE.md`
- **Video Tutorial**: (Coming soon)
- **Support Group**: [t.me/indradiscussion](https://t.me/indradiscussion)

## ✨ Why Sketchware Pro?

✅ **Build on Android** - No PC needed
✅ **Easy to Use** - Visual + code editing
✅ **Fast Compilation** - Builds in minutes
✅ **No AAPT2 Issues** - Works perfectly
✅ **Portable** - Edit anywhere on your phone

## 💬 Community

- **Discussion Group**: [t.me/indradiscussion](https://t.me/indradiscussion)
- **Direct Contact**: [t.me/iinddra](https://t.me/iinddra)
- **GitHub Issues**: [Report bugs here](https://github.com/chrisiverrr266-bot/Nyxis-Loader-Sketchware/issues)

## ⚠️ Disclaimer

**Educational Purpose Only**

This tool is for educational and research purposes. Users must comply with:
- Game Terms of Service
- Local laws and regulations
- Anti-cheat policies

## 📄 License

MIT License - Free to use and modify

## 🌟 Credits

**Made with ❤️ by Nyxis**

- Design: Nyxis Team
- Platform: Sketchware Pro
- Community: Android Modding Community

---

<div align="center">

### 🚀 Ready to Build?

⭐ **Star this repo** • 👁 **Watch for updates** • 💔 **Fork to customize**

**Sketchware Pro Edition - Build APKs directly on your phone!**

</div>