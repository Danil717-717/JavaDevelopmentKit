package less2.circles;

import less2.common.MainCanvas;
import less2.common.Sprite;

import java.awt.*;
import java.util.Random;

/*
создаем класс шарика,
который будет перемещаться по экрану
 */
public class Ball extends Sprite {
    private static Random rnd = new Random();
    private final Color color;
    private float vX;
    private float vY;

    Ball(){
        //задаем в конструкторе рандомные размеры шара
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());
        vX = 100f + (float) (Math.random() * 200f);
        vY = 100f + (float) (Math.random() * 200f);
    }

    /*
    прибавляем к текущим координатам шарика
    его скорость умноженную на дельту времени
     */
    @Override
    public void update(MainCanvas canvas, float deltaTime) {
        x += vX * deltaTime;
        y += vY * deltaTime;

        if(getLeft() < canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if(getRight()>canvas.getRight()){
            setRight(canvas.getRight());
            vX = -vX;
        }
        if(getTop()< canvas.getTop()){
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getButtom()){
            setBottom(canvas.getButtom());
            vY = -vY;
        }
    }

    /*
    объекту графики задаётся цвет текущего шарика и вызывается
    метод fillOval(), которому передаются левая и верхняя координаты,
     ширина и высота
     */
    @Override
    public void render(MainCanvas canvas, Graphics g) {
        g.setColor(color);
        g.fillOval((int)getLeft(),(int)getTop(),(int)getWidth(),(int)getHeight());
    }
}
