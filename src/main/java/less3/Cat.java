package less3;

public class Cat extends Animal implements Serializable{
    protected Cat() {
        this.name = "Cat";
    }
    protected Cat(String name){super(name);}
    protected void voice(){
        System.out.println("meow");
    }
}
