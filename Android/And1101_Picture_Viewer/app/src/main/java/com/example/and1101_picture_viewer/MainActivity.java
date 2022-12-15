package com.example.and1101_picture_viewer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkStart;
    TextView tvPet;
    RadioGroup rGroup;
    Button btnReset, btnFinish;
    ImageView ivPet;
    RadioButton rbDog, rbCat, rbRabbit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkStart = findViewById(R.id.checkStart);
        tvPet = findViewById(R.id.tvPet);
        rGroup = findViewById(R.id.rGroup);
        btnReset = findViewById(R.id.btnReset);
        btnFinish = findViewById(R.id.btnFinish);
        ivPet = findViewById(R.id.ivPet);
        rbDog = findViewById(R.id.rbDog);
        rbCat = findViewById(R.id.rbCat);
        rbRabbit = findViewById(R.id.rbRabbit);

        // 1. 체크박스 체크 시 나머지 모든 항목 표시(tvPet, rGroup, ivPet)
        checkStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean start) {
                int status = start ? View.VISIBLE : View.INVISIBLE;
                rGroup.setVisibility(status);
                tvPet.setVisibility(status);
                ivPet.setVisibility(status);
            }
        });

        // 2. 라디오 버튼 선택 시 선택된 라디오버튼에 해당하는 이미지를 ivPet에 표시
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int index) {
                if(index == rbDog.getId()) {
                    ivPet.setImageResource(R.drawable.dog);
                } else if(index == rbCat.getId()) {
                    ivPet.setImageResource(R.drawable.cat);
                } else if(index == rbRabbit.getId()) {
                    ivPet.setImageResource(R.drawable.rabbit);
                }
            }
        });

        // 3. 초기화 버튼 클릭 시 숨김 처리 및 체크박스와 라디오버튼 선택 해제
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rGroup.clearCheck();
                ivPet.setImageResource(0);
                checkStart.setChecked(false);
            }
        });

        // 4. 종료 버튼 클릭 시 프로그램 끝내기(종료)
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 프로그램을 종료하려면 finish() 메서드 호출
                finishAndRemoveTask();
            }
        });

    }
}