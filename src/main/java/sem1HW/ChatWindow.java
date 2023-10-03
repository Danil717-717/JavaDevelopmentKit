package sem1HW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ChatWindow extends JFrame {
    private final int WINDOW_POS_X = 400;
    private final int WINDOW_POS_Y = 200;
    private final int WINDOW_WIDTH = 600;
    private final int WINDOW_HEIGHT = 600;
    private String WINDOW_TITLE = "Чат сервера - ";

    private final String login;
    private final String server;
    private LogFile logger;

    private JLabel inputLabel = new JLabel("Введите сообщение");
    private JTextField inputField = new JTextField(20);

    private JButton sendButton = new JButton("Отправить");

    private JTextArea outputField = new JTextArea();
    JScrollPane scrollPane = new JScrollPane(outputField);

    private JPanel panel = new JPanel(new GridLayout(2,1));
    private JPanel outGrid = new JPanel(new GridLayout(1,1));
    private JPanel inputGrid = new JPanel(new GridLayout());

    ChatWindow(String login, String server, LogFile logger) throws IOException {
        this.logger = logger;
        this.login = login;
        this.server = server;
        WINDOW_TITLE =  WINDOW_TITLE + server;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(WINDOW_TITLE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);

        initWindow();

        inputLabel.setHorizontalAlignment(JTextField.CENTER);
        inputField.setBorder(BorderFactory.createCompoundBorder
                (inputField.getBorder(),BorderFactory.createEmptyBorder
                        (10,10,10,20)));

        outGrid.add(scrollPane);
        inputGrid.add(inputLabel);
        inputGrid.add(inputField);

        panel.setLayout(null);
        outGrid.setSize(590,450);
        inputGrid.setSize(600,100);
        inputGrid.setLocation(0,450);

        panel.add(outGrid);
        panel.add(inputGrid);

        add(panel);
        add(sendButton,BorderLayout.SOUTH);

        setVisible(true);
    }

    private void initWindow() throws IOException{
        //инициализация поля вывода
        outputField.enableInputMethods(false);
        outputField.setBackground(Color.LIGHT_GRAY);
        StringBuilder builder = new StringBuilder();
        for (String string : logger.Read()) {
            builder.append(string);
            builder.append("\n");
        }
        outputField.setText(builder.toString());


        //поле ввода-вывода
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")).toString();
                String msgText = dt + " " + login + ": " + inputField.getText();
                try {
                    logger.Write(msgText);
                    outputField.append(msgText);
                    outputField.append("\n");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                inputField.setText("");
            }
        });
        inputField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss")).toString();
                    String msgText = dt + " " + login + ": " + inputField.getText();
                    try {
                        logger.Write(msgText);
                        outputField.append(msgText);
                        outputField.append("\n");
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    inputField.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

   }
}