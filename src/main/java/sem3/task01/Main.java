package sem3.task01;

/*
  Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные типа (T, V, K),
  конструктор, принимающий на вход параметры типа (T, V, K), методы
  возвращающие значения трех переменных. Создать метод, выводящий на консоль имена
  классов для трех переменных класса. Наложить ограничения на параметры типа:
  T должен реализовать интерфейс Comparable (классы оболочки, String),
  V должен реализовать интерфейс DataInput и расширять класс InputStream,
  K должен расширять клас Number
 */

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        Task01 task01 = new Task01("String",
                new InputStream() {
                    @Override
                    public int read() throws IOException {
                        throw new UnsupportedOperationException("Unl;");
                    }
                },
                5);

        task01.showType();
    }

}
