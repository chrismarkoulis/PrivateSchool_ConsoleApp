/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Assignment;
import entities.AssignmentsPerCourse;
import entities.AssignmentsPerStudentPerCourse;
import entities.Course;
import entities.Student;
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
public class AssignmentsPerStudentPerCourseDao extends SuperDao implements interfaceDao<AssignmentsPerStudentPerCourse> {

    private static final String FINDALL = "select * from AssignmentsPerStudentPerCourse";
    /* didn't need findById for extra entities */
    private static final String FINDASSIGNMENTS_PERSTUDENT_PERCOURSEBYID = "select * from AssignmentsPerStudentPerCourse where appcode = ?";
    private static final String INSERT_ASSIGNMENTS_PERSTUDENT_PERCOURSE = 
      "INSERT INTO AssignmentsPerStudentPerCourse(ccode,acode,scode,stdOralMark,stdTotalMark)values(?,?,?,?,?)";
    
    
    
    @Override
    public void insert() {
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter assignment's id/code");
        int acode = input.nextInt();
        System.out.println("Enter course's id/code");
        int ccode = input.nextInt();
        System.out.println("Enter student's id/code");
        int scode = input.nextInt();
        System.out.println("Enter student's oral mark");
        int oralMark = input.nextInt();
        System.out.println("Enter student's total mark");
        int totalMark = input.nextInt();
       
      
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERT_ASSIGNMENTS_PERSTUDENT_PERCOURSE);
            pst.setInt(1, ccode);
            pst.setInt(2, acode);
            pst.setInt(3, scode);
            pst.setInt(4, oralMark);
            pst.setInt(5, totalMark);
            
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("AssignmentsPerStudentPerCourse inserted successfully");
            } else {
                System.out.println("AssignmentsPerStudentPerCourse not inserted");
            }
            pst.close();
            closeConnections(pst);
        } catch (SQLException ex) {

            Logger.getLogger(AssignmentsPerStudentPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<AssignmentsPerStudentPerCourse> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<AssignmentsPerStudentPerCourse> assignmentsPerStudentPerCourse = new ArrayList();
        try {
            st = getConnection().prepareStatement(FINDALL);
            rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("appcode");
                Course course = getCoursebyId(rs.getInt("ccode"));
                Assignment assignment = getAssignmentbyId(rs.getInt("acode"));
                Student student = getStudentbyId(rs.getInt("scode"));
                int stdOralMark = rs.getInt("stdOralMark");
                int stdTotalMark = rs.getInt("stdTotalMark");     
                                
                AssignmentsPerStudentPerCourse app = new AssignmentsPerStudentPerCourse
                (id, assignment, student, course, stdOralMark, stdTotalMark);
                assignmentsPerStudentPerCourse.add(app);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsPerStudentPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnections(rs, st);
        }
        return assignmentsPerStudentPerCourse;
        
    }

    @Override
    public AssignmentsPerStudentPerCourse findbyId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private Assignment getAssignmentbyId(int id) {
        AssignmentDao adao = new AssignmentDao();
        Assignment a = adao.findbyId(id);

        return a;
    }
    
     private Course getCoursebyId(int id){
     CourseDao cdao = new CourseDao();
     Course c = cdao.findbyId(id);
     
     return c;
     }
    
      private Student getStudentbyId(int id) {
        StudentDao sdao = new StudentDao();
        Student s = sdao.findbyId(id);

        return s;
    }
    
    
}
