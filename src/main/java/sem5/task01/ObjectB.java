package sem5.task01;

public class ObjectB implements Runnable{
    private String name;
    @Override
    public void run() {
        System.out.println("Выполняется класс В");
    }

    void sleep() throws InterruptedException {
        Thread.sleep(4000);
    }
}
