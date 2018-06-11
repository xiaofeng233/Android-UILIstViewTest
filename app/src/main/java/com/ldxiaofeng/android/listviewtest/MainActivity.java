package com.ldxiaofeng.android.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*private String[] data={"苹果","香蕉","桔子","西瓜","梨子","葡萄",
            "菠萝","草莓", "樱桃","芒果","苹果","香蕉","桔子","西瓜",
            "梨子","葡萄","菠萝","草莓","樱桃","芒果"};*/

    private List<Fruit> fruitList = new ArrayList<>();//动态数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();//初始化数据
        FruitAdapter adapter =new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);//自定义适配器
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,android.R.layout.simple_expandable_list_item_1,data);
            //适配器，当前上下文、    ListView 子项布局的id、   适配的数据
        */
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);//传递适配器对象
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this,fruit.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits(){
        for(int i =0 ; i<2 ; i++){
            Fruit apple = new Fruit("苹果",R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana = new Fruit("香蕉",R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange = new Fruit("桔子",R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("西瓜",R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("梨子",R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape = new Fruit("葡萄",R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("菠萝",R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit("草莓",R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry = new Fruit("樱桃",R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango = new Fruit("芒果",R.drawable.mango_pic);
            fruitList.add(mango);
        }
    }
}
