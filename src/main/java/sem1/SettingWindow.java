package sem1;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Создаем еще окно, стартовое,
//где будут задаваться настройки поля и производиться выбор режима игры
public class SettingWindow  extends JFrame {
    //конструктор стартового окна
    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    protected static int sliderSizeValue = 3;
    private static int sliderWinValue = 3;
    private boolean modeValue;

    JLabel jLabelRe = new JLabel("Выберите режим игры");
    JRadioButton jRadioButChVSCPU = new JRadioButton("Человек против компьютера", true);
    JRadioButton jRadioButChVSCh = new JRadioButton("Человек против человека");

    JLabel jLabelSize = new JLabel(String.format("Установите размер" +
            " поля: %d ", sliderSizeValue));
    JSlider sliderSize = new JSlider(3,5,sliderSizeValue);

    JLabel jLabelWin = new JLabel(String.format("Установите длину" +
            " победы: %d ", sliderWinValue));
    JSlider sliderWin = new JSlider(3,5,sliderWinValue);

    JPanel grid = new JPanel(new GridLayout(4,1));

    JPanel top = new JPanel(new GridLayout(2,1));
    JPanel topButton = new JPanel(new GridLayout(2,1));
    JPanel middle = new JPanel(new GridLayout(2,1));
    JPanel botton = new JPanel(new GridLayout(2,1));

    //кнопка в окне
    JButton btnStart = new JButton("Start new game");

    ButtonGroup buttonGroup = new ButtonGroup();



    SettingWindow(GameWindow gameWindow){
        setTitle("Setting");
        setLocationRelativeTo(gameWindow);
        //setLocationRelativeTo(gameWindow.getLocation().x, gameWindow.getLocation().y);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);

        //добавление групп по заданию
        //создаем группу добавляем в нее панели
        //человек против человека и компьютера
        buttonGroup.add(jRadioButChVSCPU);
        buttonGroup.add(jRadioButChVSCh);
        //добавл кнопки выбора
        topButton.add(jRadioButChVSCPU);
        topButton.add(jRadioButChVSCh);
        //отображение панелей
        top.add(jLabelRe);
        top.add(topButton);
        //отображение выбора размера поля
        middle.add(jLabelSize);
        middle.add(sliderSize);
        //отображение у ползунка выбора кол-ва
        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderSizeValue = sliderSize.getValue();
                jLabelSize.setText(String.format("Установите размер" +
                        " поля: %d ", sliderSizeValue));
            }
        });
        //отображение выбора размера поля
        botton.add(jLabelWin);
        botton.add(sliderWin);
        //отображение у ползунка длинны победы
        sliderWin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                sliderWinValue = sliderWin.getValue();
                jLabelWin.setText(String.format("Установите длину" +
                        " победы: %d ", sliderWinValue));
            }
        });

        //добавление сетки
        grid.add(top);
        grid.add(middle);
        grid.add(botton);
        grid.add(btnStart);

        //добавили слушатель кнопок
        ///при нажатии на кнопку старт в стартовом окне
        //будет вызван метод старта новой игры с параметрами
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modeValue = jRadioButChVSCh.isSelected();
                gameWindow.startNewGame(modeValue,sliderSizeValue,sliderWinValue,sliderWinValue);
                setVisible(false);
            }
        });

        //add(btnStart);
        //отображение сетки
        add(grid);

    }
}
