package less5;

public class Ocherednost {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(2000);
                System.out.println("work done");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.join();
        System.out.println("Finish");

        for (int i = 0; i < 3; i++) {
            MyThread thread1 = new MyThread();
            thread1.start();
            thread1.join();
        }

        for (int i = 0; i < 3; i++) {
            Thread thread2 = new Thread(new MyRunnable());
            thread2.start();
            thread2.join();
        }
    }
}
