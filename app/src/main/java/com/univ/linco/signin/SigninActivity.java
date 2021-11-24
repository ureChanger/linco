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

    Intent for_mypage_nickname = new Intent(this, MypageActivity.class);
    SharedPreferences for_mypage_nickname_preferences = getSharedPreferences("UserInfo", MODE_PRIVATE);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        user_id = (EditText) findViewById(R.id.user_id);
        user_pw = (EditText) findViewById(R.id.user_pw);
        login = (Button) findViewById(R.id.login);
        go_reg = (TextView) findViewById(R.id.go_reg);

        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class, "todo-db").allowMainThreadQueries().build();

        findViewById(R.id.login).setOnClickListener(v -> {
            try {
                if (user_id.getText().toString().length() != 0 && user_pw.getText().toString().length() != 0) {
                    if (db.todoDao().getAll().get(0).getID(user_id.getText().toString()).length() != 0) {
                        if (db.todoDao().getAll().get(0).getID(user_id.getText().toString()).equals(user_pw.getText().toString())) {
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        go_reg.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });


        // private void getPreferences () {
            // for_mypage_nickname.putExtra("닉네임", for_mypage_nickname_preferences.getString("userid", ""));
        // }

    }

}