package com.univ.linco.mypage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.univ.linco.R;

public class MypageActivity extends AppCompatActivity {
    // firebase 사용시
    // FirebaseAuth auth = FirebaseAuth.getInstance(); 구문 추가하여 로그아웃 구현하기
    TextView txtResult;
    SharedPreferences shared;
    SharedPreferences.Editor editor;
    SharedPreferences for_nickname;
    Intent getID = getIntent();
    String getnickname = getID.getStringExtra("닉네임");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


//        txtResult = (TextView) findViewById(R.id.txtResult);

        Button camping = (Button) findViewById(R.id.camping);
        Button kids = (Button) findViewById(R.id.kids);
        Button game = (Button) findViewById(R.id.game);
        Button watch = (Button) findViewById(R.id.watch);
        Button fashion = (Button) findViewById(R.id.fashion);
        Button reset = (Button) findViewById(R.id.reset);
        ImageButton back = (ImageButton) findViewById(R.id.left_arrow);
        ImageButton logout = (ImageButton) findViewById(R.id.logout_button);
        TextView nickname = (TextView) findViewById(R.id.nickname);
        for_nickname = getSharedPreferences("UserInfo", MODE_PRIVATE);
        nickname.setText(getnickname);



        final String[] filter_list = {"캠핑","육아","게임","시계","패션"};


        // assembly시 로그아웃 구현

//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MypageActivity.this , MainActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                startActivity(i);
//            }
//        });



        //메인 화면으로 전환하는 intent
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent to_main = new Intent(getApplicationContext(), MainActivity);
//                startActivity(to_main);
//            }
//        });

        camping.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                camping.setVisibility(View.GONE);
                editor.putBoolean("캠핑",false);
                editor.commit();
            }
        });
        kids.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                kids.setVisibility(View.GONE);
                editor.putBoolean("육아",false);
                editor.commit();
            }
        });
        game.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                game.setVisibility(View.GONE);
                editor.putBoolean("게임",false);
                editor.commit();
            }
        });
        watch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                watch.setVisibility(View.GONE);
                editor.putBoolean("시계",false);
                editor.commit();
            }
        });
        fashion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fashion.setVisibility(View.GONE);
                editor.putBoolean("패션",false);
                editor.commit();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camping.setVisibility(View.VISIBLE);
                kids.setVisibility(View.VISIBLE);
                game.setVisibility(View.VISIBLE);
                watch.setVisibility(View.VISIBLE);
                fashion.setVisibility(View.VISIBLE);
                editor.putBoolean("캠핑",true);
                editor.putBoolean("육아",true);
                editor.putBoolean("게임",true);
                editor.putBoolean("시계",true);
                editor.putBoolean("패션",true);
                editor.commit();
            }
        });



    }

    //로그아웃 구현

//    public void logout(View view){
//        auth.signOut();
//        finish();
//    }


//        //버튼
//        public void mOnPopupClick(View v){
//            //데이터 담아서 팝업(액티비티) 호출
//            Intent intent = new Intent(this, PopupActivity.class);
//            intent.putExtra("data", "Test Popup");
//            startActivityForResult(intent, 1);
//        }
//
//        @Override
//        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//            if(requestCode==1){
//                if(resultCode==RESULT_OK){
//                    //데이터 받기
//                    String result = data.getStringExtra("result");
//                    txtResult.setText(result);
//                }
//            }
//        }
}