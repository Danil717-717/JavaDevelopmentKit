package sem5HW.v4;

import java.util.Random;


public class Philher implements Runnable {
    private final Object monitor = Philher.class;

    private final String name;
    private final Random random = new Random();

    Philher(String name) {
        this.name = name;
    }

    public synchronized void run() {
        synchronized (monitor) {
            for (int i = 0; i < 3; i++) {
                havingLunch();
                thinking();
                try {
                    monitor.notify();
                    monitor.wait();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            monitor.notify();

        }

    }

    /**
     * Метод философ думает
     */
    public void thinking() {
        System.out.println(name + " размышляет");
        try {
            Thread.sleep(random.nextInt(2000 - 1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод философ обедает
     */
    public void havingLunch() {
        System.out.println(name + " обедает");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
