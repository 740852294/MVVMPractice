package com.owen.module_sample;

import com.owen.framework.mvvm.view.IMVVMView;

/**
 * 项目名:     MVVMPractice
 * 包名       com.owen.module_sample
 * 文件名:    ILoginView
 * 创建者:    Zheng Yuanle
 * 创建时间:  2022/2/25 13:31
 * 描述:
 */
public interface ILoginView extends IMVVMView {

    void loginSuccess(UserBean userBean);

    void onError(int code, String desc);
}
