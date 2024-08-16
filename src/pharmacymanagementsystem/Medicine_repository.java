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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Dell
 */
public class Medicine_repository {
    
    public void SelectMed(Connection Con ,Statement st , ResultSet rs , JTable MedicineTable)
    { try { 
        Con =DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
        st = Con.createStatement();
        rs = st.executeQuery("Select *from MedicineTBL");
        MedicineTable.setModel(DbUtils.resultSetToTableModel(rs));
        Con.close();
    }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
 
    public double get_Sqty_C(String comp_name , int clas) throws Exception 
    {
        Medicine M= new Medicine();
            int  qty = 0 , qty_slr = 0 , med_count ;
            double sqty = 0;
            
            //The medicines class range = [1,3]
            if(clas<1 || clas>3 )
                throw new ArithmeticException("No medicines exist with this class value");
            
        try {
                 M.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
                 M.setSt( M.Con.createStatement());
                 
                 //To make sure the company exists in the data base
                 M.setRs(M.st.executeQuery("SELECT exists(select COMPNAME from COMPANYTBL where COMPNAME LIKE '" + comp_name + "') as found" ));
                 if (M.rs.next()) 
                 {
                    int x = M.rs.getInt("found");
                    if (x == 0)
                        throw new Exception("No medicines exist under this company name");
                 }
                  
                 
                 //Start fetching quantity info.
                 M.setRs(M.st.executeQuery("SELECT * FROM MedicineTBL WHERE MEDCOMP LIKE '" + comp_name + "' AND MEDID LIKE '" + clas + "%'"));
           
            while (M.rs.next()) 
           {
               qty  = M.rs.getInt("medqty");
               
               qty_slr  = M.rs.getInt("qty_slr");
               
               sqty+= qty_slr - qty;   
            }
            
        } catch (SQLException ex) {
             System.out.println("Error in getting quantity");
             return 0;
        }
        
        //To get the number of medicines
        try { 
            M.setRs(M.st.executeQuery("SELECT count() as count FROM MedicineTBL WHERE MEDCOMP LIKE '" + comp_name + "' AND MEDID LIKE '" + clas + "%'"));
            if (M.rs.next())
           {       
                med_count = M.rs.getInt("count");
                sqty = Math.pow( (sqty/clas) ,(double) med_count);
           } 
            
        } catch (SQLException ex) {
            System.out.println("Error in getting count");
        } 
        
        if(qty == 0 )
        return 0;   
        
        return sqty;
    }
            
            
            
    /*    public double get_SqtyC(String comp_name , int clas)
    {
    Medicine M= new Medicine();
    int  qty = 0 , qty_slr = 0 , med_count ;
    double sqty = 0;
    comp_name =  comp_name.toUpperCase();
    try {
    M.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
    M.setSt( M.Con.createStatement());
    M.setRs(M.st.executeQuery("SELECT * FROM MedicineTBL WHERE MEDCOMP LIKE '" + comp_name + "' AND MEDID LIKE '" + clas + "%'"));
    
    
    while (M.rs.next()) {
    qty  = M.rs.getInt("medqty");
    
    qty_slr  = M.rs.getInt("qty_slr");
    
    sqty+= qty_slr - qty;
    
    }
    
    M.setRs(M.st.executeQuery("SELECT count() as count FROM MedicineTBL WHERE MEDCOMP LIKE '" + comp_name + "' AND MEDID LIKE '" + clas + "%'"));
    if (M.rs.next())
    {
    med_count = M.rs.getInt("count");
    sqty = Math.pow( (sqty/clas) ,(double) med_count);
    }
    else
    return 0.0 ;
    
    } catch (SQLException e) {
    System.out.println("Error in getting quantity");
    }
    
    return sqty;
    }*/
    
    
    public void GetCompany(JComboBox MedComp)
    {  /*
        Medicine M2 = new Medicine();
        try{
            M2.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            M2.setSt(M2.getCon().createStatement());
            String query = "Select *from COMPANYTBL";
            M2.setRs(M2.getSt().executeQuery(query));
            while(M2.getRs().next())
            {
                String Mycomp = M2.getRs().getString("COMPNAME");
                MedComp.addItem(Mycomp);
            }
        }catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        */
         try{
             Connection Con = DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
             Statement st = Con.createStatement();
            String query = "Select *from COMPANYTBL";
             ResultSet rs = st.executeQuery(query);
            while(rs.next())
            {
                String Mycomp = rs.getString("COMPNAME");
                MedComp.addItem(Mycomp);
            }
            Con.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void Delete (String ID , JTable MedicineTable)
    {
        Medicine M = new Medicine();
        
        try{
           M.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
           String Query ="Delete from MEDICINETBL where MEDID=" +ID;
           Statement Add = M.getCon().createStatement();
           Add.executeLargeUpdate(Query);
           SelectMed(M.getCon(), M.getSt(), M.getRs(), MedicineTable);
           JOptionPane.showMessageDialog(M, "Medicine deleted Successfully");
           M.getCon().close();

            } catch (SQLException ex) {
                  System.out.println(ex.getMessage());            }
    }
    
    
    
    public void Add (String ID , String Name , String Price , String Qty ,java.util.Date FD,java.util.Date ED, JTable MedicineTable , JComboBox MedComp , String QTY_SLR)
    {
        Medicine M = new Medicine();
        
        /*M.setFDate(FDate);
        FDate = MedFab.getDate();
        MyFabdate = new java.sql.Date(FDate.getTime());
        EDate = MedExp.getDate();
        MyExpdate = new java.sql.Date(EDate.getTime());*/
        try {
            M.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            PreparedStatement add = M.getCon().prepareStatement("insert into MEDICINETBL values(?,?,?,?,?,?,?,?)");
            add.setInt(1, Integer.valueOf(ID));
            add.setString(2,Name);
            add.setInt(3, Integer.valueOf(Price));
            add.setInt(4, Integer.valueOf(Qty));
            add.setInt(8, Integer.valueOf(QTY_SLR));
            
            add.setString(5, FD.toString());           
            add.setString(6, ED.toString());
            
            add.setString(7, MedComp.getSelectedItem().toString());
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(M, "Medicine Added Successfully");
            M.getCon().close();
            SelectMed(M.getCon(), M.getSt(), M.getRs(), MedicineTable);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void Update(String ID , String Name , String Price , String Qty ,java.util.Date FD,java.util.Date ED, JTable MedicineTable , JComboBox MedComp, String QTY_SLR)
    {
        Medicine M = new Medicine();
        
        try{
            M.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            String UpdateQuery ="Update MEDICINETBL set MEDNAME = '"+Name+"'"+",MEDPRICE = "+Price+""+",MEDQTY = "+Qty+""+",MEDFAB = '"+FD.toString()+"'"+",MEDEXP = '"+ED.toString()+"'"+",MEDCOMP = '"+MedComp.getSelectedItem().toString()+"' ,QTY_SLR = " + QTY_SLR +" where MEDId="+ ID;
           Statement Add = M.getCon().createStatement();
           Add.executeLargeUpdate(UpdateQuery);
           JOptionPane.showMessageDialog(M, "medicine updated successfully ");
           M.getCon().close();
    
        }   catch (SQLException ex) {
                  System.out.println(ex.getMessage());           
        }
            SelectMed(M.getCon(), M.getSt(), M.getRs(), MedicineTable); 
    }
    public int search(String st1){
        
        Medicine M = new Medicine();
        int flag = 0;
        if (st1.isEmpty()){ return -1;}
        try {  
                M.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
                Statement s = M.getCon().createStatement();
                ResultSet rs = s.executeQuery("select MEDNAME from MEDICINETBL");
                while(rs.next())
                { 
                    if (rs.getString("MEDNAME").equalsIgnoreCase(st1))
                    {   flag = 1;
                        break;
                    }
                }
                M.getCon().close();
        }catch (SQLException ex) {
               System.out.println(ex.getMessage());
            }
        return flag;
}
    public String search_expdate(String med_name){
        
        Medicine M = new Medicine();
        String ss = null ;
        try {  
           
            M.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
                String sql = "Select MEDEXP from MEDICINETBL where MEDICINETBL.MEDNAME ='"+med_name+"'";
              Statement s = M.getCon().createStatement();
                ResultSet rs = s.executeQuery(sql);
                
                while(rs.next()){
                ss = rs.getString("MEDEXP");
                }
                
                rs.close();
                M.getCon().close();
            
        }catch (SQLException ex) {
               System.out.println(ex.getMessage());
            }
        return ss;
}
}


