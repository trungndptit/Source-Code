package com.example.sourcecode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.sourcecode.adapter.ExampleAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ExampleAdapter mFileSelectAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // grid with 3 columns
//        mFileSelectAdapter = new ExampleAdapter();
//        mRecyclerView.setAdapter(mFileSelectAdapter);
//        mRecyclerView.setLayoutManager(new GridLayoutManager(
//                MainActivity.this, 3, GridLayoutManager.VERTICAL, false));
//        mRecyclerView.setHasFixedSize(true);

        // normal recycler view
//        mFileSelectAdapter = new ExampleAdapter();
//        mRecyclerView.setAdapter(mFileSelectAdapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        mRecyclerView.setHasFixedSize(true);
    }
}
