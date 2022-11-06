import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Blood {
    public static void main(String[] args) {


        int choice;

        while (true) {
            System.out.println("select an option");
            System.out.println("1.insert");
            System.out.println("2.view");
            System.out.println("3.search");
            System.out.println("4.delete");
            System.out.println("5.update");
            System.out.println("6.Exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("insert donor selected");
                    System.out.println("enter the name:");
                    String name = scanner.next();
                    System.out.println("enter the bloodgroup:");
                    String bloodgroup = scanner.next();
                    System.out.println("enter the unit:");
                    int unit = scanner.nextInt();
                    System.out.println("enter the phone:");
                    String phone = scanner.next();
                    System.out.println("enter the place:");
                    String place = scanner.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbankdb", "root", "");
                        String sql = "INSERT INTO `donors`(`name`, `bloodgroup`, `unit`, `phone`, `place`) VALUES (?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1, name);
                        stmt.setString(2, bloodgroup);
                        stmt.setInt(3, unit);
                        stmt.setString(4, phone);
                        stmt.setString(5, place);

                        stmt.executeUpdate();
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    break;

                case 2:
                    System.out.println("view selected");
                    break;
                case 3:
                    System.out.println("search selected");
                    break;

                case 4:
                    System.out.println("delete selected");
                    break;

                case 5:
                    System.out.println("update selected");
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter correct value");
                    break;
            }
        }
    }
}
