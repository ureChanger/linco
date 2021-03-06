package com.univ.linco.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.univ.linco.R;
import com.univ.linco.mypage.database.Filter;
import com.univ.linco.signin.SigninActivity;
import com.univ.linco.signup.database.User;
import com.univ.linco.signup.database.UserClient;
import com.univ.linco.signup.database.UserDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterActivity extends AppCompatActivity{

    EditText et_user_name;
    EditText et_user_reg_id;
    EditText et_user_reg_pw;
    EditText et_user_reg_pwc;
    String user_name="", user_reg_id="", user_reg_pw="";

    Button register;
    TextView go_login;
    String shared = "file";
    ImageView hashtag;
    String str_keyword;
    String[] array_str = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_user_name = (EditText) findViewById(R.id.user_name);
        et_user_reg_id = (EditText) findViewById(R.id.user_reg_id);
        et_user_reg_pw = (EditText) findViewById(R.id.user_reg_pw);
        et_user_reg_pwc = (EditText) findViewById(R.id.user_reg_pwc);
        register = (Button) findViewById(R.id.register);
        go_login = (TextView) findViewById(R.id.go_login);
        hashtag = (ImageView) findViewById(R.id.hashtag);


        final UserDao userDao = UserClient.getInstance(getApplicationContext()).getAppDatabase().userDao();
        Intent intent_get = getIntent();
        Log.d("test_si", intent_get.getStringExtra("from"));
        if(intent_get.getStringExtra("from").equals("popup")){
            str_keyword = intent_get.getStringExtra("keyword");
            array_str = str_keyword.split("/");
        }

        //????????????
//        "/??????/??????";
//        ["??????", "??????"];

        findViewById(R.id.register).setOnClickListener(v -> {

            if(!TextUtils.isEmpty(et_user_name.getText())){
                user_name = et_user_name.getText().toString();
            } else {
                Toast.makeText(this,"????????? ????????? ????????? . " ,Toast.LENGTH_SHORT).show();
                return;
            }
            if(!TextUtils.isEmpty(et_user_reg_id.getText())){
                for (int i=0; i<userDao.getAll().size(); i++){
                    Log.d("test_si", userDao.getAll().toString());
                    Log.d("test_si", et_user_reg_id.getText().toString());
                    if (et_user_reg_id.getText().toString().equals(userDao.getAll().get(i).getUser_id())){
                        Toast.makeText(this, "?????? ???????????? ?????????????????? . ", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                user_reg_id = et_user_reg_id.getText().toString();
            } else {
                Toast.makeText(this,"???????????? ????????? ????????? . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            if(!TextUtils.isEmpty(et_user_reg_pw.getText().toString())){
                user_reg_pw = et_user_reg_pw.getText().toString();
            }else {
                Toast.makeText(this,"??????????????? ????????? ????????? . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            if(TextUtils.isEmpty(et_user_reg_pwc.getText().toString()) || !user_reg_pw.equals(et_user_reg_pwc.getText().toString())){
                Toast.makeText(this,"??????????????? ???????????? ???????????? . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            if(array_str.length == 0){
                Toast.makeText(this,"????????? #????????? ?????? ???????????? ?????????????????? . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            userDao.insert(new User(user_name, user_reg_id, user_reg_pw, str_keyword));
            Toast.makeText(RegisterActivity.this, "?????? ?????? ??????", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent);

            }
        );

        go_login.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), SigninActivity.class);
            startActivity(intent);
            finish();
        });

        hashtag.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
            startActivity(intent);
        });

    }
}