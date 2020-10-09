package com.cvilia.netease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cvilia.netease.config.PageUrlConfig;
import com.cvilia.netease.databinding.ActivityMainBinding;

@Route(path = PageUrlConfig.MAIN_PAGE)
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayout = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mLayout.getRoot();
        setContentView(view);
        mLayout.textView.setText("你好啊");
        mLayout.helloTv.setText("都好都好");
    }
}