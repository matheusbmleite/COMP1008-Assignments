/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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
public class MembersTest {
    Member member1, member2;
    Members validMembers;
    ArrayList<Member> membersList;
    Membership membership;
    public MembersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        member1 = new Member("Jaret", "Wright", "1 Georgian Drive",
        "Barrie", "ON", "L4M3X9", LocalDate.of(1980, Month.MAY, 10), "jaretWright@someemail.com",
        "7059508890");
        
        member2 = new Member("Jaret", "Wrong", "12 Barkley Road",
        "Barriere", "BC", "L4M3X9", LocalDate.of(1970, Month.APRIL, 10), "jaretWrong@someemail.com",
        "7058908891");
        
        validMembers = new Members();
        validMembers.addMember(member1);
        
        membersList = new ArrayList<Member>();
        membersList.add(member1);
        
        membership = new Membership("Gym", LocalDate.now(), LocalDate.of(2017, Month.DECEMBER, 2));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addMember method, of class Members.
     */
    @Test
    public void testAddMember() {
        System.out.println("addMember");
        validMembers.addMember(member2);
    }

    /**
     * Test of getMembersList method, of class Members.
     */
    @Test
    public void testGetMembersList() {
        System.out.println("getMembersList");
        ArrayList<Member> expResult = membersList;
        ArrayList<Member> result = validMembers.getMembersList();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Members.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "The member Jaret Wright has the following memberships:\n\n";
        String result = validMembers.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of toString method, of class Members.
     */
    @Test
    public void testToStringWithMembership() {
        System.out.println("toStringWithMembership");
        validMembers.getMembersList().get(0).addMembership(membership);
        String expResult = String.format("The member Jaret Wright has the following memberships:%n"+ 
                                            " Membership type: GYM\n" +
                                            "Membership status ACTIVE\n" +
                                            "Start date %s%n" +
                                            "End date 2017-12-02%n%n", LocalDate.now().toString());
        String result = validMembers.toString();
        assertEquals(expResult, result);
    }
    
}
