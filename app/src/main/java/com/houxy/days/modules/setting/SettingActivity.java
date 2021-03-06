package com.houxy.days.modules.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.houxy.days.R;
import com.houxy.days.base.ToolbarActivity;

/**
 * Created by Houxy on 2016/9/29.
 *
 * Info :  SettingActivity.java
 */

public class SettingActivity extends ToolbarActivity{
    @Override
    protected int provideContentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getFragmentManager().beginTransaction().replace(R.id.frameLayout, new SettingFragment()).commit();
        setStatusBar();
    }

    private void initView() {
        setToolBarTitle("设置");
    }

}
