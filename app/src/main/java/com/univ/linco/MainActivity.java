package com.univ.linco;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

import com.univ.linco.mypage.MypageActivity;
import com.univ.linco.posting.DetailsActivity;
import com.univ.linco.posting.PostingActivity;
import com.univ.linco.posting.database.Post;
import com.univ.linco.posting.database.PostClient;
import com.univ.linco.posting.database.PostDao;
import com.univ.linco.posting.database.PostDummyData;
import com.univ.linco.thumbnail.Filtering;
import com.univ.linco.thumbnail.ThumbnailAdapter;
import com.univ.linco.thumbnail.ThumbnailData;
import com.univ.linco.thumbnail.ThumbnailItem;

import java.util.ArrayList;
import java.util.List;
import java.util.function.LongFunction;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_posting, btn_mypage;
    Button btn_mine, btn_all, btn_popular;
    Intent intent;
    GridView gridView_thumbnail;
    List<Post> data_db;
    ThumbnailData thumbnail_data;
    ArrayList<ThumbnailItem> data;
    Filtering filter;
    ThumbnailAdapter adapter = new ThumbnailAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //데이터베이스
        PostDao db = PostClient.getInstance(getApplicationContext()).getAppDatabase()
                .postDao();

        data_db = db.getAll();

        //메인 썸네일 데이터 세팅
        thumbnail_data = new ThumbnailData(data_db);
        data = thumbnail_data.getThumbnailData();

        filter = new Filtering(data);

        //버튼 인텐트 연결
        btn_posting = findViewById(R.id.btn_posting);
        btn_mypage = findViewById(R.id.btn_mypage);
        btn_mine = findViewById(R.id.btn_mine);
        btn_all = findViewById(R.id.btn_all);
        btn_popular = findViewById(R.id.btn_popular);

        btn_posting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), PostingActivity.class);
                startActivity(intent);
            }
        });

        btn_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
            }
        });

        btn_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ThumbnailItem> data_mine = filter.sortMine();
                ThumbnailAdapter adapter_mine = new ThumbnailAdapter();
                for (int i=0; i<data_mine.size(); i++){
                    adapter_mine.addItem(data_mine.get(i));
                }

                adapter = adapter_mine;

                gridView_thumbnail.setAdapter(adapter);
            }
        });

        btn_all.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ArrayList<ThumbnailItem> data_all = filter.sortAll();
                        ThumbnailAdapter adapter_all = new ThumbnailAdapter();
                        for (int i=0; i<data_all.size(); i++){
                            adapter_all.addItem(data_all.get(i));
                        }

                        adapter = adapter_all;

                        gridView_thumbnail.setAdapter(adapter);
                    }
                }
        );

        btn_popular.setOnClickListener(
                new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onClick(View v) {
                        ArrayList<ThumbnailItem> data_popular = filter.sortPopular();
                        ThumbnailAdapter adapter_popular = new ThumbnailAdapter();
                        for (int i=0; i<data_popular.size(); i++){
                            adapter_popular.addItem(data_popular.get(i));
                        }

                        adapter = adapter_popular;

                        gridView_thumbnail.setAdapter(adapter);
                    }
                }
        );

        //그리드뷰 그리기
        gridView_thumbnail = findViewById(R.id.gridView_thumbnail);

        for (int i=0; i<data.size();i++){
            adapter.addItem(data.get(i));
        }

        gridView_thumbnail.setAdapter(adapter);
        
        gridView_thumbnail.setOnItemClickListener(new AdapterView.OnItemClickListener(){
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