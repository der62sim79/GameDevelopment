package at.ta.ioAufgabe2;

public class Person2 {

    private String personName;
    private Department2 department2;


    public Person2(String personName, Department2 department2) {
        this.personName = personName;
        this.department2 = department2;

    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Department2 getDepartment2() {
        return department2;
    }

    public void setDepartment2(Department2 department2) {
        this.department2 = department2;
    }

    @Override
    public String toString() {
        return "abteilung = " + department2;
    }
}
