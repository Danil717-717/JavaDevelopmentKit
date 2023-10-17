package sem3.Task02;

import java.util.Arrays;

public class Task02 <T>{
    Object[] arr;

    public Task02() {
        arr = new Object[0];
    }

    public void add(T t){
        Object[] temp_arr = new Object[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            temp_arr[i] = arr[i];
        }
        temp_arr[temp_arr.length -  1] = t;
        
        arr = temp_arr;

    }

    public void remove(T t){
        Integer position = find(t);
        if(position != null){
            Object[] temp_arr = new Object[arr.length - 1];

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
}
