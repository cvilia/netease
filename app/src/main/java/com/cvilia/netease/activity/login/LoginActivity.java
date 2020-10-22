package com.cvilia.netease.activity.login;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.cvilia.netease.R;
import com.cvilia.netease.bean.User;
import com.cvilia.netease.component.ProgressDialog;
import com.cvilia.netease.config.Constants;
import com.cvilia.netease.config.PageUrlConfig;
import com.cvilia.netease.databinding.ActivityLoginBinding;
import com.cvilia.netease.framework.BaseActivity;
import com.cvilia.netease.sp.MMKVUtil;
import com.cvilia.netease.utils.Md5;
import com.cvilia.netease.utils.RegexUtils;
import com.cvilia.netease.utils.ToastUtil;

@Route(path = PageUrlConfig.LOGIN_PAGE)
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContact.View, View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @Autowired()
    int loginType;//1 = 手机登录 2 = 邮箱登录

    private ActivityLoginBinding mViewBind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initWidgetEvent() {

    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        mViewBind.actionBar.backIv.setOnClickListener(this);
        mViewBind.loginBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        if (loginType == 2) {
            mViewBind.loginTypeTv.setText(getString(R.string.login_by_email));
            mViewBind.accountEt.setHint(getString(R.string.please_input_email));
        } else {
            mViewBind.accountEt.setInputType(InputType.TYPE_CLASS_PHONE);
        }
    }

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected void setContentView() {
        mViewBind = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mViewBind.getRoot());
    }

    @Override
    public void loginSuccess(User user) {
        dialog.dismiss();
        MMKVUtil.saveString(Constants.USER_ID, user.getAccount().getId() + "");
        MMKVUtil.saveString(Constants.USER_NAME, user.getAccount().getUserName());
        MMKVUtil.saveString(Constants.USER_NICK_NAME, user.getProfile().getNickname());
        MMKVUtil.saveString(Constants.USER_TOKEN, user.getToken());
        ARouter.getInstance().build(PageUrlConfig.MAIN_PAGE).navigation(this, new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                finish();
            }
        });
    }

    @Override
    public void loginFailed() {
        dialog.dismiss();
    }

    @Override
    public void loading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.backIv) {
            finish();
        }
        if (id == R.id.loginBtn) {
            login();
        }
    }

    ProgressDialog dialog;

    private void login() {

        if (loginType == 1) {//手机

        } else if (loginType == 2) {//邮箱
            if (TextUtils.isEmpty(mViewBind.accountEt.getText().toString())) {
                ToastUtil.showShort(getString(R.string.please_input_email));
                return;
            }
            if (!RegexUtils.isMail(mViewBind.accountEt.getText().toString())) {
                ToastUtil.showShort(getString(R.string.err_email));
                return;
            }
            if (TextUtils.isEmpty(mViewBind.passwordEt.getText().toString())) {
                ToastUtil.showShort(getString(R.string.null_password));
                return;
            }
            String password = Md5.getMd5(mViewBind.passwordEt.getText().toString());
            if (!TextUtils.isEmpty(password)) {
                Log.e(TAG, password);
                Context context;
                dialog = new ProgressDialog(this);
                dialog.show();
                mPresenter.loginByEmail(mViewBind.accountEt.getText().toString(), password);
            }
        }

    }
}