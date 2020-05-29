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

        List<Department2> parent = new ArrayList<>();

        File file = new File("./testdata/abteilung1.txt");


        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] splittedValuesArray = line.split(";");

                for (int i = 0; i < splittedValuesArray.length; i++) {
                    splittedValuesArray[i] = splittedValuesArray[i].strip();
                }

                Department2 dep = new Department2(splittedValuesArray[1]);
                Person2 pers = new Person2(splittedValuesArray[0]);
                if (splittedValuesArray[1] != null) {
                    Department2 parent1 = null;
                    for (Department2 exist : parent) {

                        if (exist.getName().equals(splittedValuesArray[2])) {
                            parent1 = exist;
                            break;
                        }

                    }

                    if (parent1 == null) {
                        Department2 department = new Department2(splittedValuesArray[2]);
                        parent.add(department);
                    }
                    
                    parent1.addChildDepartment(dep);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Department2 department2 : parent) {
            department2.printChildDepartment();
        }
    }
}
