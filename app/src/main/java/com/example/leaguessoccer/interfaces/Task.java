package com.example.leaguessoccer.interfaces;

public interface Task<R> {
    void onComplete(R result);
    void onError(String error);
}
