package less4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListCollect {
    public static void main(String[] args) {
        Collection<String> collors = List.of("White","Black","Red"
                ,"Green","Blue");
        Collection<Integer> collection = List.of(1,2,3,4,5);
        ArrayList<Integer> list = new ArrayList<>(collection);

        list.get(1); // O(1)
        list.set(1, 2); // O(1)
        list.contains(1); // O(n)
    }
}
