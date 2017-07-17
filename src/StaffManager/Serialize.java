package StaffManager;

import java.io.*;
import java.util.ArrayList;

/**
 * Klasa Serialize zawiera statyczne metody służące serializacji obiektów klasy Employee zawartych w kolekcji
 * do pliku płaskiego oraz ich deserializacji.
 * Created by Maciej on 2017-07-15.
 */

public class Serialize {

    //statyczna metoda serializacji listy obiektów klasy Employee do pliku płaskiego 'database.ser'
    public static void SerializeListOfEmployees() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("database.ser");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(Company.employeeList);
            fos.close();
            oos.close();
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }

    }

    //statyczna metoda deserializacji (odczytu) listy obiektów klasy Employee do pliku płaskiego 'database.ser'
    public static void DeserializeListOfEmployees() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("database.ser");
            ois = new ObjectInputStream(fis);

            Company.employeeList = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException fnfex) {
            fnfex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (ClassNotFoundException ccex) {
            ccex.printStackTrace();
        }
    }

    //statyczna metoda sprawdzająca czy plik z bazą znajduje się w katalogu z programem
    public static boolean CheckIfThereIsFile() {
        File data = new File("database.ser");
        if (data.exists() && !data.isDirectory()) {
            return true;
        } else {
            return false;
        }
    }

}
