package com.univ.linco.mypage;
//..

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.univ.linco.mypage.database.Filter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.univ.linco.MainActivity;
import com.univ.linco.R;
import com.univ.linco.mypage.database.FilterClient;
import com.univ.linco.mypage.database.FilterDao;
import com.univ.linco.posting.DetailsActivity;
import com.univ.linco.posting.database.Post;
import com.univ.linco.posting.database.PostClient;
import com.univ.linco.posting.database.PostDao;
import com.univ.linco.signin.SigninActivity;
import com.univ.linco.signup.database.User;
import com.univ.linco.signup.database.UserClient;
import com.univ.linco.signup.database.UserDao;
import com.univ.linco.thumbnail.ThumbnailAdapter;
import com.univ.linco.thumbnail.ThumbnailData;
import com.univ.linco.thumbnail.ThumbnailItem;

import java.util.ArrayList;
import java.util.List;

public class MypageActivity extends AppCompatActivity {
    TextView nickname;
    Intent intent;
    GridView gridView_mypost;
    ThumbnailData thumbnail_data;
    ArrayList<ThumbnailItem> data;
    Intent getID = getIntent();
    FilterDao db;
    Filter data_filter;
    private static final String SHARED_PREF_NAME = "mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);

        //내부 DB 로드
        SharedPreferences pref = getSharedPreferences("login_id", MODE_PRIVATE);
        UserDao userDao = UserClient.getInstance(getApplicationContext()).getAppDatabase().userDao();
        PostDao db_post = PostClient.getInstance(getApplicationContext()).getAppDatabase().postDao();
        FilterDao filterDao = FilterClient.getInstance(getApplicationContext()).getAppDatabase().filterDao();
        User user_info = userDao.getAll().get(pref.getInt("login", 0));

        //뷰 할당
        nickname = findViewById(R.id.nickname);
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

        //이름 할당
        nickname.setText(user_info.getName()+"님");

        //내가 쓴 글 데이터 정리
        ArrayList<Post> my_post = new ArrayList<>();
        for (int i=0; i<db_post.getAll().size(); i++){
            if(db_post.getAll().get(i).getUser_id().equals(user_info.getUser_id())){
                my_post.add(db_post.getAll().get(i));
            }
        }
        thumbnail_data = new ThumbnailData(my_post);
        data = thumbnail_data.getThumbnailData();



        Button[] array_btn = {camping, beauty, wealth, sports, interior, kids, device, book, fashion};

        data_filter = filterDao.getAll().get(filterDao.getAll().size()-1);

        Boolean[] array_filter = {
                data_filter.isCamping(), data_filter.isBeauty(), data_filter.isWealth(),
                data_filter.isSports(), data_filter.isInterior(), data_filter.isKids(),
                data_filter.isDevice(), data_filter.isBook(), data_filter.isFashion()
        };

        for (int i=0; i< array_filter.length; i++){
            if(array_filter[i]==false){
                array_btn[i].setVisibility(View.GONE);
            }
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent = new Intent(getApplicationContext(), SigninActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

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
                filterDao.updateFilter(data_filter);
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

        gridView_mypost.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent to_detail = new Intent(getApplicationContext(), DetailsActivity.class);
                final ThumbnailItem item = (ThumbnailItem) adapter.getItem(position);
                int id_item = item.getPost_id();
                to_detail.putExtra("id", id_item);
                startActivity(to_detail);
            }
        });

    }
}