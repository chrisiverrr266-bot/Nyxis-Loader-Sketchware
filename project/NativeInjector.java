package com.nyxis.loader;

import java.io.*;

public class NativeInjector {

    public static boolean inject(String packageName, String libPath) {
        // Check if library exists
        File libFile = new File(libPath);
        if (!libFile.exists()) {
            return false;
        }
        
        // Check for root access
        if (isRootAvailable()) {
            return injectWithRoot(packageName, libPath);
        } else {
            return injectVirtual(packageName, libPath);
        }
    }
    
    private static boolean isRootAvailable() {
        try {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            os.writeBytes("exit\n");
            os.flush();
            os.close();
            process.waitFor();
            return process.exitValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static boolean injectWithRoot(String packageName, String libPath) {
        try {
            // Get process ID
            int pid = getProcessId(packageName);
            if (pid == -1) {
                return false;
            }
            
            // Execute root commands
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(process.getOutputStream());
            
            // Copy library to temp location
            String targetPath = "/data/local/tmp/libNyxisCheat.so";
            os.writeBytes("cp " + libPath + " " + targetPath + "\n");
            os.writeBytes("chmod 755 " + targetPath + "\n");
            
            // Restart target app with library
            os.writeBytes("am force-stop " + packageName + "\n");
            os.writeBytes("sleep 1\n");
            os.writeBytes("am start -n " + packageName + "/.MainActivity\n");
            
            os.writeBytes("exit\n");
            os.flush();
            os.close();
            
            process.waitFor();
            return process.exitValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static boolean injectVirtual(String packageName, String libPath) {
        try {
            // Use LD_PRELOAD technique
            ProcessBuilder pb = new ProcessBuilder();
            pb.environment().put("LD_PRELOAD", libPath);
            
            String startCmd = "am start -n " + packageName + "/.MainActivity";
            Process process = pb.command("sh", "-c", startCmd).start();
            
            process.waitFor();
            return process.exitValue() == 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static int getProcessId(String packageName) {
        try {
            Process process = Runtime.getRuntime().exec("ps");
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
            
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(packageName)) {
                    String[] parts = line.trim().split("\\s+");
                    if (parts.length > 1) {
                        try {
                            return Integer.parseInt(parts[1]);
                        } catch (NumberFormatException e) {
                            return Integer.parseInt(parts[0]);
                        }
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            // Ignore
        }
        return -1;
    }
}