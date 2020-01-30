/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Assignment;
import entities.AssignmentsPerCourse;
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
public class AssignmentsPerCourseDao extends SuperDao implements interfaceDao<AssignmentsPerCourse> {

    private static final String FINDALL = "select * from AssignmentsPerCourse";
    /* didn't need findById for extra entities */
    private static final String FINDASSIGNMENTSPERCOURSEBYID = "select * from AssignmentsPerCourse where apccode = ?";
    private static final String INSERTASSIGNMENTSPERCOURSE = "INSERT INTO TrainersPerCourse(acode,ccode)values(?,?)";
    
    
    
    @Override
    public void insert() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter assignment's id/code");
        int acode = input.nextInt();
        System.out.println("Enter course's id/code");
        int ccode = input.nextInt();
       
      
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERTASSIGNMENTSPERCOURSE);
            pst.setInt(1, acode);
            pst.setInt(2, ccode);
            
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("AssignmentsPerCourse inserted successfully");
            } else {
                System.out.println("AssignmentsPerCourse not inserted");
            }
            pst.close();
            closeConnections(pst);
        } catch (SQLException ex) {

            Logger.getLogger(AssignmentsPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<AssignmentsPerCourse> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<AssignmentsPerCourse> assignmentsPerCourse = new ArrayList();
        try {
            st = getConnection().prepareStatement(FINDALL);
            rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("apccode");
                Assignment assignment = getAssignmentbyId(rs.getInt("acode"));
                Course course = getCoursebyId(rs.getInt("ccode"));
                
                
                AssignmentsPerCourse apc = new AssignmentsPerCourse(id, assignment, course);
                assignmentsPerCourse.add(apc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentsPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnections(rs, st);
        }
        return assignmentsPerCourse;
    }

    

    @Override
    public AssignmentsPerCourse findbyId(int id) {
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
    
    
    
}
