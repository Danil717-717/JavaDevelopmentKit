package sem1.Task02;
/*
 sem1Task02
 Создать окно клиента чата. Окно должно содержать JtextField
 для ввода логина, пароля, IP-адреса сервера, порта подключения
 к серверу, область ввода сообщений, JTextArea область просмотра
 сообщений чата и JButton подключения к серверу и отправки сообщения
 в чат. Желательно сразу сгруппировать компоненты, относящиеся к
 серверу сгруппировать на JPanel сверху экрана, а компоненты,
 относящиеся к отправке сообщения – на JPanel снизу.
 */
public class Main {
    public static void main(String[] args) {
        //new ChatWindow();
        new ConnectWindow();
        System.out.println("Method main() is over");
    }
}
