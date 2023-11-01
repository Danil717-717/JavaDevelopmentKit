package sem3HW.task01;

public class Main {
    public static void main(String[] args) {
        Task01 task01 = new Task01(new Integer[]{1,2,3,4});
        System.out.println(task01.info());
        task01.add(34);
        task01.add(567890);
        task01.add(23567);
        System.out.println("После добавления: " + task01.info());
        task01.remove(34);
        System.out.println("После удаления - 34:  " + task01.info());
    }
}
