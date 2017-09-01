package com.lk.infinitx.core;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.lk.infinitx.injector.Injector;

/**
 * Created by virtualpathum on 30/8/2017.
 */

public abstract class BaseActivity<T> extends AppCompatActivity implements Injector {

    private T component;

    @CallSuper
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
    }

    @NonNull
    @Override
    public T component() {
        if (component == null) {
            component = createComponent();
        }
        return component;
    }

    @NonNull
    protected abstract T createComponent();
}
