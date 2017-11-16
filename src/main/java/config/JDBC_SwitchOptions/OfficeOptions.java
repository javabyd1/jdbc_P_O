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
public class OfficeOptions {


    public void endProgram() {
        System.out.println("Główne menu");
    }

    public void officeList() {

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
            sql = "SELECT * FROM stanowiska";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id_stanowiska = rs.getInt("id_stanowiska");
                String nazwa = rs.getString("nazwa");

                //Display values
                System.out.println("ID: " + id_stanowiska + ", " + " Nazwa stanowiska: " + nazwa + ", ");
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

    public void insertNewOffice() {
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

            System.out.println("Wprowadz id stanowiska: ");
            int id_input = input.nextInt();
            input.nextLine();
            System.out.println("Wprowadz nazwe stanowiska");
            String stanowisko_nazwa = input.nextLine();

            sql = "INSERT INTO stanowiska  VALUES (" + id_input + ", '" + stanowisko_nazwa + "')";
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

            System.out.println("Wprowadz id stanowiska");

            int id_search = input.nextInt();
            sql = "SELECT * FROM stanowiska WHERE id_stanowiska=" + id_search + "";
            ResultSet rsa = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while (rsa.next()) {
                //Retrieve by column name
                int id_stanowiska = rsa.getInt("id_stanowiska");
                String nazwa = rsa.getString("nazwa");

                //Display values
                System.out.println("ID: " + id_stanowiska + ", ");
                System.out.print(" Nazwa stanowiska: " + nazwa + ", ");
            }
            rsa.close();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }

}



