package com.univ.linco.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.univ.linco.R;
import com.univ.linco.signin.SigninActivity;

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

        //받은 데이터
        String[] keyword = { };

        final AppDatabase db = Room.databaseBuilder(this, AppDatabase.class,"todo-db").allowMainThreadQueries().build();

        user_name.setText(db.todoDao().getAll().get(0).getName());
        user_reg_id.setText(db.todoDao().getAll().get(0).getID());
        user_reg_pw.setText(db.todoDao().getAll().get(0).getPassword());
        user_reg_pwc.setText(db.todoDao().getAll().get(0).getPasswordcheck());

        //슬라이스
//        "/캠핑/게임";
//        ["캠핑", "게임"];

        findViewById(R.id.register).setOnClickListener(v -> {

            if  (user_name != null && user_reg_id != null && user_reg_pw != null && user_reg_pwc != null && user_reg_pw == user_reg_pwc){

                db.todoDao().insert(new Todo(user_name.getText().toString(),user_reg_id.getText().toString(),
                        user_reg_pw.getText().toString(), user_reg_pwc.getText().toString(), keyword.toString()));
                // user_name.setText(db.todoDao().getAll().get(0).getName());

                Log.v("123", "가입 클릭");
                Toast.makeText(RegisterActivity.this, "회원 가입 완료", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(intent);

            }else{
                Toast.makeText(RegisterActivity.this, "회원 가입 정보를 다시 입력해주세요", Toast.LENGTH_SHORT).show();
            }

        });


        go_login.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent);
            finish();
        });

        hashtag.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
            startActivity(intent);
            finish();
        });




    }
}