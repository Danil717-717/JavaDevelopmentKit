package less1;

import javax.swing.*;
import java.awt.*;

//Создали игровое поле
public class Map extends JPanel {

    Map(){
        //окраска игрового поля
        setBackground(Color.BLACK);
    }

    //метод начала новой игры с параметрами
    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        System.out.printf("Mode: %d; \nSize: x=%d, y=%d;\nWin Length: %d",
                mode, fSzX,fSzY,wLen);
    }
}
