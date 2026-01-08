# 🚀 Quick Start - Nyxis Loader for Sketchware Pro

## One-Page Reference

### 📦 What You Need
- Sketchware Pro (latest version)
- This repository files
- 10 minutes of time

### 📄 Files to Import

```
📂 project/
  ├─ MainActivity.java        → Main logic
  ├─ NativeInjector.java   → Injection code  
  ├─ activity_main.xml     → UI layout
  ├─ colors.xml            → Color theme
  ├─ strings.xml           → Text strings
  └─ AndroidManifest.xml   → Permissions
```

### ⚡ Super Quick Import

1. **Create Project**
   ```
   Name: Nyxis Loader
   Package: com.nyxis.loader
   Min SDK: 21
   ```

2. **Import Layout**
   - Design View → XML Mode
   - Paste `activity_main.xml`

3. **Add Code**
   - Logic View → Paste `MainActivity.java`
   - Add Java Class → `NativeInjector.java`

4. **Add Resources**
   - Colors from `colors.xml`
   - Strings from `strings.xml`

5. **Set Permissions**
   - INTERNET ☑
   - WRITE_EXTERNAL_STORAGE ☑
   - READ_EXTERNAL_STORAGE ☑

6. **Build APK**
   - Menu → Build APK → Done! 🎉

### 🎯 Key Configuration

**Library URL** (MainActivity.java line 15):
```java
https://raw.githubusercontent.com/chrisiverrr266-bot/My-libs-/main/libNyxisCheat.so
```

**Telegram Links** (MainActivity.java lines 17-18):
```java
Discussion: https://t.me/indradiscussion
Contact: https://t.me/iinddra
```

### 🛠 Troubleshooting

| Problem | Solution |
|---------|----------|
| Build fails | Check package name is `com.nyxis.loader` |
| Missing R | Rebuild project (Menu → Clean) |
| Crash on start | Verify all button IDs match |
| Download fails | Add INTERNET permission |

### 🎨 Colors Reference

```xml
Primary Green: #00FF88
Dark Background: #0a0a0a
Card Background: #1a1a1a
Telegram Blue: #00A8FF
Gray Text: #888888
```

### 📝 Component IDs

```java
@id/tvStatus    - Status text view
@id/btnInject   - Main inject button
@id/btnSupport  - Telegram support button
@id/btnContact  - Telegram contact button
```

### 📱 App Features

✅ Downloads lib from GitHub automatically
✅ Supports root and non-root devices
✅ Telegram community integration
✅ Modern dark UI with Nyxis branding
✅ Real-time status updates

### 🔗 Important Links

- **Full Guide**: See `SKETCHWARE_GUIDE.md`
- **Support**: [t.me/indradiscussion](https://t.me/indradiscussion)
- **Contact**: [t.me/iinddra](https://t.me/iinddra)
- **Repository**: [github.com/chrisiverrr266-bot/Nyxis-Loader-Sketchware](https://github.com/chrisiverrr266-bot/Nyxis-Loader-Sketchware)

### ⏱ Build Time

- Import: 5 minutes
- First build: 5-10 minutes  
- Subsequent builds: 2-3 minutes

---

**Made with ❤ by Nyxis** • **Build APKs on your phone!**