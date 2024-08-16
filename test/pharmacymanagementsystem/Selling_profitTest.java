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
 * @author hanaa
 */
public class Selling_profitTest {
    
    public Selling_profitTest() {
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

    @Test
    public void testSelling_Profit_calc1() {
        System.out.println("Selling_Profit_calc");
        float total_paid = 1;
        Selling_profit instance = new Selling_profit();
        double expResult = 0.05;
        double result = instance.Selling_Profit_calc(total_paid);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    public void testSelling_Profit_calc2() {
        System.out.println("Selling_Profit_calc");
        float total_paid = -1;
        Selling_profit instance = new Selling_profit();
        double expResult = -1;
        double result = instance.Selling_Profit_calc(total_paid);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
  
    
}
