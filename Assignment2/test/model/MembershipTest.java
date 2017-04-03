/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matheus leite
 */
public class MembershipTest {
    
    Membership validMembership;
    Membership invalidMembership;
    
    public MembershipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validMembership = new Membership("Gym", LocalDate.now(), LocalDate.of(2017, Month.DECEMBER, 2));
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of constructor of the class Membership.
     */
    @Test
    public void testCreateInvalidEndDateMembership() {
        System.out.println("CreateInvalidEndDateMembership");
        try {
            invalidMembership = new Membership("Gym", LocalDate.of(2017, Month.APRIL, 1), LocalDate.of(2017, Month.MARCH, 30));
        } catch (IllegalArgumentException e) {
            System.out.printf("Constructor threw an exception of invalid end date \"%s\"", e.getMessage());
        }        
    }
    
    /**
     * Test of constructor of the class Membership.
     */
    @Test
    public void testCreateStartDateAfterEndDateMembership() {
        System.out.println("CreateStartDateAfterEndDateMembership");
        try {
            invalidMembership = new Membership("Gym", LocalDate.of(2017, Month.APRIL, 2), LocalDate.of(2017, Month.MARCH, 30));
        } catch (IllegalArgumentException e) {
            System.out.printf("Constructor threw an exception of invalid end date \"%s\"", e.getMessage());
        }        
    }
    
    /**
     * Test of constructor of the class Membership.
     */
    @Test
    public void testCreateInvalidTypeMembership() {
        System.out.println("CreateInvalidEndDateMembership");
        try {
            invalidMembership = new Membership("Gymm", LocalDate.of(2017, Month.APRIL, 1), LocalDate.of(2017, Month.MARCH, 30));
        } catch (IllegalArgumentException e) {
            System.out.printf("Constructor threw an exception of invalid type \"%s\"", e.getMessage());
        }        
    }

    /**
     * Test of getType method, of class Membership.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        String expResult = "GYM";
        String result = validMembership.getType();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateStatus method, of class Membership.
     */
    @Test
    public void testUpdateStatus() {
        System.out.println("updateStatus");
        validMembership.updateStatus();
    }
    
    /**
     * Test of updateStatus method, of class Membership.
     */
    @Test
    public void testUpdateStatusExpired() {
        System.out.println("updateStatusExpired");
        invalidMembership = new Membership("Gym", LocalDate.of(2017, Month.MARCH, 30), LocalDate.of(2017, Month.APRIL, 1));
        validMembership.updateStatus();
    }

    /**
     * Test of setPrice method, of class Membership.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        validMembership.setPrice();
    }

    /**
     * Test of getStartDate method, of class Membership.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        LocalDate expResult = LocalDate.now();
        LocalDate result = validMembership.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndDate method, of class Membership.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        LocalDate expResult = LocalDate.of(2017, Month.DECEMBER, 2);
        LocalDate result = validMembership.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Membership.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        double expResult = 607.5;
        double result = validMembership.getPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getStatus method, of class Membership.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        String expResult = "ACTIVE";
        String result = validMembership.getStatus();
        assertEquals(expResult, result);
    }
    
}
