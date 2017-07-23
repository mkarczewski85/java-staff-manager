package StaffManager;

import java.util.Scanner;

/**
 * Klasa narzędziowa zawierająca statyczną metodę służącą do wypełniania pół obiektu typu Employee.
 * Created by Maciej on 2017-07-19.
 */
public class FillingIn {

    public static void Form(Employee employee, int id) {
        Scanner input = new Scanner(System.in);
        System.out.println("Uzupełnij poniższe dane.");
        System.out.print("Imię: ");
        employee.setName(input.nextLine());
        System.out.print("Nazwisko: ");
        employee.setSurname(input.nextLine());
        System.out.print("Stanowisko: ");
        employee.setPosition(input.nextLine());
        System.out.print("Zarobki: ");
        employee.setSalary(input.nextDouble());
        System.out.print("Rok urodzenia: ");
        employee.setBirthYear(input.nextInt());
        employee.setId(id);
    }

}
