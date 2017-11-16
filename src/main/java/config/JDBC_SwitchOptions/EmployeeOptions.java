package config.JDBC_SwitchOptions;

import config.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Created by HP on 2017-11-15.
 */
public class EmployeeOptions {

    public void endProgram() {
        System.out.println("Główne menu");
    }


    public void employeeList() {

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = Database.getConnection();
            //STEP 4: Execute a query

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM pracownicy";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_pracownika = rs.getInt("id_pracownika");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String kolor_oczu = rs.getString("kolor_oczu");
                int wzrost = rs.getInt("wzrost");
                char plec = rs.getString("plec").charAt(0);
                String telefon = rs.getString("telefon");
                String email = rs.getString("email");
                String pesel = rs.getString("pesel");
                LocalDate data_urodzin = rs.getDate("data_urodzin").toLocalDate();
                int id_stanowiska = rs.getInt("id_stanowiska");
                int wynagrodzenie = rs.getInt("wynagrodzenie");
                int id_firmy = rs.getInt("id_firmy");

                //Display values
                System.out.println("ID: " + id_pracownika + ", " + " Imie: " + imie + ", " + " Nazwisko: " + nazwisko + ", " + " Kolor oczu: " + kolor_oczu +
                        ", " + " Wzrost: " + wzrost + ", " + " Plec: " + plec + ", " + " Telefon: " + telefon + ", " + " Email: " + email + ", " + " PESEL: " + pesel + ", "
                        + " Data urodzenia: " + data_urodzin + ", " + " ID stanowiska: " + id_stanowiska + ", " + " Wynagrodzenie: " + wynagrodzenie + ", " + " ID firmy: " + id_firmy + ", ");
            }
            rs.close();
            stmt.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void insertNewEmployee() {
        Scanner input = new Scanner(System.in);

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = Database.getConnection();
            //STEP 4: Execute a query

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            System.out.println("Wprowadz id pracownika: ");
            int id_input = input.nextInt();
            input.nextLine();
            System.out.println("Wprowadz imie");
            String imie = input.nextLine();
            System.out.println("Wprowadz nazwisko");
            String nazwisko = input.nextLine();
            System.out.println("Wprowadz kolor oczu");
            String kolor_oczu = input.nextLine();
            System.out.println("Wprowadz wzrost");
            short wzrost = input.nextShort();
            System.out.println("Wprowadz plec");
            char plec = input.next().charAt(0);
            input.nextLine();
            System.out.println("Wprowadz numer telefonu");
            String numer_telefonu = input.nextLine();
            System.out.println("Wprowadz email");
            String email = input.nextLine();
            System.out.println("Wprowadz numer PESEL");
            String pesel = input.nextLine();
            System.out.println("Wprowadz datę urodzenia");
            String data_urodzin = input.nextLine();
            System.out.println("Wprowadz id stanowiska");
            int id_stanowiska = input.nextInt();
            System.out.println("Wprowadz wynagrodzenie");
            int wynagrodzenie = input.nextInt();
            System.out.println("Wprowadz id firmy");
            int id_firmy = input.nextInt();


            sql = "INSERT INTO pracownicy VALUES (" + id_input + ", '" + imie + "', '" + nazwisko + "', '" + kolor_oczu + "', " + wzrost + ", '"
                    + plec + "', '" + numer_telefonu + "', '" + email + "', '" + pesel + "', '" + data_urodzin + "', " + id_stanowiska + ", "
                    + wynagrodzenie + ", " + id_firmy + ")";
            stmt.executeUpdate(sql);
            System.out.println("Value inserted succesfully");
            stmt.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

    public void findById() {
        Scanner input = new Scanner(System.in);

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = Database.getConnection();
            //STEP 4: Execute a query

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            System.out.println("Wprowadz id adresu");

            int id_search = input.nextInt();
            sql = "SELECT * FROM pracownicy WHERE id_pracownika=" + id_search + "";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_pracownika = rs.getInt("id_pracownika");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String kolor_oczu = rs.getString("kolor_oczu");
                int wzrost = rs.getInt("wzrost");
                char plec = rs.getString("plec").charAt(0);
                String telefon = rs.getString("telefon");
                String email = rs.getString("email");
                String pesel = rs.getString("pesel");
                LocalDate data_urodzin = rs.getDate("data_urodzin").toLocalDate();
                int id_stanowiska = rs.getInt("id_stanowiska");
                int wynagrodzenie = rs.getInt("wynagrodzenie");
                int id_firmy = rs.getInt("id_firmy");

                //Display values
                System.out.println("ID: " + id_pracownika + ", " + " Imie: " + imie + ", " + " Nazwisko: " + nazwisko + ", " + " Kolor oczu: "
                        + kolor_oczu + ", " + " Wzrost: " + wzrost + ", " + " Płeć: " + plec + ", " + " Telefon: " + telefon + ", " + " Email: "
                        + email + ", " + " PESEL: " + pesel + ", " + " Data urodzin: " + data_urodzin + ", " + " ID stanowiska: "
                        + id_stanowiska + ", " + " Wynagrodzenie: " + wynagrodzenie + ", " + " ID firmy: " + id_firmy + ", ");

            }
            rs.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
}
