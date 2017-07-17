package StaffManager;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Klasa Company zawiera metody statyczne odpowiedzialne za tworzenie obiektów typu Employee i uzupełnianie listy
 * pracowników, a także dostępną statycznie kolekcję obiektów typu Employee.
 * Created by Maciej on 2017-07-15.
 */

public class Company {

    public static ArrayList<Employee> employeeList = new ArrayList<>(100);

    public static void addEmployee() {
        Scanner input = new Scanner(System.in);
        employeeList.add(new Employee());
        System.out.println("Uzupełnij poniższe dane.");
        System.out.print("Imię: ");
        employeeList.get(Company.employeeList.size() - 1).setName(input.nextLine());
        System.out.print("Nazwisko: ");
        employeeList.get(Company.employeeList.size() - 1).setSurname(input.nextLine());
        System.out.print("Stanowisko: ");
        employeeList.get(Company.employeeList.size() - 1).setPosition(input.nextLine());
        System.out.print("Zarobki: ");
        employeeList.get(Company.employeeList.size() - 1).setSalary(input.nextDouble());
        System.out.print("Rok urodzenia: ");
        employeeList.get(Company.employeeList.size() - 1).setBirthYear(input.nextInt());
        employeeList.get(Company.employeeList.size() - 1).setId();
        System.out.print("Chcesz dokonać jeszcze jednego wpisu? (T/n): ");
        char decision = input.next().charAt(0);
        if (decision == 'T' || decision == 't') {
            addEmployee();
        }
    }

    public static void printListOfEmployees() {
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println(employeeList.get(i).toString());
        }
    }

    public static void printEmployee(int id) {
        System.out.println(employeeList.get(id - 1).toString());
    }

    public static void removeEmployee(int id) {
        employeeList.remove(id - 1);
        for (int i = id - 1; i < employeeList.size(); i++) {
            employeeList.get(i).setId(i + 1);
        }

    }


}
