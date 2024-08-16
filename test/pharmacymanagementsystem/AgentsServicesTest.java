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
 * @author Hp
 */
public class AgentsServicesTest {
    
    public AgentsServicesTest() {
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
     * Test of getTime1 method, of class Agents_Services.
     */
    @Test
    public void testGetTime1() {
        System.out.println("getTime1");
        Agents_Services instance = new Agents_Services();
        int expResult = 2;
        instance.setTime1(expResult);
        int result = instance.getTime1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setTime1 method, of class Agents_Services.
     */
    @Test
    public void testSetTime1() {
        System.out.println("setTime1");
        int Time1 = 4;
        Agents_Services instance = new Agents_Services();
        int expResult = 4;
        int result = instance.setTime1(Time1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getTime2 method, of class Agents_Services.
     */
    @Test
    public void testGetTime2() {
        System.out.println("getTime2");
        Agents_Services instance = new Agents_Services();
        int expResult = 1;
        instance.setTime2(expResult);
        int result = instance.getTime2();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTime2 method, of class Agents_Services.
     */
    @Test
    public void testSetTime2() {
        System.out.println("setTime2");
        int Time2 = 1;
        Agents_Services instance = new Agents_Services();
        int expResult = 1;
        int result = instance.setTime2(Time2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTotal_Time method, of class Agents_Services.
     */
    @Test
    public void testGetTotal_Time() {
        System.out.println("getTotal_Time");
        Agents_Services instance = new Agents_Services();
        int expResult = 7;
        instance.setTotal_Time(expResult);
        int result = instance.getTotal_Time();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTotal_Time method, of class Agents_Services.
     */
    @Test
    public void testSetTotal_Time() {
        System.out.println("setTotal_Time");
        int Total_Time = 7;
        Agents_Services instance = new Agents_Services();
        int expResult = 7;
        int result = instance.setTotal_Time(Total_Time);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Calculate_Time method, of class Agents_Services.
     */
    @Test
    public void testCalculate_Time() {
        System.out.println("Calculate_Time");
        int startTime = 9;
        int endTime = 4;
        Agents_Services instance = new Agents_Services();
        int expResult = 7;
        int result = instance.Calculate_Time(startTime, endTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculate_Time2() {
        System.out.println("Calculate_Time");
        int startTime = 9;
        int endTime = 9;
        Agents_Services instance = new Agents_Services();
        int expResult = 12;
        int result = instance.Calculate_Time(startTime, endTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    @Test
    public void testCalculate_Time3() {
        System.out.println("Calculate_Time");
        int startTime = 2;
        int endTime = 9;
        Agents_Services instance = new Agents_Services();
        int expResult = 7;
        int result = instance.Calculate_Time(startTime, endTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of calculateSalary method, of class Agents_Services.
     */
    @Test
    public void testCalculateSalary() {
        System.out.println("calculateSalary");
        int startTime = 9;
        int endTime = 4;
        Agents_Services instance = new Agents_Services();
        int expResult = 469;
        int result = instance.calculateSalary(startTime, endTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
     @Test
    public void testCalculateSalary2() {
        System.out.println("calculateSalary");
        int startTime = 9;
        int endTime = 9;
        Agents_Services instance = new Agents_Services();
        int expResult = 804;
        int result = instance.calculateSalary(startTime, endTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
     @Test
    public void testCalculateSalary3() {
        System.out.println("calculateSalary");
        int startTime = 2;
        int endTime = 9;
        Agents_Services instance = new Agents_Services();
        int expResult = 469;
        int result = instance.calculateSalary(startTime, endTime);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
