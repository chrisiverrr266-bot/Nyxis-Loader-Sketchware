# Complete Sketchware Pro Import Guide

## Step-by-Step Tutorial

### Part 1: Create New Project

1. **Open Sketchware Pro**
   - Tap the **+** button

2. **Project Setup**
   ```
   App Name: Nyxis Loader
   Package Name: com.nyxis.loader
   Minimum SDK: API 21 (Android 5.0)
   Target SDK: API 34
   ```

3. **Project Type**
   - Select **Single Activity**
   - Activity Name: `MainActivity`

### Part 2: Design View (Layout)

#### Option A: Using XML (Easiest)

1. **Switch to XML Mode**
   - In Design View, tap **View** menu
   - Select **XML Editor**

2. **Paste Layout Code**
   - Delete existing XML
   - Copy entire `activity_main.xml` from repository
   - Paste into XML editor
   - Save

#### Option B: Manual Design (Visual)

1. **Root Layout**
   - Linear Layout (Vertical)
   - Background: `#0a0a0a`
   - Padding: 20dp all sides

2. **Header Card**
   - Add Linear Layout
   - Background: `#1a1a1a`
   - Padding: 24dp
   - Add TextViews:
     - "NYXIS" (42sp, bold, #00FF88)
     - "L O A D E R" (16sp, #888888)

3. **Status Card**
   - Linear Layout
   - Background: `#2a2a2a`
   - Add TextView with ID: `tvStatus`

4. **Buttons**
   - Add Button with ID: `btnInject`
   - Add Button with ID: `btnSupport`
   - Add Button with ID: `btnContact`

### Part 3: Logic View (Java Code)

1. **Open Logic View**
   - Tap **Logic** icon

2. **Add Main Code**
   - Switch to **Text Mode** (if available)
   - Or use **Block Mode** and add custom blocks

3. **Add onCreate Method**
   ```java
   // Copy from MainActivity.java
   // Lines for findViewById, setOnClickListener
   ```

4. **Add Custom Methods**
   - `startInjection()`
   - `downloadLibrary()`
   - `injectLibrary()`
   - `updateStatus()`
   - `openTelegram()`
   - `showToast()`

### Part 4: Add Custom Java Class

1. **Create New Java File**
   - Menu → **More** → **Add Java Class**
   - Class Name: `NativeInjector`

2. **Paste Injector Code**
   - Copy entire `NativeInjector.java`
   - Paste into new class
   - Save

### Part 5: Resources

#### Colors

1. **Open Resource Manager**
   - Menu → **Resources** → **Colors**

2. **Add Colors**
   ```xml
   colorPrimary: #00FF88
   colorPrimaryDark: #00CC6A
   nyxis_green: #00FF88
   nyxis_dark: #0a0a0a
   telegram_blue: #00A8FF
   ```

#### Strings

1. **Open Strings**
   - Menu → **Resources** → **Strings**

2. **Add Strings**
   ```xml
   app_name: Nyxis Loader
   inject_button: INJECT LIBRARY
   status_ready: Ready to inject
   downloading: Downloading library from GitHub...
   injecting: Injecting into Call of Duty Mobile...
   success: ✓ Injection successful!
   ```

#### Styles

1. **Open Styles**
   - Menu → **Resources** → **Themes**

2. **Set Theme**
   - Parent: `Theme.Material.Light.NoActionBar`
   - Primary Color: `#00FF88`
   - Dark Primary: `#00CC6A`
   - Background: `#0a0a0a`

### Part 6: Permissions

1. **Open AndroidManifest Editor**
   - Menu → **Project Settings** → **Permissions**

2. **Add Permissions**
   - ☑ INTERNET
   - ☑ WRITE_EXTERNAL_STORAGE
   - ☑ READ_EXTERNAL_STORAGE

### Part 7: Additional Settings

1. **App Settings**
   - Menu → **Project Settings**
   - App Icon: Upload custom icon (optional)
   - Version Code: 1
   - Version Name: 1.0

2. **Build Settings**
   - Min SDK: 21
   - Target SDK: 34
   - Build Tools: Latest

### Part 8: Testing & Building

#### Test Run

1. **Connect Device or Emulator**
   - Enable USB Debugging
   - Or use Sketchware's built-in emulator

2. **Run App**
   - Tap **Run** (▶️) button
   - Check for errors
   - Fix any issues shown

#### Build APK

1. **Final Build**
   - Menu → **Build APK**
   - Select **Debug** or **Release**
   - Wait for compilation

2. **Locate APK**
   - Path shown in success message
   - Usually: `/storage/emulated/0/sketchware/...`

3. **Install & Test**
   - Tap notification to install
   - Or use file manager

## Quick Import Checklist

- [ ] Project created with correct package name
- [ ] Layout XML imported or designed
- [ ] MainActivity.java code added
- [ ] NativeInjector.java class added
- [ ] Colors added to resources
- [ ] Strings added to resources
- [ ] Theme configured
- [ ] Permissions added to manifest
- [ ] No errors in error panel
- [ ] Test run successful
- [ ] APK builds successfully

## Common Mistakes to Avoid

❌ **Wrong Package Name**
- Must be exactly `com.nyxis.loader`

❌ **Missing IDs**
- Ensure `tvStatus`, `btnInject`, etc. match

❌ **Forgot Permissions**
- App will crash without INTERNET permission

❌ **Resources Not Imported**
- Colors and strings must be added

❌ **Old Sketchware Version**
- Use latest Sketchware Pro for best results

## Pro Tips

💡 **Save Often**
- Sketchware can crash, save frequently

💡 **Use XML Mode**
- Faster to paste XML than manual design

💡 **Test Incrementally**
- Test after adding each major component

💡 **Check Logcat**
- Use built-in logcat for debugging

💡 **Backup Project**
- Menu → Export → Save .sketchware file

## Video Tutorial

*(Coming Soon)*

Subscribe to get notified:
- YouTube: (Link pending)
- Telegram: [t.me/indradiscussion](https://t.me/indradiscussion)

## Need Help?

**Get Support:**
- Telegram Group: [t.me/indradiscussion](https://t.me/indradiscussion)
- Direct Contact: [t.me/iinddra](https://t.me/iinddra)
- GitHub Issues: Report bugs

## Success!

If you followed all steps correctly, you should now have:
- ✅ Working Nyxis Loader APK
- ✅ Built entirely on your Android device
- ✅ Ready to use with Call of Duty Mobile

Enjoy! 🎉