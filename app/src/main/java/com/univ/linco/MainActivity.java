package com.univ.linco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import com.univ.linco.mypage.MypageActivity;
import com.univ.linco.thumbnail.ThumbnailAdapter;
import com.univ.linco.thumbnail.ThumbnailData;
import com.univ.linco.thumbnail.ThumbnailItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageButton btn_posting;
    ImageButton btn_mypage;
    Intent intent;
    GridView gridView_thumbnail;
    ThumbnailData thumbnail_data;
    ArrayList<ThumbnailItem> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 인텐트 연결
        btn_posting = findViewById(R.id.btn_posting);
        btn_mypage = findViewById(R.id.btn_mypage);

        btn_posting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                intent = new Intent(getApplicationContext(), PostingActivity.class);
//                startActivity(intent);
            }
        });

        btn_mypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
            }
        });


        //그리드뷰 그리기
        gridView_thumbnail = findViewById(R.id.gridView_thumbnail);
        ThumbnailAdapter adapter = new ThumbnailAdapter();

        thumbnail_data = new ThumbnailData();
        data = thumbnail_data.getThumbnailData();

        for (int i=0; i<data.size();i++){
            adapter.addItem(data.get(i));
        }

        gridView_thumbnail.setAdapter(adapter);

    }
}