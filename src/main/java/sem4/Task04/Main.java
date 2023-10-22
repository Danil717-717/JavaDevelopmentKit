package sem4.Task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Создать класс справочник сотрудников, который содержит
 внутри коллекцию сотрудников - каждый сотрудник должен
 иметь следующие атрибуты:
     Табельный номер
     Номер телефона
     Имя
     Стаж
 - Добавить метод, который ищет сотрудника по стажу (может быть список)
 - Добавить метод, который выводит номер телефона сотрудника по имени
 (может быть список)
 - Добавить метод, который ищет сотрудника по табельному номеру
 - Добавить метод добавление нового сотрудника в справочник сотрудников
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> worker = new ArrayList<>(
                List.of(
                        new Worker(0, "456789", "Ann", 10),
                        new Worker(2, "456889", "Alex", 12),
                        new Worker(3, "456989", "Vaso", 1),
                        new Worker(4, "455789", "Mixail", 5),
                        new Worker(8, "455789352", "Vaso", 5),
                        new Worker(6, "453789", "Anjela", 8),
                        new Worker(7, "451789", "Ann", 15)
                ));
        System.out.println("1");

        System.out.println("Сотрудник со стажем 8: " + findExperience(worker, 8));
        System.out.println("Сотрудник со стажем 5: " + findExperience(worker, 5));
        System.out.println("Сотрудник со стажем 12: " + findExperience(worker, 12));
        System.out.println("Сотрудник со стажем 20: " + findExperience(worker, 20));

        System.out.println("1 V2");
        findExperience2(worker, 8);
        findExperience2(worker, 20);
        System.out.println();
        System.out.println("1 ver3");
        System.out.println(Arrays.toString(findExp(worker,5)));
        System.out.println(Arrays.toString(findExp(worker,2)));
        System.out.println();

        System.out.println("2 Номер по имени");
        System.out.println(Arrays.toString(findPhone(worker, "Vaso")));
        System.out.println(Arrays.toString(findPhone(worker, "Vassdfsdo")));
        System.out.println();

        System.out.println("3 По табельному");
        findPersonId(worker, 2);
        findPersonId(worker, 3);
        findPersonId(worker, 15);
        System.out.println();

        System.out.println("4 добавление");
        worker.forEach(System.out::println);
        addWorker(worker, new Worker(0, "456789", "Annaho", 10));
        System.out.println();
        worker.forEach(System.out::println);
        System.out.println();

        System.out.println("4 v2");
        addWork(worker,"324345", "Nika",6);
        System.out.println(worker);
        worker.forEach(System.out::println);

    }

    static Worker[] findExp(List<Worker> list, int exp){
        return list.stream().filter(p -> p.getExperience() == exp)
                .toArray(Worker[]::new);
    }

    static Worker findExperience(List<Worker> list, int exp) {
        var res = list.stream().filter(p -> p.getExperience() == exp).findAny();
        String s = "No";
        if (res.isPresent()) {
            return res.get();
        }
        return null;
    }

    static void findExperience2(List<Worker> list, int exp) {
        var res = list.stream().filter(p -> p.getExperience() == exp).findAny();
        String s = "No";
        if (res.isPresent()) {
            System.out.printf("Сотрудник со стажем %d: %s", exp, res.get());
            System.out.println();
        } else {
            System.out.printf("Сотрудник со стажем %d: Нет такого сотрудника", exp);
        }

    }


    static String[] findPhone(List<Worker> list, String name) {
        return list.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .map(p -> p.getPhone()).toArray(String[]::new);
    }

    static void findPersonId(List<Worker> list, int personId) {
        var res = list.stream().filter(p -> p.getPersonId() == personId).findAny();
        if (res.isPresent()) {
            System.out.printf("Сотрудник с табельным номером %d: %s", personId, res.get());
            System.out.println();
        } else {
            System.out.printf("Сотрудник с табельным номером %d: Нет такого сотрудника", personId);
        }
    }

    static void addWorker(List<Worker> list, Worker worker) {

//        var res = list.stream().filter(p -> p.equals(worker)).findAny();

        for (int i = 0; i < list.size(); i++) {
            if(!(list.get(i).getPersonId() == worker.getPersonId())){

                worker.setPersonId(list.stream().mapToInt(Worker::getPersonId).max().getAsInt());
                list.add(worker);

            }
        }


    }

    static void addWork(List<Worker> list,String phone,String name, int exp){
        int lastId = list.stream().mapToInt(Worker::getPersonId).max().getAsInt();
        list.add(new Worker(lastId+1, phone,name,exp));
    }
}
