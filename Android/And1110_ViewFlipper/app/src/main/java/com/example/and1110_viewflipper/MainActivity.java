package com.example.and1110_viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPrev = findViewById(R.id.btnPrev);
        Button btnNext = findViewById(R.id.btnNext);
        ViewFlipper viewFlipper = findViewById(R.id.viewFlipper);

        btnPrev.setOnClickListener(view -> viewFlipper.showPrevious());
        btnNext.setOnClickListener(view -> viewFlipper.showNext());

    }
}