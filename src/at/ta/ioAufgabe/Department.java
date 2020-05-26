package at.ta.ioAufgabe;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {


    private String name;
    private List<Name> employe;

    public Department(String name) {
        this.name = name;
        this.employe = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Name> getEmploye() {
        return employe;
    }

    public void setEmploye(List<Name> employe) {
        this.employe = employe;
    }

    public void printBaseDataPerson() {

    }

    public void addPersonDepartment(Name name) {
        this.employe.add(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {

      return "Department " + name + " Mitarbeiter " + employe;
    }
}
