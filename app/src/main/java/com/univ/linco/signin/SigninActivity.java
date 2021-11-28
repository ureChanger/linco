package com.univ.linco.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.univ.linco.MainActivity;
import com.univ.linco.R;
import com.univ.linco.mypage.database.Filter;
import com.univ.linco.mypage.database.FilterClient;
import com.univ.linco.mypage.database.FilterDao;
import com.univ.linco.signup.RegisterActivity;
import com.univ.linco.signup.database.AppDatabaseUser;
import com.univ.linco.signup.database.User;
import com.univ.linco.signup.database.UserClient;
import com.univ.linco.signup.database.UserDao;

public class SigninActivity extends AppCompatActivity {

    EditText user_id;
    EditText user_pw;
    Button login;
    TextView go_reg;
    String shared = "file";
    SharedPreferences prefs;
    Filter data_filter;
    User user_info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);

        user_id = (EditText) findViewById(R.id.user_id);
        user_pw = (EditText) findViewById(R.id.user_pw);
        login = (Button) findViewById(R.id.login);
        go_reg = (TextView) findViewById(R.id.go_reg);

        final UserDao userDao = UserClient.getInstance(getApplicationContext()).getAppDatabase().userDao();
        final FilterDao filterDao = FilterClient.getInstance(getApplicationContext()).getAppDatabase().filterDao();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(user_id.getText().toString())){
                    Toast.makeText(getApplicationContext(),"아이디를 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(user_pw.getText().toString())){
                    Toast.makeText(getApplicationContext(),"비밀번호를 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
                    return;
                }

                try {
                    for (int i=0; i<userDao.getAll().size(); i++){
                        if (userDao.getAll().get(i).getUser_id().equals(user_id.getText().toString())){
                            if (userDao.getAll().get(i).getUser_password().equals(user_pw.getText().toString())){
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                SharedPreferences pref = getSharedPreferences("login_id", MODE_PRIVATE);
                                SharedPreferences.Editor editor = pref.edit();
                                editor.putInt("login", i);
                                editor.commit();

                                //키워드데이터
                                user_info = userDao.getAll().get(i);
                                String str_keyword = user_info.getKeyword();
                                String[] array_keyword = str_keyword.split("/");

                                data_filter = new Filter(false, false, false, false,
                                        false, false, false, false, false);

                                for (int j=0; j<array_keyword.length; j++){
                                    data_filter = setFilter(data_filter, array_keyword[j]);
                                }

                                filterDao.insert(data_filter);

                                startActivity(intent);

                                return;
                            }else {
                                Toast.makeText(SigninActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    Toast.makeText(SigninActivity.this, "가입된 계정이 없습니다..", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                }
            }
        });

        go_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                intent.putExtra("from", "login");
                startActivity(intent);
            }
        });

    }

    public Filter setFilter(Filter filter, String idx){
        switch (idx){
            case "캠핑":
                filter.setCamping(true);
                break;
            case "뷰티":
                filter.setBeauty(true);
                break;
            case "건강":
                filter.setWealth(true);
                break;
            case "스포츠":
                filter.setSports(true);
                break;
            case "인테리어":
                filter.setInterior(true);
                break;
            case "육아":
                filter.setKids(true);
                break;
            case "전자기기":
                filter.setDevice(true);
                break;
            case "도서":
                filter.setBook(true);
                break;
            case "패션":
                filter.setFashion(true);
                break;
        }

        return filter;
    }

}