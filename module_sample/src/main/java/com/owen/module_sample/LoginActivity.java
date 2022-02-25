package com.owen.module_sample;

import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;

import com.owen.library_common.base.BaseActivity;
import com.owen.module_sample.databinding.SampleLoginDataBinding;

/**
 * 项目名:     MVVMPractice
 * 包名       com.owen.module_sample
 * 文件名:    LoginActivity
 * 创建者:    Zheng Yuanle
 * 创建时间:  2022/2/25 13:49
 * 描述:
 */
public class LoginActivity extends BaseActivity<ILoginView,LoginPresenter, SampleLoginDataBinding> implements ILoginView {

    private UserViewModel userViewModel;

    @Override
    protected int layoutId() {
        return R.layout.layout_sample;
    }

    @Override
    protected void initData() {
        getMVVMPresenter().login("ruffian", "test12345");
    }

    @Override
    protected void initView() {
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        getViewDataBinding().setLifecycleOwner(this);
        getViewDataBinding().setUserViewModel(userViewModel);
    }

    @Override
    public LoginPresenter makePresenter() {
        return new LoginPresenter();
    }

    @Override
    public void loginSuccess(UserBean userBean) {
        userViewModel.getUserBean().setValue(userBean);//ViewModel绑定数据直接更新UI
        Toast.makeText(this, "欢迎您，" + userBean.getNickname(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int code, String desc) {
        Toast.makeText(this, desc, Toast.LENGTH_SHORT).show();
    }
}
