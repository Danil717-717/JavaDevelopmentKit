package less2.circles;

import less2.common.CanvasRepaintListener;
import less2.common.Interactable;
import less2.common.MainCanvas;

import javax.swing.*;
import java.awt.*;

public class MainWindow  extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 200;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 600;

    //private final Sprite[] sprites = new Sprite[10];
    private final Interactable[] interactables = new Interactable[10];
    private final Background[] backgrounds = new Background[10];


    private MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X,POS_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Circles");

        // В конструкторе добавляется простой цикл
        // инициализирующий приложение десятью шариками.
//        for (int i = 0; i < sprites.length;i++){
//            sprites[i] = new Ball();
//        }

        interactables[0] = new Background() {
            @Override
            public void update(MainCanvas canvas, float deltaTime) {
                super.update(canvas, deltaTime);
            }

            @Override
            public void render(MainCanvas canvas, Graphics g) {
                super.render(canvas, g);
            }
        };
        for (int i = 0; i < interactables.length;i++){
            interactables[i] = new Ball();
        }

        //Добавляем MainCanvas в окно
        //и в конструктор основного окна мы передали
        //ссылку на экземпляр этот же экземпляр Канве
        //чтобы она знала у какого обьекта брать метод обновления
        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        setVisible(true);
    }


    //метод описывает цикл для нашего приложения
    //бизнес логика
    // метод обновления сцены и рендерит ее
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    //метод который как то изменяет наше приложение
//    private void update(MainCanvas canvas, float deltaTime){
//        for (int i = 0; i < sprites.length; i++) {
//            sprites[i].update(canvas,deltaTime);
//        }
//    };
    private void update(MainCanvas canvas, float deltaTime){
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas,deltaTime);
        }
    };

    // метод, который отдает команды рисующим
    // самих себя компонентов
//    private void render(MainCanvas canvas, Graphics g){
//        for (int i = 0; i < sprites.length; i++) {
//            sprites[i].render(canvas,g);
//        }
//    };
    private void render(MainCanvas canvas, Graphics g){
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas,g);
        }
    };

    public static void main(String[] args) {
        new MainWindow();
    }
}
