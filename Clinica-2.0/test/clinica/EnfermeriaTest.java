/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DAW111
 */
public class EnfermeriaTest {
    
    public EnfermeriaTest() {
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
     * Test of getCategoria method, of class Enfermeria.
     */
    @Test
    public void testGetCategoria() {
        System.out.println("getCategoria");
        Enfermeria instance = new Enfermeria();
        char expResult = ' ';
        char result = instance.getCategoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCategoria method, of class Enfermeria.
     */
    @Test
    public void testSetCategoria() {
        System.out.println("setCategoria");
        char categoria = ' ';
        Enfermeria instance = new Enfermeria();
        instance.setCategoria(categoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntervenciones method, of class Enfermeria.
     */
    @Test
    public void testGetIntervenciones() {
        System.out.println("getIntervenciones");
        Enfermeria instance = new Enfermeria();
        ArrayList<Intervencion> expResult = null;
        ArrayList<Intervencion> result = instance.getIntervenciones();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIntervenciones method, of class Enfermeria.
     */
    @Test
    public void testSetIntervenciones() {
        System.out.println("setIntervenciones");
        ArrayList<Intervencion> intervenciones = null;
        Enfermeria instance = new Enfermeria();
        instance.setIntervenciones(intervenciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Data method, of class Enfermeria.
     */
    @Test
    public void testData() {
        System.out.println("Data");
        Enfermeria instance = new Enfermeria();
        String expResult = "";
        String result = instance.Data();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Enfermeria.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Enfermeria instance = new Enfermeria();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnfermeriaById method, of class Enfermeria.
     */
    @Test
    public void testGetEnfermeriaById() {
        System.out.println("getEnfermeriaById");
        long id = 0L;
        Enfermeria instance = new Enfermeria();
        Enfermeria expResult = null;
        Enfermeria result = instance.getEnfermeriaById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEnfermeria method, of class Enfermeria.
     */
    @Test
    public void testGetAllEnfermeria() {
        System.out.println("getAllEnfermeria");
        Enfermeria instance = new Enfermeria();
        ArrayList<Enfermeria> expResult = null;
        ArrayList<Enfermeria> result = instance.getAllEnfermeria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoEnfermeria method, of class Enfermeria.
     */
    @Test
    public void testNuevoEnfermeria() throws Exception {
        System.out.println("nuevoEnfermeria");
        Enfermeria expResult = null;
        Enfermeria result = Enfermeria.nuevoEnfermeria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readEnfermeriaFromTextFile method, of class Enfermeria.
     */
    @Test
    public void testReadEnfermeriaFromTextFile() {
        System.out.println("readEnfermeriaFromTextFile");
        String path = "";
        ArrayList<Enfermeria> expResult = null;
        ArrayList<Enfermeria> result = Enfermeria.readEnfermeriaFromTextFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readEnfermeriaFromBinaryFile method, of class Enfermeria.
     */
    @Test
    public void testReadEnfermeriaFromBinaryFile() {
        System.out.println("readEnfermeriaFromBinaryFile");
        String path = "";
        ArrayList<Enfermeria> expResult = null;
        ArrayList<Enfermeria> result = Enfermeria.readEnfermeriaFromBinaryFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toTextFile method, of class Enfermeria.
     */
    @Test
    public void testToTextFile() {
        System.out.println("toTextFile");
        String path = "";
        Enfermeria instance = new Enfermeria();
        instance.toTextFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toBinaryFile method, of class Enfermeria.
     */
    @Test
    public void testToBinaryFile() {
        System.out.println("toBinaryFile");
        String path = "";
        Enfermeria instance = new Enfermeria();
        instance.toBinaryFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
