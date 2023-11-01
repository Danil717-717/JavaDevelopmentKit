package sem5HW.v4;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        //CountDownLatch startSignal = new CountDownLatch(1);
        //CountDownLatch doneSignal = new CountDownLatch(1);


//
//        //doSomethingElse();            // don't let run yet
//        startSignal.countDown();      // let all threads proceed
//        //doSomethingElse();
//        doneSignal.await();           // wait for all to finish

        Philher philosopher1 = new Philher(/*startSignal, doneSignal,*/ "phil1");
        Philher philosopher2 = new Philher(/*startSignal, doneSignal,*/ "phil2");
        Philher philosopher3 = new Philher(/*startSignal, doneSignal,*/ "phil3");
        Philher philosopher4 = new Philher(/*startSignal, doneSignal,*/ "phil4");
        //Philher philosopher5 = new Philher(/*startSignal, doneSignal,*/ "phil5");

        Thread ph1 = new Thread(philosopher1);
        Thread ph2 = new Thread(philosopher2);
        Thread ph3 = new Thread(philosopher3);
        Thread ph4 = new Thread(philosopher4);
        //Thread ph5 = new Thread(philosopher5);

        ph1.start();
        ph2.start();
        ph3.start();
        ph4.start();
       //    ph5.start();



    }
}

