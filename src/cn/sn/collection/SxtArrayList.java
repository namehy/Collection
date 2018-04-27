package cn.sn.collection;

import java.util.ArrayList;
import java.util.List;

/*
自己实现一个ArrayList
 */
public class SxtArrayList {
    private Object[] elementData;

    private int size;

    private int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public SxtArrayList() {
        this(10);
    }

    public SxtArrayList(int initialCapacity){
        if (initialCapacity<0){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        elementData=new Object[initialCapacity];

    }

    public void add(Object obj){
        //数组扩容和数据的拷贝
        if(size==elementData.length){
            Object[] newArray=new Object[size*2+1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
          /*  for(int i=0;i<elementData.length;i++){
                newArray[i]=elementData[i];
            }*/
          elementData=newArray;
        }

        elementData[size++]=obj;
        //size++;
    }

    public Object get(int index){
        if (index<0||index>=size){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return elementData[index];
    }


    public static void main(String[] args) {
        SxtArrayList list=new SxtArrayList(3);
        list.add("333");
        list.add("444");
        list.add("5");
        list.add("333");
        list.add("333");
        list.add("333");
        System.out.println(list.size);
        System.out.println(list.get(6));
    }
}
