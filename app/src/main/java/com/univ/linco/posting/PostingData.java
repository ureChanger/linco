package com.univ.linco.posting;

import android.net.Uri;
import android.os.Parcelable;

import java.io.Serializable;

public class PostingData  implements Serializable {
    String id = "00005"; // todo 나중에 아이디값 세팅 할때 사용
    String title = "";
    String imageUrl ;
    String keyword = "";
    int num = 0;
    String url = "";
    String main = "";


    public PostingData(String title, String imageUrl, String keyword, int num, String url, String main) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.keyword = keyword;
        this.num = num;
        this.url = url;
        this.main = main;
    }

    public PostingData(String title, String keyword, int num, String url, String main) {
        this.title = title;
        this.keyword = keyword;
        this.num = num;
        this.url = url;
        this.main = main;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }


}