package StaffManager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

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
        if (salary < 0) {
            System.out.println("Pensja nie moze byc mniejsza od zero");
            this.salary = -salary;
        } else {
            this.salary = salary;
        }

    }

    public int getAge() {
        return this.age;
    }

    public int getBirthYear() {
        return birthYear;
    }

    //wiek obliczany jest automatycznie na podstawie podanego roku urodzenia
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
        LocalDate currentYear = LocalDate.now();
        this.age = currentYear.getYear() - birthYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //przesłonięta metoda toString() odpowiada za wyświetlanie stanu pól obiektu w odpowiednio sformatowanym łańcuchu
    @Override
    public String toString() {
        return "Pracownik nr " + id + ": " + name + " " + surname + ", stanowisko: " + position + ", pensja: " + salary
                + ", wiek: " + age;
    }

    //przesłonięta metoda equals odpowiada za porównywanie dwóch obiketów klasy Employee
    @Override
    public boolean equals(Object otherObject) {
        //sprawdzam czy obiekty są identyczne
        if (this == otherObject) return true;
        //sprawdzam czy jawny parametr jest null
        if (otherObject == null) return false;
        //sprawdzam czy klasy są identyczne
        if (getClass() != otherObject.getClass()) return false;
        //teraz bezpiecznie rzutuję jawny parametr na klasę Employee
        Employee other = (Employee) otherObject;
        //sprawdzam czy wartości pól dwóch obiektów klasy Employee są identyczne
        return Objects.equals(name, other.name) && Objects.equals(surname, other.surname) &&
                Objects.equals(position, other.position) && salary == other.salary && age == other.age;
    }

    //przesłonięta metoda hashCode() zwracająca wartość skrótu obiektu
    @Override
    public int hashCode() {
        return Objects.hash(name, surname, position, salary, age);
    }
}
