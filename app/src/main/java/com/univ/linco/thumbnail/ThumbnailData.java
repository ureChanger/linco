package com.univ.linco.thumbnail;

import java.util.ArrayList;

import com.univ.linco.R;
import com.univ.linco.posting.database.Post;
import com.univ.linco.posting.database.PostDummyData;

public class ThumbnailData {
    //요청하기 코드 "날짜순", 등등
    private PostDummyData postDummyData = new PostDummyData();
    private ArrayList<Post> dummyData = postDummyData.getPostDummyData();

    //임의로 직접 입력
    private ArrayList<ThumbnailItem> thumbnailData = new ArrayList<ThumbnailItem>(){
        {
            for(int i=0; i<dummyData.size(); i++){
                Post data = dummyData.get(i);
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
                                Integer.toString(i),
                                data.getUser_id(),
                                data.getDate(),
                                data.getKeyword(),
                                Integer.parseInt(data.getUri_image()),
                                data.getTitle(),
                                data.getTarget(),
                                data.getPeople(),
                                img_channel
                        )
                );
            }
        }
    };

    public ArrayList<ThumbnailItem> getThumbnailData(){
        return thumbnailData;
    }
}
