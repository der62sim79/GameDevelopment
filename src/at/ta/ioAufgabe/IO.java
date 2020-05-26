package at.ta.ioAufgabe;

import java.io.*;

public class IO {

    public static Department management = new Department("Vorstand");
    public static Department buyingDepartment = new Department("Einkauf");
    public static Department buyingDepartmentEurope = new Department("Einkauf Europa");
    public static Department buyingDepartmentItaly = new Department("Einkauf Italien");
    public static Department buyingDepartmentUSA = new Department("Einkauf USA");
    public static Department distribution = new Department("Vertrieb");
    public static Department distributionEU = new Department("Vertrieb Europa");

    public static void main(String[] args) {

        File file = new File("./testdata/abteilungen.txt");

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] splittedValuesArray = line.split(";");

                Name name = new Name(splittedValuesArray[0]);

                checkDepartment(splittedValuesArray[1],name);


                System.out.println(distributionEU);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void checkDepartment (String line, Name name){
        if (line.equals("Vorstand")){
            management.addPersonDepartment(name);
        } else if (line.equals("Einkauf")){
            buyingDepartment.addPersonDepartment(name);
        } else if (line.equals("Einkauf Europa")){
            buyingDepartmentEurope.addPersonDepartment(name);
        }else if (line.equals("Einkauf Italien")){
            buyingDepartmentItaly.addPersonDepartment(name);
        } else if (line.equals("Einkauf USA")){
            buyingDepartmentUSA.addPersonDepartment(name);
        }else if (line.equals("Vertrieb")){
            distribution.addPersonDepartment(name);
        }else if (line.equals("Vertrieb Europa")){
            distributionEU.addPersonDepartment(name);
        }
    }
}
