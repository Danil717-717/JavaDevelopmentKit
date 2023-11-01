package sem2.task01;

public class ConsoleServerListener implements ServerListener{
    @Override
    public void getMessage(String message) {
        System.out.println(message);
    }
}
