package sem6;
import org.apache.commons.math3.stat.*;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

/*
В рамках выполнения задачи необходимо:
    ● Создать свой Java Maven проект;
    ● Добавьте зависимость commons-math3 (предназначена для решения
      математических задач) и изучить интерфейс библиотеки.
    ● Воспользоваться пакетом org.apache.commons.math3.stat и классом
DescriptiveStatistics.
    ○ Создать коллекцию из числовых элементов.
    ○ С помощью объекта DescriptiveStatistics вычислить минимальное и
      максимальное значение, сумму и среднее арифметическое.
    ● Воспользоваться пакетом org.apache.commons.math3.util. С помощью класса
ArithmeticUtils найти:
    ○ факториал числа N.
    ○ Наименьшее общее частное двух чисел
    ○ Наибольший общий делитель двух чисел
    ○ Проверить, что число N это степень двойки
 */

public class Task01 {
    public static void main(String[] args) {
        double [] arr = new double[]{3.1, 3.2, 3.3};
        DescriptiveStatistics ds = new DescriptiveStatistics(arr);
        System.out.println("ds.getMin(): " + ds.getMin());
        System.out.println("ds.getMax(): " + ds.getMax());
        System.out.println("ds.getSum(): " + ds.getSum());
        System.out.println("ds.getMean(): " + ds.getMean());


        System.out.println(ArithmeticUtils.factorial(5));
        System.out.println(ArithmeticUtils.lcm(4,2)); //Наименьшее общее частное двух чисел
        System.out.println(ArithmeticUtils.gcd(4,2)); //Наибольший общий делитель двух чисел
        System.out.println(ArithmeticUtils.isPowerOfTwo(4));
    }
}
