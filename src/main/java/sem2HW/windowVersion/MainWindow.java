package sem2HW.windowVersion;

import sem2HW.common.NumsConcot;
import sem2HW.common.NumsSum;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.sum;

public class MainWindow extends JFrame implements NumsSum, NumsConcot {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;

    JPanel panelInp = new JPanel();
    JLabel inputNum = new JLabel("Введите цифры: ");

    JPanel panelNums = new JPanel();
    JLabel inputNum1 = new JLabel("Цифра 1: ");

    JTextField num1 = new JTextField(10);
    JLabel inputNum2 = new JLabel("Цифра 2: ");

    JTextField num2 = new JTextField(10);

    JPanel panelBut = new JPanel(new GridLayout(1, 2));
    JLabel nameAction = new JLabel("Выберете действие:  ");
    JButton buttonSum = new JButton("Сумма");
    JButton buttonConc = new JButton("Конкатенация");

    JButton buttonClear = new JButton("очистить");


    JPanel panelRes = new JPanel(new GridLayout());
    JLabel nameRes = new JLabel("Результат: ");
    JTextArea numRes = new JTextArea(1, 5);


    JPanel panel = new JPanel(new GridLayout(4, 1));

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        setTitle(" HW ");
        setLocationRelativeTo(null);

        inputNum.setHorizontalAlignment(JTextField.CENTER);
        panel.setBackground(Color.GRAY);

        panelInp.add(inputNum);

        panelNums.add(inputNum1);
        panelNums.add(num1);
        panelNums.add(inputNum2);
        panelNums.add(num2);


        panelBut.add(nameAction);
        panelBut.add(buttonSum);
        panelBut.add(buttonConc);
        panelBut.add(buttonClear);

        panelRes.add(nameRes);
        panelRes.add(numRes);

        panel.add(panelInp);
        panel.add(panelNums);

        panel.add(panelBut);
        panel.add(panelRes);

        add(panel);

        buttonConc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1.getText();
                num2.getText();
                numRes.append(concotNums((Integer.parseInt(num1.getText())), Integer.parseInt(num2.getText())));
            }
        });

        buttonSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1.getText();
                num2.getText();
                numRes.append(sumNums((Integer.parseInt(num1.getText())), Integer.parseInt(num2.getText())));
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                num1.setText(" ");
                num2.setText(" ");
                numRes.setText(" ");
            }
        });

        setVisible(true);
    }


    public static void main(String[] args) {
        new MainWindow();
    }

    @Override
    public String concotNums(int num1, int num2) {
        return num1 + String.valueOf(num2);
    }

    @Override
    public String sumNums(int num1, int num2) {
        return (num1
                + " + " + num2 + " = " + sum(num1, num2));
    }
}
