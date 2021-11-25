package com.univ.linco.mypage;
//..

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.univ.linco.MainActivity;
import com.univ.linco.R;
import com.univ.linco.signin.SigninActivity;
import com.univ.linco.thumbnail.ThumbnailAdapter;
import com.univ.linco.thumbnail.ThumbnailData;
import com.univ.linco.thumbnail.ThumbnailItem;

import java.util.ArrayList;

public class MypageActivity extends AppCompatActivity {

    TextView txtResult;
    Intent intent;
    GridView gridView_mypost;
    ThumbnailData thumbnail_data;
    ArrayList<ThumbnailItem> data;
    SharedPreferences sharedPreferences;
    Intent getID = getIntent();
    String getnickname = getID.getStringExtra("닉네임");
    private static final String SHARED_PREF_NAME = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        txtResult = (TextView) findViewById(R.id.txtResult);

        thumbnail_data = new ThumbnailData();
        data = thumbnail_data.getThumbnailData();


        Filter filter = new Filter(false,false,false,false,false,false,false,false);


        final MypageDatabase db = Room.databaseBuilder(this, MypageDatabase.class, "mypage-db")
                .allowMainThreadQueries()
                .build();

        db.mypageDao().getAll();





        ImageButton logout = (ImageButton)findViewById(R.id.logout_button);
        ImageButton back = (ImageButton)findViewById(R.id.left_arrow);
        Button camping = (Button) findViewById(R.id.camping);
        Button beauty = (Button) findViewById(R.id.beauty);
        Button wealth = (Button) findViewById(R.id.wealth);
        Button sports = (Button) findViewById(R.id.sports);
        Button interior = (Button) findViewById(R.id.interior);
        Button kids = (Button) findViewById(R.id.kids);
        Button device = (Button) findViewById(R.id.device);
        Button book = (Button) findViewById(R.id.book);
        Button fashion = (Button) findViewById(R.id.fashion);
        Button reset = (Button) findViewById(R.id.reset);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                intent = new Intent(getApplicationContext(), SigninActivity.class);
                startActivity(intent);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                name_intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(name_intent);
//            }
//        });

//        logout.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "로그아웃 성공!", Toast.LENGTH_SHORT).show();
//
//                // 로그아웃 부분
//                UserManagement.getInstance()
//                        .requestLogout(new LogoutResponseCallback() {
//                            @Override
//                            public void onCompleteLogout() {
//                                // 로그아웃이 되었다면 로그인 액티비티로 넘어간다.
//                                Intent intent = new Intent(MypageActivity.this, LoginActivity.class);
//                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                                startActivity(intent);
//                            }
//                        });
//            }
//        });

        camping.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                camping.setVisibility(View.GONE);
                filter.setCamping(true);
                db.mypageDao().insert(filter);
            }
        });
        beauty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                beauty.setVisibility(View.GONE);
                filter.setBeauty(false);
                db.mypageDao().insert(filter);
            }
        });
        wealth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                wealth.setVisibility(View.GONE);
                filter.setWealth(false);
                db.mypageDao().insert(filter);
            }
        });
        sports.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sports.setVisibility(View.GONE);
                filter.setSports(false);
                db.mypageDao().insert(filter);
            }
        });
        interior.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                wealth.setVisibility(View.GONE);
                filter.setInterior(false);
                db.mypageDao().insert(filter);
            }
        });
        kids.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                interior.setVisibility(View.GONE);
                filter.setKids(false);
                db.mypageDao().insert(filter);
            }
        });
        device.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                kids.setVisibility(View.GONE);
                filter.setDevice(false);
                db.mypageDao().insert(filter);
            }
        });
        book.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                device.setVisibility(View.GONE);
                filter.setBook(false);
                db.mypageDao().insert(filter);
            }
        });

        fashion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                book.setVisibility(View.GONE);
                filter.setFashion(false);
                db.mypageDao().insert(filter);
            }
        });




        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camping.setVisibility(View.VISIBLE);
                beauty.setVisibility(View.VISIBLE);
                wealth.setVisibility(View.VISIBLE);
                sports.setVisibility(View.VISIBLE);
                interior.setVisibility(View.VISIBLE);
                kids.setVisibility(View.VISIBLE);
                device.setVisibility(View.VISIBLE);
                book.setVisibility(View.VISIBLE);
                fashion.setVisibility(View.VISIBLE);
                filter.setCamping(true);
                filter.setBeauty(true);
                filter.setWealth(true);
                filter.setSports(true);
                filter.setInterior(true);
                filter.setKids(true);
                filter.setDevice(true);
                filter.setBook(true);
                filter.setFashion(true);
            }
        });

        gridView_mypost = findViewById(R.id.gridView_mypost);
        ThumbnailAdapter adapter = new ThumbnailAdapter();

        for (int i=0; i<data.size();i++){
            adapter.addItem(data.get(i));
        }

        gridView_mypost.setAdapter(adapter);





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