/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import javax.swing.JTextField;
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
 * @author hanaa
 */
public class Selling_Price_ServiceTest {
    
    public Selling_Price_ServiceTest() {
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
     * Test of Selling_Price_calc method, of class Selling_Price_Service2.
     */
    
    
    @Test
    public void testSelling_Price_calc1() {
        System.out.println("Selling_Price_calc(Check Quantity less than 0)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "PANADOL";
        int medQty = -10 ;
        float expResult = 0.0F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testSelling_Price_calc2() {
        System.out.println("Selling_Price_calc(Check at Quantity = 0)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "PANADOL";
        int medQty = 0 ;
        float expResult = 0.0F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testSelling_Price_calc3() {
        System.out.println("Selling_Price_calc(Check Quantity greater than 0)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "PANADOL";
        int medQty = 1 ;
        float expResult = 49.5F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testSelling_Price_calc4() {
        System.out.println("Selling_Price_calc (Check Quantity between 0 and Max)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "PANADOL";
        int medQty = 20 ;
        float expResult = 990.0F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testSelling_Price_calc5() {
        System.out.println("Selling_Price_calc (Check Quantity less than Max Quantity)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "PANADOL";
        int medQty = 39 ;
        float expResult = 1930.5F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testSelling_Price_calc6() {
        System.out.println("Selling_Price_calc(Check at max Quantity)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "PANADOL";
        int medQty = 40 ;
        float expResult = 1980.0F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testSelling_Price_calc7() {
        System.out.println("Selling_Price_calc (Check Quantity greater than Max Quantity)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "PANADOL";
        int medQty = 41 ;
        float expResult = 1980.0F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testSelling_Price_calc8() {
        System.out.println("Selling_Price_calc(Cleck Medicine Name exist in Medicine Set)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        when(Mok.getMed_Price("CONGSTAL")).thenReturn(50);
        when(Mok.getMed_Qty("CONGSTAL")).thenReturn(50);        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "CONGSTAL";
        int medQty = 10 ;
        float expResult = 550.0F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testSelling_Price_calc9() {
        System.out.println("Selling_Price_calc(Cleck Medicine Name not exist)");
        Selling_repository Mok = mock(Selling_repository.class);
        when(Mok.getMed_Price("PANADOL")).thenReturn(45);
        when(Mok.getMed_Qty("PANADOL")).thenReturn(40);
        
        Selling_Price_Service obj ;
                obj = new Selling_Price_Service();
        String medName = "PANADO";
        int medQty = 45 ;
        float expResult = 0.0F;
        float result = obj.Selling_Price_calc(medName, medQty);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
