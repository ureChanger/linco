package com.univ.linco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity{

    EditText user_name;
    EditText user_reg_id;
    EditText user_reg_pw;
    EditText user_reg_pwc;
    Button register;
    TextView go_login;
    String shared = "file";
    ImageView hashtag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user_name = (EditText) findViewById(R.id.user_name);
        user_reg_id = (EditText) findViewById(R.id.user_reg_id);
        user_reg_pw = (EditText) findViewById(R.id.user_reg_pw);
        user_reg_pwc = (EditText) findViewById(R.id.user_reg_pwc);
        register = (Button) findViewById(R.id.register);
        go_login = (TextView) findViewById(R.id.go_login);
        hashtag = (ImageView) findViewById(R.id.hashtag);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        String name = sharedPreferences.getString("name", "");
        user_name.setText(name);

        String id = sharedPreferences.getString("id", "");
        user_reg_id.setText(id);

        String pw = sharedPreferences.getString("pw", "");
        user_reg_pw.setText(pw);

        String pwc = sharedPreferences.getString("pwc", "");
        user_reg_pwc.setText(pwc);

        go_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared,0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (user_name != null && user_reg_id != null && user_reg_pw != null && user_reg_pwc != null && user_reg_pw == user_reg_pwc) {

            String name = user_name.getText().toString();
            editor.putString("name", name);

            String id = user_reg_id.getText().toString();
            editor.putString("id", id);

            String pw = user_reg_pw.getText().toString();
            editor.putString("pw", pw);

            String pwc = user_reg_pwc.getText().toString();
            editor.putString("pwc", pwc);

            editor.commit();

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(RegisterActivity.this, "회원 가입 완료", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });

        }else{
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(RegisterActivity.this, "회원 가입 정보를 다시 입력해주세요", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void mOnPopupClick(View v){
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, PopupActivity.class);
        intent.putExtra("data", "");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                //데이터 받기
                boolean first = data.getBooleanExtra("캠핑",true);
                boolean second = data.getBooleanExtra("게임", true);
                boolean third = data.getBooleanExtra("패션", true);
                boolean fourth = data.getBooleanExtra("육아", true);
                boolean fifth = data.getBooleanExtra("시계", true);
                boolean sixth = data.getBooleanExtra("전자기기", true);
                boolean seventh = data.getBooleanExtra("도서", true);
                boolean eight = data.getBooleanExtra("요리", true);
                boolean ninth = data.getBooleanExtra("뷰티", true);

            }
        }
    }
}