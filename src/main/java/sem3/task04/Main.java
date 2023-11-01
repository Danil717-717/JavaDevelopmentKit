package sem3.task04;

import java.util.Random;

/*
Описать интерфейс Person с методами doWork() и haveRest().
 Написать два класса работник и бездельник, реализующих интерфейс.
  Работник работает, и не умеет бездельничать, в то время как
  бездельник не умеет работать, но умеет отдыхать.
   Написать обобщённые классы Workplace и Club, содержащие
   массив из Person. В классах необходимо
  вызывать у всего массива людей вызывать соответствующие методы.
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        int quntity = 15; //random.nextInt(20);
        Person[] person = new Person[quntity];

        for(int i = 0; i < quntity; i++){
            if(random.nextBoolean()){
                person[i] = new Worker();
            }else {
                person[i] = new Slacker();
            }
        }

        System.out.println("-----Club-----");
        Club<Person> club = new Club<>(person);
        System.out.println("-----Work-----");
        Workplace<Person> workplace = new Workplace<>(person);
    }

}
