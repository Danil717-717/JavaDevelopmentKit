package sem5HW.v2;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    Semaphore sem; // семафор ограничивающий число философов
    // кол-во приемов пищи
    int num = 0;
    // условный номер философа
    int id;

    // в качестве параметров конструктора передаем идентификатор философа и семафор
    Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 3)// пока количество приемов пищи не достигнет 3
            {
                //Запрашиваем у семафора разрешение на выполнение
                sem.acquire();
                System.out.println("Философ " + id + " обедает");
                // философ ест
                sleep(500);
                num++;

                System.out.println("Философ " + id + " думает");
                sem.release();

                // философ думает
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("у философа " + id + " перерыв");
        }
    }
}
