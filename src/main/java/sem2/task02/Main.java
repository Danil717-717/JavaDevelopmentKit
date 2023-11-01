package sem2.task02;
/*
 Создать интерфейсы ServerSocketThreadListener и
 SocketThreadListener, содержащие методы,
 соответствующие событиям сервера и клиента чата.
 Реализовать созданные интерфейсы простым логированием.
 Со стороны клиента – только SocketThreadListener,
 со стороны сервера – оба интерфейса.
 */

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //new ChatWindow(new Server(new ConsoleServerListener()));
        new ChatWindow(new ConsoleServerListener(), new Server(new LogServerListener("./src/main/java/sem2/Task02/LogServer")));

    }
}
