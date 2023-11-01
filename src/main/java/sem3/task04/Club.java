package sem3.task04;

public class Club <T extends Person>{

    private T[] arr;

    public Club(T[] arr) {
        this.arr = arr;

        for (T person:arr) {
            person.haveRest();
        }
    }
}
