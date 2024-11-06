package deque;

public interface Deque<T> {
    public void addFirst(T item);
    public void addLast(T item);
    public T removeFirst();
    public T removeLast();
    public int size();
    public default boolean isEmpty(){
        if(size() == 0) return true;
        return false;
    };
    public T get(int index);
    public boolean equals(Object o);
    public void printDeque();
}
