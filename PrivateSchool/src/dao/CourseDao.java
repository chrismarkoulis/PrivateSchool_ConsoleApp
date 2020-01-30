/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Course;
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

/**
 *
 * @author chris
 */
public class CourseDao extends SuperDao implements interfaceDao<Course> {

    private static final String FINDALL = "select ccode, ctitle, cstream, "
            + "ctype, cstartDate, cendDate from courses";
    private static final String FINDCOURSEBYID = "select * from courses where ccode = ?";
    private static final String INSERTCOURSE = "INSERT INTO courses(ctitle, cstream, ctype,cstartDate,cendDate)"
            + "values(?,?,?,?,?)";
    
    
    
    @Override
    public void insert() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter course's title");
        String title = input.nextLine();
        System.out.println("Enter course's stream");
        String stream = input.nextLine();
        System.out.println("Enter course's type");
        String type = input.nextLine();
        Date startDate = checkStartDate(input);
        Date endDate = checkEndDate(input);
        

        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERTCOURSE);
            pst.setString(1, title);
            pst.setString(2, stream);
            pst.setString(3, type);
            pst.setDate(4, startDate);
            pst.setDate(5,endDate);
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Course inserted successfully");
            } else {
                System.out.println("Course not inserted");
            }
            pst.close();
            closeConnections(pst);
        } catch (SQLException ex) {

            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public List<Course> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Course> courses = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int ccode = rs.getInt(1);
                String ctile = rs.getString(2);
                String cstream = rs.getString(3);
                String ctype = rs.getString(4);
                LocalDate cstartDate = rs.getDate(5).toLocalDate();
                LocalDate cendDate = rs.getDate(6).toLocalDate();
                Course s = new Course(ccode, ctile, cstream, ctype, cstartDate, cendDate);
                courses.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return courses;

    }

    @Override
    public Course findbyId(int id) {
        
        Course c = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            
             pstm = getConnection().prepareStatement(FINDCOURSEBYID);
             pstm.setInt(1,id);
             rs = pstm.executeQuery();
             rs.next();
                int ccode = rs.getInt(1);
                String ctile = rs.getString(2);
                String cstream = rs.getString(3);
                String ctype = rs.getString(4);
                LocalDate cstartDate = rs.getDate(5).toLocalDate();
                LocalDate cendDate = rs.getDate(6).toLocalDate();
             c = new Course(ccode, ctile, cstream, ctype, cstartDate, cendDate);
        } catch (SQLException ex) {
            Logger.getLogger(CourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
closeConnections(rs, pstm);
}
return c;


    }
    
    
    
    
    private static Date checkStartDate(Scanner input) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Date d=null;
        try {
            System.out.println("Enter course's start date in dd/mm/yyyy format");
           String date = input.nextLine();
            LocalDate ld= LocalDate.parse(date, formatter);
           d= Date.valueOf(ld);
            
        } catch (Exception e) {
            System.out.println("Invalid input.Try again");
            checkStartDate(input);
        }
        
        return d;

    }
    
    private static Date checkEndDate(Scanner input) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Date d=null;
        try {
            System.out.println("Enter course's end date in dd/mm/yyyy format");
           String date = input.nextLine();
            LocalDate ld= LocalDate.parse(date, formatter);
           d= Date.valueOf(ld);
            
        } catch (Exception e) {
            System.out.println("Invalid input.Try again");
            checkEndDate(input);
        }
        
        return d;

    }
    
    
    
}
