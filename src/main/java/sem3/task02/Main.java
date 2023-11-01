package sem3.task02;

/*
 Описать собственную коллекцию – список на основе массива.
 Коллекция должна иметь возможность хранить любые типы данных,
 иметь методы добавления и удаления элементов.
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("--Inteeger--");
        Task02<Integer> arrInt = new Task02<>();
        System.out.println("--before--");
        System.out.println(arrInt.info());
        arrInt.add(27500);
        arrInt.add(700);
        arrInt.add(320000);
        System.out.println("--after add--");
        System.out.println(arrInt.info());
        arrInt.remove(320000);
        System.out.println("--after remove--");
        System.out.println(arrInt.info());


        System.out.println();
        System.out.println("--String--");
        Task02<String> arrStrin = new Task02<>();
        System.out.println("--before--");
        System.out.println(arrStrin.info());
        arrStrin.add("27500");
        arrStrin.add("700");
        arrStrin.add("320000");
        System.out.println("--after add--");
        System.out.println(arrStrin.info());
        arrStrin.remove("320000");
        System.out.println("--after remove--");
        System.out.println(arrStrin.info());
    }
}
