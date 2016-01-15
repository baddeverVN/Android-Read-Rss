package com.example.minhtien.btbuoi10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Objects.Cate;
import adapter.AdapterMenu;

/**
 * Created by minhtien on 1/15/16.
 */
public class MenuActivity extends Activity implements AdapterView.OnItemClickListener{
    public static final String KEY_DATA = "key_data";
    private static final String LINK_1 = "http://www.24h.com.vn/upload/rss/bongda.rss";
    private static final String LINK_2 = "http://www.24h.com.vn/upload/rss/giaoducduhoc.rss";
    private static final String LINK_3 = "http://www.24h.com.vn/upload/rss/anninhhinhsu.rss";

    private ListView listCates;
    private ArrayList<Cate> arrCates;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initData();
        initViews();

    }

    private void initViews() {
        listCates = (ListView) findViewById(R.id.listMenu);
        AdapterMenu adapter = new AdapterMenu(this,R.layout.activity_item_menu,arrCates);
        listCates.setAdapter(adapter);
        listCates.setOnItemClickListener(this);
    }

    private void initData() {
        arrCates = new ArrayList<Cate>();
        arrCates.add(new Cate(R.drawable.bongda,"Bóng đá"));
        arrCates.add(new Cate(R.drawable.giaoduc,"Giáo Dục"));
        arrCates.add(new Cate(R.drawable.phapluat,"An ninh - Hình sự"));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0 :
                intent = new Intent(MenuActivity.this,MainActivity.class);
                intent.putExtra(KEY_DATA, LINK_1);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(MenuActivity.this,MainActivity.class);
                intent.putExtra(KEY_DATA, LINK_2);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(MenuActivity.this,MainActivity.class);
                intent.putExtra(KEY_DATA, LINK_3);
                startActivity(intent);
                break;
        }
    }
}
