/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.patrick.demo.java8kattas.utils;

import com.technologyconversations.java8exercises.streams.Person;
import java.io.File;
import java.util.List;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author patrickn
 */
public class PersonUtilsTest {
    
    public PersonUtilsTest() {
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
     * Test of getCountries method, of class PersonUtils.
     */
    @Test
    public void testGetCountries() {
        System.out.println("getCountries");
        PersonUtils.getCountries();
        File dir = new File("src/main/resources/json");
        assertTrue(dir.exists());
        assertTrue(dir.isDirectory());
        assertTrue(dir.list().length !=0);
    }

    /**
     * Test of getRandomPerson method, of class PersonUtils.
     */
    @Test
    public void testGetRandomPerson() {
        System.out.println("getRandomPerson");
        Person expResult = null;
        Person result = PersonUtils.getRandomPerson();
        assertNotNull(result);
        assertNotNull(result.getName());
        assertNotNull(result.getAge());
        assertNotNull(result.getNationality());
    }

    /**
     * Test of getCountries method, of class PersonUtils.
     */
   

    /**
     * Test of getPersonList method, of class PersonUtils.
     */
    @Test
    public void testGetPersonList() {
        System.out.println("getPersonList");
        List<Person> result = PersonUtils.getPersonList(10);
        int rd = new Random().nextInt(10);
        assertTrue(result.get(rd) !=null);
    }
    
}
