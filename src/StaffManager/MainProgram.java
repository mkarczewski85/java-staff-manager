package StaffManager;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        Company myCompany = new Company();

        //Sprawdzam czy został zapisany plik database.ser z obiektami klasy Employee (baza z danymi pracowników).
        //Jeśli plik znajduje się w katalogu z programem przywoływana jest metoda deserializacji.
        if (Serialize.CheckIfThereIsFile()) {
            myCompany.employeeList = Serialize.DeserializeListOfEmployees();
        } else {
            System.out.println("Brak bazy danych!");
        }

        boolean flag = true;
        int option;
        Scanner scanner = new Scanner(System.in);

        //menu z opcjami do wyboru
        while (flag) {
            System.out.println("1. Wprowadz nowy rekord");
            System.out.println("2. Wyświetl listę pracowników");
            System.out.println("3. Wyświetl dane pracownika");
            System.out.println("4. Wyświetl dane pracownika o najwyższych zarobkach");
            System.out.println("5. Wyświetl informację nt. średniej zarobków pracowników w firmie");
            System.out.println("6. Wyświetl informację nt. średniej wieku pracowników w firmie");
            System.out.println("7. Usuń dane pracownika");
            System.out.println("8. Zapisz zmiany do pliku");
            System.out.println("0. Wyjdź");
            System.out.print("Wybierz opcję: ");
            option = scanner.nextInt();

            switch (option) {
                //opcja dodania nowego pracownika
                case 1: {
                    Employee nextEmployee = new Employee();
                    myCompany.addEmployee(nextEmployee);
                    break;
                }
                //opacja drukowania całej listy pracowników
                case 2: {
                    myCompany.printListOfEmployees();
                    break;
                }
                //opcja wyświetlenia danych nt. jednego pracownika
                case 3: {
                    System.out.print("Podaj nr pracownika: ");
                    int idNumber = scanner.nextInt();
                    myCompany.printEmployee(idNumber);
                    break;
                }
                //opcja wyświetlenia danych pracownika o najwyższych zarobkach
                case 4: {
                    System.out.println("Pracownikiem o najwyższych zarobkach jest:");
                    System.out.println(myCompany.getEmployeeWithHighestSalary().toString());
                    break;
                }
                //opcja wyświetlenia informacji nt. średniej zarobków pracowników w firmie
                case 5: {
                    System.out.println("Średnia zarobków w fimie wynosi: " + myCompany.countAvgSalary() + " złotych");
                    break;
                }
                //opcja wyświetlenia informacji nt. średniej wieku pracowników w firmie
                case 6: {
                    System.out.println("Średnia wieku pracowników zatrudnionych w firmie wynosi: "
                            + myCompany.countAvgAge() + " l.");
                    break;
                }
                //opcja usunięcia z bazy danych jednego pracownika
                case 7: {
                    System.out.print("Podaj nr pracownika: ");
                    int idNumber = scanner.nextInt();
                    myCompany.removeEmployee(idNumber);
                    break;
                }
                //opcja zapisu stanu obiektów klasy Employee do pliku 'database.ser'
                case 8: {
                    Serialize.SerializeListOfEmployees(myCompany.employeeList);
                    break;
                }
                //opcja wyjścia z systemu
                case 0: {
                    flag = false;
                    break;
                }
                //wiadomo
                default: {
                    System.out.println("Nie ma takiej opcji! Spróbuj jeszcze raz!");
                    break;
                }
            }

        }

    }
}
