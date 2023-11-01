package sem3HW.task02;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(40, 2.2f));
        System.out.println(calculator.multiply(40, 2.2));
        System.out.println(calculator.divide(40, -2));
        System.out.println(calculator.subtract(40, 2));
    }
}
