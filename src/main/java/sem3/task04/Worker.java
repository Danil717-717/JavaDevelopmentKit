package sem3.task04;

public class Worker implements Person{
    @Override
    public void doWork() {
        System.out.println("работаю");
    }

    @Override
    public void haveRest() {
        System.out.println("не умею отдыхать только работаю");
    }
}
