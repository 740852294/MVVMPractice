package com.owen.framework.http;

/**
 * HttpCallback
 *
 * @author ZhengYuanle
 */
public interface HttpCallback<T> {
    public void onSuccess(T object);

    public void onError(int code, String msg);

    public void onCancel();
}