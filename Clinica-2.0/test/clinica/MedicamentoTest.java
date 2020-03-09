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
public class MedicamentoTest {
    
    public MedicamentoTest() {
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
     * Test of getId method, of class Medicamento.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Medicamento instance = new Medicamento();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Medicamento.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Medicamento instance = new Medicamento();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Medicamento.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Medicamento instance = new Medicamento();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Medicamento.
     */
    @Test
    public void testSetNombre() throws Exception {
        System.out.println("setNombre");
        String nombre = "";
        Medicamento instance = new Medicamento();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrincipioActivo method, of class Medicamento.
     */
    @Test
    public void testGetPrincipioActivo() {
        System.out.println("getPrincipioActivo");
        Medicamento instance = new Medicamento();
        String expResult = "";
        String result = instance.getPrincipioActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrincipioActivo method, of class Medicamento.
     */
    @Test
    public void testSetPrincipioActivo() throws Exception {
        System.out.println("setPrincipioActivo");
        String principioActivo = "";
        Medicamento instance = new Medicamento();
        instance.setPrincipioActivo(principioActivo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDosisMaxDiaria method, of class Medicamento.
     */
    @Test
    public void testGetDosisMaxDiaria() {
        System.out.println("getDosisMaxDiaria");
        Medicamento instance = new Medicamento();
        float expResult = 0.0F;
        float result = instance.getDosisMaxDiaria();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDosisMaxDiaria method, of class Medicamento.
     */
    @Test
    public void testSetDosisMaxDiaria() throws Exception {
        System.out.println("setDosisMaxDiaria");
        int dosisMaxDiaria = 0;
        Medicamento instance = new Medicamento();
        instance.setDosisMaxDiaria(dosisMaxDiaria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAlergia method, of class Medicamento.
     */
    @Test
    public void testGetAlergia() {
        System.out.println("getAlergia");
        Medicamento instance = new Medicamento();
        Alergia expResult = null;
        Alergia result = instance.getAlergia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAlergia method, of class Medicamento.
     */
    @Test
    public void testSetAlergia() {
        System.out.println("setAlergia");
        Alergia alergia = null;
        Medicamento instance = new Medicamento();
        instance.setAlergia(alergia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Medicamento.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Medicamento instance = new Medicamento();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Data method, of class Medicamento.
     */
    @Test
    public void testData() {
        System.out.println("Data");
        Medicamento instance = new Medicamento();
        String expResult = "";
        String result = instance.Data();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllMedicamento method, of class Medicamento.
     */
    @Test
    public void testGetAllMedicamento() {
        System.out.println("getAllMedicamento");
        Medicamento instance = new Medicamento();
        ArrayList<Medicamento> expResult = null;
        ArrayList<Medicamento> result = instance.getAllMedicamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMedicamentoById method, of class Medicamento.
     */
    @Test
    public void testGetMedicamentoById() {
        System.out.println("getMedicamentoById");
        long id = 0L;
        Medicamento instance = new Medicamento();
        Medicamento expResult = null;
        Medicamento result = instance.getMedicamentoById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoMedicamento method, of class Medicamento.
     */
    @Test
    public void testNuevoMedicamento() throws Exception {
        System.out.println("nuevoMedicamento");
        Medicamento expResult = null;
        Medicamento result = Medicamento.nuevoMedicamento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromTextFile method, of class Medicamento.
     */
    @Test
    public void testFromTextFile() {
        System.out.println("fromTextFile");
        String path = "";
        ArrayList<Medicamento> expResult = null;
        ArrayList<Medicamento> result = Medicamento.fromTextFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fromBinaryFile method, of class Medicamento.
     */
    @Test
    public void testFromBinaryFile() {
        System.out.println("fromBinaryFile");
        String path = "";
        ArrayList<Medicamento> expResult = null;
        ArrayList<Medicamento> result = Medicamento.fromBinaryFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toTextFile method, of class Medicamento.
     */
    @Test
    public void testToTextFile() {
        System.out.println("toTextFile");
        String path = "";
        Medicamento instance = new Medicamento();
        instance.toTextFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toBinaryFile method, of class Medicamento.
     */
    @Test
    public void testToBinaryFile() {
        System.out.println("toBinaryFile");
        String path = "";
        Medicamento instance = new Medicamento();
        instance.toBinaryFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
