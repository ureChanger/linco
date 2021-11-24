package com.univ.linco.signup;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.univ.linco.R;
import com.univ.linco.signin.SigninActivity;

public class PopupActivity extends Activity {

    CheckBox btn3;
    CheckBox btn4;
    CheckBox btn5;
    CheckBox btn6;
    CheckBox btn7;
    CheckBox btn8;
    CheckBox btn9;
    CheckBox btn10;
    CheckBox btn11;
    Button btn12;
    String keyword = "";

    SharedPreferences shared;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);

        btn3 = (CheckBox) findViewById(R.id.btn3);
        btn4 = (CheckBox) findViewById(R.id.btn4);
        btn5 = (CheckBox) findViewById(R.id.btn5);
        btn6 = (CheckBox) findViewById(R.id.btn6);
        btn7 = (CheckBox) findViewById(R.id.btn7);
        btn8 = (CheckBox) findViewById(R.id.btn8);
        btn9 = (CheckBox) findViewById(R.id.btn9);
        btn10 = (CheckBox) findViewById(R.id.btn10);
        btn11 = (CheckBox) findViewById(R.id.btn11);
        btn12 = (Button) findViewById(R.id.btn12);


        if (btn3.isChecked()){
            keyword += "/캠핑";
            editor.putBoolean("캠핑",true);
            editor.commit();
        }

        if (btn4.isChecked()){
            keyword += "/뷰티";
            editor.putBoolean("뷰티",true);
            editor.commit();
        }

        if (btn5.isChecked()){
            keyword += "/건강";
            editor.putBoolean("건강",true);
            editor.commit();
        }

        if (btn6.isChecked()){
            keyword += "/스포츠";
            editor.putBoolean("스포츠",true);
            editor.commit();
        }

        if (btn7.isChecked()){
            keyword += "/인테리어";
            editor.putBoolean("인테리어",true);
            editor.commit();
        }

        if (btn8.isChecked()){
            keyword += "/육아";
            editor.putBoolean("육아",true);
            editor.commit();
        }

        if (btn9.isChecked()){
            keyword += "/전자기기";
            editor.putBoolean("전자기기",true);
            editor.commit();
        }

        if (btn10.isChecked()){
            keyword += "/도서";
            editor.putBoolean("도서",true);
            editor.commit();
        }

        if (btn11.isChecked()){
            keyword += "/패션";
            editor.putBoolean("패션",true);
            editor.commit();
        }
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();


    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //keyword = "/게임/육아"
        //데이터 전달하기
        Toast.makeText(PopupActivity.this, "Keyword 설정 완료", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        startActivity(intent);

        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }



}

