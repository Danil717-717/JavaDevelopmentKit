package less2.common;


import less2.circles.Background;

import javax.swing.*;
import java.awt.*;


//Делаем MainCanvas универсальным методом для рисования чего либо
public class MainCanvas extends JPanel {

//    //для того чтобы Canva знала от куда брать обьекты
//    //создадим поле необходимого класса
//    private final MainWindow controller;
    //теперь с интерфейсом так
    private final CanvasRepaintListener controller;

    private long lastFrameTime;

    //передаем это поле в конструктор
    public MainCanvas(CanvasRepaintListener controller){
        //setBackground(Color.BLUE);

        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }


    //переопределяем метод с незначительными изменениями
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        //и обновлять
        //repaint(); этот вариант нагрузит систему
        //делаем так - многопоточность
        try {
            Thread.sleep(16); //спит 16 милисек
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        //меняем милисек в секунды
        float deltaTime = (System.nanoTime() - lastFrameTime) * 0.000000001f;
        // и вызываем метод который будет перерисовывать
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();


        repaint();
    }

    //добавляем методы возвращающие границы окна
    public int getLeft(){return 0;}
    public int getRight(){return getWidth() - 1;}
    public int getTop(){return 0;}
    public int getButtom(){return getHeight() - 1;}
}
