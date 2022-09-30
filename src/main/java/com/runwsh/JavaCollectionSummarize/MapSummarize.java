package com.runwsh.JavaCollectionSummarize;

import java.util.HashMap;
import java.util.Map;

public class MapSummarize {

    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("name","张三");
        map.put("sex","男");
        map.put("age","18岁");

        // put (分为两种 1.添加(返回null)  2. 替换(返回未添加前该键对应的值))
        Object score = map.put("score", "90");
        System.out.println(score); // null
        Object put = map.put("name", "李四");
        System.out.println(put);  //张三

        // remove 移除 如果移除的key存在返回这个可以key对应的值,否则返回null
        Object sex = map.remove("sex1");
        System.out.println(sex);   // 男  如果map.remove("sex1")找不到key就会返回null
        System.out.println(map);   // {score=90, name=李四, age=18岁}

        // containsKey map是否包含key
        boolean sex1 = map.containsKey("sex");
        System.out.println(sex1);  //true

        // containsValue map中是否存在某个值
         boolean lisi = map.containsValue("李四");
        System.out.println(lisi);  // true

        //isEmpty map是否为空
         boolean empty = map.isEmpty();
        System.out.println(empty); //false

        // clear 清空map集合
        map.clear();
        System.out.println(map); //{}

        // map的大小
        int size = map.size();
        System.out.println(size);// 注释掉那个clear就是4 否则就是0
    }

}
