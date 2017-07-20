package StaffManager;

import java.util.ArrayList;

/**
 * Klasa Company zawiera metody odpowiedzialne za tworzenie obiektów typu Employee i uzupełnianie listy
 * pracowników, a także kolekcję obiektów typu Employee.
 * Created by Maciej on 2017-07-15.
 */

public class Company {

    public ArrayList<Employee> employeeList;

    public Company(){
        employeeList = new ArrayList<>();
    }

    //przekazuje obiekt typu Employee do wypełnienia pól a następnie przekazuje go do listy
    public void addEmployee(Employee nextEmployee) {
        FillingIn.Form(nextEmployee, employeeList.size() + 1);
        employeeList.add(nextEmployee);
    }

    //wyświetla na ekranie pełną listę pracowników
    public void printListOfEmployees() {
        for (Employee emp : employeeList) {
            System.out.println(emp.toString());
        }
    }

    //wyświetla na ekranie dane pracownika o wskazanym numerze
    public void printEmployee(int id) {
        System.out.println(employeeList.get(id - 1).toString());
    }

    //usuwa pracownika o wksazanym numerze z listy oraz aktualizuje numery reszty pracowników
    public void removeEmployee(int id) {
        employeeList.remove(id - 1);
        for (int i = id - 1; i < employeeList.size(); i++) {
            employeeList.get(i).setId(i + 1);
        }
    }

}
