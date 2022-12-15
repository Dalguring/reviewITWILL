package com.example.and1025_basicwidget_checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox cbAndroid, cbIPhone, cbWindow, cbAll;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cbAndroid = findViewById(R.id.cbAndroid);
        cbIPhone = findViewById(R.id.cbIPhone);
        cbWindow = findViewById(R.id.cbWindow);
        cbAll = findViewById(R.id.cbAll);
        btnOk = findViewById(R.id.btnOk);

        // 1. 전체선택 체크 시 나머지 체크박스 항목들을 체크설정
        // 전체선택 체크 해제 시 나머지 체크박스 항목들을 체크해제설정
        cbAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                cbAndroid.setChecked(isChecked);
                cbIPhone.setChecked(isChecked);
                cbWindow.setChecked(isChecked);
            }
        });

        // 2. Button에 OnClickListener 연결
        // 안드로이드폰, 아이폰, 윈도우폰 체크 상태를 확인하여
        // 체크된 항목의 텍스트를 결합하여 출력
        // ex) 안드로이드폰과 아이폰 체크 시 : "안드로이드폰 / 아이폰"
        btnOk.setOnClickListener(view -> {
            CheckBox[] cbs = {cbAndroid, cbIPhone, cbWindow};
            String str = "";
            for(CheckBox cb : cbs) {
                if(cb.isChecked()) {
                    str += cb.getText() + " / ";
                }
            }
            Toast.makeText(MainActivity.this, str.substring(0, str.length()-3), Toast.LENGTH_SHORT).show();
        });


    }
}