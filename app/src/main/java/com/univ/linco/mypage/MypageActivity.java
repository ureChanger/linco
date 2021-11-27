package com.univ.linco.mypage;
//..

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.univ.linco.mypage.database.Filter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.univ.linco.MainActivity;
import com.univ.linco.R;
import com.univ.linco.mypage.database.FilterClient;
import com.univ.linco.mypage.database.FilterDao;
import com.univ.linco.posting.database.Post;
import com.univ.linco.posting.database.PostClient;
import com.univ.linco.posting.database.PostDao;
import com.univ.linco.signin.SigninActivity;
import com.univ.linco.thumbnail.ThumbnailAdapter;
import com.univ.linco.thumbnail.ThumbnailData;
import com.univ.linco.thumbnail.ThumbnailItem;

import java.util.ArrayList;
import java.util.List;

public class MypageActivity extends AppCompatActivity {
    TextView txtResult;
    Intent intent;
    GridView gridView_mypost;
    ThumbnailData thumbnail_data;
    ArrayList<ThumbnailItem> data;
    SharedPreferences sharedPreferences;
    Intent getID = getIntent();
    String getnickname = "링코";
    FilterDao db;
    Filter data_filter;
    private static final String SHARED_PREF_NAME = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);
//        txtResult = (TextView) findViewById(R.id.txtResult);

        PostDao db_post = PostClient.getInstance(getApplicationContext()).getAppDatabase().postDao();

        ArrayList<Post> my_post = new ArrayList<>();
        for (int i=0; i<db_post.getAll().size(); i++){
            if(db_post.getAll().get(i).getUser_id().equals("user_id")){
                my_post.add(db_post.getAll().get(i));
            }
        }
        thumbnail_data = new ThumbnailData(my_post);
        data = thumbnail_data.getThumbnailData();

        db = FilterClient.getInstance(getApplicationContext()).getAppDatabase().filterDao();
        data_filter = db.getAll().get(db.getAll().size()-1);

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

        Button[] array_btn = {camping, beauty, wealth, sports, interior, kids, device, book, fashion};
        Boolean[] array_filter = {
                data_filter.isCamping(), data_filter.isBeauty(), data_filter.isWealth(),
                data_filter.isSports(), data_filter.isInterior(), data_filter.isKids(),
                data_filter.isDevice(), data_filter.isBook(), data_filter.isFashion()
        };

        for (int i=0; i<array_btn.length; i++){
            Log.d("test_filter", array_filter[i].toString());
            if (array_filter[i]==false){
                array_btn[i].setVisibility(View.GONE);
            }
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.clear();
//                editor.commit();
                finish();
                intent = new Intent(getApplicationContext(), SigninActivity.class);
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
                data_filter.setCamping(false);
            }
        });
        beauty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                beauty.setVisibility(View.GONE);
                data_filter.setBeauty(false);
            }
        });
        wealth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                wealth.setVisibility(View.GONE);
                data_filter.setWealth(false);
            }
        });
        sports.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sports.setVisibility(View.GONE);
                data_filter.setSports(false);
            }
        });
        interior.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                interior.setVisibility(View.GONE);
                data_filter.setInterior(false);
            }
        });
        kids.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                kids.setVisibility(View.GONE);
                data_filter.setDevice(false);
            }
        });
        device.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                device.setVisibility(View.GONE);
                data_filter.setBook(false);
            }
        });

        book.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                book.setVisibility(View.GONE);
                data_filter.setFashion(false);
            }
        });

        fashion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fashion.setVisibility(View.GONE);
                data_filter.setFashion(false);
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
                data_filter.setCamping(true);
                data_filter.setBeauty(true);
                data_filter.setWealth(true);
                data_filter.setSports(true);
                data_filter.setInterior(true);
                data_filter.setKids(true);
                data_filter.setDevice(true);
                data_filter.setBook(true);
                data_filter.setFashion(true);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.updateFilter(data_filter);
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        gridView_mypost = findViewById(R.id.gridView_mypost);
        ThumbnailAdapter adapter = new ThumbnailAdapter();

        for (int i=0; i<data.size();i++){
            adapter.addItem(data.get(i));
        }

        gridView_mypost.setAdapter(adapter);

    }

    public void log(){
        Log.d("test_filter", "camping:"+Boolean.toString(data_filter.isCamping()));
        Log.d("test_filter", "beauty: "+Boolean.toString(data_filter.isBeauty()));
        Log.d("test_filter", "wealth: "+Boolean.toString(data_filter.isWealth()));
        Log.d("test_filter", "sports: "+Boolean.toString(data_filter.isSports()));
        Log.d("test_filter", "interior: "+Boolean.toString(data_filter.isInterior()));
        Log.d("test_filter", "kids: "+Boolean.toString(data_filter.isKids()));
        Log.d("test_filter", "device: "+Boolean.toString(data_filter.isDevice()));
        Log.d("test_filter", "book: "+Boolean.toString(data_filter.isBook()));
        Log.d("test_filter", "fashion: "+Boolean.toString(data_filter.isFashion()));
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