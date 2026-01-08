package com.nyxis.loader;

import android.app.*;
import android.content.*;
import android.os.*;
import java.io.*;

/**
 * Background service to auto-load library when target app starts
 */
public class AutoLoadService extends Service {

    private BroadcastReceiver appLaunchReceiver;
    private String targetPackage = "com.activision.callofduty.shooter";
    private String libPath;

    @Override
    public void onCreate() {
        super.onCreate();
        
        // Get library path
        libPath = new File(getExternalFilesDir(null), "libNyxisCheat.so").getAbsolutePath();
        
        // Register receiver for app launches
        appLaunchReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String packageName = intent.getData().getSchemeSpecificPart();
                
                if (targetPackage.equals(packageName)) {
                    // Target app launched, inject library
                    injectOnLaunch();
                }
            }
        };
        
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_PACKAGE_ADDED);
        filter.addAction(Intent.ACTION_PACKAGE_REPLACED);
        filter.addDataScheme("package");
        
        registerReceiver(appLaunchReceiver, filter);
        
        // Start foreground notification
        startForeground();
    }

    private void startForeground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                "nyxis_loader",
                "Nyxis Loader",
                NotificationManager.IMPORTANCE_LOW
            );
            
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        
        Notification notification = new Notification.Builder(this, "nyxis_loader")
            .setContentTitle("Nyxis Loader")
            .setContentText("Auto-inject enabled")
            .setSmallIcon(android.R.drawable.ic_menu_upload)
            .build();
        
        startForeground(1, notification);
    }

    private void injectOnLaunch() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for app to fully start
                    Thread.sleep(3000);
                    
                    // Check if in virtual environment
                    if (VirtualInjector.isRunningInVirtual()) {
                        VirtualInjector.injectIntoVirtual(
                            AutoLoadService.this,
                            targetPackage,
                            libPath
                        );
                    } else {
                        NativeInjector.inject(targetPackage, libPath);
                    }
                    
                } catch (Exception e) {
                    // Ignore
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY; // Restart if killed
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (appLaunchReceiver != null) {
            unregisterReceiver(appLaunchReceiver);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}