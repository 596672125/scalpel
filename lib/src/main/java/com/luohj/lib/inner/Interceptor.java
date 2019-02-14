package com.luohj.lib.inner;

public interface Interceptor<T,R>{

    R intercept(Chain<T,R> chain);

    interface Chain<T,R> {
        T params();

        R proceed(T params);
    }
}
