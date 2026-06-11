
package studentmanagement;

import java.util.Scanner;
import java.sql.*;

public class StudentManagement {
    static String URL = "Jdbc:mysql://localhost:3306/student";
    static String USER = "root";
    static String PASS = "";
    static Scanner s = new Scanner(System.in);
    
    
    static void Menu(){
        
           
           boolean loop = true;
           
           while(loop){
                System.out.println("===== Welcome To Student Registration System =====");
                System.out.println("1. Register Students");
                System.out.println("2. Update Students");
                System.out.println("3. Delete Students");
                System.out.println("4. View Students");
                System.out.println("5. Search Student By Name");
                System.out.println("6. All Student Average Grade");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int option = s.nextInt();
                switch(option){
                    case 1:
                        Add_student();
                        break;
                    case 2:
                        Update_student();
                        break;
                    case 3:
                        Remove_student();
                        break;
                    case 4:
                        ViewAll_student();
                        break;
                    case 5:
                        Search_student();
                        break;
                    case 6:
                        AverageGrade_student();
                        break;
                    case 7:
                        System.out.println("Thanks For Using Us");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Option");
                        break;
                }
           }
    
    }
    static void Add_student(){
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
        
            System.out.print("Enter Student ID: ");
            int id = s.nextInt();
            s.nextLine();
            System.out.print("Enter Full Name: ");
            String name = s.nextLine();
            System.out.print("Enter Student's Age: ");
            int age = s.nextInt();
            System.out.print("Enter Average Mark: ");
            double mark = s.nextDouble();
            s.nextLine();
            System.out.print("Enter Course: ");
            String course = s.nextLine();
            String insertSQL = "INSERT INTO STUDENT_DETAILS(STUDENT_ID, FULL_NAME, AGE, MARK, COURSE) VALUES(?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setDouble(4, mark);
            pstmt.setString(5, course);            
            
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(name + " added successfully");
            } else {
                System.out.println("Failed to add student.");
            }
            
                boolean loop = true;
                
                while(loop){
                    System.out.println("---------------------------------");
                    System.out.println("1. Back");
                    System.out.println("2. Exit");
                    System.out.print("Choose an option: ");
                    int option = s.nextInt();
                    switch(option){
                        case 1:
                            Menu();
                            break;
                        case 2:
                            System.out.println("Thanks For Using Our System");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                }
                          
            
        
        
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    static void Update_student(){
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            
            boolean loop = true;
            while(loop){
                System.out.println(" Modify an existing student's details ");
                System.out.println("1. Full Name");
                System.out.println("2. Age");
                System.out.println("3. Mark");
                System.out.println("4. Course");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");
                int option = s.nextInt();
                switch(option){
                    case 1:

                        System.out.print("Enter Student ID: ");
                        int id = s.nextInt();
                        s.nextLine();
                        System.out.print("Enter New Full Name: ");
                        String name = s.nextLine();
                        String insertSQL = "UPDATE STUDENT_DETAILS SET FULL_NAME = ? WHERE STUDENT_ID = ? ";

                        PreparedStatement pstmt = conn.prepareStatement(insertSQL);
                        pstmt.setString(1, name);
                        pstmt.setInt(2, id);
                        int rowsAffected = pstmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Student fullname updated successfully.");
                        } else {
                            System.out.println("No Student found with ID " + id);
                        }
                    break;
                    case 2:
                        System.out.print("Enter Student ID: ");
                        int id1 = s.nextInt();
                        s.nextLine();
                        System.out.print("Enter New Age: ");
                        int age = s.nextInt();
                        String insertSQL1 = "UPDATE STUDENT_DETAILS SET AGE = ? WHERE STUDENT_ID = ? ";

                        PreparedStatement pstmt1 = conn.prepareStatement(insertSQL1);
                        pstmt1.setInt(1, age);
                        pstmt1.setInt(2, id1);
                        int rowsAffected1 = pstmt1.executeUpdate();
                        if (rowsAffected1 > 0) {
                            System.out.println("Student Age updated successfully.");
                        } else {
                            System.out.println("No Student found with ID " + id1);
                        }
                    break;
                    case 3:
                        System.out.print("Enter Student ID: ");
                        int id2 = s.nextInt();
                        s.nextLine();
                        System.out.print("Enter New Age: ");
                        double mark = s.nextInt();
                        String insertSQL2 = "UPDATE STUDENT_DETAILS SET MARK = ? WHERE STUDENT_ID = ? ";

                        PreparedStatement pstmt2 = conn.prepareStatement(insertSQL2);
                        pstmt2.setDouble(1, mark);
                        pstmt2.setInt(2, id2);
                        int rowsAffected2 = pstmt2.executeUpdate();
                        if (rowsAffected2 > 0) {
                            System.out.println("Student Mark updated successfully.");
                        } else {
                            System.out.println("No Student found with ID " + id2);
                        }

                    break;
                    case 4:
                        System.out.print("Enter Student ID: ");
                        int id3 = s.nextInt();
                        s.nextLine();
                        System.out.print("Enter New Course: ");
                        String course = s.nextLine();
                        String insertSQL3 = "UPDATE STUDENT_DETAILS SET COURSE = ? WHERE STUDENT_ID = ? ";

                        PreparedStatement pstmt3 = conn.prepareStatement(insertSQL3);
                        pstmt3.setString(1, course);
                        pstmt3.setInt(2, id3);
                        int rowsAffected3 = pstmt3.executeUpdate();
                        if (rowsAffected3 > 0) {
                            System.out.println("Student Mark updated successfully.");
                        } else {
                            System.out.println("No Student found with ID " + id3);
                        }

                    break;
                    case 5:
                        Menu();
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;            
                }
            
            
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    
    static void Remove_student(){
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            
            System.out.println("===== Delete Student Record ======");
            s.nextLine();
            System.out.print("Enter Student ID: ");
            int id = s.nextInt();
            String insertSQL = "DELETE FROM STUDENT_DETAILS WHERE STUDENT_ID = ?";

            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Successfully Removed Student");
            } else {
                System.out.println("No Student found with ID " + id);
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
    
    
    }
    static void ViewAll_student(){
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            System.out.println("===== View All Students ======");
            String insertSQL = "SELECT * FROM STUDENT_DETAILS";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("STUDENT_ID");
                //String St_id = rs.getString("STUDENT_ID");
                String fullname = rs.getString("Full_Name");
                int Age = rs.getInt("Age");
                String course = rs.getString("COURSE");
                
                System.out.println("------------------------------");
                System.out.println("Student ID: " + id);
                //System.out.println("Student ID: " + St_id);
                System.out.println("Full Name: " + fullname);
                System.out.println("Age: " + Age);
                System.out.println("Course: " + course);
                System.out.println("------------------------------");
            
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
    
    }
    static void Search_student(){
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            
            System.out.println("===== Search Student ======");
            s.nextLine();
            System.out.print("Enter Student Full Name: ");
            String name = s.nextLine();
            String insertSQL = "SELECT * FROM STUDENT_DETAILS WHERE Full_Name = ?";

            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, name);            
        
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                
                    int idd = rs.getInt("STUDENT_ID");
                    //String St_id = rs.getString("STUDENT_ID");
                    String fullname = rs.getString("Full_Name");
                    int Age = rs.getInt("Age");
                    String course = rs.getString("COURSE");

                    System.out.println("------------------------------");
                    System.out.println("Student ID: " + idd);
                    //System.out.println("Student ID: " + St_id);
                    System.out.println("Full Name: " + fullname);
                    System.out.println("Age: " + Age);
                    System.out.println("Course: " + course);
                    System.out.println("------------------------------");

                
            } else {
                System.out.println("No Student found with Name: " + name);
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    
    }
    static void AverageGrade_student(){
        try(Connection conn = DriverManager.getConnection(URL, USER, PASS)){
            System.out.println("===== Check Student Average Grade  ======");
          
            String insertSQL = "SELECT AVG(MARK) AS AVERAGE_MARK FROM STUDENT_DETAILS";

            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
                      
        
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                
                    double mark = rs.getDouble("AVERAGE_MARK");

                    System.out.println("------------------------------");
                    System.out.println("Average Mark: " + mark);
                    System.out.println("------------------------------");

                
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
    
    }
   
    public static void main(String[] args) {
       Menu();
    }
    
}
