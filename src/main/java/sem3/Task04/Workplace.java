package sem3.Task04;

public class Workplace<T extends Person> {
    private T[] arr;

    public Workplace(T[] arr) {
        this.arr = arr;

        for (T person:arr) {
            person.doWork();
        }
    }
}
