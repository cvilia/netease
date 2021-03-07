package com.cvilia.netease.activity;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.cvilia.netease.R;
import com.cvilia.netease.adapter.LocalMusicAdapter;
import com.cvilia.netease.config.PageUrlConfig;
import com.cvilia.netease.databinding.ActivityLocalMusicBinding;
import com.cvilia.netease.framework.BaseActivity;
import com.cvilia.netease.mvp.m.LocalMusicContact;
import com.cvilia.netease.mvp.p.LocalMusicPresenter;
import com.cvilia.netease.service.PlayerIntentService;
import com.cvilia.netease.sqlmodel.LocalMusic;
import com.cvilia.netease.utils.RxPermissionUtils;
import com.cvilia.netease.utils.ToastUtil;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.tbruyelle.rxpermissions3.Permission;

import java.io.IOException;
import java.util.List;

@Route(path = PageUrlConfig.LOCAL_MUSIC_ACTIVITY)
public class LocalMusicActivity extends BaseActivity<LocalMusicPresenter> implements LocalMusicContact.View, OnItemChildClickListener {
    private static String[] PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    private ActivityLocalMusicBinding mBinding;
    private LocalMusicAdapter adapter;
    private MediaPlayer player;

    private PlayerConnection playerConnection;

    @Override
    protected void onViewCreated() {
        player = new MediaPlayer();
        playerConnection = new PlayerConnection();
        RxPermissionUtils.requestPermissions(this, PERMISSIONS, new RxPermissionUtils.OnPermissionCallBack() {
            @Override
            public void onPermissionsGranted() {
                mPresenter.scanLocalMusic();
            }

            @Override
            public void onAtLeastOneReject(Permission permission) {

            }

            @Override
            public void onAllRejectAndDoNotAskAgain(Permission permission) {

            }
        });
    }

    @Override
    protected View getRootView() {
        mBinding = ActivityLocalMusicBinding.inflate(getLayoutInflater());
        return mBinding.getRoot();
    }

    @Override
    protected void initWidgetEvent() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mBinding.recyclerview.setLayoutManager(linearLayoutManager);
        mBinding.recyclerview.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = 60;
            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected LocalMusicPresenter getPresenter() {
        return new LocalMusicPresenter();
    }

    @Override
    public void scanLocalMusicSuccess(List<LocalMusic> musics) {
        if (musics.size() < 1) {
            ToastUtil.showShort("未发现本地音乐");
            return;
        }
        adapter = new LocalMusicAdapter(musics);
        adapter.addChildClickViewIds(R.id.more);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Intent intent = new Intent(LocalMusicActivity.this, PlayerIntentService.class);
            intent.setAction(PlayerIntentService.ACTION_MUSIC);
            intent.putExtra(PlayerIntentService.LOCAL_MUSIC, musics.get(position));
            startService(intent);
        });
        adapter.setOnItemChildClickListener(this);
        View header = LayoutInflater.from(this).inflate(R.layout.item_local_music_header, null);
        adapter.setHeaderView(header);
        mBinding.recyclerview.setAdapter(adapter);
    }

    @Override
    public void scanLocalFail() {

    }

    @Override
    public void loading() {

    }

    @Override
    public void dismissLoading() {

    }

    /*******************************************OnItemChildClickListener********************************/

    @Override
    public void onItemChildClick(@NonNull BaseQuickAdapter adapter, @NonNull View view, int position) {
        if (view.getId() == R.id.more) {
            ToastUtil.showShort("点击更多");
        }
    }

    /*******************************************Inner Class********************************/
    private class PlayerConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}