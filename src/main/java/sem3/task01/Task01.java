package sem3.task01;

import java.io.InputStream;
import java.io.Serializable;

public class Task01 <T extends Comparable, V extends InputStream & Serializable, K extends Number>{
    private T type;
    private V value;
    private K key;

    public Task01(T type, V value, K key) {
        this.type = type;
        this.value = value;
        this.key = key;
    }

    public T getType() {
        return type;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public void showType() {
        System.out.printf("Type of key is %s, type = %s, "+
                        "type of value is %s, value = %s\n"+
                        "type of key is %s, key = %s\n",
                type.getClass().getName(),getType(),
                value.getClass().getName(),getValue(),
                key.getClass().getName(), getKey());
    }
}
