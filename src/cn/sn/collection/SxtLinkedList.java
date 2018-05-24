package cn.sn.collection;

public class SxtLinkedList {

    private Node first;
    private Node last;

    private int size;

    public static void main(String[] args) {
        SxtLinkedList list=new SxtLinkedList();
        list.add("aaa");
        list.add("bbb");
        System.out.println(list.size);

    }

    private void add(Object obj) {
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

}



