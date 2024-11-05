package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.comparator = c;
    }

    public T max(){
        if(isEmpty()) return null;
        T mapa=get(0);
        for(int i = 1; i < size(); i++){
            if(comparator.compare(mapa, get(i))<0) mapa=get(i);
        }
        return mapa;
    }

    public T max(Comparator<T> c){
        if(isEmpty()) return null;
        T mapa=get(0);
        for(int i = 1; i < size(); i++){
            if(comparator.compare(mapa,get(i))<0) mapa=get(i);
        }
        return mapa;
    }
}

