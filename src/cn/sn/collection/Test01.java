package cn.sn.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        //Collection c;
        //ArrayList底层是数组实现，所以查询快，修改，插入，删除慢
        //LinkList 底层是链表，查询慢，修改，插入，删除快
        //Vector线程安全，效率低
        List list=new ArrayList();//左边接口，右边实现类

        list.add("aaa");

        list.add(new Date());

        list.add(1234); //包装类的自动装箱 自动转换Interge

        list.add(new Dog());

        System.out.println(list.size());//里面元素的长度，而不是数组的长度

        System.out.println(list.isEmpty());
        //list.remove("aaa");
        //System.out.println(list.size());

        List list2=new ArrayList();
        list2.add("bbb");
        list2.add("ccc");

        list.add(list2);
        System.out.println(list.size());

        //a跟顺序的操作
        String str= (String) list.get(0);
        System.out.println(str);

        list.set(1,"ababa");

    }
    public static class Dog{

    }
}
