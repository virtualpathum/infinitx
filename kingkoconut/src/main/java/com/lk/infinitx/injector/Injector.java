package com.lk.infinitx.injector;

import android.support.annotation.NonNull;

/**
 * Created by virtualpathum on 30/8/2017.
 */

public interface Injector<T> {

    @NonNull
    T component();

    void inject();

}
