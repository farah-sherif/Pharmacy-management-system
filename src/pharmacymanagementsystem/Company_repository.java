/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

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
public class Company_repository {
    
    
    public void SelectMed(Connection Con ,Statement st , ResultSet rs , JTable CompTable)
    { try { 
        Con =DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
        st = Con.createStatement();
        rs = st.executeQuery("Select *from COMPANYTBL");
        CompTable.setModel(DbUtils.resultSetToTableModel(rs));
        st.close();
        rs.close();
        Con.close();
    }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    
    public void Delete ( JTable CompTable , String ID)
    {
        Company C = new Company();
        try{
           C.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
           String Query ="Delete from COMPANYTBL where CompId=" +ID;
           Statement Add = C.getCon().createStatement();
           Add.executeLargeUpdate(Query);
           SelectMed(C.getCon() , C.getSt() ,C.getRs() , CompTable);
           JOptionPane.showMessageDialog(C, "Company deleted Successfully");
           Add.close();
           C.getCon().close();

            } catch (SQLException ex) {
                  System.out.println(ex.getMessage());            }
    }
    
    
    public void Add (int id , String name , String address , int experience , String phone , JTable CompTable)
    {
        Company C = new Company();
        try {
            C.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            PreparedStatement add = C.getCon().prepareStatement("insert into COMPANYTBL values(?,?,?,?,?)");
            add.setInt(1,id);
            add.setString(2, name);
            add.setString(3, address);
            add.setInt(4, experience);
            add.setString(5, phone);
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(C, "Company Added Successfully");
            C.getCon().close();
            SelectMed(C.getCon() , C.getSt() ,C.getRs() , CompTable);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void Update (int id , String name , String address , int experience , String phone , JTable CompTable)
    {
        Company C = new Company();
        try{
            
           C.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
           String UpdateQuery ="Update COMPANYTBL set COMPNAME = '"+name+"'"+",COMPAD = '"
                   +address+"'"+",COMPEXP = "+experience+",COMPPHONE = '"+phone+"'"
                   +"where COMPID="+ id;
           Statement Add = C.getCon().createStatement();
           Add.executeLargeUpdate(UpdateQuery);
           JOptionPane.showMessageDialog(C, "Company updated successfully ");
           C.getCon().close();
        }catch (SQLException ex) {
                  System.out.println(ex.getMessage());           
        }
         SelectMed(C.getCon() , C.getSt() ,C.getRs() , CompTable);  
    }
    
    
        public int get_exp (String comp_name) throws Exception
{
    Company C = new Company();
    int exp = 0 ;
    
    try {
            C.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            C.setSt( C.Con.createStatement());
            
             //To make sure the company exists in the data base
                 C.setRs(C.st.executeQuery("SELECT exists(select COMPNAME from COMPANYTBL where COMPNAME LIKE '" + comp_name + "') as found" ));
                 if (C.rs.next()) 
                 {
                    int x = C.rs.getInt("found");
                    if (x == 0)
                        throw new Exception("There`s no such company");
                 }
                 
                 
            C.setRs(C.st.executeQuery("SELECT * FROM CompanyTBL WHERE COMPNAME LIKE '%" + comp_name + "%'")); 
            if (C.rs.next()) {
                exp = C.rs.getInt("COMPEXP");
            }
        } catch (SQLException e) {
            System.out.println("Error in getting experience");
        }
    
    return exp;
}
    
}



