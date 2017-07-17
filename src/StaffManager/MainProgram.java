package StaffManager;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        //Sprawdzam czy został zapisany plik database.ser z obiektami klasy Employee (baza z danymi pracowników).
         //Jeśli plik znajduje się w katalogu z programem przywoływana jest metoda deserializacji.
        if (Serialize.CheckIfThereIsFile()) {
            Serialize.DeserializeListOfEmployees();
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
            System.out.println("4. Usuń dane pracownika");
            System.out.println("5. Zapisz zmiany do pliku");
            System.out.println("6. Wyjdź");
            System.out.print("Wybierz opcję: ");
            option = scanner.nextInt();

            switch (option) {
                //opcja dodania nowego pracownika
                case 1: {
                    Company.addEmployee();
                    break;
                }
                //opacja drukowania całej listy pracowników
                case 2: {
                    Company.printListOfEmployees();
                    break;
                }
                //opcja wyświetlenia danych nt. jednego pracownika
                case 3: {
                    System.out.print("Podaj nr pracownika: ");
                    int idNumber = scanner.nextInt();
                    Company.printEmployee(idNumber);
                    break;
                }
                //opcja usunięcia z bazy danych jednego pracownika
                case 4: {
                    System.out.print("Podaj nr pracownika: ");
                    int idNumber = scanner.nextInt();
                    Company.removeEmployee(idNumber);
                    break;
                }
                //opcja zapisu stanu obiektów klasy Employee do pliku 'database.ser'
                case 5: {
                    Serialize.SerializeListOfEmployees();
                    break;
                }
                //opcja wyjścia z systemu
                case 6: {
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
