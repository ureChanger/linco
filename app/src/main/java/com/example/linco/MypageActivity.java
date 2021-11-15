package com.example.linco;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MypageActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);
//        txtResult = (TextView) findViewById(R.id.txtResult);

        Button camping = (Button) findViewById(R.id.camping);
        Button kids = (Button) findViewById(R.id.kids);
        Button game = (Button) findViewById(R.id.game);
        Button watch = (Button) findViewById(R.id.watch);
        Button fashion = (Button) findViewById(R.id.fashion);
        Button reset = (Button) findViewById(R.id.reset);
        final String[] filter_list = {"캠핑","육아","게임","시계","패션"};

        camping.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                camping.setVisibility(View.GONE);
            }
        });
        kids.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                kids.setVisibility(View.GONE);
            }
        });
        game.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                game.setVisibility(View.GONE);
            }
        });
        watch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                watch.setVisibility(View.GONE);
            }
        });
        fashion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fashion.setVisibility(View.GONE);
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
            }
        });

    }
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