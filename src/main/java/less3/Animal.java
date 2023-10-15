package less3;

public class Animal {
    protected String name;

    protected Animal() {
        this.name = "Animal";
    }
    protected Animal(String name){this.name = name;}

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + name ;
    }
}
