/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Student;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypackage.PrivateSchool;

/**
 *
 * @author chris
 */
public class StudentDao extends SuperDao implements interfaceDao<Student> {
    
    private static final String FINDALL = "select scode, sfirstName, slastName, sdateOfBirth, tuitionFees from students";
    private static final String FINDSTUDENTBYID = "select * from students where scode = ?";
    private static final String INSERTSTUDENT = "INSERT INTO students(sfirstName, slastName, sdateOfBirth, tuitionFees)values(?,?,?,?)";

        
    
    @Override
    public void insert(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student's First name");
        String fname = input.nextLine();
        System.out.println("Enter student's name");
        String lname = input.nextLine();
        Date dob = checkDate(input);
        System.out.println("Enter student's tuition fees");
        int tuitionfees = input.nextInt();

        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERTSTUDENT);
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setDate(3, dob);
            pst.setInt(4, tuitionfees);
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Student inserted successfully");
            } else {
                System.out.println("Student not inserted");
            }
            pst.close();
            closeConnections(pst);
        } catch (SQLException ex) {

            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean create(Student s) {
        PreparedStatement pst = null;
        boolean created = false;
        try {
            pst = getConnection().prepareStatement(INSERTSTUDENT);
            pst.setString(1, s.getFirstName());
            pst.setString(2, s.getLastName());
            pst.setObject(3, s.getDob());
            pst.setInt(4, s.getTuitionFees());
            int result = pst.executeUpdate();
            if (result > 0) {
                created = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(pst);
        }
        return created;



    }

    @Override
    public List<Student> findAll() {
    Statement stmt = null;
        ResultSet rs = null;
        List<Student> students = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int scode = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                LocalDate dob = rs.getDate(4).toLocalDate();
                int fees = rs.getInt(5);
               Student s = new Student(scode, fName, lName, dob, fees);
                students.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return students;

    }

    @Override
    public Student findbyId(int id) {
        Student s = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            
             pstm = getConnection().prepareStatement(FINDSTUDENTBYID);
             pstm.setInt(1,id);
             rs = pstm.executeQuery();
             rs.next();
             int scode = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                LocalDate dob = rs.getDate(4).toLocalDate();
                int fees = rs.getInt(5);
             s = new Student(scode, fName, lName, dob, fees);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
closeConnections(rs, pstm);
}
return s;



    }
    
    
    
    
    
    private static Date checkDate(Scanner input) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Date d=null;
        try {
            System.out.println("Enter student's date of birth in dd/mm/yyyy format");
           String date = input.nextLine();
            LocalDate ld= LocalDate.parse(date, formatter);
           d= Date.valueOf(ld);
            
        } catch (Exception e) {
            System.out.println("Invalid input.Try again");
            checkDate(input);
        }
        
        return d;

    }
    
    
}
