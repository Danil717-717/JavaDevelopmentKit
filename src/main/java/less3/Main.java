package less3;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    private static class Box {
        private Object object;

        public Box(Object object) {
            this.object = object;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        public void printInfo() {
            System.out.printf("Box (%s): %s",
                    object.getClass().getSimpleName(),
                    object.toString());
        }

        //параметризированный метод
        private static <T> void setIfNull(GBox<T> box, T t) {
            if (box.getValue() == null) {
                box.setValue(t);
            }
        }

        public static void copyTo(ArrayList src, ArrayList dst) {
            for (Object o : src) dst.add(o);
        }

        //Обобщения, исследования и дочерние типы
        private static <T extends Number> void setNull(BBox<T> box, T t) {
        }

        private static void someMethod(Number n) {
        }

        static void boxTest(GBox n) {
        }

        //Ограничения (маскирование) «сверху» и «снизу»
        private static <T extends Number> boolean compare(T src, T dst) {
            return src.equals(dst);
        }

        public static void copyToo(ArrayList src, ArrayList dst) {
            for (Object o : src) dst.add(o);
        }

        public static <T> void copyTTo(
                ArrayList<? extends T> src, ArrayList<? super T> dst) {
            for (T o : src) {
                dst.add(o);
            }
        }

        //Выведение типов — это возможность компилятора автоматически
        //определять аргументы типа на основе контекста.
        private static <T> T pick(T first, T second) {
            return second;
        }

//        public static <U> void addBox(U u, List<Box<U>> boxes){
//            App.<Cat>addBox(new Cat("Kusya"), catsInBoxes);
//            addBox(new Cat("Kusya"), catsInBoxes);
//
//        }
//        public class Box<T> {
//             <U> Box(U u) {

        //Подстановочный символ <?>
        //Подстановочный символ никогда не используется в качестве аргумента типа для вызова
        //обобщённого метода, создания экземпляра обобщённого класса или супертипа
        //private static <?> T method(T first, T second){return  second;}

        static void printInfo(TBox<? extends Animal> animalInBox){
            System.out.println("Info about animal: " + animalInBox);
        }
    }

    public static void main(String[] args) {
        Box b1 = new Box(20);
        Box b2 = new Box(30);
        System.out.println((int) b1.getObject() + (int) b2.getObject());

        //проверка на принадлежность к типу
        if (b1.getObject() instanceof Integer && b2.getObject() instanceof Integer) {
            int sum = (Integer) b1.getObject() + (Integer) b2.getObject();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("The contents of boxes differ by type");
        }


        GBox<String> stringGBox = new GBox<>("Hello");
        stringGBox.showType();
        GBox<Integer> integerGBox = new GBox<>(20);
        integerGBox.showType();


        KVBox<Integer, String> kvb0 = new KVBox<>(1, "Hello");
        KVBox<String, GBox<String>> kvb1 = new KVBox<>("Hello", new GBox<>("Java"));


        //параметризированный метод
        System.out.println();
        GBox<Integer> box = new GBox<>(null);
        Box.setIfNull(box, 13);
        System.out.println(box.getValue());
        GBox<Integer> box0 = new GBox<>(1);
        Box.setIfNull(box0, 13);
        System.out.println(box0.getValue());

        //маскирование сверху и снизу
        System.out.println();
        ArrayList<Integer> ial = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Number> nal = new ArrayList<>(Arrays.asList(1f, 2, 3.0));
        System.out.println(ial);
        System.out.println(nal);
        Box.copyTo(ial, nal);
        System.out.println(nal);
        Box.copyTo(nal, ial);
        System.out.println(ial);

        //Обобщения, исследования и дочерние типы
        System.out.println();
        Box.boxTest(new GBox<Number>(10));
        Box.boxTest(new GBox<Integer>(1));
        Box.boxTest(new GBox<Float>(1.0f));

        //Box.someMethod(new Integer(10));
        //Box.someMethod(new Double(10.1));

        //Ограничения (маскирование) «сверху» и «снизу»
        System.out.println();
        System.out.println(Box.compare(1, 1.0f));
        System.out.println(Box.compare(1.0f, 1.0f));
        System.out.println(Box.compare(1, 1));
        System.out.println();
        ArrayList<Cat> cats = new ArrayList<>(Arrays.asList(new Cat()));
        ArrayList<Animal> animals = new ArrayList<>(Arrays.asList(new Animal()));
        //Box.copyTTo(animals,cats);
        System.out.println(cats);
        //cats.get(1).voice();

        //Выведение типов
        System.out.println();
        //Serializable se1 = Box.pick("d",new Cat());
        //Serializable se2 = Box.pick("d",new ArrayList<String>());

        // Целевой тип выражения
        TBox<String> tBox = TBox.emptyBox();

        //Подстановочный символ <?>
        //TBox<String>b = new TBox<?>();

        TBox<Cat> catInBox = TBox.emptyBox();
        catInBox.setValue(new Cat("Vasya"));
        Box.printInfo(catInBox);

        TBox<Dog> dogTBox = TBox.emptyBox();
        dogTBox.setValue(new Dog("Kusya"));
        Box.printInfo(dogTBox);
    }
}

