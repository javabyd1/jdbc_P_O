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
public class CompanyOptions {

    public void endProgram() {
        System.out.println("Główne menu");
    }


    public void companyList() {

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
            sql = "SELECT * FROM firmy";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_firmy = rs.getInt("id_firmy");
                String nazwa = rs.getString("nazwa");
                String ulica = rs.getString("ulica");
                String numer_domu = rs.getString("numer_domu");
                String numer_mieszkania = rs.getString("numer_mieszkania");
                String nip = rs.getString("nip");

                //Display values
                System.out.println("ID: " + id_firmy + ", " + " Nazwa: " + nazwa + ", " + " Ulica: " + ulica + ", " + " Numer domu: "
                        + numer_domu + ", " + " Numer mieszkania: " + numer_mieszkania + ", " + " NIP: " + nip + ", ");
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

    public void insertNewCompany() {
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

            System.out.println("Wprowadz id firmy: ");
            int id_input = input.nextInt();
            input.nextLine();
            System.out.println("Wprowadz nazwę firmy");
            String nazwa = input.nextLine();
            System.out.println("Wprowadz ulicę");
            String ulica = input.nextLine();
            System.out.println("Wprowadz numer_domu");
            String numer_domu = input.nextLine();
            System.out.println("Wprowadz numer_mieszkania");
            String numer_mieszkania = input.nextLine();
            System.out.println("Wprowadz NIP");
            String nip = input.nextLine();

            sql = "INSERT INTO firmy VALUES (" + id_input + ", '" + nazwa + "', '" + ulica + "', '" + numer_domu + "', '" + numer_mieszkania + "', '" + nip + "')";
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
            sql = "SELECT * FROM firmy WHERE id_firmy=" + id_search + "";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_firmy = rs.getInt("id_firmy");
                String nazwa = rs.getString("nazwa");
                String ulica = rs.getString("ulica");
                String numer_domu = rs.getString("numer_domu");
                String numer_mieszkania = rs.getString("numer_mieszkania");
                String nip = rs.getString("nip");

                //Display values
                System.out.println("ID: " + id_firmy + ", " + " Nazwa: " + nazwa + ", " + " Ulica: " + ulica + ", " + " Numer domu: " + numer_domu + ", " + " Numer mieszkania: " + numer_mieszkania + ", " + " NIP: " + nip + ", ");

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
