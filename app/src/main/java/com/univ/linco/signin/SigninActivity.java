package com.univ.linco.signin;

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
import android.widget.TextView;
import android.widget.Toast;

import com.univ.linco.R;
import com.univ.linco.mypage.MypageActivity;
import com.univ.linco.signup.RegisterActivity;

public class SigninActivity extends AppCompatActivity {


    EditText user_id;
    EditText user_pw;
    Button login;
    TextView go_reg;
    String shared = "file";
    SharedPreferences prefs;
    Intent for_mypage_nickname = new Intent(this, MypageActivity.class);
    SharedPreferences for_mypage_nickname_preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);

        String id = sharedPreferences.getString("id", "");
        user_id.setText(id);

        String pw = sharedPreferences.getString("pw", "");
        user_pw.setText(pw);

        go_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

        if (id != null && pw != null) {

            setContentView(R.layout.activity_main);

            user_id = (EditText) findViewById(R.id.user_id);
            user_pw = (EditText) findViewById(R.id.user_pw);
            login = (Button) findViewById(R.id.login);
            go_reg = (TextView) findViewById(R.id.go_reg);


            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        if (id.equalsIgnoreCase(user_id.getText().toString()) && pw.equals(user_pw.getText().toString())) {
                            Toast.makeText(SigninActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class); //메인 화면(뷰)로 이동(수정!)
                            startActivity(intent);
                        } else {
                            Toast.makeText(SigninActivity.this, "로그인 실패", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    //Editor를 preferences에 쓰겠다고 연결
                    SharedPreferences.Editor editor = for_mypage_nickname_preferences.edit();
                    //putString(KEY,VALUE)
                    editor.putString("userid",user_id.getText().toString());
                    //항상 commit & apply 를 해주어야 저장이 된다.
                    editor.commit();
                    //메소드 호출
                    getPreferences();
                }
            });
        }else{
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent);
        }
    }
    private void getPreferences(){
        for_mypage_nickname.putExtra("닉네임", for_mypage_nickname_preferences.getString("userid",""));
    }
}