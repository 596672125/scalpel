# Scalpel
针对具体业务流程细分中断处理


### 功能

1. 具体业务流程中断处理
2. 增加注解处理方式

### 使用

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

### License


    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.gradle_plugin_android_aspectjx
