package com.cvilia.netease.activity.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cvilia.netease.R;
import com.cvilia.netease.ViewPagerAdapter;
import com.cvilia.netease.config.PageUrlConfig;
import com.cvilia.netease.databinding.ActivityMainBinding;
import com.cvilia.netease.databinding.TabItemBinding;
import com.cvilia.netease.fragment.CloudFragment;
import com.cvilia.netease.fragment.DiscoverFragment;
import com.cvilia.netease.fragment.MyFragment;
import com.cvilia.netease.fragment.VideoFragment;
import com.cvilia.netease.framework.BaseActivity;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Route(path = PageUrlConfig.MAIN_PAGE)
public class MainActivity extends BaseActivity<MainPresenter> implements MainContact.View , ViewPager.OnPageChangeListener {

    private ActivityMainBinding mViewBind;
    private List<Fragment> mFragments;
    private ViewPagerAdapter mAdapter;
    private static final String[] tabs = {"我的", "发现", "云村", "视频"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setContentView() {
        mViewBind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mViewBind.getRoot());
    }

    @Override
    protected void initWidgetEvent() {

    }

    @Override
    protected void initData() {
        mViewBind.viewPager.addOnPageChangeListener(this);
        mFragments = new ArrayList<>();
        mFragments.add(new MyFragment());
        mFragments.add(new DiscoverFragment());
        mFragments.add(new CloudFragment());
        mFragments.add(new VideoFragment());
        mAdapter = new ViewPagerAdapter(mFragments, getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewBind.viewPager.setAdapter(mAdapter);
        for (int i = 0;i<4;i++){
            TabLayout.Tab tab = mViewBind.tabLayout.newTab();
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_item, null);
            TextView textView = view.findViewById(R.id.tabTv);
            textView.setText(tabs[i]);
            tab.setCustomView(view);
            mViewBind.tabLayout.addTab(tab);
        }
        mViewBind.tabLayout.setupWithViewPager(mViewBind.viewPager);
    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter();
    }

    @Override
    public void loadingSuccess() {

    }

    @Override
    public void loadingFailed() {

    }

    @Override
    public void loading() {

    }

    @Override
    public void dismissLoading() {

    }

    /*******************************************OnPageChangeListener********************************/
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Objects.requireNonNull(mViewBind.tabLayout.getTabAt(position)).select();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    /*******************************************OnPageChangeListener********************************/
}