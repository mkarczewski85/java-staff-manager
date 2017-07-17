package StaffManager;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Klasa Employee (POJO). Jej instancje reprezentują rekordy przechowujące informacje o pracownikach firmy.
 * Dostęp i ustawianie za pomocą metod getters i setters.
 * Created by Maciej on 2017-07-15.
 */

public class Employee implements Serializable {

    private String name;
    private String surname;
    private String position;
    private double salary;
    private int age;
    private int birthYear;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return this.age;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
        LocalDate currentYear = LocalDate.now();
        this.age = currentYear.getYear() - birthYear;
    }

    public int getId() {
        return id;
    }

    //nr pracownika ustawiany jest przez program na podstawie pola statycznego nextId (inkrementacja po nadaniu)
    public void setId() {
        this.id = Company.employeeList.size();
    }

    public void setId(int id) {
        this.id = id;
    }

    //metoda toString() odpowiada za wyświetlanie stanu pól obiektu w odpowiednio sformatowanym łańcuchu
    public String toString() {
        return "Pracownik nr " + id + ": " + name + " " + surname + ", stanowisko: " + position + ", pensja: " + salary
                + ", wiek: " + age;
    }

}
