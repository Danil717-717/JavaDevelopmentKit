package sem2.task02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame implements ClientSocketListener {
    private static final int WINDOW_HEIGHT = 300;
    private static final int WINDOW_WIDTH = 300;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Start");
    JButton btnStop = new JButton("Stop");
    JPanel panel = new JPanel();
    Server server;
    ServerListener listener;

    ChatWindow(ServerListener listener, Server server){
        this.listener = listener;
        this.server = server;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setTitle("Info");

        panel = new JPanel(new GridLayout(1,2));
        panel.add(btnStart);
        panel.add(btnStop);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                server.start();
                btnPress("Нажата кнопка старт сервера");
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                server.stop();
                btnPress("Нажата кнопка стоп сервера");
            }
        });

        add(panel);
        setVisible(true);
    }

//    @Override
//    public void getMessage(String message) {
//        System.out.println(message);
//    }

    @Override
    public void btnPress(String message) {
        listener.getMessage(message);
    }
}
