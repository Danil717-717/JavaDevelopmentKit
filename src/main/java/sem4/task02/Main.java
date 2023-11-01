package sem4.task02;

import java.util.*;

/*
 Создайте коллекцию мужских и женских имен с помощью интерфейса
 List - добавьте повторяющиеся значения
 Получите уникальный список Set на основании List
 Определите наименьший элемент (алфавитный порядок)
 Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
 Удалите все элементы содержащие букву ‘A’
 */
public class Main {
    public static void main(String[] args) {
        List<String> namePeople = new ArrayList<>();
        namePeople.add("Ann");
        namePeople.add("John");
        namePeople.add("Maryss");
        namePeople.add("NickK");
        namePeople.add("Ann");
        namePeople.add("NickK");
        namePeople.add("Bentayyo");
        System.out.println("List " + namePeople);


        Set<String> namePeopleSet = new HashSet<>(namePeople);
        System.out.println("Set " + namePeopleSet);

        System.out.println("Set min " + namePeopleSet.stream().findFirst());
        System.out.println("Set min " + namePeopleSet.stream().min(Comparator.naturalOrder()).get());

        System.out.println(namePeople.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        }).findFirst().get());


        ArrayList<String> newArr = new ArrayList<>();
        for (String i : namePeople) {
            if((!(i.contains("A")) && (!(i.contains("a"))) )){
                newArr.add(i);
            }
        }
        System.out.println("new List no 'A' ver 1 " + newArr);

        namePeople.removeIf(i -> i.contains("A"));
        namePeople.removeIf(i -> i.contains("a"));
        System.out.println("List no 'A a' ver 2 " + namePeople);

        namePeople.removeIf(i -> i.toLowerCase().contains("a"));
        System.out.println("List no 'A a' ver 3 " + namePeople);


    }
}
