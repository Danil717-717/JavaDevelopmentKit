package sem2HW.common;

import java.util.Scanner;

public class InpUser {

    int num1;
    int num2;
    public void inputNum(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        num1 = sc.nextInt();
        System.out.println("Введите второе число: ");
        num2 = sc.nextInt();
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
