package deque;

public interface Deque<T> {
    void addfirst(T item);
    void addlast(T item);
    T removefirst();
    T removelast();
    int size();
    public default boolean isEmpty(){
        if(size() == 0) return true;
        return false;
    };
    T get(int index);
}
