package sem1.Task01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static sem1.Task01.SettingWindow.sliderSizeValue;

public class GameWindow extends JFrame {
    //Конструктор окна (настройка размеров окна)
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    //добавляем кнопки
    JButton btnStart = new JButton("New Game");
    JButton btnExit = new JButton("Exit");

    Map map;
    SettingWindow settings;

    GameWindow(){
        //Нажатие на крестик, по-умолчанию, делает окно невидимым, а не завершает программу.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocation(WINDOW_POSX,WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //название окна
        setTitle("TicTacToe");
        //запрещаем изменение размеров окна
        setResizable(false);

        //делаем позиционирование стартового окна
        //относительно основного окна с игрой
        map = new Map(sliderSizeValue, sliderSizeValue);
        settings = new SettingWindow(this);
        //settings.setVisible(true);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });


        //собственно компоновщик
        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        //добавили кнопки, но они друг на друге(компоновщики)
        //add(btnStart);
        //add(btnExit);
        add(panBottom,BorderLayout.SOUTH);
        //добавили поле
        add(map);

        // по умолчанию окно невидимое, делаем видимым
        setVisible(true);
    }

    //Из метода основного класса startNewGame() вызывается map.startNewGame()
    //класса мэп
    //происходит цепочка вызывов от стартового окна к основному
    //1. основное окно делает окно настроек видимым;
    //2. окно настроек говорит основному, что пора начинать игру;
    void startNewGame(boolean mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
