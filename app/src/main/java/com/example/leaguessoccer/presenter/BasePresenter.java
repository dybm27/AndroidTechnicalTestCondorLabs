package com.example.leaguessoccer.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.leaguessoccer.interfaces.Task;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BasePresenter {

    private final Executor executor = Executors.newSingleThreadExecutor();
    private final Handler handler = new Handler(Looper.getMainLooper());


    public <R> void executeTask(Callable<R> callable, Task<R> callback) {
        executor.execute(() -> {
            final R result;
            try {
                result = callable.call();
                handler.post(() -> {
                    callback.onComplete(result);
                });
            } catch (Exception e) {
                e.printStackTrace();
                callback.onError(e.getMessage());
            }
        });
    }
}
