package sem4.Task04;


import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Worker implements Checker<Worker> {
    private int personId;
    private String phone;
    private String name;
    private int experience;

    public Worker(int personId, String phone, String name, int experience) {
        this.personId = personId;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public int getPersonId() {
        return personId;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String toString() {
        return String.format("Табельный номер: %d, " +
                "Телефон: %s, " +
                "Имя: %s," +
                "Стаж: %d", personId, phone, name, experience);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return personId == worker.personId && phone.equals(worker.phone) && name.equals(worker.name) && experience == worker.experience;
    }

    @Override
    public boolean findWorkerByExper(Worker w, int exp) {
        return (w.personId == exp);
    }

    @Override
    public boolean findPhoneByName(Worker w, String name) {
        return(w.name == name);
    }

    @Override
    public boolean findWorkerbyPersonId(Worker w, int personId) {
        return (w.personId == personId);
    }




    public static <T> Collection<T> findWorkExp(Collection<T> coll, Checker<T> chk, int experience) {
        LinkedList<T> l = new LinkedList<T>();
        for (T obj : coll) {
            if (chk.findWorkerByExper(obj, experience))
                l.add(obj);
        }
        return l;
    }

    public static <T> Collection<T> findPhoneName(Collection<T> coll, Checker<T> chk, String name) {
        LinkedList<T> l = new LinkedList<T>();
        for (T obj : coll) {
            if (chk.findPhoneByName(obj, name))
                l.add(obj);
        }
        return l;
    }

    public static <String>List findPh(List<Worker> list) {
        List<java.lang.String> listPhone = new ArrayList<>();
        for (Worker i:list) {
            java.lang.String p = i.getPhone();
            listPhone.add(p);
        }
        return listPhone;
    }

    public static <T> Collection<T> findWorkPersId(Collection<T> coll, Checker<T> chk, int personId) {
        LinkedList<T> l = new LinkedList<T>();
        for (T obj : coll) {
            if (chk.findWorkerbyPersonId(obj, personId))
                l.add(obj);
        }
        return l;
    }
}

