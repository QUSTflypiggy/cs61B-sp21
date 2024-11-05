package deque;

public class LinkedListDeque<T> implements Deque<T>{

    //哨兵节点
    private class Node{
        T item;
        Node next;
        Node prev;
        public Node(T item, Node prev, Node next){
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node sentinel;
    private int size;
    //构造函数
    public LinkedListDeque() {
        sentinel=new Node(null,null,null);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size=0;
    }

    @Override
    public void addfirst(T item) {
        //值，上一个点（哨兵节点），下一个点（原来第一个节点）
        Node newNode = new Node(item, sentinel, sentinel.next);
        //更新原头节点
        sentinel.next.prev = newNode;
        //更新哨兵节点
        sentinel.next = newNode;
        size++;
    }

    @Override
    public void addlast(T item) {
        Node newNode=new Node(item,sentinel.prev,sentinel);
        sentinel.prev.next=newNode;
        sentinel.prev=newNode;
        size++;
    }

    @Override
    public T removefirst() {
        if(size==0)return null;
        Node fn=sentinel.next;
        T item=fn.item;
        sentinel.next=fn.next;
        fn.next.prev=sentinel;
        size--;
        return item;
    }

    @Override
    public T removelast() {
        if(size==0)return null;
        Node ln=sentinel.prev;
        T item=ln.item;
        sentinel.prev=ln.prev;
        ln.prev.next=sentinel;
        size--;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    public void printDeque() {
        //if(isEmpty())System.out.println("sdf");
        Node np=sentinel.next;
        while(np!=sentinel){
            System.out.println(np.item);
            np=np.next;
        }
    }

    @Override
    public T get(int x){
        if(x<0||x>size)return null;
        Node be=sentinel.next;
        for(int i=0;i<x;i++){
            be=be.next;
        }
        return be.item;
    }

    public T getRecursive(int x){
        if(x<0||x>size)return null;
        return getRHelp(x,sentinel.next);
    }

    public T getRHelp(int x,Node p){
        if(x==0)return p.item;
        return getRHelp(x-1,p.next);
    }

}
