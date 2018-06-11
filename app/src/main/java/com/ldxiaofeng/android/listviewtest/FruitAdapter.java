package com.ldxiaofeng.android.listviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by 13178 on 2018-6-9.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId,
                        List<Fruit> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){//每个子项被滚动到屏幕内会被调用
        Fruit fruit = getItem(position);//获得当前fruit实例

        //View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        View view;
        ViewHoler viewHoler;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHoler = new ViewHoler();
            viewHoler.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHoler.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHoler);
        }else{
            view = convertView;
            viewHoler = (ViewHoler) view.getTag();
        }
        //ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        //TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        viewHoler.fruitImage.setImageResource(fruit.getImageId());
        viewHoler.fruitName.setText(fruit.getName());
        return view;
    }

    class ViewHoler{
        ImageView fruitImage;
        TextView fruitName;
    }
}
