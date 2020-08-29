package com.bytedance.interview2;

import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DownloadTaskUtil {

    private HandlerThread handlerThread = new HandlerThread("download_file");
    private Handler workHandler = new Handler(handlerThread.getLooper());

    static class ErrorCode {
        public static final int ERROR_CODE_INVALID_URL = -1;
        public static final int ERROR_CODE_NO_NETWORK_PERMISSION = -2;
        public static final int ERROR_CODE_NO_STORAGE_PERMISSION = -3;
        public static final int ERROR_CODE_EXT_STORAGE_UNMONTED = -4;
        public static final int ERROR_CODE_SAVE_FAILED = -5;
    }

    interface Callback {
        public void onSuccess(String path);

        public void onFailure(int errorCodeg, String errorMsg);
    }

    public void doDownload(final String url, final Callback callback) {
        if (callback == null) {
            return;
        }

        if (TextUtils.isEmpty(url)) {
            callback.onFailure(ErrorCode.ERROR_CODE_INVALID_URL, "");
            return;
        }

        workHandler.post(new Runnable() {
            @Override
            public void run() {
                doRealWorkInWorkerThread(url, callback);
            }
        });
    }

    private void doRealWorkInWorkerThread(String url, Callback callback) {
        if (!checkNetworkPermission()) {
            callback.onFailure(ErrorCode.ERROR_CODE_NO_NETWORK_PERMISSION, null);
            return;
        }

        if (!checkStoragePermission()) {
            callback.onFailure(ErrorCode.ERROR_CODE_NO_STORAGE_PERMISSION, null);
            return;
        }

        if(Environment.isExternalStorageEmulated()) {
            callback.onFailure(ErrorCode.ERROR_CODE_EXT_STORAGE_UNMONTED, null);
            return;
        }

        String path = downloadFileWithNetwork(url, callback);
        if (!TextUtils.isEmpty(path)) {
            callback.onSuccess(path);
        }
    }

    private boolean checkNetworkPermission() {
        // todo
        // ...
        boolean result = false;
        return result;
    }

    private boolean checkStoragePermission() {
        // todo
        // ...
        boolean result = false;
        return result;
    }

    private String downloadFileWithNetwork(String url, Callback callback) {
        String destiPath = "";

        boolean isDownloadSuccess = false;
        // todo
        // do http request
        if (isDownloadSuccess) {
            // FIXME
            boolean isSaveSuccess = saveFileToSdcard(null, callback);
            if (!isSaveSuccess) {
                callback.onFailure(ErrorCode.ERROR_CODE_SAVE_FAILED, null);
            }
        }

        return destiPath;
    }

    private static final int READ_IO_BUFFER = 4 * 1024;

    private boolean saveFileToSdcard(FileInputStream inputStream, Callback callback) {
        boolean result = true;

        byte[] buffer = new byte[READ_IO_BUFFER];
        try {
            int offset = 0;
            while (inputStream.read(buffer) != -1) {
                FileOutputStream fileOutputStream = new FileOutputStream(getFile());
                fileOutputStream.write(buffer, offset, buffer.length);
                offset += buffer.length;
            }
        } catch (Exception e) {
            result = false;
            callback.onFailure(ErrorCode.ERROR_CODE_SAVE_FAILED, null);
        }

        return result;
    }

    private File getFile() {
        File file = new File(Environment.getDownloadCacheDirectory() + "/ " + System.currentTimeMillis());
        return file;
    }

}
