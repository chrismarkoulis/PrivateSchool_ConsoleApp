/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.MoreThanOneCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class MoreThanOneCourseDao extends SuperDao {
    
    private static final String FINDALL = "select * from moreThanOneCourse";
    
    
    public List<MoreThanOneCourse> lastQuery(){

        PreparedStatement st = null;
        ResultSet rs = null;
        List<MoreThanOneCourse> list = new ArrayList();
        try {
            st = getConnection().prepareStatement(FINDALL);
            rs = st.executeQuery();
            while(rs.next()){
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int id = rs.getInt("student_ID");
                int number = rs.getInt("number_of_courses");
                
                
                
                MoreThanOneCourse mtc = new MoreThanOneCourse(firstName, lastName, id, number);
                list.add(mtc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MoreThanOneCourseDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            closeConnections(rs, st);
        }
        return list;



}
    
    
}
