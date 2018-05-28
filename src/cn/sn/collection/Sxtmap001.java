package cn.sn.collection;
/*
自定义实现Map的功能
暂不完美
Map:存放键值对，根据键对象找队友的值对象
 */
public class Sxtmap001 {
    SxEntry[] arr=new SxEntry[990];
    int size;

    public void put(Object key,Object value){
        SxEntry e=new SxEntry(key,value);
        arr[size++]=e;
    }

    public Object get(Object key){
        for (int i=0;i<size;i++){
            if (arr[i].key.equals(key)){
                return arr[i].value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Sxtmap001 m=new Sxtmap001();

    }
}
