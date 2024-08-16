
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author W.I
 */
public class Medicine_servicesTest {
    
    public Medicine_servicesTest() {
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
     * Test of search_medicine method, of class Medicine_services.
     */
    
    @Test
    public void testSearch_medicine() {
        System.out.println("medicine found");
        Medicine_services instance = new Medicine_services();
        int expResult = 1;
        int result = instance.search_medicine("panadol");
        assertEquals(expResult, result);
        
    }
    @Test
    public void testSearch_medicine2() {
        System.out.println("medicine not found");
        Medicine_services instance = new Medicine_services();
        int expResult = 0;
        int result = instance.search_medicine("Medicine x");
        assertEquals(expResult, result);
        
    }
     @Test
    public void testSearch_medicine3() {
        System.out.println("empty input");
        Medicine_services instance = new Medicine_services();
        int expResult = -1;
        int result = instance.search_medicine("");
        assertEquals(expResult, result);
        
    }
///////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void testCheck_expiry1() {
        System.out.println("check_expiry");
        String exp_date = "2025-11-27";
        String current_date = "2023-06-21";
        Medicine_services instance = new Medicine_services();
        String expResult = "Medicine hasn't expired yet !";
        String result = instance.check_expiry(exp_date, current_date);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheck_expiry2() {
        System.out.println("check_expiry");
        String exp_date = "2022-07-05";
        String current_date = "2023-06-21";
        Medicine_services instance = new Medicine_services();
        String expResult = "Medicine has expired !";
        String result = instance.check_expiry(exp_date, current_date);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheck_expiry3() {
        System.out.println("check_expiry");
        String exp_date = "2023-06-21";
        String current_date = "2023-06-21";
        Medicine_services instance = new Medicine_services();
        String expResult = "Medicine expires today !";
        String result = instance.check_expiry(exp_date, current_date);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheck_expiry4() {
        System.out.println("check_expiry");
        String exp_date = "abcd";
        String current_date = "2023-05-14";
        Medicine_services instance = new Medicine_services();
        String expResult = null;
        String result = instance.check_expiry(exp_date, current_date);
        assertEquals(expResult, result);
    }

    
    
    
}
