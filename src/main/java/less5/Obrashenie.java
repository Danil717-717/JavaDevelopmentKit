package less5;

public class Obrashenie {
    static Integer object = Integer.valueOf(0);
    // неизвестно какое будет значение у этой переменной
    // нет гарантии

    public static void main(String[] args) {
        Runnable task = () -> {
            object = object + 1;
            System.out.println(Thread.currentThread().getName());
        };

        Thread thread = new Thread(task);
        thread.start();

        System.out.println(Thread.currentThread().getName());
        object = object + 1;
        System.out.println(object.intValue());
    }
}
