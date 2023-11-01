package sem5HW.v1_noWork;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/*
Есть пять философов (потоки), которые могут либо обедать либо размышлять.
Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
После каждого приема пищи философ должен размышлять
Не должно возникнуть общей блокировки
Философы не должны есть больше одного раза подряд

Дополнение

Реализовать много поточное приложение имитирующее работу месенджера:
Хранение и работа с логом чата проводится в основном потоке
Остальные потоки - клиенты, хранят в себе имя пользователя, имет графическую
оболочку отображающую чат и позволяющую отправлять сообщения в чат
 */
public class Main {

    static AtomicInteger philosopher1 = new AtomicInteger(); // 0 - размышляет, 1 - обедает
    static AtomicInteger philosopher2 = new AtomicInteger(); // 0 - размышляет, 1 - обедает
    static AtomicInteger philosopher3 = new AtomicInteger(); // 0 - размышляет, 1 - обедает
    static AtomicInteger philosopher4 = new AtomicInteger(); // 0 - размышляет, 1 - обедает
    static AtomicInteger philosopher5 = new AtomicInteger(); // 0 - размышляет, 1 - обедает
    //static AtomicInteger countDiner = new AtomicInteger(4);
    static AtomicBoolean switcher = new AtomicBoolean(true);

    static Random rand = new Random();




    public static void main(String[] args) throws InterruptedException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String dateTimeString = now.format(formatter);
        AtomicBoolean shech = new AtomicBoolean(false);
        CountDownLatch latch = new CountDownLatch(2);


        Thread phil1 = new Thread(() -> {
            AtomicInteger countDiner = new AtomicInteger(3);
            System.out.println(dateTimeString + " Филосов1 думает");
            while (countDiner.get() > 0) {
                try {
                    System.out.println(dateTimeString + " Филосов1 обедает");
                    Thread.sleep(500);
                    System.out.println(dateTimeString + " Филосов1 думает");
                    philosopher1.set(1);
                    countDiner.set(countDiner.get() - 1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread phil2 = new Thread(() -> {
            AtomicInteger countDiner = new AtomicInteger(3);
            System.out.println(dateTimeString + " Филосов2 думает");
            while (countDiner.get() > 0) {
                try {
                    System.out.println(dateTimeString + " Филосов2 обедает");
                    Thread.sleep(500);
                    System.out.println(dateTimeString + " Филосов2 думает");
                    countDiner.set(countDiner.get() - 1);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        Thread phil3 = new Thread(() -> {
            AtomicInteger countDiner = new AtomicInteger(3);
            System.out.println(dateTimeString + " Филосов3 думает");
            while (countDiner.get() > 0) {
                try {
                    //latch.countDown();
                    //shech.set(true);
                    //philosopher3.set(0);
                    System.out.println(dateTimeString + " Филосов3 обедает");
                    Thread.sleep(500);
                    //latch.countDown();
                    System.out.println(dateTimeString + " Филосов3 думает");
                    //latch.countDown();
                    //Thread.sleep(5000);

                    countDiner.set(countDiner.get() - 1);
                    //Thread.interrupted();
                    //latch.countDown();
                    //philosopher3.set(1);
                    //shech.set(false);
                    //latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });


        //Thread ocher = new Thread(() -> {
//            try {
//                //latch.await();
//                phil1.start();
//                phil2.start();
//                phil3.start();
//
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }

            //phil1.start();
//            latch.countDown();
            //phil2.start();
//            latch.countDown();
//            phil3.start();
//            latch.countDown();
//            while ((!(philosopher1.get() == 1)) || (!(philosopher1.get() == 1))){
//                phil1.start();
//            }
//            try {
//                phil1.wait();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }


        //});


        phil1.start();
        //phil1.join();
        phil2.start();
        //phil2.join();
        phil3.start();
//        while (!shech.get()){
//            p
//        }
//        try {
//            phil1.wait();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //phil3.join();
        //ocher.start();


    }
}
