package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T>{
    private T[] array;
    private int front;
    private int back;
    private int size;

    // 构造函数，初始化一个空的 ArrayDeque
    public ArrayDeque() {
        array = (T[]) new Object[8];
        front = 0;
        back = 0;
        size = 0;
    }

    // 扩容或缩容
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        front = 0;
        back = size;
        array = newArray;
    }

    @Override
    // 在前端添加元素
    public void addFirst(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        front = (front - 1 + array.length) % array.length;
        array[front] = item;
        size++;
    }

    @Override
    // 在后端添加元素
    public void addLast(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[back] = item;
        back = (back + 1) % array.length;
        size++;
    }

    @Override
    // 从前端删除元素
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T removedItem = array[front];
        array[front] = null; // 避免内存泄漏
        front = (front + 1) % array.length;
        size--;

        // 判断是否需要缩容
        if (size < array.length / 4 && array.length >= 16) {
            resize(array.length / 2);
        }

        return removedItem;
    }

    @Override
    // 从后端删除元素
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        back = (back - 1 + array.length) % array.length;
        T removedItem = array[back];
        array[back] = null; // 避免内存泄漏
        size--;

        // 判断是否需要缩容
        if (size < array.length / 4 && array.length >= 16) {
            resize(array.length / 2);
        }

        return removedItem;
    }

    @Override
    // 获取指定位置的元素
    public T get(int index) {
        if (index < 0 || index >= size) {return null;}
        return array[(front + index) % array.length];
    }

    // 获取当前 deque 中的元素个数
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new dequeIterator();
    }

    private class dequeIterator implements Iterator<T> {
        private int currentpl;
        public dequeIterator() {
            currentpl = 0;
        }
        @Override
        public boolean hasNext() {
            return currentpl < size;
        }

        @Override
        public T next() {
            return get(currentpl++);
        }
    }
}
