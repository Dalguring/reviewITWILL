package com.example.basicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        Toast.makeText(MainActivity.this, "Hello, World 클릭됨", Toast.LENGTH_SHORT).show();
    }

    public void btnClick2(View v) {
        Toast.makeText(MainActivity.this, "버튼 클릭됨", Toast.LENGTH_SHORT).show();
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-4608-6788"));
        startActivity(intent);
    }

}