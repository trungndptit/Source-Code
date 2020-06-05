package com.example.sourcecode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Chú ý quyền FOREGROUND_SERVICE
        // khai bao trong manifest cả service và receiver và app
        Intent intent = new Intent(MainActivity.this, LockScreenServiceStart.class);
//        startService(intent);

    }
}
