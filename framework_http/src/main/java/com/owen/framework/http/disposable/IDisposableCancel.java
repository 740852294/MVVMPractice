package com.owen.framework.http.disposable;

/**
 * 调用取消接口定义
 *
 * @author ZhengYuanle
 */
public interface IDisposableCancel {

    public void cancel();

    public boolean isCanceled();
}