package sem2.Task04;

/*
  Дописать третье задание таким образом, чтобы в идентификатор
  типа Developer записывался объект Frontender, и далее
  вызывался метод developGUI(), не изменяя существующие
  интерфейсы, только код основного класса.
 */
public class Main {
    public static void main(String[] args) {
        Developer dev1 = new FrontEndDev();
        dev1.developerAction();
        Developer dev2 = new BackEndDev();
        dev2.developerAction();

        Developer dev3 = new FrontEndDev();
        ((FrontEndDev) dev3).writeFrontEndCode();
        Developer dev4 = new BackEndDev();
        if(dev4 instanceof  FrontEndDev) {
            ((FrontEndDev) dev4).writeFrontEndCode();
        }


        //анонимный класс
        var test1 = new BackEndProgrammer(){
            @Override
            public void writeBackEndCode(){}
        };
        //2-ой анонимный класс
        var test2 = new BackEndProgrammer(){
            @Override
            public void writeBackEndCode(){}
        };
        System.out.println(test1.getClass().toString());
        System.out.println(test2.getClass());
    }
}
