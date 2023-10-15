package less3;

/*
E - элемент (Element, Entity, всеобьемлющие использующиеся коллекции вJava
K - Ключ
N - Число
T - Тип
V - Значение
S,U и тд - 2й,3й и тд типы
 */
public class GBox <T>{
    private T value;
    public GBox(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void  showType(){
        System.out.printf("Type is %s, with value %s\n",
        value.getClass().getName(), getValue());
    }
}
