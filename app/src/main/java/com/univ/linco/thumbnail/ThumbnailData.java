package com.univ.linco.thumbnail;

import java.util.ArrayList;
import java.util.List;

import com.univ.linco.R;
import com.univ.linco.posting.database.AppDatabase;
import com.univ.linco.posting.database.Post;
import com.univ.linco.posting.database.PostDummyData;

public class ThumbnailData {
    private List<Post> db_data;
    private ArrayList<ThumbnailItem> thumbnailData;

    public ThumbnailData(List<Post> db_data) {
        this.db_data = db_data;
        thumbnailData = new ArrayList<ThumbnailItem>(){
            {
                for(int i=0; i<db_data.size(); i++){
                    Post data = db_data.get(i);
                    Integer img_channel = R.drawable.naver;
                    switch (data.getChannel()){
                        case "naver":
                            img_channel = R.drawable.naver;
                            break;
                        case "instagram":
                            img_channel = R.drawable.img_instagram;
                            break;
                    }
                    add(
                            new ThumbnailItem(
                                    data.getId(),
                                    data.getPost_id(),
                                    data.getUser_id(),
                                    data.getDate(),
                                    data.getKeyword(),
                                    data.getUri_image(),
                                    data.getId_drawable(),
                                    data.getTitle(),
                                    data.getTarget(),
                                    data.getPeople(),
                                    img_channel
                            )
                    );
                }
            }
        };
    }

    public List<Post> getDb_data() {
        return db_data;
    }

    public void setDb_data(List<Post> db_data) {
        this.db_data = db_data;
    }

    public void setThumbnailData(ArrayList<ThumbnailItem> thumbnailData) {
        this.thumbnailData = thumbnailData;
    }

    public ArrayList<ThumbnailItem> getThumbnailData(){
        return thumbnailData;
    }
}
