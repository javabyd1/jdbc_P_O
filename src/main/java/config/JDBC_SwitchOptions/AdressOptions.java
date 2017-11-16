package config.JDBC_SwitchOptions;

import config.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Created by HP on 2017-11-15.
 */
public class AdressOptions {

    public void endProgram() {
        System.out.println("Główne menu");
    }


    public void adressList() {

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
            sql = "SELECT * FROM adresy";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_adresu = rs.getInt("id_adresu");
                String ulica = rs.getString("ulica");
                String numer_domu = rs.getString("numer_domu");
                String numer_mieszkania = rs.getString("numer_mieszkania");
                String kod_pocztowy = rs.getString("kod_pocztowy");
                String miasto = rs.getString("miasto");
                String panstwo = rs.getString("panstwo");
                String wojewodztwo = rs.getString("wojewodztwo");

                //Display values
                System.out.println("ID: " + id_adresu + ", " + " Ulica: " + ulica + ", " + " Numer domu: " + numer_domu + ", "
                        + " Numer mieszkania: " + numer_mieszkania + ", " + " Kod pocztowy: " + kod_pocztowy + ", " + " Miasto: "
                        + miasto + ", " + " Panstwo: " + panstwo + ", " + " Wojewodztwo: " + wojewodztwo + ", ");
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

    public void insertNewAdress() {
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

            System.out.println("Wprowadz id adresu: ");
            int id_input = input.nextInt();
            input.nextLine();
            System.out.println("Wprowadz ulicę");
            String ulica = input.nextLine();
            System.out.println("Wprowadz numer_domu");
            String numer_domu = input.nextLine();
            System.out.println("Wprowadz numer_mieszkania");
            String numer_mieszkania = input.nextLine();
            System.out.println("Wprowadz kod_pocztowy");
            String kod_pocztowy = input.nextLine();
            System.out.println("Wprowadz miasto");
            String miasto = input.nextLine();
            System.out.println("Wprowadz panstwo");
            String panstwo = input.nextLine();
            System.out.println("Wprowadz wojewodztwo");
            String wojewodztwo = input.nextLine();

            sql = "INSERT INTO adresy  VALUES (" + id_input + ", '" + ulica + "', '" + numer_domu + "', '" + numer_mieszkania + "', '"
                    + kod_pocztowy + "', '" + miasto + "', '" + panstwo + "', '" + wojewodztwo + "')";
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
            sql = "SELECT * FROM adresy WHERE id_adresu=" + id_search + "";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_adresu = rs.getInt("id_adresu");
                String ulica = rs.getString("ulica");
                String numer_domu = rs.getString("numer_domu");
                String numer_mieszkania = rs.getString("numer_mieszkania");
                String kod_pocztowy = rs.getString("kod_pocztowy");
                String miasto = rs.getString("miasto");
                String panstwo = rs.getString("panstwo");
                String wojewodztwo = rs.getString("wojewodztwo");

                //Display values
                System.out.println("ID: " + id_adresu + ", " + " Ulica: " + ulica + ", " + " Numer domu: " + numer_domu + ", "
                        + " Numer mieszkania: " + numer_mieszkania + ", " + " Kod pocztowy: " + kod_pocztowy + ", "
                        + " Miasto: " + miasto + ", " + " Panstwo: " + panstwo + ", " + " Wojewodztwo: " + wojewodztwo + ", ");

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