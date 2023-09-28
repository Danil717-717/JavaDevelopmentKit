package less1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Создаем еще окно, стартовое,
//где будут задаваться настройки поля и производиться выбор режима игры
public class SettingWindow  extends JFrame {
    //конструктор стартового окна
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    //кнопка в окне
    JButton btnStart = new JButton("Start new game");
    SettingWindow(GameWindow gameWindow){
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        //добавили слушатель кнопок
        ///при нажатии на кнопку старт в стартовом окне
        //будет вызван метод старта новой игры с параметрами
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0,3,3,3);
                setVisible(false);
            }
        });

        add(btnStart);
    }
}
