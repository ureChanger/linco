package com.univ.linco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;

import com.univ.linco.mypage.MypageActivity;
import com.univ.linco.posting.PostingActivity;
import com.univ.linco.thumbnail.Filtering;
import com.univ.linco.thumbnail.ThumbnailAdapter;
import com.univ.linco.thumbnail.ThumbnailData;
import com.univ.linco.thumbnail.ThumbnailItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_posting;
    ImageButton btn_mypage;
    Button btn_mine;
    Intent intent;
    GridView gridView_thumbnail;
    ThumbnailData thumbnail_data;
    ArrayList<ThumbnailItem> data;
    Filtering filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터 로딩
        thumbnail_data = new ThumbnailData();
        data = thumbnail_data.getThumbnailData();

        filter = new Filtering(data);

        //버튼 인텐트 연결
        btn_posting = findViewById(R.id.btn_posting);
        btn_mypage = findViewById(R.id.btn_mypage);
        btn_mine = findViewById(R.id.button6);

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

                gridView_thumbnail.setAdapter(adapter_mine);
            }
        });

        //그리드뷰 그리기
        gridView_thumbnail = findViewById(R.id.gridView_thumbnail);
        ThumbnailAdapter adapter = new ThumbnailAdapter();

        for (int i=0; i<data.size();i++){
            adapter.addItem(data.get(i));
        }

        gridView_thumbnail.setAdapter(adapter);

    }
}