package less5;

public class Task implements Runnable{

    private int value;

    public Task(int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }

    public void inc(){
        value++;
    }

    @Override
    public void run() {
        System.out.println(value);
    }

    @Override
    public String toString() {
        return String.format("(%s)" + value);
    }
}
