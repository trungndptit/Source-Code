package com.example.sourcecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void saveBitmap(final Bitmap bitmap) {
        try {
            File file = new File(Environment.getExternalStorageDirectory() + "/Been Love Memory");
            if (file.exists() || file.mkdirs()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Photo_");
                stringBuilder.append(System.currentTimeMillis());
                stringBuilder.append(".jpg");
                String stringBuilder2 = stringBuilder.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(file.getPath());
                stringBuilder3.append(File.separator);
                stringBuilder3.append(stringBuilder2);
                String filename = stringBuilder3.toString();
                File file2 = new File(filename);
                try {
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    Uri uri = Uri.fromFile(file2);

                    // share image into social network
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("image/*");
                    intent.putExtra(Intent.EXTRA_STREAM, uri);
                    startActivity(Intent.createChooser(intent, "Share via"));

                    fileOutputStream.flush();
                    fileOutputStream.close();
                    System.out.println("Debug share");
                } catch (Exception e) {
                    System.out.println("Debug error" + e.getLocalizedMessage());
                    e.printStackTrace();
                }
                Thread.sleep(1000);
                return;
            }
        } catch (Exception unused) {
            unused.printStackTrace();
        }
    }
}
