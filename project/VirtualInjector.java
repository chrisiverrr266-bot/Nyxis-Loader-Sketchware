package com.nyxis.loader;

import java.io.*;
import java.util.*;
import android.content.*;
import android.os.*;

/**
 * Advanced Virtual Environment Injector
 * Supports: VirtualXposed, VMOS, Parallel Space, etc.
 */
public class VirtualInjector {

    // Common virtual environment package names
    private static final String[] VIRTUAL_PACKAGES = {
        "io.va.exposed",              // VirtualXposed
        "com.vmos.pro",               // VMOS Pro
        "com.lbe.parallel.intl",      // Parallel Space
        "com.ludashi.dualspace",      // Dual Space
        "com.oasisfeng.island",       // Island
        "com.excelliance.multiaccounts" // Multiple Accounts
    };

    /**
     * Inject library into virtual environment
     */
    public static boolean injectIntoVirtual(Context context, String targetPackage, String libPath) {
        // Detect which virtual environment is installed
        String virtualPackage = detectVirtualEnvironment(context);
        
        if (virtualPackage == null) {
            return false;
        }
        
        // Copy library to virtual accessible location
        String virtualLibPath = copyToVirtualPath(libPath, virtualPackage);
        
        if (virtualLibPath == null) {
            return false;
        }
        
        // Configure virtual environment to load library
        switch (virtualPackage) {
            case "io.va.exposed":
                return injectVirtualXposed(context, targetPackage, virtualLibPath);
            case "com.vmos.pro":
                return injectVMOS(targetPackage, virtualLibPath);
            default:
                return injectGenericVirtual(targetPackage, virtualLibPath);
        }
    }

    /**
     * Detect installed virtual environment
     */
    private static String detectVirtualEnvironment(Context context) {
        PackageManager pm = context.getPackageManager();
        
        for (String packageName : VIRTUAL_PACKAGES) {
            try {
                pm.getPackageInfo(packageName, 0);
                return packageName; // Found virtual environment
            } catch (Exception e) {
                // Not installed, continue
            }
        }
        return null;
    }

    /**
     * Copy library to virtual-accessible path
     */
    private static String copyToVirtualPath(String libPath, String virtualPackage) {
        try {
            File sourceFile = new File(libPath);
            
            // Virtual environments can access /sdcard/
            File destDir = new File(Environment.getExternalStorageDirectory(), 
                "NyxisLoader/libs");
            destDir.mkdirs();
            
            File destFile = new File(destDir, "libNyxisCheat.so");
            
            // Copy file
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            
            byte[] buffer = new byte[4096];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            
            fis.close();
            fos.close();
            
            return destFile.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Inject into VirtualXposed
     */
    private static boolean injectVirtualXposed(Context context, String targetPackage, String libPath) {
        try {
            // Create configuration file for VirtualXposed
            File configDir = new File(Environment.getExternalStorageDirectory(),
                "VirtualXposed/config");
            configDir.mkdirs();
            
            File configFile = new File(configDir, targetPackage + ".conf");
            FileWriter writer = new FileWriter(configFile);
            
            // Write injection config
            writer.write("# Nyxis Loader Configuration\n");
            writer.write("LIBRARY_PATH=" + libPath + "\n");
            writer.write("INJECTION_METHOD=LD_PRELOAD\n");
            writer.write("AUTO_INJECT=true\n");
            
            writer.close();
            
            // Launch target app in VirtualXposed with library
            Intent intent = new Intent();
            intent.setClassName("io.va.exposed", "io.va.exposed.ui.VirtualXposedActivity");
            intent.putExtra("package_name", targetPackage);
            intent.putExtra("library_path", libPath);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            
            context.startActivity(intent);
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Inject into VMOS
     */
    private static boolean injectVMOS(String targetPackage, String libPath) {
        try {
            // VMOS uses a different approach - modify init script
            File vmosDir = new File(Environment.getExternalStorageDirectory(),
                "vmos/custom");
            vmosDir.mkdirs();
            
            File initScript = new File(vmosDir, "init.sh");
            FileWriter writer = new FileWriter(initScript, true);
            
            // Add LD_PRELOAD to init script
            writer.write("\n# Nyxis Loader\n");
            writer.write("export LD_PRELOAD=" + libPath + "\n");
            writer.write("am start -n " + targetPackage + "/.MainActivity\n");
            
            writer.close();
            
            // Make executable
            Runtime.getRuntime().exec("chmod 755 " + initScript.getAbsolutePath());
            
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Generic virtual environment injection
     */
    private static boolean injectGenericVirtual(String targetPackage, String libPath) {
        try {
            // Create LD_PRELOAD configuration
            File preloadFile = new File(Environment.getExternalStorageDirectory(),
                "NyxisLoader/preload.conf");
            
            FileWriter writer = new FileWriter(preloadFile);
            writer.write(libPath);
            writer.close();
            
            // Try to set environment variable
            ProcessBuilder pb = new ProcessBuilder();
            Map<String, String> env = pb.environment();
            env.put("LD_PRELOAD", libPath);
            
            // Launch target
            pb.command("am", "start", "-n", targetPackage + "/.MainActivity");
            Process process = pb.start();
            process.waitFor();
            
            return process.exitValue() == 0;
            
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Setup auto-load for cloned apps
     */
    public static boolean setupAutoLoad(Context context, String targetPackage, String libPath) {
        try {
            // Create autoload configuration
            File autoloadDir = new File(Environment.getExternalStorageDirectory(),
                "NyxisLoader/autoload");
            autoloadDir.mkdirs();
            
            File configFile = new File(autoloadDir, targetPackage + ".json");
            FileWriter writer = new FileWriter(configFile);
            
            // JSON configuration
            writer.write("{\n");
            writer.write("  \"package\": \"" + targetPackage + "\",\n");
            writer.write("  \"library\": \"" + libPath + "\",\n");
            writer.write("  \"auto_inject\": true,\n");
            writer.write("  \"show_menu\": true,\n");
            writer.write("  \"method\": \"LD_PRELOAD\"\n");
            writer.write("}\n");
            
            writer.close();
            
            // Create trigger script
            File triggerScript = new File(autoloadDir, "trigger.sh");
            FileWriter scriptWriter = new FileWriter(triggerScript);
            
            scriptWriter.write("#!/system/bin/sh\n");
            scriptWriter.write("# Nyxis Auto-Loader\n\n");
            scriptWriter.write("PACKAGE=" + targetPackage + "\n");
            scriptWriter.write("LIB=" + libPath + "\n\n");
            scriptWriter.write("export LD_PRELOAD=$LIB\n");
            scriptWriter.write("am start -n $PACKAGE/.MainActivity\n");
            
            scriptWriter.close();
            
            // Make executable
            Runtime.getRuntime().exec("chmod 755 " + triggerScript.getAbsolutePath());
            
            return true;
            
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Check if app is running in virtual environment
     */
    public static boolean isRunningInVirtual() {
        try {
            // Check for virtual environment indicators
            String[] virtualIndicators = {
                "/data/data/io.va.exposed",
                "/data/data/com.vmos.pro",
                "/system/lib/libva.so",
                "/proc/self/cmdline"
            };
            
            for (String indicator : virtualIndicators) {
                File file = new File(indicator);
                if (file.exists()) {
                    return true;
                }
            }
            
            // Check process name
            BufferedReader reader = new BufferedReader(
                new FileReader("/proc/self/cmdline"));
            String cmdline = reader.readLine();
            reader.close();
            
            if (cmdline != null) {
                for (String virtualPkg : VIRTUAL_PACKAGES) {
                    if (cmdline.contains(virtualPkg)) {
                        return true;
                    }
                }
            }
            
        } catch (Exception e) {
            // Ignore
        }
        return false;
    }
}