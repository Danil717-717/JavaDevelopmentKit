package less4;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IteratorCollection {
    public static void main(String[] args) {
                       //List.of - возвращает неизменяемый список
        Collection<String> collors = List.of("White","Black","Red"
        ,"Green","Blue");

        //Iterator
        /*
        E next() - получение сл элемента
        boolean hasNext() - проверка наличия сл элемента
        void remove() - удаление текущего элемента
         */
        Iterator<String> iterator = collors.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        //For each
        for (String str : collors) {
            System.out.print(str + " ");
        }
        System.out.println();

        //Stream Api
        //в Stream api есть встроеный форич
        collors.stream()
                .forEach(value -> System.out.print(value + " "));
        System.out.println();
        //и через лямбду вывводим коллекцию или так
        collors.stream().forEach(System.out::println);
        //метод референс, каждый элемент выводится с новой строки
    }
}
