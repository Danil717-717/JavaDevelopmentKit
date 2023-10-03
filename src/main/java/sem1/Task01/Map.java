package sem1.Task01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import static sem1.Task01.SettingWindow.sliderSizeValue;

//Создали игровое поле
public class Map extends JPanel {
    private int panelWidth;
    private int panelHeight;
    private int cellHeight;
    private int cellWidth;

    //поля для логики игры
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил комп!";
    private static final String MSG_DRAW = "Ничья!";

    private final int HUMAN_DOT = 1; //символы для обозначения
    private final int AI_DOT = 2; //на поле игрока, компьютера и
    private final int EMPTY_DOT = 0; // и пустая ячейка
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private char[][] field;

    public static final int FIELD_SIZE = 5;         // размер игрового поля
    public static final int DOTS_TO_WIN = 4;        // сколько ячеек нужно подряд заполнить, чтобы победить

    private boolean isGameOver;
    private boolean isInitialized;

    Map(int fieldSizeX, int fieldSizeY) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;


        //окраска игрового поля
        //setBackground(Color.BLACK);
        //добавляем обработчик мыши
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });
        isInitialized = false;


    }
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        render(g);
//    }

    private void update(MouseEvent e) {
        //при старте новой игры игра перестаёт быть законченой, а поле становится
        //инициализированным;
        if (isGameOver || !isInitialized) return;
        //по клику мыши показывает координаты клика
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        //System.out.printf("x=%d, y = %d\n", cellX, cellY);
        //методы обновления игрового
        //состояния и отрисовки игрового поля
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        //так же внутри обработчика мыши
        //вызываем перерисовку
        repaint();
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        if (chekWin((char) dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;
        }
        if (isMapFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    //метод начала новой игры с параметрами
    void startNewGame(boolean mode, int fSzX, int fSzY, int wLen) {
        System.out.printf("Mode: %s; \nSize: x=%d, y=%d;\nWin Length: %d",
                mode, fSzX, fSzY, wLen);
        //инициализация поля
        initMap();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    //рисование с помощью класса Graphics
    //который умеет рисовать геометриеские рисунки
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    //перерисовка панели
    private void render(Graphics g) {
        if (!isInitialized) return;
//        g.setColor(Color.BLACK);
//        g.drawLine(0,0,100,100);
//        int panelWidth = getWidth();
//        int panelHeight = getHeight();
        //разрисовка поля на 9 квадратов
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellHeight = panelHeight / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        g.setColor(Color.BLACK);
        for (int h = 0; h < fieldSizeY; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int w = 0; w < fieldSizeX; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }
        //после рисования полей нужно сделать перересовку
        repaint();

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT) continue;

                if (field[y][x] == HUMAN_DOT) {
                    //отрисовка фигур на поле
                    g.setColor(Color.BLUE);
                    g.fillRect(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT) {
                    g.setColor(new Color(0xff0000));
                    g.fillOval(x * cellWidth + DOT_PADDING,
                            y * cellHeight + DOT_PADDING,
                            cellWidth - DOT_PADDING * 2,
                            cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " +
                            field[y][x] + " in cell: x=" + x + " y=" + y);
                }
            }
        }
        if (isGameOver) showMessageGameOver(g);
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight() / 2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 80, getHeight() / 2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight() / 2);
                break;
            default:
                throw new RuntimeException("Unexpect gameOver state: " + gameOverType);
        }
    }

    /**
     * TicTacToe game logic
     */
    //метод инициализации поля создает новый массив
    //и заполняет пустыми символами
    private void initMap() {
        fieldSizeY = sliderSizeValue;
        fieldSizeX = sliderSizeValue;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    /*
    Когда кто-то (игрок или компьютер) будет совершать ход,
    будет важно, попал ли игрок в какую-то ячейку поля и пустота
    ли она, потому что нельзя ставить крестик поверх нолика и наоборот.
     */
    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    //попал ли в пустую ячейку
    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    /*
    Компьютер будет очень примитивный – он будет делать ход
    в случайные места на карте.
     */
    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    /*
    Проверка выигрыша
    Далее приведён код, который не следует допускать при работе
    над приложениями. Метод принимает на вход символ, который
    нужно проверить и проверяет - не победил ли он.
     */
    /*
    Всегда пишите с помощью циклов, потому что стоит захотеть изменить
    размер поля на 4х4 или 5х5 – размер и сложность этого метода
    будет расти в геометрической прогрессии
     */
//    private int size;
//    //private byte[][] desc;
//
//    public Map(int ASize) {
//        size = ASize;
//        field = new char[size][size];
//    }
//    private boolean checkLine(int x, int y, int vx, int vy, int len, int c) {
//        final int far_x = x + (len - 1) * vx;
//        final int far_y = y + (len - 1) * vx;
//        if (!isValidCell(far_x, far_y)) return false;
//        for (int i = 0; i < len; i++) {
//            if (field[y + i * vy][x + i * vx] != c) return false;
//        }
//        return true;
//    }

    private boolean chekWin(char c) {
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
//        for (int i =0; i < fieldSizeX; i++){
//            for (int j = 0; j < fieldSizeY; j++){
//                if (checkLine(i,j,1,0,FIELD_SIZE,c)) return true;
//                if (checkLine(i,j,1,1,FIELD_SIZE,c)) return true;
//                if (checkLine(i,j,0,1,FIELD_SIZE,c)) return true;
//                if (checkLine(i,j,1,-1,FIELD_SIZE,c)) return true;
//            }
//        }
//        return false;
//
    }

//    private boolean checkWinnerHorizontal() {
//        for (int i = 0; i < size; i++) {
//            boolean res = true;
//            for (int j = 1; j < size && res; j++)
//                res = field[i][j] == field[i][0];
//            if (res)
//                return true;
//        }
//        return false;
//    }

//    private boolean checkWinnerVertical() {
//        for (int i = 0; i < winLength; i++) {
//            boolean res = true;
//            for (int j = 1; j < winLength && res; j++)
//                res = field[j][i] == field[0][i];
//            if (res)
//                return true;
//        }
//        return false;
//    }

    //    private boolean checkWinnerDiagonals() {
//        boolean res = true;
//        for (int i = 1; i < winLength && res; i++)
//            res = field[i][i] == field[0][0];
//        if (res)
//            return true;
//        res = true;
//        for (int i = 1; i < winLength && res; i++)
//            res = field[winLength - i - 1][i] == field[winLength - 1][0];
//        return res;
//    }
//    private boolean checkWinnerDiagonals(char c) {
//        boolean toright = true; // установили логическое значение 1
//        boolean toleft = true;
//        for (int i=0; i<4; i++) { // Блок от 0 до 3
//            toright = toright & (field[i][i] == c);
//        }
//        // Дальше мы вернули (true), если во всех клетках нам встретились символы symb
//        if (toright || toleft) return true;
//        // или вернули (false), если встретился хоть один символ, отличный от symb
//        return false;
//    }

    /*
    И метод проверки поля на состояние ничьей. Ничья в
    крестиках-ноликах наступает, когда не победил ни игрок ни оппонент,
    и не осталось пустых клеток
     */
    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
}
