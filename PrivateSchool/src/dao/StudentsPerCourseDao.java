/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Course;
import entities.Student;
import entities.StudentsPerCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class StudentsPerCourseDao extends SuperDao implements interfaceDao<StudentsPerCourse> {

    private static final String FINDALL = "select * from studentsPerCourse";
    /* didn't need findById for extra entities */
    private static final String FINDSTUDENTSPERCOURSEBYID = "select * from StudentsPerCourse where spccode = ?";
    private static final String INSERTSTUDENTSPERCOURSE = "INSERT INTO StudentsPerCourse(ccode,scode)values(?,?)";
    
    
    
    @Override
    public void insert() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter course's id/code");
        int ccode = input.nextInt();
        System.out.println("Enter students's id/code");
        int scode = input.nextInt();
       
      
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERTSTUDENTSPERCOURSE);
            pst.setInt(1, ccode);
            pst.setInt(2, scode);
            
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("StudentsPerCourse inserted successfully");
            } else {
                System.out.println("StudentsPerCourse not inserted");
            }
            pst.close();
            closeConnections(pst);
        } catch (SQLException ex) {

            Logger.getLogger(StudentsPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @Override
    public List<StudentsPerCourse> findAll() {
    
    PreparedStatement st = null;
        ResultSet rs = null;
        List<StudentsPerCourse> studentsPerCourse = new ArrayList();
        try {
            st = getConnection().prepareStatement(FINDALL);
            rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("spccode");
                Student student = getStudentbyId(rs.getInt("scode"));
                Course course = getCoursebyId(rs.getInt("ccode"));
                
                
                StudentsPerCourse spc = new StudentsPerCourse(id, student, course);
                studentsPerCourse.add(spc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnections(rs, st);
        }
        return studentsPerCourse;
    }
    
    
    

    
    
    
    
    
    @Override
    public StudentsPerCourse findbyId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
     private Student getStudentbyId(int id) {
        StudentDao sdao = new StudentDao();
        Student s = sdao.findbyId(id);

        return s;
    }
    
     private Course getCoursebyId(int id){
     CourseDao cdao = new CourseDao();
     Course c = cdao.findbyId(id);
     
     return c;
     }
    
    
    
}
