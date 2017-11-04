import config.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;


public class JDBC_MenuSwitch {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/j1b";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
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

            System.out.println("Wybierz:");
            System.out.println("1. Lista stanowisk " + "\n" + "2. Dodaj stanowisko" + "\n" + "3. Wyszukaj po numerze id");
            int x = input.nextInt();

            if (x != 1 || x != 2){
                System.out.println("Wpisałes złą liczbę");
            }


            switch (x) {
                case 1:
                    sql = "SELECT * FROM stanowiska";
                    ResultSet rs = stmt.executeQuery(sql);
                    //STEP 5: Extract data from result set
                    while (rs.next()) {
                        //Retrieve by column name
                        int id_stanowiska = rs.getInt("id_stanowiska");
                        String nazwa = rs.getString("nazwa");

                        //Display values
                        System.out.println("ID: " + id_stanowiska + ", ");
                        System.out.print(" Nazwa stanowiska: " + nazwa + ", ");
                    }
                    rs.close();
                    break;
                case 2:
                    System.out.println("Wprowadz id stanowiska: ");

                    int id_input = input.nextInt();

                    input.nextLine();
                    System.out.println("Wprowadz nazwe stanowiska");
                    String stanowisko_nazwa = input.nextLine();

                    sql = "INSERT INTO stanowiska  VALUES (" + id_input + ", '" + stanowisko_nazwa + "')";
                    stmt.executeUpdate(sql);
                    System.out.println("Value inserted succesfully");
                    break;
                case 3:
                    System.out.println("Wprowadz id stanowiska");

                    int id_search = input.nextInt();
            //        sql = "SELECT "
            }

            //STEP 6: Clean-up environment

            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}
