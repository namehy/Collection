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

    public void remove(int index){
        rangeCheck(index);
        //删除指定位置的对象
        //a b d e
        int numMoved=size-index-1;
        if (numMoved>0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        /*
        System.arraycopy是native方法，直接在操作内存的，木有新建吧。。。
        elementData[--size] = null; 这显然不是一整个数组，只是让数组中的一个元素指向了 null。
        刚才看了一下源码，先解释你对 remove 的疑惑
        remove 的过程是这样的：

        根据删除的位置：index
        算出需要移动的数组长度：int numMoved = size - index - 1;

        如果 numMoved 大于 0
        则进行数组移动：
        System.arraycopy(elementData, index+1, elementData, index, numMoved);
        将需要删除的位置之后的，numMoved 长度的数组元素，向前移动

        移动过后，list 中需要的数组的长度少了 1
        所以：elementData[--size] = null;
        将多出的这个引用指向 null，让 GC 可以正确回收内存
        并让 size 自减 1 ，保证 size 属性反应出 list 所需要的正确数组长度
        再解释你对 clone 的疑惑
        clone 确实是生成了一个新的 ArrayList 对象：
        ArrayList<E> v = (ArrayList<E>) super.clone();
        这个 v 就是 clone 出来的新对象

        然后：
        v.elementData = Arrays.copyOf(elementData, size);
        这是把当前 ArrayList 中的 elementData 数组 copy 给了新对象 v 的 elementData
        需要说明的是：
        v.elementData 和 elementData 确实是两个数组
        但是它们中的每一个数组元素，在这一刻其实都依次指向着同一个对象
        也就是说：
        v.elementData != elementData
        但是：
        v.elementData[0] == elementData[0]
        v.elementData[1] == elementData[1]
        ……
        v.elementData[size-1] == elementData[size-1]

         */
        elementData[--size]=null;
    }

    public void  remove(Object obj){
        for (int i=0;i<size;i++){
            if (get(i).equals(obj)){//注意

            }
        }
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

    private void rangeCheck(int index){
        if (index<0||index>=size){
            try {
                throw new Exception();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
