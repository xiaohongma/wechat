package com.example.location;

//import android.app.Activity;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.SearchView;
import static android.view.Gravity.TOP;


public class MainActivity extends FragmentActivity implements OnClickListener {
    private Menu menu;
    private List<Dialog> list = new ArrayList<Dialog>();
    private PopupWindow popupWindow;
    private ListView listView;
    private SearchView search;
    private ViewPager pager;
    private View layout;
    private ImageButton wechatButton;
    private ImageButton contactsButton;
    private ImageButton lifeButton;
    private ImageButton myButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().setDisplayUseLogoEnabled(false);
        getActionBar().setDisplayShowHomeEnabled(false);//去掉左上角的程序图标
        wechatButton =(ImageButton)findViewById(R.id.button_wechat);
        contactsButton = (ImageButton)findViewById(R.id.button_contacts);
        lifeButton =(ImageButton)findViewById(R.id.button_life);
        myButton = (ImageButton)findViewById(R.id.button_my);
        wechatButton.setOnClickListener(this);
        contactsButton.setOnClickListener(this);
        lifeButton.setOnClickListener(this);
        myButton.setOnClickListener(this);
        pager =(ViewPager)findViewById(R.id.pager);
        MyFragmentAdapter myAdapter = new MyFragmentAdapter( getSupportFragmentManager());
        getFragmentManager();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
      search = (SearchView)menu.findItem(R.id.action_search).getActionView();
        search.setOnSearchClickListener(this);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

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
                getActionBar().setDisplayHomeAsUpEnabled(true);
              //  Intent i = new Intent(MainActivity.this,SearchActivity.class);
               // startActivity(i);

                break;
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
   /*private void  initPopupMenu(){

        View view = getLayoutInflater().inflate(R.layout.action_more,null);
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT,
               ViewGroup.LayoutParams.WRAP_CONTENT);

        //popupMenu = new PopupMenu();

    }
    public int Dp2Px(Context context, float dp) {
               final float scale = context.getResources().getDisplayMetrics().density;
              return (int) (dp * scale + 0.5f);
           }*/

}

