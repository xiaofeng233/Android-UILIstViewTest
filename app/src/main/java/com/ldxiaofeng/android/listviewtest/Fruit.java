package com.ldxiaofeng.android.listviewtest;

/**
 * Created by 13178 on 2018-6-9.
 */

public class Fruit {

    private String name;

    private int imageId;

    public Fruit(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
