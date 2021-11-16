package com.univ.linco.posting;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.univ.linco.MainActivity;
import com.univ.linco.R;
import com.univ.linco.mypage.MypageActivity;

public class PostingActivity extends AppCompatActivity {

    private final int PICK_IMAGE = 11334;
    private ImageView gallaryImage , selectImageIcon;
    private EditText titleEt, keywordEt, numEt, urlEt, mainEt;
    private ImageView postingBtn , backBtn, userBtn;
    private Uri seletedUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posting);

        gallaryImage = findViewById(R.id.gallary_image);
        gallaryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickFromGallery();
            }
        });

        titleEt = findViewById(R.id.title_et);
        numEt = findViewById(R.id.input_num_et);
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
        postingBtn.setOnClickListener(view ->{

            String title = "";
            String keyword = "";
            int num = 0;
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

            if(Integer.parseInt(numEt.getText().toString()) > 0){
                num = Integer.parseInt(numEt.getText().toString());
            }else {
                Toast.makeText(this,"참여인원을 제대로 입력해 주세요 . " ,Toast.LENGTH_SHORT).show();
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
            PostingData data = new PostingData(title, seletedUri.toString(), keyword, num, url, main);
            Intent intent = new Intent(this , DetailsActivity.class);
            intent.putExtra("data" , data );
            startActivity(intent);
        });
    }


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