package sem3.task04;

public class Slacker implements Person{
    @Override
    public void doWork() {
        System.out.println("не умею работать отдыхаю");
    }

    @Override
    public void haveRest() {
        System.out.println("бездельничаю");
    }
}
