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
public class MemberTest {
    
    Member validMember;
    Member invalidMember;
    
    public MemberTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validMember = new Member("Jaret", "Wright", "1 Georgian Drive",
        "Barrie", "ON", "L4M3X9", LocalDate.of(1980, Month.MAY, 10), "jaretWright@someemail.com",
        "7059508890");
        
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of creating an invalid member, of class Member.
     */
    @Test
    public void testCreateInvalidMember() {
        System.out.println("CreateInvalidMember");
        try
        {
            invalidMember = new Member("Jaret", "Wrong", "120 Toronto Avenue",
        "Barrie", "ON", "L4M3XX", LocalDate.of(1982, Month.SEPTEMBER, 10), "jaretWrong@someemail.com",
        "7059508990");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Constructor threw an exception of invalid postal code \"%s\"", e.getMessage());
        }
    }
    
    
    /**
     * Test of getFirstName method, of class Member.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Jaret";
        String result = validMember.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Member.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Wright";
        String result = validMember.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStreetAddress method, of class Member.
     */
    @Test
    public void testGetStreetAddress() {
        System.out.println("getStreetAddress");
        String expResult = "1 Georgian Drive";
        String result = validMember.getStreetAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class Member.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        String expResult = "Barrie";
        String result = validMember.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProvince method, of class Member.
     */
    @Test
    public void testGetProvince() {
        System.out.println("getProvince");
        String expResult = "ON";
        String result = validMember.getProvince();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPostalCode method, of class Member.
     */
    @Test
    public void testGetPostalCode() {
        System.out.println("getPostalCode");
        String expResult = "L4M3X9";
        String result = validMember.getPostalCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBirthday method, of class Member.
     */
    @Test
    public void testGetBirthday() {
        System.out.println("getBirthday");
        LocalDate expResult = LocalDate.of(1980, Month.MAY, 10);
        LocalDate result = validMember.getBirthday();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFullAddress method, of class Member.
     */
    @Test
    public void testGetFullAddress() {
        System.out.println("getFullAddress");
        String expResult = "1 Georgian Drive, Barrie, ON, L4M3X9";
        String result = validMember.getFullAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        int expResult = 36;
        int result = validMember.getAge();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAgeSameMonth() {
        Member someMember = new Member("Jaret", "Wrong", "120 Toronto Avenue",
        "Barrie", "ON", "L4M3X6", LocalDate.of(1980, Month.APRIL, 10), "jaretWrong@someemail.com",
        "7059508990");
        System.out.println("getAgeSameMonth");
        int expResult = 36;
        int result = someMember.getAge();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getAge method, of class Member.
     */
    @Test
    public void testGetAgeSameDay() {
        Member someMember = new Member("Jaret", "Wrong", "120 Toronto Avenue",
        "Barrie", "ON", "L4M3X6", LocalDate.of(1980, Month.APRIL, 1), "jaretWrong@someemail.com",
        "7059508990");
        System.out.println("getAgeSameMonth");
        int expResult = 37;
        int result = someMember.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYearBorn method, of class Member.
     */
    @Test
    public void testGetYearBorn() {
        System.out.println("getYearBorn");
        int expResult = 1980;
        int result = validMember.getYearBorn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Member.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "Scott";
        validMember.setFirstName(firstName);
    }

    /**
     * Test of setLastName method, of class Member.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "McCrindle";
        validMember.setLastName(lastName);
    }

    /**
     * Test of setStreetAddress method, of class Member.
     */
    @Test
    public void testSetStreetAddress() {
        System.out.println("setStreetAddress");
        String streetAddress = "34 Queen street";
        validMember.setStreetAddress(streetAddress);
    }

    /**
     * Test of setCity method, of class Member.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "Toronto";
        validMember.setCity(city);
    }

    /**
     * Test of setPostalCode method, of class Member.
     */
    @Test
    public void testSetPostalCode() {
        System.out.println("setPostalCode");
        String postalCode = "L5M2H4";
        validMember.setPostalCode(postalCode);
    }

    /**
     * Test of setProvince method, of class Member.
     */
    @Test
    public void testSetProvince() {
        System.out.println("setProvince");
        String province = "AL";
        validMember.setProvince(province);
    }

    /**
     * Test of setBirthday method, of class Member.
     */
    @Test
    public void testSetBirthday() {
        System.out.println("setBirthday");
        LocalDate birthdate = LocalDate.of(1990, Month.MARCH, 23);
        validMember.setBirthday(birthdate);
    }

    /**
     * Test of changeAddress method, of class Member.
     */
    @Test
    public void testChangeAddress() {
        System.out.println("changeAddress");
        String street = "90 King Street";
        String city = "Orilia";
        String province = "BC";
        String postalCode = "L6K4H5";
        validMember.changeAddress(street, city, province, postalCode);
    }
    
    /**
     * Test of changeAddress method with invalid postal code, of class Member.
     */
    @Test
    public void testChangeAddressInvalidPostalCode() {
        System.out.println("changeAddressInvalidPostalCode");
        String street = "90 King Street";
        String city = "Orilia";
        String province = "BC";
        String postalCode = "L69H5";
        try
        {
            validMember.changeAddress(street, city, province, postalCode);
            fail("An exception should've been thrown due to the invalid postal code");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("An exception was thrown for the invalid postalCode, the exception = \"%s\"%n",e.getMessage());
        }
    }

    /**
     * Test of toString method, of class Member.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Jaret Wright";
        String result = validMember.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhoneNumber method, of class Member.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phoneNumber = "9809990098";
        validMember.setPhoneNumber(phoneNumber);
    }
    
    /**
     * Test of setPhoneNumber method, of class Member.
     */
    @Test
    public void testSetInvalidLengthPhoneNumber() {
        System.out.println("setPhoneNumberInvalidLength");
        String phoneNumber = "980990098";
        try {
            validMember.setPhoneNumber(phoneNumber);
        } catch (IllegalArgumentException e) {
            System.out.printf("An exception was thrown for the invalid phone "
                    + "number, the exception = \"%s\"%n",e.getMessage());
        }
    }
    
    /**
     * Test of setPhoneNumber method, of class Member.
     */
    @Test
    public void testSetInvalidPatternPhoneNumber() {
        System.out.println("setPhoneNumberInvalidPattern");
        String phoneNumber = "980990A980";
        try {
            validMember.setPhoneNumber(phoneNumber);
        } catch (IllegalArgumentException e) {
            System.out.printf("An exception was thrown for the invalid phone "
                    + "number, the exception = \"%s\"%n",e.getMessage());
        }
    }
    
}
