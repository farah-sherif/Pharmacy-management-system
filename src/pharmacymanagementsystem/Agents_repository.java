/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import pharmacymanagementsystem.Agents;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Dell
 */
public class Agents_repository {
    
    
    //(why?) rs & st .close couldn`t be moved bellow the function`s call in Agents class
    
    public void SelectMed(Connection Con ,Statement st , ResultSet rs , JTable AgentTable)
    { try { 
        Con =DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
        st = Con.createStatement();
        rs = st.executeQuery("Select *from AGENTTBL");
        AgentTable.setModel(DbUtils.resultSetToTableModel(rs));
        st.close();
        rs.close();
    }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
   // on writting line 52 in the beginning of the class "stackoverflow" exception will come out.
  //As the constructor of Agents creates an object of Agents_repository, That`s how a loop rises
    
    public void Delete ( JTable AgentTable , String ID)
    {
        Agents A = new Agents();
        try{
           A.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
           String Query ="Delete from AGENTTBL where AID=" +ID;
           Statement Add = A.getCon().createStatement();
           Add.executeLargeUpdate(Query);
           SelectMed(A.getCon() , A.getSt() ,A.getRs() , AgentTable);
           JOptionPane.showMessageDialog(A, "Agent deleted Successfully");
           Add.close();
           A.getCon().close();

            } catch (SQLException ex) {
                  System.out.println(ex.getMessage());            }
    }
    
    
    public void Add (int id , String name , int age , String phone , String password , String gender , JTable AgentTable)
    {
        Agents A = new Agents();
        try {
            A.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            PreparedStatement add = A.getCon().prepareStatement("insert into AGENTTBL values(?,?,?,?,?,?)");
            add.setInt(1, id);
            add.setString(2, name);
            add.setInt(3, age);
            add.setString(4, phone);
            add.setString(5, password);
            add.setString(6, gender);
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(A, "Agent Added Successfully");
            A.getCon().close();
            SelectMed(A.getCon() , A.getSt() , A.getRs() , AgentTable);

        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
    }
    
    public void update (int id , String name , int age , String phone , String password , String gender , JTable AgentTable)
    {
        Agents A = new Agents();
        try{
           
           A.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
           //String text = AgId.getText();
           String UpdateQuery ="Update AGENTTBL set ANAME = '"+name+"'"+",AAGE = "+age+",APHONE = '"+phone+"'"+",APASS = '"+password+"'"+",AGENDER = '"+gender+"'"+"where AId="+ id;
           Statement Add = A.getCon().createStatement();
           Add.executeLargeUpdate(UpdateQuery);
           JOptionPane.showMessageDialog(A, "Agent updated successfully "); 
           A.getCon().close();
           Add.close();
        }catch (SQLException ex) {
                  System.out.println(ex.getMessage());           
        }
         
         SelectMed(A.getCon() , A.getSt() , A.getRs() , AgentTable); 
    }
}
