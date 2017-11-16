package config.JDBC_SwitchOptions;

import java.util.Scanner;

public class DB_Menu {


    public void adressMenu() {
        AdressOptions adressOptions = new AdressOptions();
        Scanner input = new Scanner(System.in);
        int x;
        do {
            System.out.println();
            System.out.println("Wybierz:");
            System.out.println("1. Lista adresów " + "\n" + "2. Dodaj adres" + "\n" + "3. Wyszukaj po numerze id" + "\n" + "0. Przejdź do głównego menu");
            x = input.nextInt();

            switch (x) {

                case 0:
                    adressOptions.endProgram();
                    break;
                case 1:
                    adressOptions.adressList();
                    break;
                case 2:
                    adressOptions.insertNewAdress();
                    break;
                case 3:
                    adressOptions.findById();
                    break;
            }
        } while (x != 0);


    }

    public void companyMenu() {
        CompanyOptions companyOptions = new CompanyOptions();

        Scanner input = new Scanner(System.in);
        int x;
        do {
            System.out.println();
            System.out.println("Wybierz:");
            System.out.println("1. Lista firm " + "\n" + "2. Dodaj firmę" + "\n" + "3. Wyszukaj po numerze id" + "\n" + "0. Przejdź do głównego menu");
            x = input.nextInt();

            switch (x) {

                case 0:
                    companyOptions.endProgram();
                    break;
                case 1:
                    companyOptions.companyList();
                    break;
                case 2:
                    companyOptions.insertNewCompany();
                    break;
                case 3:
                    companyOptions.findById();
                    break;
            }
        } while (x != 0);
    }

    public void employeeMenu() {
        EmployeeOptions employeeOptions = new EmployeeOptions();
        Scanner input = new Scanner(System.in);
        int x;
        do {
            System.out.println();
            System.out.println("Wybierz:");
            System.out.println("1. Lista pracowników " + "\n" + "2. Dodaj pracownika" + "\n" + "3. Wyszukaj po numerze id" + "\n" + "0. Przejdź do głównego menu");
            x = input.nextInt();

            switch (x) {

                case 0:
                    employeeOptions.endProgram();
                    break;
                case 1:
                    employeeOptions.employeeList();
                    break;
                case 2:
                    employeeOptions.insertNewEmployee();
                    break;
                case 3:
                    employeeOptions.findById();
                    break;
            }
        } while (x != 0);

    }

    public void officeMenu() {
        OfficeOptions officeOptions = new OfficeOptions();
        Scanner input = new Scanner(System.in);
        int x;
        do {
            System.out.println();
            System.out.println("Wybierz:");
            System.out.println("1. Lista stanowisk " + "\n" + "2. Dodaj stanowisko" + "\n" + "3. Wyszukaj po numerze id" + "\n" + "0. Przejdź do głównego menu");
            x = input.nextInt();

            switch (x) {

                case 0:
                    officeOptions.endProgram();
                    break;
                case 1:
                    officeOptions.officeList();
                    break;
                case 2:
                    officeOptions.insertNewOffice();
                    break;
                case 3:
                    officeOptions.findById();
                    break;
            }
        } while (x != 0);
    }

}
