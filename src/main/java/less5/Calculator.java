package less5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Task> queue = new ArrayDeque<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread taskServise = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    executorService.submit(() -> {
                        Task task = queue.poll();//достает таску и убирает ее с очереди

                        if (task != null) {
                            System.out.println("Task " + task + " started");
                            task.run();
                        }
                    });
                    //бери таску и выполни её
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        taskServise.start();
        while (sc.hasNextLine()) {
            //1+2

            try {
//                String[] token = sc.nextLine().split("\\+");
//                int left = Integer.parseInt(token[0]);
//                int right = Integer.parseInt(token[1]);
                int value= Integer.parseInt(sc.nextLine().trim());
                Task task = new Task(value);
                queue.add(task);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

