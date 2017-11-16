
import config.JDBC_SwitchOptions.DB_Menu;

import java.util.Scanner;


public class JDBC_MenuSwitch {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/j1b";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {

        DB_Menu menu = new DB_Menu();


        Scanner input = new Scanner(System.in);

        int x;

        do {
            System.out.println();
            System.out.println("Wybierz, którą bazą danych chcesz pracować?");
            System.out.println("1. Adresy " + "\n" + "2. Firmy" + "\n" + "3. Pracownicy" + "\n" + "4. Stanowiska" + "\n" + "0. Zakoncz dzialanie programu");
            x = input.nextInt();


            switch (x) {
                case 0:
                    System.out.println("Zakonczyles dzialanie programu");
                    break;
                case 1:
                    menu.adressMenu();
                    break;
                case 2:
                    menu.companyMenu();
                    break;
                case 3:
                    menu.employeeMenu();
                    break;
                case 4:
                    menu.officeMenu();
                    break;
            }
        } while (x != 0);

        //STEP 6: Clean-up environment

//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            //Handle errors for JDBC
//            se.printStackTrace();
//        } catch (Exception e) {
//            //Handle errors for Class.forName
//            e.printStackTrace();
//        } finally {
//            //finally block used to close resources
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            }// nothing we can do
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }//end finally try
//        }//end try
        System.out.println("Goodbye!");
    }//end main
}
