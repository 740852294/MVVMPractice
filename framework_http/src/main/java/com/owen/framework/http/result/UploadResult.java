package com.owen.framework.http.result;

import com.owen.framework.http.UploadCallback;

import java.io.File;

/**
 * UploadResult
 *
 * @author ZhengYuanle
 */
public class UploadResult<T> extends HttpResult implements IUploadResult {

    public UploadResult(UploadCallback<T> httpCallback) {
        super(httpCallback);
    }

    @Override
    public void progress(File file, long currentSize, long totalSize, float progress, int currentIndex, int totalFile) {
        if (mIHttpCallback != null)
            ((UploadCallback) mIHttpCallback).progress(file, currentSize, totalSize, progress, currentIndex, totalFile);
    }
}