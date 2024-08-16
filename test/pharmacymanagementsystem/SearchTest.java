/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author W.I
 */
public class SearchTest {
    
    public SearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


//    @Test
//    public void testDelete() {
//        System.out.println("Delete");
//        String ID = "";
//        JTable MedicineTable = null;
//        Medicine_repository instance = new Medicine_repository();
//        instance.Delete(ID, MedicineTable);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    @Test
//    public void testAdd() {
//        System.out.println("Add");
//        String ID = "";
//        String Name = "";
//        String Price = "";
//        String Qty = "";
//        Date FD = null;
//        Date ED = null;
//        JTable MedicineTable = null;
//        JComboBox MedComp = null;
//        String QTY_SLR = "";
//        Medicine_repository instance = new Medicine_repository();
//        instance.Add(ID, Name, Price, Qty, FD, ED, MedicineTable, MedComp, QTY_SLR);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//

        @Test
    public void testSearch() {
        System.out.println("existing medicine");
        String st1 = "NOVALGEN";
        Medicine_repository instance = new Medicine_repository();
        int expResult = 1;
        int result = instance.search(st1);
        assertEquals(expResult, result);
       
    }
        @Test
    public void testSearch2() {
        System.out.println("non existing medicine");
        String st1 = "MED X";
        Medicine_repository instance = new Medicine_repository();
        int expResult = 0;
        int result = instance.search(st1);
        assertEquals(expResult, result);
    }
    
}
