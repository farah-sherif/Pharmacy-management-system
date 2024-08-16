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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Hp
 */
public class Admin_repository {

    public void SelectMed(Connection Con, Statement st, ResultSet rs, JTable AgentTable) {
        try {
            Con = DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db");
            st = Con.createStatement();
            rs = st.executeQuery("Select *from Admin");
            AgentTable.setModel(DbUtils.resultSetToTableModel(rs));
            st.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void Add(String name, int id, String password, String phone, JTable Regist) {
        Admin r = new Admin();
        try {
            r.setCon(DriverManager.getConnection("jdbc:sqlite:Pharmacydb.db"));
            PreparedStatement add = r.getCon().prepareStatement("insert into Admin values(?,?,?,?)");
            add.setString(1, name);
            add.setInt(2, id);
            add.setString(3, password);
            add.setString(4, phone);
            int row = add.executeUpdate();
            JOptionPane.showMessageDialog(r, "Manager Added Successfully");
            r.getCon().close();
            SelectMed(r.getCon(), r.getSt(), r.getRs(), Regist);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
