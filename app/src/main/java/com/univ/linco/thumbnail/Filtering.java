package com.univ.linco.thumbnail;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Filtering{
    private ArrayList<ThumbnailItem> data;
    private ArrayList<ThumbnailItem> data_all = new ArrayList<>();

    public Filtering(ArrayList<ThumbnailItem> data) {

        this.data = data;
        for (int i=0; i<data.size(); i++){
            data_all.add(data.get(i));
        }
    }

    public ArrayList<ThumbnailItem> sortMine(){
        ArrayList<ThumbnailItem> result = new ArrayList<ThumbnailItem>();

        for (int i=0; i < data.size(); i++){
            if (data.get(i).getUser_id().equals("user_id")){
                result.add(data.get(i));
            }
        }

        return result;
    }

    public ArrayList<ThumbnailItem> sortAll(){
        return data_all;
    }

    Comparator<ThumbnailItem> ThumbnailComparator = new Comparator<ThumbnailItem>() {
        @Override
        public int compare(ThumbnailItem o1, ThumbnailItem o2) {
            return o2.getPeople() - o1.getPeople();
        }
    };

    public ArrayList<ThumbnailItem> sortPopular(){
        ArrayList<ThumbnailItem> result_popular = data;
        Collections.sort(result_popular, ThumbnailComparator);
        return result_popular;
    }
}
