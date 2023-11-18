package sem6;

import javax.management.ImmutableDescriptor;
import java.util.Set;

/*
В рамках выполнения задачи необходимо:
    ● Создать свой Java Gradle проект;
    ● Добавить зависимость Guava (популярная библиотека от Google, содержащая набор
      утилитарных механизмов).
    ● Воспользоваться утилитарным классом Lists:
    ○ Развернуть список элементов
    ○ Получить лист Character из строки
    ○ Разделить лист на группы по 2 элемента
    ● Воспользоваться утилитарным классом Sets
    ○ Получить итоговый Set из двух коллекций
    ○ Получить итоговый Set из общих элементов двух коллекций
    ○ Получить итоговый Set из непересекающихся элементов двух коллекций
 */
public class Task02 {

    /*
    dependencies{
    implementation("com.google.guava","guava","32.1.2-jre")
    }
     */
    public static void main(String[] args) {
//        Lists.charactersOf("My string 1"); //Получить лист Character из строки
//
//        //v1 Разделить лист на группы по 2 элемента
//        ImmutableList<Character> list = Lists.charactersOf("My string 1");
//        for(int i = 0; i <list.size() - 2; i=i+2){
//            System.out.println(list.subList(i,i+2));
//        }
//        //v2 Разделить лист на группы по 2 элемента
//        System.out.println(Lists.partition(Lists.charactersOf("My string 1"),2));
//
//        //Получить итоговый Set из двух коллекций
//        System.out.println(Sets.union(Set.of(1,2,3,4),Set.of(3,4,5,6)));
//        //Получить итоговый Set из общих элементов двух коллекций
//        System.out.println(Sets.intersecttion(Set.of(1,2,3,4),Set.of(3,4,5,6)));
//        //Получить итоговый Set из непересекающихся элементов двух коллекций
//        System.out.println(Sets.difference(Set.of(1,2,3,4),Set.of(3,4,5,6)));

    }
}
