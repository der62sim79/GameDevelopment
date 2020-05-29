package at.ta.ioAufgabe2;

public class Person2 {

    String personName;

    public Person2(String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void personName() {
        System.out.println("Name: " + personName);
    }
}
