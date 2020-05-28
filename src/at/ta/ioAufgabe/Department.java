package at.ta.ioAufgabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {


    private String name;
    private List<Person> people;

    public Department(String name) {
        this.name = name;
        this.people = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addPersonDepartment(Person person) {
        this.people.add(person);
    }


    public void printEmploye() {
        System.out.println("Mitarbeiter \"" + this.name + "\":");
        for (Person person : this.people) {
            person.prsonName();
        }
    }
}