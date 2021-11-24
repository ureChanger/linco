package com.univ.linco.thumbnail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.univ.linco.R;

import java.util.ArrayList;

public class ThumbnailAdapter extends BaseAdapter {
    ArrayList<ThumbnailItem> items = new ArrayList<ThumbnailItem>();
    Context context; //어플리케이션의 정보를 담고 있음

    public void addItem(ThumbnailItem item){
        items.add(item);
    }

    @Override
    public int getCount(){
        return items.size();
    }

    @Override
    public Object getItem(int position){
        return items.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext(); //context 객체는 acativity의 정보를 읽어 옴
        ThumbnailItem thumbnailItem = items.get(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_grid_thumbnail, parent, false);
        }

        com.github.siyamed.shapeimageview.mask.PorterShapeImageView thumbnail = convertView.findViewById(R.id.img_thumbnail);
        ImageView link = convertView.findViewById(R.id.img_item_ink);
        ImageView img_participants = convertView.findViewById(R.id.img_item_participants);
        TextView participants = convertView.findViewById(R.id.text_item_participants);
        TextView target = convertView.findViewById(R.id.text_item_target);
        TextView title = convertView.findViewById(R.id.text_title);

        thumbnail.setImageResource(thumbnailItem.getDrawable_image());
        link.setImageResource(thumbnailItem.getImg_link());
        img_participants.setImageResource(R.drawable.img_participants);
        participants.setText(thumbnailItem.getPeople().toString()+"명");
        target.setText("("+thumbnailItem.getTarget().toString()+"명)");
        title.setText(thumbnailItem.getTitle());

        return convertView;
    }
}
