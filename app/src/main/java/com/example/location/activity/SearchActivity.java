package com.example.location.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageButton;

import com.example.location.R;

/**
 * Created by Administrator on 2016/4/2.
 */
public class SearchActivity extends Activity {
    private ImageButton friendLife;
    private ImageButton publicPush;
    private ImageButton article;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        
       // setContentView(R.layout.search_field);
        getActionBar().setDisplayShowHomeEnabled(false);//不显示logo
        getActionBar().setDisplayShowTitleEnabled(false);//不显示标题
        //getActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按钮

        friendLife = (ImageButton)findViewById(R.id.search_friend_life);
        publicPush = (ImageButton)findViewById(R.id.search_public_push);
        article = (ImageButton)findViewById(R.id.search_article);
    }
    @Override
    public boolean  onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_search,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
