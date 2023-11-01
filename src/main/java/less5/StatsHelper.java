package less5;

import java.util.Scanner;
import java.util.TreeMap;

public class StatsHelper {
    private static int count = 0;

    public static void main(String [] args) throws InterruptedException{

        Thread readThred = new Thread(()->{
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine() && !Thread.interrupted()){
                sc.nextLine();
                count++;
            }
        });
        readThred.setDaemon(true);//этот поток может быть сервисным
        readThred.start();
        readThred.interrupt(); //прерывает поток с проверкой в условие
        while (true){
            System.out.println(count + " messages inputted by user");
            Thread.sleep(1000);
        }
    }
}
