package cn.sn.collection;

import java.util.LinkedList;

public class SxtMap002 {
    LinkedList[] arr=new LinkedList[999];
    int size;

    public void put(Object key,Object value){
        //System.out.println(key.hashCode());
        SxEntry e=new SxEntry(key,value);

        int hash=key.hashCode();//负数控制
        hash=hash<0?-hash:hash;

        int a=key.hashCode()%arr.length;
        if(arr[a]==null){
            LinkedList list=new LinkedList();
            arr[a]=list;
            list.add(e);
        }else {
            LinkedList list=arr[a];
            for (int i=0;i<list.size();i++){
                SxEntry e2=(SxEntry)list.get(i);
                if(e2.key.equals(key)){
                    e2.value=value;//键值重复直接覆盖
                    return;
                }
            }
            arr[a].add(e);
        }
        //arr[a]=e;
    }

    public Object get(Object key){
        //return arr[key.hashCode()%999];
        int a=key.hashCode()%arr.length;
        if(arr[a]!=null){
          LinkedList list=arr[a];
          for (int i=0;i<list.size();i++){
            SxEntry e=(SxEntry)list.get(i);
            if(e.key.equals(key)){
                return e.value;
            }
          }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
