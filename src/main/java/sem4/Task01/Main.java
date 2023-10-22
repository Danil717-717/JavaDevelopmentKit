package sem4.Task01;
/*
 Создайте коллекцию мужских и женских имен с помощью интерфейса List
 Отсортируйте коллекцию в алфавитном порядке
 Отсортируйте коллекцию по количеству букв в слове
 Разверните коллекцию
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> namePeople = new ArrayList<>();
        namePeople.add("John");
        namePeople.add("Maryss");
        namePeople.add("NickK");
        namePeople.add("Ann");
        namePeople.add("Bentayyo");

        System.out.println("Start List " + namePeople);
        Collections.sort(namePeople);
        System.out.println("List.sort " + namePeople);

        namePeople.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println("List.comporator " + namePeople);

        Collections.reverse(namePeople);
        System.out.println("List.revers " + namePeople);


    }


}
