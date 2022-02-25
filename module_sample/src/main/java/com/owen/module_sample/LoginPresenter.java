package com.owen.module_sample;

import com.owen.framework.mvvm.model.IModelCallback;
import com.owen.framework.mvvm.model.ModelFactory;
import com.owen.framework.mvvm.presenter.MVVMPresenter;

/**
 * 项目名:     MVVMPractice
 * 包名       com.owen.module_sample
 * 文件名:    LoginPresenter
 * 创建者:    Zheng Yuanle
 * 创建时间:  2022/2/25 13:48
 * 描述:
 */
public class LoginPresenter extends MVVMPresenter<ILoginView> {

    /**
     * 登录
     */
    public void login(String account, String password) {
        ModelFactory.getModel(LoginModel.class).login(account, password, getView().getLifecycleOwner(), new IModelCallback.Http<UserBean>() {
            @Override
            public void onSuccess(UserBean object) {
                if (!isAttached()) return;
                getView().loginSuccess(object);
            }

            @Override
            public void onError(int code, String msg) {
                if (isAttached()) getView().onError(code, msg);
            }

            @Override
            public void onCancel() {
            }
        });
    }
}