package sem1HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConnectWindow extends JFrame {

    private final int WINDOW_HEIGHT = 400;
    private final int WINDOW_WIDTH = 400;
    private final int WINDOW_POS_X = 600;
    private final int WINDOW_POS_Y = 200;
    private String WINDOW_TITLE = "connection to the server";
    private LogFile logHandler;

    JLabel loginLabel = new JLabel("Введите логин:");

    JTextField loginField = new JTextField();

    JLabel passwordLabel = new JLabel("Введите пароль:");
    JPasswordField passwordField = new JPasswordField();

    JLabel serverLabel = new JLabel("Введите сервер: ");
    JTextField serverField = new JTextField();

    JButton buttonConnect = new JButton("Подключиться");

    JPanel mainGrid = new JPanel(new GridLayout(4,1, 60, 60));
    JPanel loginGrid = new JPanel(new GridLayout(1,1));
    JPanel passwordGrid = new JPanel(new GridLayout(1,1));
    JPanel serverGrid = new JPanel(new GridLayout(1,1));
    ConnectWindow(LogFile logHandler){
        this.logHandler = logHandler;

        setTitle(WINDOW_TITLE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        loginLabel.setHorizontalAlignment(JTextField.CENTER);
        loginGrid.add(loginLabel);
        loginGrid.add(loginField);
        loginField.setBorder(BorderFactory.createCompoundBorder
                (serverField.getBorder(),BorderFactory.
                        createEmptyBorder(10,10,10,10)));

        passwordField.setEchoChar('*');
        passwordGrid.add(passwordLabel);
        passwordGrid.add(passwordField);
        passwordLabel.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setBorder(BorderFactory.createCompoundBorder
                (serverField.getBorder(),BorderFactory.createEmptyBorder
                        (10,10,10,10)));

        serverGrid.add(serverLabel);
        serverGrid.add(serverField);
        serverLabel.setHorizontalAlignment(JTextField.CENTER);
        serverField.setBorder(BorderFactory.createCompoundBorder
                (serverField.getBorder(),BorderFactory.createEmptyBorder
                        (10,10,10,10)));

        mainGrid.add(loginGrid);
        mainGrid.add(passwordGrid);
        mainGrid.add(serverGrid);
        mainGrid.add(buttonConnect);

        add(mainGrid);

        initWindow();


        setVisible(true);
    }

    private void initWindow(){
        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String login = loginField.getText();
                String server = serverField.getText();
                try {
                    new ChatWindow(login, server, logHandler);
                } catch (IOException ex) {
                    // TODO Auto-generated catch block
                    ex.printStackTrace();
                }
                setVisible(false);
            }
        });

    }
}