package com.example.and1027_simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // id 연결
        EditText text1 = findViewById(R.id.text1);
        EditText text2 = findViewById(R.id.text2);
        Button plus = findViewById(R.id.plus);
        Button subs = findViewById(R.id.subs);
        Button multi = findViewById(R.id.multi);
        Button div = findViewById(R.id.div);
        TextView result = findViewById(R.id.result);

        // Listener 연결
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(view.getId() == R.id.plus) {
//                    Toast.makeText(MainActivity.this, "더하기", Toast.LENGTH_SHORT).show();
//                }
                // EditText(text1, text2)에 입력된 숫자 2개 가져와서 정수로 변환 후
                // 연산하여 결과를 TextView(result)에 출력
                // => 단, 숫자가 입력되지 않았을 경우 오류 메세지 출력 및 커서 요청
                if(text1.length() == 0) {
                    Toast.makeText(MainActivity.this, "숫자1 입력 필수!", Toast.LENGTH_SHORT).show();
                    text1.requestFocus();
                    return;
                } else if(text2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "숫자2 입력 필수!", Toast.LENGTH_SHORT).show();
                    text2.requestFocus();
                    return;
                }
                // 입력받은 숫자 가져오기
                // => 만약, 정수와 실수를 구분하는 경우
//                if(text1.getText().toString().contains(".") || text2.getText().toString().contains(".")) {
//                    // 둘 중 하나라도 실수가 존재하면 실수 형태로 계산
//                } else {
//                    // 정수형태로 계산
//                }

                int num1 = Integer.parseInt(text1.getText().toString());
                int num2 = Integer.parseInt(text2.getText().toString());
                int resultNum = 0;

                switch (view.getId()) {
                    case R.id.plus: resultNum = num1 + num2; break;
                    case R.id.subs: resultNum = num1 - num2; break;
                    case R.id.multi: resultNum = num1 * num2; break;
                    case R.id.div:

                        // 두번째 피연산자가 0이면 예외가 발생하므로 주의!
                        if(num2 == 0) {
                            Toast.makeText(MainActivity.this, "나눗셈에 0 사용금지", Toast.LENGTH_SHORT).show();
                            text2.requestFocus();
                            result.setText("계산결과 : 오류 발생!");
                            return;
                        }
                        resultNum = num1 / num2; break;
                }
                result.setText("계산결과 : " + resultNum);
            }
        };

        plus.setOnClickListener(listener);
        subs.setOnClickListener(listener);
        multi.setOnClickListener(listener);
        div.setOnClickListener(listener);



//        plus.setOnClickListener(view -> {
//            int plusNum = Integer.parseInt(String.valueOf(text1.getText())) + Integer.parseInt(String.valueOf(text2.getText()));
//            result.setText("계산결과 : " + plusNum);
//        });
//
//        subs.setOnClickListener(view -> {
//            int subsNum = Integer.parseInt(String.valueOf(text1.getText())) - Integer.parseInt(String.valueOf(text2.getText()));
//            result.setText("계산결과 : " + subsNum);
//        });
//
//        multi.setOnClickListener(view -> {
//            int multiNum = Integer.parseInt(String.valueOf(text1.getText())) * Integer.parseInt(String.valueOf(text2.getText()));
//            result.setText("계산결과 : " + multiNum);
//        });
//
//        div.setOnClickListener(view -> {
//            int divNum = Integer.parseInt(String.valueOf(text1.getText())) / Integer.parseInt(String.valueOf(text2.getText()));
//            result.setText("계산결과 : " + divNum);
//        });


    }

}