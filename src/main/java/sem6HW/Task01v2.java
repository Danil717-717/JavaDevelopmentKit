package sem6HW;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Task01v2 {

    public static void main(String[] args) {

        Random random = new Random();
        int trial = 1000;

        String s1 = "Игрок никогда не меняет дверь.";
        String s2 = "Игрок всегда меняет дверь.";
        String s3 = "Всего побед из ";
        String s4 = "Процент выигрыша: ";
        System.out.println(s1);
        int win = 0;
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int contestantDoor = random.nextInt(3);

            if (contestantDoor == prizeDoor) {
                win++;
            }
        }
        int winNewer = win;

        System.out.println(s3 + trial + ": " + win);
        System.out.println(s4 + (double) win / trial);
        System.out.println();


        System.out.println(s2);
        win = 0;
        for (int i = 1; i <= trial; i++) {
            int prizeDoor = random.nextInt(3);
            int contestantDoor = random.nextInt(3);

            int wrongDoor = prizeDoor;
            while (wrongDoor == prizeDoor ||
                    wrongDoor == contestantDoor) {
                wrongDoor = random.nextInt(3);
            }

            int alternateDoor = 3 - (contestantDoor + wrongDoor);

            if (alternateDoor == prizeDoor) {
                win++;
            }
        }


        System.out.println(s2 + trial + ": " + win);
        System.out.println(s3 + (double) win / trial);

        try (FileWriter writer = new FileWriter("./src/main/java/sem6HW/Monty Hall.txt", true)) {
            writer.write(s1 + "\n");
            writer.write(s3 + trial + ": " + winNewer + "\n");
            writer.write(s4 + (double) winNewer / trial + "\n");
            writer.write(s2 + "\n");
            writer.write(s3 + trial + ": " + win + "\n");
            writer.write(s3 + (double) win / trial + "\n");
            writer.write("\n");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
