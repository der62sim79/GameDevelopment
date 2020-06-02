package at.ta.ioAufgabe2;

/*
Franz Müller;Vorstand;
Max Mustermann;Einkauf;Vorstand
Frida Haudrauf;Einkauf Europa;Einkauf
Alois Stich;Einkauf Europa;Einkauf
Bernd Muster;Einkauf Italien;Einkauf Europa
Ulla Neu;Einkauf USA;Einkauf
Iris Tor;Vertrieb;Vorstand
Paul Hinter;Vertrieb Europa;Vertrieb
Ernst Bock; Vertrieb Europa;Vertrieb
Olga Peter; Vertrieb Europa;Vertrieb
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class IO2 {

    public static void main(String[] args) {

        List<Person2> people = new ArrayList<>();
        List<Department2> department2List = new ArrayList<>();
        List<String> departmentResult = new ArrayList<>();

        File file = new File("./testdata/abteilung1.txt");


        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splittedValuesArray = line.split(";");

                String personName = splittedValuesArray[0];
                String departmentName = splittedValuesArray[1];

                if (splittedValuesArray.length == 2) {
                    Department2 department2 = new Department2(departmentName.trim(), "");
                    Person2 person2 = new Person2(personName, department2);
                    department2.addPerson(person2);
                    department2List.add(department2);
                    people.add(person2);
                }
                if (splittedValuesArray.length == 3) {
                    String parentDepartmentName = splittedValuesArray[2];
                    Department2 department2 = new Department2(departmentName.trim(), parentDepartmentName);
                    Person2 person2 = new Person2(personName, department2);
                    department2.addPerson(person2);
                    department2List.add(department2);
                    people.add(person2);
                }
            }
            for (Department2 departmen : department2List) {
                if (!departmentResult.contains(departmen.getParentDepartmentName())) {
                    departmentResult.add(departmen.getParentDepartmentName());
                }
            }
            for (String departmentName : departmentResult) {
                System.out.println( "Dem "+ departmentName.toUpperCase() + " unterstellte Mitarbeiter: ");
                for (Person2 person : people) {
                    if (departmentName.equalsIgnoreCase(person.getDepartment2().getParentDepartmentName())) {
                        System.out.println(" " + person.getPersonName());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}