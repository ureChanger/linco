package com.univ.linco.posting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.BarringInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.univ.linco.MainActivity;
import com.univ.linco.R;
import com.univ.linco.mypage.MypageActivity;
import com.univ.linco.posting.database.Post;
import com.univ.linco.posting.database.PostClient;
import com.univ.linco.posting.database.PostDao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostingActivity extends AppCompatActivity {

    private final int PICK_IMAGE = 11334;
    private ImageView gallaryImage , selectImageIcon;
    private EditText titleEt, keywordEt, numEt, peopleEt, urlEt, mainEt;
    private ImageView postingBtn , backBtn, userBtn;
    private Uri seletedUri;
    private Bitmap bitmap;
    private Date dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        //데이터베이스
        PostDao db = PostClient.getInstance(getApplicationContext()).getAppDatabase()
                .postDao();

        //이미지 할당
        gallaryImage = findViewById(R.id.gallary_image);
        gallaryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickFromGallery();
            }
        });

        //각 뷰 아이디 할당
        titleEt = findViewById(R.id.title_et);
        numEt = findViewById(R.id.input_num_et);
        peopleEt = findViewById(R.id.input_num_people);
        urlEt = findViewById(R.id.input_url_et);
        mainEt = findViewById(R.id.main_text_et);
        keywordEt = findViewById(R.id.keyword_et);
        postingBtn = findViewById(R.id.posting_btn);
        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        userBtn = findViewById(R.id.user_btn);
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext() , MypageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        selectImageIcon = findViewById(R.id.image_select_icon);

        //데이터 입력
        postingBtn.setOnClickListener(view ->{
            String title = "";
            String keyword = "";
            int num = 0;
            int people = 0;
            String url = "";
            String main = "";

            if(!TextUtils.isEmpty(titleEt.getText())){
                title = titleEt.getText().toString();
            } else {
                Toast.makeText(this,"제목을 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
                return;
            }
            if(!TextUtils.isEmpty(keywordEt.getText())){
                keyword = keywordEt.getText().toString();
            } else {
                Toast.makeText(this,"키워드를 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            if(!TextUtils.isEmpty(numEt.getText().toString())){
                num = Integer.parseInt(numEt.getText().toString());
            }else {
                Toast.makeText(this,"목표 인원을 제대로 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            if(!TextUtils.isEmpty(peopleEt.getText().toString())){
                people = Integer.parseInt(peopleEt.getText().toString());
            }else {
                Toast.makeText(this,"참여 인원을 제대로 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            if(!TextUtils.isEmpty(urlEt.getText())){
                url = urlEt.getText().toString();
            } else {
                Toast.makeText(this,"URL을 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            if(!TextUtils.isEmpty(mainEt.getText())){
                main = mainEt.getText().toString();
            } else {
                Toast.makeText(this,"본문을 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            if(seletedUri == null){
                Toast.makeText(this,"사진을 선택해 주세요 . " ,Toast.LENGTH_SHORT).show();
                return;
            }

            dt = new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(dt);

            //내부 데이터베이스에 저장
            db.insert(new Post("user_id", keyword, title, main,
                    Integer.parseInt(numEt.getText().toString()),
                    Integer.parseInt(peopleEt.getText().toString()),
                    url, date, seletedUri.toString(),
                    0, "naver"));

            Intent intent = new Intent(this , DetailsActivity.class);

            int id = db.getAll().get(db.getAll().size()-1).getId();
            startActivity(intent);
        });
    }

    //이미지 가져오기
    private void pickFromGallery(){
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        String[] mimeTypes = {"image/jpeg", "image/png"};
        intent.putExtra(Intent.EXTRA_MIME_TYPES,mimeTypes);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }
            selectImageIcon.setVisibility(View.GONE);
            Uri selectedImage = data.getData();
            seletedUri = selectedImage;
            gallaryImage.setImageURI(selectedImage);
        }
    }
}