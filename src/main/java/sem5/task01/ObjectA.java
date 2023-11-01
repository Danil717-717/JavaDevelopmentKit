package sem5.task01;

public class ObjectA extends Thread{

    private String name;
    @Override
    public void run() {
        System.out.println("Выполняется класс А");
    }

     void sleep() throws InterruptedException {
        Thread.sleep(4000);
     }
}
