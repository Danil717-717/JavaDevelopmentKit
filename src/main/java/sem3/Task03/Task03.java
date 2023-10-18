package sem3.Task03;

import java.util.Iterator;

public class Task03 <T> implements Iterator<T>,Iterable<T> {

    private T[] arr;
    private Integer index = 0;

    public Task03(T[] arr) {
        this.arr = arr;
    }


    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return (arr.length > index);
    }

    @Override
    public T next() {
        if(hasNext()){
            return arr[index++];
        }
        return null;
    }
}
