/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Trainer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chris
 */
public class TrainerDao extends SuperDao implements interfaceDao<Trainer> {

    private static final String FINDALL = "select tcode, tfirstName, tlastName, trsubject from trainers";
    private static final String FINDTRAINERBYID = "select * from trainers where tcode = ?";
    private static final String INSERTTRAINER = "INSERT INTO trainers(tfirstName, tlastName, trsubject)values(?,?,?)";

    
        
    
    @Override
    public void insert() {
         Scanner input = new Scanner(System.in);
        System.out.println("Enter trainer's First name");
        String fname = input.nextLine();
        System.out.println("Enter trainer's name");
        String lname = input.nextLine();
        System.out.println("Enter trainer's subject");
        String subject = input.nextLine();

        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERTTRAINER);
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, subject);
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Trainer inserted successfully");
            } else {
                System.out.println("Trainer not inserted");
            }
            pst.close();
            closeConnections(pst);
        } catch (SQLException ex) {

            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    public List<Trainer> findAll() {
        Statement stmt = null;
        ResultSet rs = null;
        List<Trainer> trainers = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int tcode = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String subject = rs.getString(4);
                Trainer s = new Trainer(tcode, fName, lName, subject);
                trainers.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return trainers;

    }

    
    
    
    
    
    
    @Override
    public Trainer findbyId(int id) {
        Trainer t = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            
             pstm = getConnection().prepareStatement(FINDTRAINERBYID);
             pstm.setInt(1,id);
             rs = pstm.executeQuery();
             rs.next();
                int tcode = rs.getInt(1);
                String fName = rs.getString(2);
                String lName = rs.getString(3);
                String subject = rs.getString(4);
                t = new Trainer(tcode, fName, lName, subject);
        } catch (SQLException ex) {
            Logger.getLogger(TrainerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
closeConnections(rs, pstm);
}
return t;

        
    }
    
}
