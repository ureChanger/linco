package com.univ.linco.posting;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


import com.univ.linco.MainActivity;
import com.univ.linco.R;
import com.univ.linco.mypage.MypageActivity;
import com.univ.linco.posting.PostingData;
import com.univ.linco.posting.database.AppDatabase;
import com.univ.linco.posting.database.Post;
import com.univ.linco.posting.database.PostClient;
import com.univ.linco.posting.database.PostDao;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ImageView gallaryImage , postingBtn , backBtn , userBtn;
    ImageButton emargencyBtn;
    TextView titleTv, mainTv , perTv , progressTv1, seekbarTv;
    SeekBar seekBar1;
    LinearLayout tagLayout;
    Post data;
    int progressnum;


    final String[] words = new String[] {"저작권 침해", "위험 소지가 있는 제품", "스팸 및 사기 의심"};

    int max = 0;
    String numtext = "명의 참여자가 필요해요!";
    String url = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //데이터베이스
        PostDao db = PostClient.getInstance(getApplicationContext()).getAppDatabase()
                .postDao();

        //데이터베이스로부터 SELECT(조회) 쿼리하여 전체 저장 데이터 가져오기
        ArrayList<Post> lstPostData = (ArrayList<Post>) db.getAll();
        // 현재는 임시로 DB List에서 가장 마지막으로 작성 된 게시글 정보를 가져옴
        Intent intent = getIntent();
        int id_item = intent.getIntExtra("id", 0);
        Post post = lstPostData.get(id_item);

        String strTitle = post.getTitle();
        String strImgUrl = post.getUri_image();
        String strKeyword = post.getKeyword();
        int numVal = post.getTarget();
        String strUrl = post.getUrl();
        String strMain = post.getContent();
        progressnum = post.getPeople();
        max = post.getTarget();

        gallaryImage = findViewById(R.id.gallary_image);
        titleTv = findViewById(R.id.title_text);
        mainTv = findViewById(R.id.main_text);
        perTv = findViewById(R.id.seekbar_progress_per_tv);
        seekbarTv = findViewById(R.id.seekbar_progress_text2);
        progressTv1 = findViewById(R.id.seekbar_progress_text1);
        postingBtn = findViewById(R.id.posting_btn2);
        emargencyBtn = findViewById(R.id.emargency_btn);
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        userBtn = findViewById(R.id.user_btn);
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MypageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        url = post.getUrl();
        seekBar1 = findViewById(R.id.seekbar);
        seekBar1.setPadding(0, 0, 0, 0);
        tagLayout = findViewById(R.id.tag_layout);


        postingBtn.setOnClickListener(view -> {
            goUrl(url);
        });

        emargencyBtn.setOnClickListener(view -> {
            new AlertDialog.Builder(this).setTitle("신고").setMultiChoiceItems(words, null, (dialog, which, isChecked) -> {

            })
                    .setPositiveButton("확인", null)
                    .setNegativeButton("취소", null)
                    .setOnDismissListener(dialog -> {
                        Toast.makeText(getBaseContext(), "신고가 완료되었습니다", Toast.LENGTH_SHORT).show();
                    }).show();

        });

        data = post;

        if(data.getUser_id().equals("dummy")){
            gallaryImage.setImageResource(data.getId_drawable());
        }else {
            try {
                Toast.makeText(getApplicationContext(), "내부 이미지 불러옵니다", Toast.LENGTH_SHORT).show();
                gallaryImage.setImageURI(Uri.parse(data.getUri_image()));
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), "어이쿠 오류", Toast.LENGTH_SHORT).show();
                gallaryImage.setImageResource(R.drawable.drawable_error);
            }
        }

        titleTv.setText(data.getTitle());
        mainTv.setText(data.getContent());
        setSeekbarUi();
        setTagView(getTagString(data.getKeyword()));
    }

    private void setSeekbarUi(){
        seekBar1.setOnTouchListener((v, event) -> true);
        int percent = (int)((double)progressnum / (double)max * 100.0);
        perTv.setText(percent + "%");
        String set = "("+progressnum +"/" + max +")";
        seekbarTv.setText(set);
        progressTv1.setText(max-progressnum + numtext);
        seekBar1.setProgress(percent/10);
        seekBar1.setMax(10);
    }


    private String[] getTagString(String tagTxt){
        String[] tagArray = null;
        tagTxt = tagTxt.replace("\n" , "");
        tagArray = tagTxt.split(" ");

        for(int i=0; i<tagArray.length; i++){
            Log.d("kdm" , "tag  : " + tagArray[i]);
        }
        return tagArray;
    }

    private void setTagView( String[] tagArray){
        for(int i=0; i<tagArray.length; i++){
            LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout view = (LinearLayout) inflater.inflate(R.layout.view_tagview, null);
            TextView tv = view.findViewById(R.id.tagview_text);
            tv.setText(tagArray[i]);
            tagLayout.addView(view);
        }
    }

    private void goUrl(String url){
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "url을 정확하게 입력했는지 확인해주세요.", Toast.LENGTH_SHORT).show();
        }

    }
}