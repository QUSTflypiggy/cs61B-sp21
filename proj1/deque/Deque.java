package deque;

public interface Deque<T> {
    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    int size();
    public default boolean isEmpty(){
        if(size() == 0) return true;
        return false;
    };
    T get(int index);
}
