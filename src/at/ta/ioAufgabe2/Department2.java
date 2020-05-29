package at.ta.ioAufgabe2;

import java.util.ArrayList;
import java.util.List;

public class Department2 {

    private String name;
    private List<Department2> childDepartment;
    private List<Person2> personen2s;

    public Department2(String name) {
        this.name = name;
        this.childDepartment = new ArrayList<>();
        this.personen2s = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChildDepartment (Department2 department2){
        this.childDepartment.add(department2);
    }

    public void addPerson (Person2 personen2){
        this.personen2s.add(personen2);
    }

    public void printChildDepartment (){
        System.out.println(" Mitarbeiter \"" + this.name + "\":");

    }



}
