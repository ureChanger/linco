package com.univ.linco;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.demo.linco.R;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    ImageView gallaryImage , postingBtn , backBtn , userBtn;
    ImageButton emargencyBtn;
    TextView titleTv, mainTv , perTv , progressTv1, seekbarTv;
    SeekBar seekBar1;
    LinearLayout tagLayout;

    final String[] words = new String[] {"저작권 침해", "위험 소지가 있는 제품", "스팸 및 사기 의심"};


    int progressnum = 1;
    int max = 0;
    String numtext = "명의 참여자가 필요해요!";
    String url = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        PostingData data;

        Intent intent = getIntent();
        data = (PostingData) intent.getSerializableExtra("data");

        Log.d("kdm" , "imageuri  : " + data.imageUrl );
        Log.d("kdm" , "title  : " + data.title );
        Log.d("kdm" , "keyword  : " + data.keyword );
        Log.d("kdm" , "num  : " + data.num );
        Log.d("kdm" , "url  : " + data.url );
        Log.d("kdm" , "main  : " + data.main );

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
                Intent intent = new Intent(this , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        userBtn = findViewById(R.id.user_btn);
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(this , MypageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        max = data.num;
        url = data.url;
        seekBar1 = findViewById(R.id.seekbar);
        seekBar1.setPadding(0, 0, 0, 0);
        tagLayout = findViewById(R.id.tag_layout);


        postingBtn.setOnClickListener(view ->{
            goUrl(url);
        });

        emargencyBtn.setOnClickListener(view ->{
            new AlertDialog.Builder(this).setTitle("신고").setMultiChoiceItems(words, null, (dialog, which, isChecked) -> {

            })
                    .setPositiveButton("확인",null)
                    .setNegativeButton("취소",null)
                    .setOnDismissListener(dialog -> {
                        Toast.makeText(getBaseContext(), "신고가 완료되었습니다" ,Toast.LENGTH_SHORT).show();
                    }).show();

        });



        gallaryImage.setImageURI(Uri.parse(data.imageUrl));
        titleTv.setText(data.title);
        mainTv.setText(data.main);
        setSeekbarUi();
        setTagView(getTagString(data.keyword));
    }

    private void setSeekbarUi(){
        seekBar1.setProgress(progressnum);
        seekBar1.setMax(max);
        seekBar1.setOnTouchListener((v, event) -> true);
        int percent = (int)((double)progressnum / (double)max * 100.0);
        perTv.setText(percent + "%");
        String set = "("+progressnum +"/" + max +")";
        seekbarTv.setText(set);
        progressTv1.setText(max-progressnum + numtext);
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
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url)); startActivity(intent);
    }
}