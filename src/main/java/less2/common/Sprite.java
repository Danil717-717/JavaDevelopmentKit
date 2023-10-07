package less2.common;

import less2.common.Interactable;
import less2.common.MainCanvas;

import java.awt.*;

/*
Класс Sprite описывает общие для всех рисуемых
объектов в программе поведение и свойства
 */
public abstract class Sprite implements Interactable {
    // необходимо условиться, что X и Y –
    //это центр любого визуального объекта на канве
    //И, следовательно, удобно хранить
    //не длину с шириной, а половину длины и половину ширины.
    // А границы объекта,
    //соответственно, будут отдаваться через геттеры и сеттеры
    protected float x;
    protected float y;
    protected float halfWidth;
    protected float halfHeight;

    protected float getLeft(){return x - halfWidth;}
    public void setLeft(float left) {x = left + halfWidth;}

    public float getRight() {return x + halfWidth;}
    public void setRight(float right) { x = right - halfWidth;}

    public float getTop() {return y - halfHeight;}
    public void setTop(float top) { y = top + halfHeight;}

    public float getBottom() {return y + halfHeight;}
    public void setBottom(float bottom) { y = bottom - halfHeight;}

    protected float getWidth(){ return 2f * halfWidth;}
    protected float getHeight(){ return 2f * halfHeight;}

    public void update(MainCanvas canvas, float deltaTime){}
    public void render(MainCanvas canvas, Graphics g){}



}
