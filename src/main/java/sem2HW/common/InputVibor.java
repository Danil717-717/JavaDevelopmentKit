package sem2HW.common;

import java.util.Scanner;

public class InputVibor {
    int num;
    public void UserVibor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Выберете действие: \n" +
                "1. Сумма\n" +
                "2. Конкатенация ");
        num = sc.nextInt();
    }

    public int getNum() {
        return num;
    }
}
