package sem5HW.v2;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(1);
        for (int i = 1; i < 6; i++)
            new Philosopher(sem, i).start();
    }
}




