package com.univ.linco.thumbnail;

import java.util.ArrayList;

public class Filtering{
    private ArrayList<ThumbnailItem> data;

    public Filtering(ArrayList<ThumbnailItem> data) {
        this.data = data;
    }

    public ArrayList<ThumbnailItem> sortMine(){
        ArrayList<ThumbnailItem> result = new ArrayList<ThumbnailItem>();

        for (int i=0; i < data.size(); i++){
            if (data.get(i).getUser_id() == "my"){
                result.add(data.get(i));
            }
        }

        return result;
    }
}
