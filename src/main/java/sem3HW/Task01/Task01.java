package sem3HW.Task01;

import java.util.Arrays;
import java.util.Iterator;

public class Task01 <T> implements Iterator<T>,Iterable<T> {

    private T[] arr;
    private Integer index = 0;


    public Task01(T[] arr) {
        this.arr = arr;
    }

    public void add(T t){
        T[] temp_arr = (T[]) new Object[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            temp_arr[i] = arr[i];
        }
        temp_arr[temp_arr.length -  1] = t;

        arr = temp_arr;

    }

    public void remove(T t){
        Integer position = find(t);
        if(position != null){
            T[] temp_arr = (T[]) new Object [arr.length - 1];

            for (int i = 0; i <position; i++) {
                temp_arr[i] = arr[i];
            }

            for (int i = position; i < arr.length -1; i++) {
                temp_arr[i] = arr[i + 1];
            }

            arr = temp_arr;
        }
    }

    public Integer find(T t){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals(t)) return i;
        }
        return null;
    }

    public String info(){
        return Arrays.toString(arr);
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


