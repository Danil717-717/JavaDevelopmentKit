package sem4.task04;

public interface Checker<T> {
    public boolean findWorkerByExper(T obj, int exp);
    public boolean findPhoneByName(T obj, String name);
    public boolean findWorkerbyPersonId(T obj, int personId);

}
