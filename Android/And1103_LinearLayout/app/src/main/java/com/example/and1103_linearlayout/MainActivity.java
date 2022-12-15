package com.example.and1103_linearlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Layout 폴더 내의 activity_main.xml 파일을 현재 액티비티에서 표시(연결)하도록 설정
//        setContentView(R.layout.activity_main);
        // => 만약, 이 코드를 실행하지 않으면 activity_main.xml 파일의 레이아웃 형태가 안보임

        /*
        [ 자바 코드를 사용하여 레이아웃을 직접 생성하기 ]
        1. LinearLayout 객체를 생성
            => 현재 액티비티 클래스 객체를 전달해야하므로 레퍼런스 this 를 파라미터로 전달
        2. LinearLayout 객체의 setXXX() 메서드를 호출하여 속성 설정 가능
            => 필수 속성 중 orientation 속성 변경 위해 setOrientation() 메서드 호출
        -----------------------------------------------------------------------------
        [ 레이아웃 내에서 표시할 위젯 생성하기 ]
        3. 생성할 위젯의 객체 생성
        4. 위젯 속성 변경
        -----------------------------------------------------------------------------
        [ 생성된 위젯과 레이아웃을 각각 표시하기 ]
        5. 생성된 레이아웃에 생성된 위젯 표시 (addView())
        6. 레이아웃을 액티비티에 표시 (setContentView())

         */

        LinearLayout layout = new LinearLayout(this);
        // => 현재 액티비티 객체 (AppCompatActivity 클래스를 상속받은 객체)를 파라미터로 전달

        layout.setOrientation(LinearLayout.VERTICAL);

        // 버튼(위젯) 생성을 위한 Button 객체 생성
        Button btn = new Button(this);

        // 버튼 위젯 속성 설정하기 위해 Button 객체의 setXXX() 메서드 호출
        // 1. 버튼 텍스트 변경
        btn.setText("버튼");
        // 2. 버튼 텍스트 사이즈 변경
        btn.setTextSize(20);
        // 3. 버튼 크기 변경 위해 LayoutParams 객체를 생성하여 WIDTH, HEIGHT 값 설정
        // => LayoutParams.XXX 상수를 활용하여 MATCH_PARENT 또는 WRAP_CONTENT 값 설정 가능
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //4. 지정된 레이아웃 크기를 담은 LayoutParams 객체를
        //   Button 객체의 setLayoutParams() 메서드를 호출하여 파라미터 전달
        btn.setLayoutParams(params);

        layout.addView(btn);

        setContentView(layout);

        // ===============================================================================
        // 버튼 객체 1개 (btn)를 생성하여 레이아웃에 추가하기
        Button btn2 = new Button(this);
        btn2.setText("버튼2");
        btn2.setTextSize(30);

        btn2.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        layout.addView(btn2);



    }


}