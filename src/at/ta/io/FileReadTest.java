package at.ta.io;

import at.ta.BreakeOut.Paddle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadTest {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        File file = new File("./testdata/adresse.txt");

        try {
            //File einlesen
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader); // File lesen zeile für zeile

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] lineArray = line.split(";");

                Person person = new Person(lineArray[0],lineArray[1],lineArray[2]);
                people.add(person);

                System.out.println(lineArray[0]);
            }

            for (Person person :people) {
                System.out.println(person);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File wurde nicht gefunden");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
