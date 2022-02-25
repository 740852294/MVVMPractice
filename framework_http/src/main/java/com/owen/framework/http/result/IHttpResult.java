package com.owen.framework.http.result;

/**
 * IHttpResult
 *
 * @author ZhengYuanle
 */
public interface IHttpResult {
    public void onSuccess(String data);

    public void onError(int code, String msg);

    public void onCancel();
}