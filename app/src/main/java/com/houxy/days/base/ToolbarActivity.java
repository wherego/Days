package com.houxy.days.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.houxy.days.R;

/**
 * Created by Houxy on 2016/9/20.
 */

public abstract class ToolbarActivity extends BaseActivity{

    abstract protected int provideContentViewId();
    protected Toolbar mToolBar;
    protected AppBarLayout mAppBarLayout;
    private TextView titleTv; //需要在toolbar里面包含TextView

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentViewId());
        mToolBar = (Toolbar)findViewById(R.id.toolbar);
        mAppBarLayout = (AppBarLayout)findViewById(R.id.app_bar_layout);
        titleTv = (TextView) findViewById(R.id.title_tv);

        if(null == mToolBar || null == mAppBarLayout ){
            throw new IllegalStateException(
                    "The subclass of ToolbarActivity must contain a toolbar.");
        }
        setSupportActionBar(mToolBar);

        if(canBack()){
            if(null != getSupportActionBar()){
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }
    }

    public boolean canBack(){
        return true;
    }

    public void setToolBarTitle(String title){
        if(null != titleTv){
            titleTv.setText(title);
        }
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}