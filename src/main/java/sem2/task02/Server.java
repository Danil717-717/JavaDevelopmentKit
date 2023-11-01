package sem2.task02;

public class Server implements ServerSocketListener {
    private boolean status;
    private ServerListener serverListener;

    Server(ServerListener serverListener){
        this.status = false;
        this.serverListener = serverListener;
    }

    public void start(){
        String message;
        if (status) {
            message = "Server is already running.";
        } else {
            status = true;
            message = "Server started.";
        }
        serverListener.getMessage(message);
    }

    public void stop(){
        String message;
        if (status) {
            status = false;
            message = "Server stoped.";
        } else {
            message = "Server is already stop.";
        }
        serverListener.getMessage(message);
    }
}
