package sem1.Task02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame{

    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    private static final String WINDOW_NAME = "Чат с сервером";

    JTextArea textOutput = new JTextArea(" ");
    JLabel label = new JLabel("Введите сообщение серверу: ");
    JTextField textInput = new JTextField();
    JButton buttonConnect = new JButton("Отправить");
    JPanel grid = new JPanel(new GridLayout(4,1));

    ChatWindow(String login){
        setTitle(WINDOW_NAME);
        setBounds(WINDOW_POSX,WINDOW_POSY,WINDOW_WIDTH,WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textOutput.setEditable(false);
        textOutput.setBackground(Color.LIGHT_GRAY);

        grid.add(textOutput);
        grid.add(label);
        grid.add(textInput);

        grid.add(buttonConnect);

        buttonConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textOutput.append(LocalDateTime.now().format
                        (DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")).
                        toString() + " " + login + " : " + textInput.getText() +  "\n");
            }
        });

        add(grid);
        setVisible(true);
    }

}
