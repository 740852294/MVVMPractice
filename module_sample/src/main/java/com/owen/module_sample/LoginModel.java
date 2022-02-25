package com.owen.module_sample;

import androidx.lifecycle.LifecycleOwner;

import com.owen.framework.http.HttpCallback;
import com.owen.framework.http.RHttp;
import com.owen.framework.mvvm.model.IModelCallback;
import com.owen.library_common.http.Response;

import java.util.TreeMap;

/**
 * 项目名:     MVVMPractice
 * 包名       com.owen.module_sample
 * 文件名:    LoginModel
 * 创建者:    Zheng Yuanle
 * 创建时间:  2022/2/25 13:37
 * 描述:
 */
public class LoginModel {

    /**
     * 登录
     */
    public void login(String account, String password, LifecycleOwner lifecycle, final IModelCallback.Http<UserBean> modelCallback) {
        //构建请求参数
        TreeMap<String, Object> request = new TreeMap<>();
        request.put("username", account);
        request.put("password", password);
        //发送请求
        new RHttp.Builder()
                .post()
                .apiUrl("user/login")
                .addParameter(request)
                .lifecycle(lifecycle)
                .build()
                .execute(new HttpCallback<Response<UserBean>>() {
                    @Override
                    public void onSuccess(Response<UserBean> object) {
                        modelCallback.onSuccess(object.getData());
                    }

                    @Override
                    public void onError(int code, String msg) {
                        modelCallback.onError(code, msg);
                    }

                    @Override
                    public void onCancel() {
                        modelCallback.onCancel();
                    }
                });
    }
}
