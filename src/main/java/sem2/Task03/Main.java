package sem2.Task03;

/*
 Описать команду разработчиков. В команде разработчиков
 могут находиться бэкендеры, которые в состоянии писать
 серверный код, фронтендеры, которые могут программировать
 экранные формы, и фуллстэк разработчики, совмещающие в себе
 обе компетенции. Реализовать класс фулстэк разработчика,
 создать экземпляр и последовательно вызвать все его методы.
 */
public class Main {
    public static void main(String[] args) {
        FullStackProgrammer programmer = new FullStackProgrammer();
        programmer.writeBackEndCode();
        programmer.writeFrontEndCode();
    }
}
