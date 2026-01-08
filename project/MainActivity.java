package com.nyxis.loader;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.net.*;
import java.io.*;
import java.net.*;

public class MainActivity extends Activity {

    private TextView tvStatus;
    private Button btnInject, btnSupport, btnContact;
    
    private static final String LIB_URL = "https://raw.githubusercontent.com/chrisiverrr266-bot/My-libs-/main/libNyxisCheat.so";
    private static final String GAME_PACKAGE = "com.activision.callofduty.shooter";
    private static final String TELEGRAM_DISCUSSION = "https://t.me/indradiscussion";
    private static final String TELEGRAM_CONTACT = "https://t.me/iinddra";
    
    private File libFile;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Initialize views
        tvStatus = findViewById(R.id.tvStatus);
        btnInject = findViewById(R.id.btnInject);
        btnSupport = findViewById(R.id.btnSupport);
        btnContact = findViewById(R.id.btnContact);
        
        // Setup library file path
        libFile = new File(getExternalFilesDir(null), "libNyxisCheat.so");
        
        // Button click listeners
        btnInject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startInjection();
            }
        });
        
        btnSupport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTelegram(TELEGRAM_DISCUSSION);
            }
        });
        
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTelegram(TELEGRAM_CONTACT);
            }
        });
    }
    
    private void startInjection() {
        btnInject.setEnabled(false);
        updateStatus(getString(R.string.downloading));
        
        // Download in background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    downloadLibrary();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateStatus(getString(R.string.injecting));
                            injectLibrary();
                        }
                    });
                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateStatus(getString(R.string.error_download));
                            btnInject.setEnabled(true);
                            showToast("Download failed: " + e.getMessage());
                        }
                    });
                }
            }
        }).start();
    }
    
    private void downloadLibrary() throws Exception {
        URL url = new URL(LIB_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();
        
        InputStream input = connection.getInputStream();
        FileOutputStream output = new FileOutputStream(libFile);
        
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        
        output.close();
        input.close();
    }
    
    private void injectLibrary() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean success = NativeInjector.inject(GAME_PACKAGE, libFile.getAbsolutePath());
                    
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (success) {
                                updateStatus(getString(R.string.success));
                                showToast("Library injected successfully!");
                            } else {
                                updateStatus(getString(R.string.error_inject));
                                showToast("Injection failed. Root access required.");
                            }
                            btnInject.setEnabled(true);
                        }
                    });
                } catch (Exception e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            updateStatus(getString(R.string.error_inject));
                            btnInject.setEnabled(true);
                        }
                    });
                }
            }
        }).start();
    }
    
    private void updateStatus(String status) {
        tvStatus.setText(status);
    }
    
    private void openTelegram(String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        } catch (Exception e) {
            showToast("Please install Telegram app");
        }
    }
    
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}