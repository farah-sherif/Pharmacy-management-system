/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.sql.*;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Dell
 */
public class Selling_repository {

    public void SelectMed(Connection Con, Statement st, ResultSet rs, JTable MedicineTable) {
        try {
            Con = DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
            st = Con.createStatement();
            rs = st.executeQuery("Select *from MedicineTBL");
            MedicineTable.setModel(DbUtils.resultSetToTableModel(rs));
            Con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ShowDate(JLabel datelbl) {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        datelbl.setText(s.format(d));
    }

    public void Update(int newQty, JTextField MedId, JTable MedicineTable) {
        Selling S = new Selling();
        try {

            S.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            String UpdateQuery = "Update MEDICINETBL set MEDQTY = " + newQty + "" + "where MEDId=" + MedId;
            Statement Add = S.getCon().createStatement();
            Add.executeLargeUpdate(UpdateQuery);
            JOptionPane.showMessageDialog(S, "medicine updated successfully ");
            S.getCon().close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        SelectMed(S.getCon(), S.getSt(), S.getRs(), MedicineTable);
    }

    public void Print(JTextArea Billtxt) {
        try {
            Billtxt.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getMed_Price(String medName) {
        int p = 0;
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
            // Create a statement object
            Statement statement = connection.createStatement();
            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MedicineTBL WHERE MEDNAME = '" + medName+ "'");
            // Extract the value from the result set
            if (resultSet.next()) {
                p = resultSet.getInt("MEDPRICE");
            }
        } catch (SQLException e) {
            System.out.println("Error in getting price");
        }
        return p;
    }
    public int getMed_Qty(String medName){
        int QTY = 0;
        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
            // Create a statement object
            Statement statement = connection.createStatement();
            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery("SELECT * FROM MedicineTBL WHERE MEDNAME = '" + medName+ "'");
            // Extract the value from the result set
            if (resultSet.next()) {
                QTY = resultSet.getInt("MEDQTY");
            }
        } catch (SQLException e) {
            System.out.println("Error in getting QTY");
        }
        return QTY;
    }
    public void updateMedQty(String medName, int qty) {
    //Selling S = new Selling();
    try {
    Connection connection = DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
    String updateQuery = "UPDATE MEDICINETBL SET MEDQTY = " + qty + " WHERE MEDNAME = '" + medName + "'";
    Statement statement = connection.createStatement();
    statement.executeUpdate(updateQuery);
     } catch (SQLException ex) {
    System.out.println("Error updating quantity: " + ex.getMessage());
}
    }   

    
    /*public void setMed_Price(Connection Con ,Statement st , ResultSet rs , TextField QTY ) throws SQLException
    { 
    try 
    { 
        Con =DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
        st = Con.createStatement();
        PreparedStatement add = Con.prepareStatement("insert into SellingTable values(?,?,?,?,?,?,?)");
            add.setInt(1, Integer.valueOf(ID));
            add.setString(2,Name);
            add.setInt(3, Integer.valueOf(Price));
            add.setInt(4, Integer.valueOf(Qty));
            
            add.setString(5, FD.toString());
            
            add.setString(6, ED.toString());
            add.setString(7, MedComp.getSelectedItem().toString());
        
        Con.close();
    }   
    catch (SQLException e) 
    {
        e.printStackTrace();
    }
    }*/

    
}
