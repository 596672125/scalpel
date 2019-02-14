package com.luohj.scalpel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.luohj.lib.Scalpel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer apply = new Scalpel<MainActivity, Integer>()
                .addInterceptor(chain -> {
                    Log.i("scalpel>>1", " " + chain.params());
                    Integer aVoid = chain.proceed(chain.params());
                    Log.i("scalpel>>1", "" + aVoid);
                    return aVoid;
                })
                .addInterceptor(chain -> {
                    Log.i("scalpel>>2", " " + chain.params());
                    Integer aVoid = chain.proceed(chain.params());
                    Log.i("scalpel>>2", "" + aVoid);
                    return 50;
                })
                .addInterceptor(chain -> {
                    Log.i("scalpel>>3", " " + chain.params());
                    Integer aVoid = chain.proceed(chain.params());
                    Log.i("scalpel>>3", "" + aVoid);
                    return aVoid;
                })
                .addInterceptor(chain -> {
                    Log.i("scalpel>>4", " " + chain.params());
                    Integer aVoid = chain.proceed(chain.params());
                    Log.i("scalpel>>4", "" + aVoid);
                    return aVoid;
                })
                .addInterceptor(chain -> {
                    Log.i("scalpel>>5", " " + chain.params());
                    Integer aVoid = chain.proceed(chain.params());
                    Log.i("scalpel>>5", "" + aVoid);
                    return aVoid;
                })
                .convert(params -> 100)
                .apply(this);
        Log.i("scalpel>>6","apply:"+apply);

    }
}
