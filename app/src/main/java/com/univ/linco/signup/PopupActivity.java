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

import com.univ.linco.R;

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

        if (savedInstanceState == null) {

            SharedPreferences prefs = getSharedPreferences(String.valueOf(shared), 0);

            boolean first = prefs.getBoolean("캠핑", false);
            boolean second = prefs.getBoolean("게임", false);
            boolean third = prefs.getBoolean("패션", false);
            boolean fourth = prefs.getBoolean("육아", false);
            boolean fifth = prefs.getBoolean("시계", false);
            boolean sixth = prefs.getBoolean("전자기기", false);
            boolean seventh = prefs.getBoolean("도서", false);
            boolean eight = prefs.getBoolean("요리", false);
            boolean ninth = prefs.getBoolean("뷰티", false);

            btn3.setChecked(first);
            btn4.setChecked(second);
            btn5.setChecked(third);
            btn6.setChecked(fourth);
            btn7.setChecked(fifth);
            btn8.setChecked(sixth);
            btn9.setChecked(seventh);
            btn10.setChecked(eight);
            btn11.setChecked(ninth);
        }
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();

        SharedPreferences prefs = getSharedPreferences(String.valueOf(shared), 0);
        SharedPreferences.Editor editor = prefs.edit();

        if (btn3.isChecked()){
            editor.putBoolean("캠핑",true);
            editor.commit();
        }

        if (btn4.isChecked()){
            editor.putBoolean("게임",true);
            editor.commit();
        }

        if (btn5.isChecked()){
            editor.putBoolean("패션",true);
            editor.commit();
        }

        if (btn6.isChecked()){
            editor.putBoolean("육아",true);
            editor.commit();
        }

        if (btn7.isChecked()){
            editor.putBoolean("시계",true);
            editor.commit();
        }

        if (btn8.isChecked()){
            editor.putBoolean("전자기기",true);
            editor.commit();
        }

        if (btn9.isChecked()){
            editor.putBoolean("도서",true);
            editor.commit();
        }

        if (btn10.isChecked()){
            editor.putBoolean("요리",true);
            editor.commit();
        }

        if (btn11.isChecked()){
            editor.putBoolean("뷰티",true);
            editor.commit();
        }

    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

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

