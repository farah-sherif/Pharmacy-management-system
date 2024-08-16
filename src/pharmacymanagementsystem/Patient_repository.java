/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author W.I
 */
public class Patient_repository {
    
    public void Add(int id , String name , int age ,String phone1,String phone2 ,String address ,int W , int H,String gender){
      Patient p = new Patient();
    try {
            p.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            PreparedStatement add = p.getCon().prepareStatement("insert into PATIENTTBL values(?,?,?,?,?,?,?,?,?)");
            add.setInt(1, id);
            add.setString(2, name);
            add.setInt(3, age);
            add.setString(4, phone1);
            add.setString(5, phone2);
            add.setString(6, address);
            add.setInt(7, W);
            add.setInt(8, H);
            add.setString(9, gender);
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(p, "patient Added Successfully");
            p.getCon().close();

        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
    }
    public void update (int id , String name , int age ,String phone1,String phone2 ,String address ,int W , int H,String gender)
    {
        Patient p = new Patient();
        try{
           p.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
           //String text = AgId.getText();
           String UpdateQuery ="Update PATIENTTBL set PANAME = '"+name+"'"+",PAAGE = "+age+",PAPHONE1 = '"+phone1+"',PAPHONE2 = '"+phone2+
                   "',PAADD = '"+address+"',PAWEIGHT ="+W+",PAHEIGHT ="+H+",PAGENDER= '"+gender+"'"+"where PAId="+ id;
           Statement Add = p.getCon().createStatement();
           Add.executeLargeUpdate(UpdateQuery);
           JOptionPane.showMessageDialog(p, "patient updated successfully "); 
           p.getCon().close();
           Add.close();
        }catch (SQLException ex) {
                  System.out.println(ex.getMessage());           
        }
    }
    
    public void Delete ( String ID)
    {
        Patient p = new Patient();
        try{
           p.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
           String Query ="Delete from PATIENTTBL where PAID=" +ID;
           Statement Add = p.getCon().createStatement();
           Add.executeLargeUpdate(Query);
           JOptionPane.showMessageDialog(p, "patient deleted Successfully");
           Add.close();
           p.getCon().close();

            } catch (SQLException ex) {
                  System.out.println(ex.getMessage());            }
    }
    
}
