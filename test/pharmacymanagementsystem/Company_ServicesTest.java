/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

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
public class Company_ServicesTest {
    
    /**
     *
     */
    public Company_ServicesTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }

    
    /**
     *
     */
    @Test
    public void testGet_score2() throws Exception {
        System.out.println("get_score2");
        //A valid case
        String comp_name = "BMS";
        Company_Services instance = new Company_Services();
        double expResult = 200;
        double result = instance.get_score(comp_name);
        assertEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     *
     */
    @Test(expected = Exception.class)
    public void testGet_score3() throws Exception {
        System.out.println("get_score3");
        // A non-exsistant company in the system`s database
        String comp_name = "NAN";
        Company_Services instance = new Company_Services();
        double result = instance.get_score(comp_name);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     *
     */
    @Test
    public void testGet_score4() throws Exception {
        System.out.println("get_score4");
        //Trying a company with multiple medicines of different classes
        String comp_name = "ibn sina";
        Company_Services instance = new Company_Services();
        double expResult = 1440;
        double result = instance.get_score(comp_name);
        assertEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
    /**
     *
     */
    @Test
    public void testGet_score() throws Exception {
        System.out.println("get_score");
        //Trying a company with multiple medicines of the same class
        String comp_name = "med care";
        Company_Services instance = new Company_Services();
        double expResult = 128000;
        double result = instance.get_score(comp_name);
        assertEquals(expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
