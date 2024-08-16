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
 * @author Dell
 */
public class Medicine_repositoryTest {
    
    public Medicine_repositoryTest() {
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

 

    /**
     * Test of get_Sqty_C method, of class Medicine_repository.
     */
    @Test(expected = ArithmeticException.class)
    public void testGet_Sqty_C() throws Exception {
        System.out.println("get_Sqty_C");
        String comp_name = "abc";
        //clas<1
        int clas = 0;
        Medicine_repository instance = new Medicine_repository();
        double result = instance.get_Sqty_C(comp_name, clas);
    }

    @Test(expected = Exception.class)
    public void testGet_Sqty_C2() throws Exception {
        System.out.println("get_Sqty_C2");
        //Compay not found
        String comp_name = "ABD";
        int clas = 1;
        Medicine_repository instance = new Medicine_repository();
        double result = instance.get_Sqty_C(comp_name, clas);
    }
    
    @Test(expected = ArithmeticException.class)
    public void testGet_Sqty_C3() throws Exception {
        System.out.println("get_Sqty_C3");
        String comp_name = "";
        //clas > 3
        int clas = 5;
        Medicine_repository instance = new Medicine_repository();
        double result = instance.get_Sqty_C(comp_name, clas);
    }
    
    @Test
    public void testGet_Sqty_C4() throws Exception {
        System.out.println("get_Sqty_C4");
        //Valid input
        String comp_name = "BMS";
        int clas = 3;
        Medicine_repository instance = new Medicine_repository();
        double expResult = 20;
        double result = instance.get_Sqty_C(comp_name, clas);
        assertEquals(expResult, result, 0.0);
    }
    
    @Test
    public void testGet_Sqty_C5() throws Exception {
        System.out.println("get_Sqty_C5");
        //Valid input with multiple medicines of the same class
        String comp_name = "med care";
        int clas = 1;
        Medicine_repository instance = new Medicine_repository();
        double expResult = 6400;
        double result = instance.get_Sqty_C(comp_name, clas);
        assertEquals(expResult, result, 0.0);
    }
    
}
