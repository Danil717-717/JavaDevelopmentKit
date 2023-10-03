package sem1.Task02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectWindow extends JFrame{

    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    private static final String WINDOW_NAME = "Подключение к серверу";

    JTextField loginFiled = new JTextField("Введите ваш логин: ");
    JTextField passFiled = new JTextField("Введите ваш пароль: ");
    JTextField serverFiled = new JTextField("Введите сервер: ");
    JButton buttonConnect = new JButton("Подключиться");

    JPanel grid = new JPanel(new GridLayout(4,1));

    ConnectWindow(){
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POSX,WINDOW_POSY,WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        grid.add(loginFiled);
        grid.add(passFiled);
        grid.add(serverFiled);
        grid.add(buttonConnect);

        add(grid);

        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = loginFiled.getText().replace("Введите ваш логин: ", "");
                new ChatWindow(login);
            }
        });

        setVisible(true);
    }
}
