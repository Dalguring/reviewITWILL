package com.example.and1108_tablelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        EditText etNum1 = findViewById(R.id.etNum1);
        EditText etNum2 = findViewById(R.id.etNum2);

        Button btn0 = findViewById(R.id.btn0);
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnSub = findViewById(R.id.btnSub);
        Button btnMulti = findViewById(R.id.btnMulti);
        Button btnDiv = findViewById(R.id.btnDiv);

        TextView result = findViewById(R.id.result);
        // EditText 자판 동작 x
        etNum1.setInputType(0);
        etNum2.setInputType(InputType.TYPE_NULL);

        // 더하기, 빼기, 곱하기, 나누기 버튼 리스너(4단계)
        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etNum1.getText().equals("")) {
                    Toast.makeText(MainActivity.this, "첫번째 숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    etNum1.requestFocus();
                    return;
                } else if(etNum2.length() == 0) {
                    Toast.makeText(MainActivity.this, "두번째 숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    etNum2.requestFocus();
                    return;
                }

                // 모든 숫자가 정상적으로 입력되었을 경우(숫자외의 문자 입력 판별 생략)
                // 입력받은 숫자 가져와서 변수에 저장
                int num1 = Integer.parseInt(etNum1.getText().toString());
                int num2 = Integer.parseInt(etNum2.getText().toString());

                switch(view.getId()) {
                    case R.id.btnPlus: result.setText("계산결과 : " + (num1 + num2)); break;
                    case R.id.btnSub: result.setText("계산결과 : " + (num1 - num2)); break;
                    case R.id.btnMulti: result.setText("계산결과 : " + (num1 * num2)); break;
                    case R.id.btnDiv: result.setText("계산결과 : " + (num1 / num2)); break;

                }
            }
        };

        btnPlus.setOnClickListener(opListener);
        btnSub.setOnClickListener(opListener);
        btnMulti.setOnClickListener(opListener);
        btnDiv.setOnClickListener(opListener);



        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 버튼 객체 확인 생략하고 바로 Button 타입 변수에 저장
//                Button btnNum = (Button) view;
//
//                if(etNum1.isFocused()) {
//                    // 기존에 입력된 숫자 가져오기(문자열로 저장)
//                    String strNum = etNum1.getText().toString();
//
//                    if(strNum.equals("0")) {
//                        strNum = "";
//                    }
//                    // 눌러진 버튼의 텍스트(숫자) 가져와서 기존에 입력된 숫자 뒤에 결합
//                    strNum += btnNum.getText();
//
//                    // EditText 1번에 결합된 숫자 표시
//                    etNum1.setText(strNum);
//                } else if(etNum2.isFocused()) {
//                    // 기존에 입력된 숫자 가져오기(문자열로 저장)
//                    String strNum = etNum2.getText().toString();
//
//                    if(strNum.equals("0")) {
//                        strNum = "";
//                    }
//                    // 눌러진 버튼의 텍스트(숫자) 가져와서 기존에 입력된 숫자 뒤에 결합
//                    strNum += btnNum.getText();
//
//                    // EditText 1번에 결합된 숫자 표시
//                    etNum2.setText(strNum);
//                } else { // 숫자 입력란에 커서가 없는 경우
//                    Toast.makeText(MainActivity.this, "입력할 위치를 선택하세요", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                Button btnNum = (Button)view;

                // 현재 focus 되어있는 View를 가져오기
//                View v = getCurrentFocus();
                EditText edit = (EditText)getCurrentFocus();

                if(edit == null) {
                    Toast.makeText(MainActivity.this, "입력할 위치를 선택하세요", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    String strNum = edit.getText().toString();

                    if(strNum.equals("0")) {
                        strNum = "";
                    }
                    strNum += btnNum.getText();
                    edit.setText(strNum);
                }


            }
        };
        btn0.setOnClickListener(listener);
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
        btn8.setOnClickListener(listener);
        btn9.setOnClickListener(listener);




    }
}