package sem3HW.task02;

public class Calculator {

    public static <T extends Number> double sum(T num1, T num2){
        double res = num1.doubleValue() + num2.doubleValue();
        return res;
    };

    public static <T extends Number> double multiply(T num1, T num2){
        double res = num1.doubleValue() * num2.doubleValue();
        return res;
    };

    public static <T extends Number> double divide(T num1, T num2){
        double res = num1.doubleValue() / num2.doubleValue();
        return res;
    }

    public static <T extends Number> double subtract(T num1, T num2){
        double res = num1.doubleValue() - num2.doubleValue();
        return res;
    };

}
