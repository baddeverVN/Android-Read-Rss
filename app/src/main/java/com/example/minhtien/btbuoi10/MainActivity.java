package com.example.minhtien.btbuoi10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Objects.Item;
import adapter.AdapterMain;


/**
 * Created by minhtien on 12/01/2016.
 */
public class MainActivity extends Activity implements AdapterView.OnItemClickListener{
    private static final String TEST = "test" ;
    public static final String KEY_LINK = "key_link" ;
    private ArrayList<Item> arrNews;
    private ListView listNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String rss = intent.getStringExtra(MenuActivity.KEY_DATA);

        MyAsynTaskParseXML myAsynTaskParseXML = new MyAsynTaskParseXML(this,handler);
        myAsynTaskParseXML.execute(rss);

        listNews = (ListView) findViewById(R.id.newsList);
        listNews.setOnItemClickListener(this);
    }
    public static int WHAT_DATA=1;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==WHAT_DATA){
                arrNews= (ArrayList<Item>) msg.obj;

                if (arrNews != null)
                    for (Item item : arrNews){
                        Log.d(TEST, item.getTitle());
                        Log.d(TEST,item.getLink());
                        Log.d(TEST,item.getPubDate());
                        Log.d(TEST,item.getImage());
                    }
                else
                {
                    Log.d(TEST,"toach");
                }

                AdapterMain adapter = new AdapterMain(MainActivity.this,R.layout.activity_item_main,arrNews);
                listNews.setAdapter(adapter);
            }
        }
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this,WebActivity.class);
        intent.putExtra(KEY_LINK,arrNews.get(position).getLink().toString());
        startActivity(intent);
    }
}
