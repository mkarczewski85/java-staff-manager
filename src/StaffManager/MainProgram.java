package StaffManager;

import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {

        if (Serialize.CheckIfThereIsFile()) {
            Serialize.DeserializeListOfEmployees();
        } else {
            System.out.println("Brak bazy danych!");
        }

        boolean flag = true;
        int option;
        Scanner scanner = new Scanner(System.in);

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
                case 1: {
                    Company.addEmployee();
                    break;
                }
                case 2: {
                    Company.printListOfEmployees();
                    break;
                }
                case 3: {
                    System.out.print("Podaj nr pracownika: ");
                    int idNumber = scanner.nextInt();
                    Company.printEmployee(idNumber);
                    break;
                }
                case 4: {
                    System.out.print("Podaj nr pracownika: ");
                    int idNumber = scanner.nextInt();
                    Company.removeEmployee(idNumber);
                    break;
                }
                case 5: {
                    Serialize.SerializeListOfEmployees();
                    break;
                }
                case 6: {
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Nie ma takiej opcji! Spróbuj jeszcze raz!");
                    break;
                }
            }

        }

    }
}
