# scalpel
针对具体业务流程细分中断处理


## feature

1. 具体业务流程中断处理
2. 增加注解处理方式

## 使用

```
//初始化时需要指定参数类型和返回类型
Integer apply = new Scalpel<MainActivity, Integer>()
                //添加中断器
                .addInterceptor(chain -> {
                    Log.i("scalpel>>1", " " + chain.params());
                    Integer aVoid = chain.proceed(chain.params());
                    Log.i("scalpel>>1", "" + aVoid);
                    return aVoid;
                })
                //暴露最终转换逻辑给用户自己处理
                .convert(params -> 100)
                //最后应用
                .apply(this);
```