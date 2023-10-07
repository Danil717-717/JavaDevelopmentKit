package sem2.Task02;

public class ConsoleServerListener implements ServerListener {
    @Override
    public void getMessage(String message) {
        System.out.println(message);
    }
}
