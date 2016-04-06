package com.example.location.activity;

//import android.app.Activity;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.SearchView;
//import android.support.v4.widget.SearchViewCompat;

import com.example.location.fragment.SearchFragment;
import com.example.location.model.Dialog;
import com.example.location.adapter.MyFragmentAdapter;
import com.example.location.R;


public class MainActivity extends FragmentActivity implements OnClickListener {
    private Menu menu;
    private List<Dialog> list = new ArrayList<Dialog>();
    private PopupWindow popupWindow;
    private ListView listView;
    private SearchView search;
    private MenuItem searchItem;
    private ViewPager pager;
    private View layout;
    private ImageButton wechatButton;
    private ImageButton contactsButton;
    private ImageButton lifeButton;
    private ImageButton myButton;
    private MenuItem overflow;
    private Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setDisplayUseLogoEnabled(false);
       // getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(false);//去掉左上角的程序图标
       //fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_main);
        wechatButton =(ImageButton)findViewById(R.id.button_wechat);
        contactsButton = (ImageButton)findViewById(R.id.button_contacts);
        lifeButton =(ImageButton)findViewById(R.id.button_life);
        myButton = (ImageButton)findViewById(R.id.button_my);
        wechatButton.setOnClickListener(this);
        contactsButton.setOnClickListener(this);
        lifeButton.setOnClickListener(this);
        myButton.setOnClickListener(this);
        pager =(ViewPager)findViewById(R.id.pager);
        MyFragmentAdapter myAdapter = new MyFragmentAdapter(getSupportFragmentManager());
        pager.setAdapter(myAdapter);
        pager.setCurrentItem(0);



        //initDialog( mPager.setCurrentItem(0););
       // DialogAdapter adapter = new DialogAdapter(MainActivity.this,R.layout.layout_item,list);
        //ListView listView = (ListView)findViewById(R.id.list_view);
       // listView.setAdapter(adapter);

        //contentLayout = (LinearLayout)findViewById(R.id.layout_content);
        //getActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        //overflow.setVisible(true);
        return super.onPrepareOptionsMenu(menu);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        //search = (SearchView)menu.findItem(R.id.action_search).getActionView();//搜索框
        searchItem = menu.findItem(R.id.action_search);//搜索框
        search = (SearchView)searchItem.getActionView();
        overflow =menu.findItem(R.id.action_overflow);
        search.setOnSearchClickListener(this);


        return true;
    }

    /**
     * 重写onBackPressed函数，退出搜索框时合上。
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
       // invalidateOptionsMenu();
        search.setIconified(true);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        overflow.setVisible(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
              // FragmentTransaction ft= getSupportFragmentManager().beginTransaction();
                getSupportFragmentManager().popBackStack();//弹出栈顶的transaction
                search.setIconified(true);
                getActionBar().setDisplayHomeAsUpEnabled(false);
                overflow.setVisible(true);
                break;
            case R.id.action_search:

                break;



        }

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //noinspection SimplifiableIfStatement
     //if(item.getItemId()==R.id.action_search){
          // SearchFragment fragment = new SearchFragment();
        //  FragmentManager fragmentManager = getFragmentManager();
       //   FragmentTransaction transaction  = fragmentManager.beginTransaction();
         // transaction.add(R.id.layout_content,fragment);
          //transaction.replace(R.id.layout_content,fragment);
      //  Intent i = new Intent(MainActivity.this,SearchFragment.class);
         // startActivity(i);
       //   transaction.commit();

     // }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
       //v.setBackgroundResource(R.drawable.ic_fingerprint_black_24dp);



        switch(v.getId()) {
            case R.id.action_search:
                getActionBar().setDisplayHomeAsUpEnabled(true);//返回键
                overflow.setVisible(false);//不显示overflow按钮
                //overflow.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
                //invalidateOptionsMenu();



                SearchFragment searchFragment = new SearchFragment();//
                // FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction  = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_main, searchFragment);

                transaction.addToBackStack(null);//按下返回键的时候退出当前SearchFragment
                transaction.commit();
                break;



                 /*getActionBar().setDisplayHomeAsUpEnabled(true);//返回键
                overflow.setVisible(false);//不显示overflow按钮
                 SearchFragment searchFragment = new SearchFragment();//
                // FragmentManager fragmentManager = getSupportFragmentManager();
                 FragmentTransaction transaction  = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_main, searchFragment);

                transaction.addToBackStack(null);//按下返回键的时候退出当前SearchFragment
                transaction.commit();*/

               // transaction.attach(fragment);


               // transaction.replace(R.id.pager,fragment);

                 // Intent i = new Intent(MainActivity.this,SearchFragment.class);
                //startActivity(i);
                //   transaction.commit();
               // setContentView(R.layout.search_field);
              //  Intent i = new Intent(MainActivity.this,SearchActivity.class);
               // startActivity(i);
            case R.id.button_wechat:
                pager.setCurrentItem(0);
                break;
            case R.id.button_contacts:
                pager.setCurrentItem(1);
                break;
            case R.id.button_life:
                pager.setCurrentItem(2);
                break;
            case R.id.button_my:
                pager.setCurrentItem(3);
                break;

            default:
                break;
        }

    }

}

