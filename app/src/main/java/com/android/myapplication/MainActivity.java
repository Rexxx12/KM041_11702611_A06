package com.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

        Toolbar Tbar;
        TabLayout Tlayout;
        ViewPager Vpager;
        PagerAdapter PageAdapter;
        TabItem Tabchats;
        TabItem TabStatus;
        TabItem TabCalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tbar=findViewById(R.id.toolbar);
        Tbar.setTitle(getResources().getString(R.string.app_name));
        setSupportActionBar(Tbar);

        Tlayout = findViewById(R.id.tab_layout);
        Tabchats=findViewById(R.id.tab1);
        TabStatus=findViewById(R.id.tab2);
        TabCalls=findViewById(R.id.tab3);
        Vpager=findViewById(R.id.viewpager);

        PageAdapter=new PageAdapter(getSupportFragmentManager(),Tlayout.getTabCount());
        Vpager.setAdapter(PageAdapter);


        Tlayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Vpager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==1)
                {
                    Tbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
                    Tlayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorAccent));
                }
                else if(tab.getPosition()==2)
                {
                    Tbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.darker_gray));
                    Tlayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,android.R.color.holo_orange_dark));
                }
                else
                {
                    Tbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                    Tlayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.colorPrimary));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Vpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(Tlayout));
    }
}
