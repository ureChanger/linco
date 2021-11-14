package com.univ.linco.thumbnail;

import com.univ.linco.R;

import java.util.ArrayList;
import java.util.Arrays;

public class ThumbnailData {
    //요청하기 코드 "날짜순", 등등

    //임의로 직접 입력
    ArrayList<ThumbnailItem> thumbnaiData = new ArrayList<ThumbnailItem>(
            Arrays.asList(
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang"),
                    new ThumbnailItem("00000001", "00000001", "2021-11-09", "camping", R.drawable.img_item_sample, R.drawable.img_instagram, "5명", "(13명)", "편안함 최강 가족용 텐트 / 12인용 / Camp zzang")
            )
    );

    public ArrayList<ThumbnailItem> getThumbnailData(){
        return thumbnaiData;
    }
}
