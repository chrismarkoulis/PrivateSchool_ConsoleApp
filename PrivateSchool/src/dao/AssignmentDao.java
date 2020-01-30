/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Assignment;
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
public class AssignmentDao extends SuperDao implements interfaceDao<Assignment> {

    private static final String FINDALL = "select acode, atitle, adescription, subDateTime, "
            + "oralMark, totalMark from assignments";
    private static final String FINDASSIGNMENTBYID = "select * from assignments where acode = ?";
    private static final String INSERTASSIGNMENT = "INSERT INTO assignments(atitle, adescription, subDateTime,oralMark,totalMark)"
            + "values(?,?,?,?,?)";

    @Override
    public void insert() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter assignment's title");
        String title = input.nextLine();
        System.out.println("Enter assignment's description");
        String description = input.nextLine();
        Date subDate = checkSubDate(input);
        System.out.println("Enter assignment's oral mark");
        int oralMark = input.nextInt();

        do {
            System.out.println("oral Mark must be between 0 and 40 points\nplease enter again");
            input.nextInt();
            break;

        } while (oralMark > 40 || oralMark < 0);
        System.out.println("Enter assignment's total mark");
        int totalMark = input.nextInt();
        while (totalMark < 0 || totalMark > 100) {

            System.out.println("total Mark must be between 0 and 100 points\nplease enter again");
            input.nextInt();
            break;
        }

        try {
            PreparedStatement pst = getConnection().prepareStatement(INSERTASSIGNMENT);
            pst.setString(1, title);
            pst.setString(2, description);
            pst.setDate(3, subDate);
            pst.setInt(4, oralMark);
            pst.setInt(5, totalMark);
            int result = pst.executeUpdate();
            if (result > 0) {
                System.out.println("Assignment inserted successfully");
            } else {
                System.out.println("Assignment not inserted");
            }
            pst.close();
            closeConnections(pst);
        } catch (SQLException ex) {

            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Assignment> findAll() {

        Statement stmt = null;
        ResultSet rs = null;
        List<Assignment> assignments = new ArrayList();
        try {
            stmt = getConnection().createStatement();
            rs = stmt.executeQuery(FINDALL);
            while (rs.next()) {
                int acode = rs.getInt(1);
                String atitle = rs.getString(2);
                String adescription = rs.getString(3);
                LocalDate subDateTime = rs.getDate(4).toLocalDate();
                int oralMark = rs.getInt(5);
                int totalMark = rs.getInt(6);
                Assignment a = new Assignment(acode, atitle, adescription, subDateTime, oralMark, totalMark);
                assignments.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, stmt);
        }
        return assignments;

    }

    @Override
    public Assignment findbyId(int id) {
        Assignment a = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {

            pstm = getConnection().prepareStatement(FINDASSIGNMENTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            rs.next();
            int acode = rs.getInt(1);
            String atitle = rs.getString(2);
            String adescription = rs.getString(3);
            LocalDate subDateTime = rs.getDate(4).toLocalDate();
            int oralMark = rs.getInt(5);
            int totalMark = rs.getInt(6);
            a = new Assignment(acode, atitle, adescription, subDateTime, oralMark, totalMark);
        } catch (SQLException ex) {
            Logger.getLogger(AssignmentDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeConnections(rs, pstm);
        }
        return a;
    }

    private static Date checkSubDate(Scanner input) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Date d = null;
        try {
            System.out.println("Enter assignment's submission date in dd/mm/yyyy format");
            String date = input.nextLine();
            LocalDate ld = LocalDate.parse(date, formatter);
            d = Date.valueOf(ld);

        } catch (Exception e) {
            System.out.println("Invalid input.Try again");
            checkSubDate(input);
        }

        return d;

    }

}
