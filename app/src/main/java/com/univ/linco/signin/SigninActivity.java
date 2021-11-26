package com.univ.linco.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.univ.linco.MainActivity;
import com.univ.linco.R;
import com.univ.linco.mypage.MypageActivity;
import com.univ.linco.signup.AppDatabase;
import com.univ.linco.signup.RegisterActivity;

public class SigninActivity extends AppCompatActivity {

    EditText user_id;
    EditText user_pw;
    Button login;
    TextView go_reg;
    String shared = "file";
    SharedPreferences prefs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);

        user_id = (EditText) findViewById(R.id.user_id);
        user_pw = (EditText) findViewById(R.id.user_pw);
        login = (Button) findViewById(R.id.login);
        go_reg = (TextView) findViewById(R.id.go_reg);

        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db").allowMainThreadQueries().build();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (user_id.getText().toString().length() != 0 && user_pw.getText().toString().length() != 0) {
                        if (db.todoDao().getAll().get(0).getUser_id().length() != 0) {
                            if (db.todoDao().getAll().get(0).getUser_id().equals(user_pw.getText().toString())) {
                                Toast.makeText(SigninActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(SigninActivity.this, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(SigninActivity.this, "가입된 계정이 없습니다..", Toast.LENGTH_LONG).show();
                        }

                    } else {
                        Toast.makeText(SigninActivity.this, "아이디와 비밀번호는 필수 입력 사항입니다.", Toast.LENGTH_LONG).show();
                    }

                }

            });

        go_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}