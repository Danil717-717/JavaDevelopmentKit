package less3;

/*
Ограниченные параметры типа
Bounded type parameters позволяют ограничить типы данных,
которые могут быть использованы в качестве параметров.
Использование bounded type parameters в Java является
хорошей практикой, которая позволяет более точно
определить используемые типы данных и обеспечивает
более безопасный и читаемый код
 */

//множественное наследование ограничений только от интерфесов
//class Bird{}
//interface Animal{}
//interface Man{}          кл     инт      инт
//public  CBox<T extends  Bird & Animal & Man>{
//
//        }

//ограничение ниже это extends( Number -> Integer ->)
//public class BBox<V extends Number> { }
//ограничение выше это super (Integer -> Number ->)
//public class BBox<V super Number> { }

public class BBox<V extends Number> {
    private V value;

    public V getValue() {
        return getValue();
    }

    public void setValue(V value) {
        this.value = value;
    }
}
