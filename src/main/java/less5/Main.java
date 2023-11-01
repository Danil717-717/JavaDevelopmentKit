package less5;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(Thread.currentThread().getName());

//        for (int i = 0; i < 3; i++) {
//            new MyThread().start();
//        }
//
//        //Hello from Thread[Thread-0,5,main]
//        //                 имя, приоритет, группа потока
//
//        for (int i = 0; i < 3; i++) {
//            new Thread(new MyRunnable()).start();
//        }
//
//        for (int i = 0; i < 3; i++) {
//            new Thread(() ->{
//                System.out.println("3. Hello from "
//                        + Thread.currentThread());
//            }).start();
//        }

        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
        //tic.setDaemon(true);// сервисный поток, если main
        //tac.setDaemon(true); //закончил свою деятельность, то все остальные тоже,
        //а не сервисный поток будет жить пока его не остановят
        tic.start();
        tac.start();
    }
}
