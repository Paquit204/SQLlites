
package testapp2b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Testapp2b {

       public static Connection connectDB() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC"); // Load the SQLite JDBC driver
            con = DriverManager.getConnection("jdbc:sqlite:testapp.db"); // Establish connection
            System.out.println("Connection Successful");
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e);
        }
        return con;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
            connectDB();
           
            System.out.println("Enter first name");
            String fname=sc.nextLine();
            System.out.println("Enter last nmae");
            String lname=sc.nextLine();
            System.out.println("Enter email");
            String ems=sc.nextLine();
            System.out.println("Enter status");
            String sts=sc.nextLine();
     
            String sql= "INSERT INTO tbl_students(s_fname,l_name, s_email, s_status) VALUES (?,?,?,?)";
            
            try {
                Connection con = connectDB();
                PreparedStatement pst=con.prepareStatement(sql);
                pst.setString (1,fname);
                pst.setString (2,lname);
                pst.setString (3,ems);
                pst.setString (4,sts);
                pst.executeUpdate();
                System.out.println("inserted sucessfully");
                
                
                
            }catch (SQLException ex){
                
                System.out.println("Connecton: " + ex.getMessage());
            }
    }
    
}
