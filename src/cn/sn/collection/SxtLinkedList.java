package cn.sn.collection;

import java.util.LinkedList;

public class SxtLinkedList {

    private Node first;
    private Node last;

    private int size;

    public static void main(String[] args) {
        SxtLinkedList list=new SxtLinkedList();
        list.add("aaa");
        list.add("bbb");
        list.add(1,"BBB");
        list.add("ccc");
        //list.remove(2);
        System.out.println(list.get(1));

    }

    public void add(Object obj) {
        if(first==null){
            Node n=new Node();
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);

            first=n;
            last=n;
        }else {
            //直接往last节点后增加新节点
            Node n=new Node();
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);
            last=n;
        }
        size++;

    }

    public int size(){
        return size;
    }

    public Object get(int index){
        rangeCheck(index);

        Node temp =node(index);
        if (temp!=null){
            return temp.obj;
        }

        return null;
    }
    public Node node(int index){
        Node temp=null;
        if(first!=null) {
            if (index<(size>>1)){
                temp=first;
                for (int i=0;i<index;i++){
                    temp=temp.next;
                }
            }else {
                temp=last;
                for (int i=size-1;i>index;i--){
                    temp=temp.previous;
                }
            }

        }
        LinkedList l;
        return temp;
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

    public void remove(int index){
        Node temp=node(index);

        if(temp!=null){
            Node up=temp.previous;
            Node down=temp.next;
            if(up==null){
                first=down;
                size--;
            }else if (down==null){
                last=up;
                size--;
            }
            else {
                up.next=down;
                down.previous=up;
                size--;
            }
        }
    }

    public void add(int index,Object obj){
        Node temp=node(index);

        Node newNode=new Node();
        newNode.obj=obj;
        if (temp!=null){
            Node up=temp.previous;
            up.next=newNode;
            newNode.previous=up;

            newNode.next=temp;
            temp.previous=newNode;

            size++;
        }
    }

}



