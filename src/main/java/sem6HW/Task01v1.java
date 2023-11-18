package sem6HW;

import java.util.Random;
import java.util.Scanner;
/*
  Домашнее задание
  В качестве задачи предлагаю вам реализовать код для
  демонстрации парадокса Монти Холла и наглядно убедиться
  в верности парадокса
  (запустить игру в цикле на 1000 и вывести итоговый счет).
  Необходимо:
    ● Создать свой Java Maven или Gradle проект;
    ● Самостоятельно реализовать прикладную задачу;
    ● Сохранить результат в HashMap<шаг теста, результат>
    ● Вывести на экран статистику по победам и поражениям
 */

public class Task01v1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random generator = new Random();
        int userDoor, openDoor, otherDoor;

        // generate random value 1 to 3
        int prizeDoor = generator.nextInt(3) + 1;
        int goatDoor1 = prizeDoor;
        while (goatDoor1 == prizeDoor) {
            goatDoor1 = generator.nextInt(3) + 1;
        }
        int goatDoor2 = goatDoor1;
        while (goatDoor2 == goatDoor1 || goatDoor2 == prizeDoor) {
            goatDoor2 = generator.nextInt(3) + 1;
        }

        // begin Game
        System.out.println("Добро пожаловать на игровое шоу Монти Холла!");
        System.out.print("Выберите дверь (1, 2, или 3): ");
        userDoor = scan.nextInt();

        // validation
        if (userDoor > 3 || userDoor <= 0) {
            System.out.print("Пожалуйста выберите дверь 1, 2, или 3");
            userDoor = scan.nextInt();
        } else {
            if (userDoor == goatDoor1) {
                openDoor = goatDoor2;
                otherDoor = prizeDoor;
            } else if (userDoor == goatDoor2) {
                openDoor = goatDoor1;
                otherDoor = prizeDoor;
            } else {
                openDoor = goatDoor1;
                otherDoor = goatDoor2;
            }

            System.out.println("\nЧерез мгновение я покажу вам, где находится приз, " +
                    "\nно сначала я покажу вам, что находится за " +
                    "одной из других дверей");
            System.out.println("\nЗа дверью номер  " + openDoor
                    + " находятся козы!");
            System.out.println("Вы выбрали дверь номер " + userDoor);
            System.out.print("\nХотели бы вы поменять свою дверь (y/n)? ");

            // take user input Yes or No
            char userReply = scan.next().charAt(0);
            while (userReply != 'y' && userReply != 'n') {
                System.out.print("Пожалуйста, введите либо y/n");
                userReply = scan.next().charAt(0);
            }
            if (userReply == 'y') {
                userDoor = otherDoor;
                System.out.println("Ваш выбор переключился на дверь "
                        + userDoor);
            }

            System.out.println("Приз находится за дверью номер: "
                    + prizeDoor);

            // check if user won or lost
            if (userDoor == prizeDoor) {
                System.out.println("Поздравляем! Вы выиграли приз!");
            } else {
                System.out.println("Извините. Вы проиграли игру.");
            }
            scan.close();
        }


    }
}
