package com.owen.library_common.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.owen.framework.mvvm.component.MVVMFragmentActivity;
import com.owen.framework.mvvm.presenter.IPresenter;
import com.owen.framework.mvvm.view.IMVVMView;
import com.owen.framework.mvvm.viewmodel.IBinding;
import com.owen.library_common.manager.ActivityManager;
import com.owen.library_common.utils.RouterUtils;

/**
 * BaseActivity
 *
 * @author ZhengYuanle
 */
public abstract class BaseActivity<V extends IMVVMView, P extends IPresenter<V>, T extends ViewDataBinding> extends MVVMFragmentActivity<V, P> implements IBinding<T> {

    private ViewDataBinding mViewDataBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityManager.get().push(this);
        super.onCreate(savedInstanceState);
        if (useDataBinding()) {
            mViewDataBinding = DataBindingUtil.setContentView(this, layoutId());
        } else {
            setContentView(layoutId());
        }
        RouterUtils.inject(this);
        initView();
        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManager.get().remove(this);
    }

    /**
     * 提供view资源id
     *
     */
    protected abstract int layoutId();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 初始化view
     */
    protected abstract void initView();

    /**
     * 是否使用数据绑定,子类可重写
     *
     */
    protected boolean useDataBinding() {
        return true;
    }

    /**
     * 获取ViewDataBinding
     *
     */
    @Override
    public T getViewDataBinding() {
        return (T) mViewDataBinding;
    }
}
