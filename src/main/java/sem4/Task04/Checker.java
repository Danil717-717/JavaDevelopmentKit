package sem4.Task04;

import java.util.List;

public interface Checker<T> {
    public boolean findWorkerByExper(T obj, int exp);
    public boolean findPhoneByName(T obj, String name);
    public boolean findWorkerbyPersonId(T obj, int personId);

}
