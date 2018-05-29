package cn.sn.collection;

import java.util.HashSet;
import java.util.Set;

/*
测试Set的常用方法
 */
public class TestSet {
    public static void main(String[] args) {
        Set set=new HashSet();//c+a+B
        set.add("aaa");
        set.add("bbb");
        set.add(new String("aaa"));
        System.out.println(set.size());
        set.contains("aaa");
        System.out.println(set.contains("aaa"));
        set.remove("aaa");
    }
}
