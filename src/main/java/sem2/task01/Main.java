package sem2.task01;
/*
Необходимо вынести логику работы сервера
в класс ChatServer, а в обработчиках кнопок оставить
только логику нажатия кнопки и журналирования сообщений от
сервера.
Для достижения цели необходимо описать интерфейс «слушатель
 сервера», с методом «получить сообщение», вызывать
 его с одной стороны, и реализовать с другой.
 */

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        //new ChatWindow(new Server(new ConsoleServerListener()));
        new ChatWindow(new Server(new LogServerListener("./src/main/java/sem2/Task01/LogServer")));

    }
}
