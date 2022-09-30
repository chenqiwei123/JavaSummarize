package com.runwsh.JavaCollectionSummarize;

import com.runwsh.JavaCollectionSummarize.Entity.Student;

import java.util.*;
import java.util.function.BiConsumer;

public class MapSummarize {

    public static void main(String[] args) {
        Map<String,String> map=new HashMap();
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
        //map.clear();
        System.out.println(map); //{}

        // map的大小
        int size = map.size();
        System.out.println(size);// 注释掉那个clear就是4 否则就是0

        // 遍历map集合,利用增强for形式
        Set<String> set = map.keySet();
        for (String key : set) {
//            System.out.println(key);
            System.out.println("key="+key+"  value="+map.get(key));
        }
        // 遍历map集合,利用entrySet遍历
        Set<Map.Entry<String,String>> set1 = map.entrySet();
        for (Map.Entry<String, String> stringStringEntry : set1) {
            System.out.println("key: "+stringStringEntry.getKey()+"  value:"+stringStringEntry.getValue());
        }

        // 遍历map集合,利用迭代器遍历
         Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            String key= String.valueOf(iterator.next());
            System.out.println("迭代器遍历: key : "+key  +"   value= "+map.get(key));
        }

        // 遍历map集合,利用lamb遍历
        map.forEach(new BiConsumer<String,String>() {
            @Override
            public void accept(String key, String value) {

            }
        });
        // 实际使用的map遍历 lamb表达式  实际就是使用entryKey进行遍历
        map.forEach((String key1, String value1) -> {
            System.out.println(key1+"="+value1);
            }
        );

        /**
         * 需求创建爱你一个hashmap集合,键是学生对象(Student), 值是籍贯(String)
         * 存储三个键值对元素并遍历
         * 要求: 同姓名,同年龄认为是同一个学生
         */
        // 创建爱你HashMap对象
        HashMap<Student,String> hm=new HashMap<>();
        // 创建三个学生对象
        Student s1=new Student("sunmin","23");
        Student s2=new Student("chenqiwei","25");
        Student s3=new Student("cccc","20");
        Student s4=new Student("chenqiwei","25");
        // 添加元素
        hm.put(s1,"上海");
        hm.put(s2,"南京");
        hm.put(s3,"兰州");
        hm.put(s4,"湖北");
        // keySet遍历
        Set<Student> students = hm.keySet();
        for (Student student : students) {
            System.out.println(student+"="+hm.get(student));
        }
        // Entry遍历
        Set<Map.Entry<Student, String>> entries = hm.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        // lombok
        hm.forEach((student,s)->System.out.println(student+"="+s));
        /**
         * 某个班级80名学生，现在需要组成秋游活动，班长提供了 四个景点依次是(A、 B、C、D),每个学生只
         * 能选择一个景点，请统计出最终哪个景点想去的人数最多。
         */

        //机器生成随机投票系统
        String[] strings={"A","B","C","D"};
        List<String> list=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i < 80; i++) {
            list.add(strings[random.nextInt(strings.length)]);
        }
        Map<String,Integer> map1=new HashMap<>();
        for (String name : list) {
            if (map1.containsKey(name)){
                int count=map1.get(name)+1;
                map1.put(name,count);
            }else {
                map1.put(name,1);
            }
        }
        System.out.println(map1);
        final int[] max = {0};

        map1.forEach((str,count)->{
            if (count> max[0]){
                max[0] =count;
            }
        });
        Set<Map.Entry<String, Integer>> entrySet = map1.entrySet();
        for (Map.Entry<String, Integer> stringIntegerEntry : entrySet) {
            if (stringIntegerEntry.getValue().equals(max[0])){
                System.out.println("最大值的key: "+stringIntegerEntry.getKey()+"="+stringIntegerEntry.getValue());
            }
        }

    }

}
