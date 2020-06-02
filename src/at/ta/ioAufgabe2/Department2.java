package at.ta.ioAufgabe2;

import at.ta.ioAufgabe.Person;

import java.util.ArrayList;
import java.util.List;

public class Department2 {

    private String name;
    private String parentDepartmentName;
    private List<Person2> people = new ArrayList<>();

    public Department2(String name, String parentDepartmentName) {
        this.name = name;
        this.parentDepartmentName = parentDepartmentName;
    }

    public void addPerson(Person2 person) {
        people.add(person);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentDepartmentName() {
        return parentDepartmentName;
    }

    public void setParentDepartmentName(String parentDepartmentName) {
        this.parentDepartmentName = parentDepartmentName;
    }

    public List<Person2> getPeople() {
        return people;
    }

    public void setPeople(List<Person2> people) {
        this.people = people;
    }
}
