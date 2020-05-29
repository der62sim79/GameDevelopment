package at.ta.ioAufgabe;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IO {

    public static void main(String[] args) {

        Department management = new Department("Vorstand");
        Department buyingDepartment = new Department("Einkauf");
        Department buyingDepartmentEurope = new Department("Einkauf Europa");
        Department buyingDepartmentItaly = new Department("Einkauf Italien");
        Department buyingDepartmentUSA = new Department("Einkauf USA");
        Department distribution = new Department("Vertrieb");
        Department distributionEU = new Department("Vertrieb Europa");

        List<Department> departments = new ArrayList<>();

        departments.add(management);
        departments.add(buyingDepartmentEurope);
        departments.add(buyingDepartment);
        departments.add(buyingDepartmentItaly);
        departments.add(buyingDepartmentUSA);
        departments.add(distributionEU);
        departments.add(distribution);


        File file = new File("./testdata/abteilungen.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] splittedValuesArray = line.split(";");

                for (int i = 0; i < splittedValuesArray.length; i++) {
                    splittedValuesArray[i] = splittedValuesArray[i].strip();

                }
                if (splittedValuesArray[0] != null) {

                    Person person = new Person(splittedValuesArray[0]);

                    for (Department department : departments) {

                        if (department.getName().equals(splittedValuesArray[1])) {
                            department.addPersonDepartment(person);
                        }

                    }

                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Department department : departments) {
            department.printEmploye();

        }
    }
}