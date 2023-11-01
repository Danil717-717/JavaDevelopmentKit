package sem2.task02;

public class ConsoleServerListener implements ServerListener {
    @Override
    public void getMessage(String message) {
        System.out.println(message);
    }
}
