/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class Company_repositoryTest {
    
    public Company_repositoryTest() {
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
     * Test of get_exp method, of class Company_repository.
     */
    @Test
    public void testGet_exp() throws Exception {
        System.out.println("get_exp");
        String comp_name = "BMS";
        Company_repository instance = new Company_repository();
        int expResult = 10;
        int result = instance.get_exp(comp_name);
        assertEquals(expResult, result);
    }
    
    
    @Test(expected = Exception.class)
    public void testGet_exp2() throws Exception {
        System.out.println("get_exp2");
        String comp_name = "None";
        Company_repository instance = new Company_repository();
        int result = instance.get_exp(comp_name);
    }
    
}
