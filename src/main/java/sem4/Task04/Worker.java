package sem4.Task04;

import java.util.Objects;

public class Worker {
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

    public String toString(){
        return String.format("Табельный номер: %d, " +
                "Телефон: %s, " +
                "Имя: %s," +
                "Стаж: %d", personId, phone,name,experience );
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return personId == worker.personId && phone.equals(worker.phone) && name.equals(worker.name) && experience == worker.experience;
    }
}
