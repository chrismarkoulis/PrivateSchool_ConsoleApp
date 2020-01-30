/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Course;
import entities.Trainer;
import entities.TrainersPerCourse;
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
public class TrainersPerCourseDao extends SuperDao implements interfaceDao<TrainersPerCourse> {

   private static final String FINDALL = "select * from TrainersPerCourse";
   /* didn't need findById for extra entities */
   private static final String FINDTRAINERSPERCOURSEBYID = "select * from TrainersPerCourse where tpccode = ?";
   private static final String INSERTTRAINERSPERCOURSE = "INSERT INTO TrainersPerCourse(ccode,tcode)values(?,?)";
    
    
    
    
    @Override
    public void insert() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter course's id/code");
        int ccode = input.nextInt();
        System.out.println("Enter trainer's id/code");
        int tcode = input.nextInt();
       
      
        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERTTRAINERSPERCOURSE);
            pst.setInt(1, ccode);
            pst.setInt(2, tcode);
            
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("TrainersPerCourse inserted successfully");
            } else {
                System.out.println("TrainersPerCourse not inserted");
            }
            pst.close();
            closeConnections(pst);
        } catch (SQLException ex) {

            Logger.getLogger(TrainersPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<TrainersPerCourse> findAll(){
        PreparedStatement st = null;
        ResultSet rs = null;
        List<TrainersPerCourse> trainersPerCourse = new ArrayList();
        try {
            st = getConnection().prepareStatement(FINDALL);
            rs = st.executeQuery();
            while(rs.next()){
                int id = rs.getInt("tpccode");
                Trainer trainer = getTrainerbyId(rs.getInt("tcode"));
                Course course = getCoursebyId(rs.getInt("ccode"));
                
                
                TrainersPerCourse spc = new TrainersPerCourse(id, trainer, course);
                trainersPerCourse.add(spc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainersPerCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnections(rs, st);
        }
        return trainersPerCourse;
    
                                                                        
    }

    @Override
    public TrainersPerCourse findbyId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Course getCoursebyId(int id){
     CourseDao cdao = new CourseDao();
     Course c = cdao.findbyId(id);
     
     return c;
     }
    
     private Trainer getTrainerbyId(int id){
     TrainerDao tdao = new TrainerDao();
     Trainer t = tdao.findbyId(id);
     
     return t;
     }
    
    
    
}
