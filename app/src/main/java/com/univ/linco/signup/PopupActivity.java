package com.univ.linco.signup;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
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

    CheckBox cb_camping, cb_beauty, cb_wealth, cb_sports,
            cb_interior, cb_kids, cb_device, cb_book, cb_fashion;
    String name, id, pw;
    Button btn_submit;
    Button btn12;
    String keyword = "";


    SharedPreferences shared;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_popup);

        cb_camping = (CheckBox) findViewById(R.id.cb_camping);
        cb_beauty = (CheckBox) findViewById(R.id.cb_beauty);
        cb_wealth = (CheckBox) findViewById(R.id.cb_wealth);
        cb_sports = (CheckBox) findViewById(R.id.cb_sports);
        cb_interior = (CheckBox) findViewById(R.id.cb_interior);
        cb_kids = (CheckBox) findViewById(R.id.cb_kids);
        cb_device = (CheckBox) findViewById(R.id.cb_device);
        cb_book = (CheckBox) findViewById(R.id.cb_book);
        cb_fashion = (CheckBox) findViewById(R.id.cb_fashion);
        btn_submit = (Button) findViewById(R.id.btn_submit);

    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();


    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        //keyword = "/게임/육아"
        if (cb_camping.isChecked()){
            keyword += "/캠핑";
        }

        if (cb_beauty.isChecked()){
            keyword += "/뷰티";
        }

        if (cb_wealth.isChecked()){
            keyword += "/건강";
        }

        if (cb_sports.isChecked()){
            keyword += "/스포츠";
        }

        if (cb_interior.isChecked()){
            keyword += "/인테리어";
        }

        if (cb_kids.isChecked()){
            keyword += "/육아";
        }

        if (cb_device.isChecked()){
            keyword += "/전자기기";
        }

        if (cb_book.isChecked()){
            keyword += "/도서";
        }

        if (cb_fashion.isChecked()){
            keyword += "/패션";
        }

        //데이터 전달하기
        Toast.makeText(PopupActivity.this, "Keyword 설정 완료", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
        intent.putExtra("from", "popup");
        intent.putExtra("keyword", keyword);

        startActivity(intent);
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

