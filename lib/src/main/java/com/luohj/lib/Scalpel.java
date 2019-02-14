package com.luohj.lib;

import com.luohj.lib.inner.Interceptor;

import java.util.ArrayList;

public class Scalpel<T,R>  {

    private ArrayList<Interceptor<T,R>> interceptors;
    private convertor<T,R> convertor;

    public Scalpel() { interceptors =new ArrayList<>();}


    public Scalpel<T,R> addInterceptor(Interceptor<T,R> func){
        this.interceptors.add(func);
        return this;
    }

    public R apply(T params){
        return new MChain(interceptors, 0, params).proceed(params);
    }


    private  R convert(T params){
        if (convertor!=null) {
            return convertor.convert(params);
        }
        return null;
    }


    public Scalpel<T,R> convert(Scalpel.convertor<T, R> convertor) {
        this.convertor = convertor;
        return this;
    }

    public interface convertor<T,R>{
        R convert(T params);
    }

    class MChain implements Interceptor.Chain<T,R>{

        ArrayList<Interceptor<T,R>> interceptors;
        private int index;

        private T params;

        public MChain(ArrayList<Interceptor<T, R>> interceptors, int index, T params) {
            this.interceptors = interceptors;
            this.index = index;
            this.params = params;
        }

        @Override
        public T params() {
            return params;
        }

        @Override
        public R proceed(T params) {
            if (index >= interceptors.size()) {
                return convert(params);
            }
            Interceptor<T, R> trInterceptor = interceptors.get(index);
            return trInterceptor.intercept(new MChain(interceptors, index + 1, params));
        }
    }

}
