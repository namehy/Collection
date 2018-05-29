package cn.sn.collection;

import java.util.HashMap;

public class SxtHashSet {

    HashMap map;
    private static final Object PRESENT=new Object();
    int size;

    public int size(){
        return map.size();
    }

    public SxtHashSet(){
        map=new HashMap();
    }

    public void add(Object obj){
        map.put(obj,PRESENT);
        size++;
    }



    public static void main(String[] args){
    SxtHashSet s=new SxtHashSet();
    s.add("aaa");
    s.add(new String("aaa"));

    System.out.println(s.size());


    }
}
