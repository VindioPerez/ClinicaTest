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
 * @author vindi
 */
public class RevisionTest {
    Revision rev1 = null;
    Revision rev2 = null;
    
    public RevisionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        rev1 = new Revision();
        rev2 = new Revision();
        rev2.setAnotaciones("hola");
        rev2.setIdCirujano(1);
    }
    
    @After
    public void tearDown() {
        rev1 = null;
        rev2 = null;
    }

    /*
    Pide entrada de datos por pantalla
    @Test
    public void testNuevoRevision() {
        System.out.println("nuevoRevision");
        Revision expResult = null;
        Revision result = Revision.nuevoRevision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of getIdCirujano method, of class Revision.
     */
    @Test
    public void testGetIdCirujano001() {
        System.out.println("getIdCirujano");
        long expResult = 0;
        long result = rev1.getIdCirujano();
        assertEquals(expResult, result);
    }
    

    /**
     * Test of getIdCirujano method, of class Revision.
     */
    @Test
    public void testGetIdCirujano002() {
        System.out.println("getIdCirujano");
        long expResult = 1;
        long result = rev2.getIdCirujano();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdCirujano method, of class Revision.
     */
    @Test
    public void testSetIdCirujano001() {
        System.out.println("setIdCirujano");
        long idCirujano = 10;
        rev1.setIdCirujano(idCirujano);
        assertEquals(idCirujano, rev1.getIdCirujano());
    }

    /**
     * Test of setIdCirujano method, of class Revision.
     */
    @Test
    public void testSetIdCirujano002() {
        System.out.println("setIdCirujano");
        long idCirujano = 0;
        rev1.setIdCirujano(idCirujano);
        assertEquals(idCirujano, rev1.getIdCirujano());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setIdCirujano method, of class Revision.
     */
    @Test
    public void testSetIdCirujano003() {
        System.out.println("setIdCirujano");
        long idCirujano = -10;
        rev1.setIdCirujano(idCirujano);
        assertEquals(idCirujano, rev1.getIdCirujano());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getAnotaciones method, of class Revision.
     */
    @Test
    public void testGetAnotaciones001() {
        System.out.println("getAnotaciones");
        String expResult = "";
        String result = rev1.getAnotaciones();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAnotaciones method, of class Revision.
     */
    @Test
    public void testGetAnotaciones002() {
        System.out.println("getAnotaciones");
        String expResult = "hola";
        String result = rev2.getAnotaciones();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAnotaciones method, of class Revision.
     */
    @Test
    public void testSetAnotaciones001() {
        System.out.println("setAnotaciones");
        String anotaciones = "adios";
        rev1.setAnotaciones(anotaciones);
        assertEquals(anotaciones, rev1.getAnotaciones());
    }

    /*
    Dejo este metodo de prueba comentado porque no se muy bien contra que podria contrastar el paciente que se importa al no tener un .txt valido disponible
    @Test
    public void testFromTextFile() {
        System.out.println("FromTextFile");
        String path = "";
        ArrayList<Revision> expResult = null;
        ArrayList<Revision> result = Revision.FromTextFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
    Dejo este metodo de prueba comentado porque no se muy bien contra que podria contrastar la revision que se importa al no tener un .dat valido disponible
    @Test
    public void testFromBinaryFile() {
        System.out.println("FromBinaryFile");
        String path = "";
        ArrayList<Revision> expResult = null;
        ArrayList<Revision> result = Revision.FromBinaryFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of writeToTextFile method, of class Revision.
     */
    @Test
    public void testWriteToTextFile() {
        System.out.println("writeToTextFile");        
        String path = "revision.txt";
        rev2.writeToTextFile(path);
        Revision rev3 = Revision.FromTextFile(path).get(0);
        assertEquals(rev2, rev3);
    }

    /**
     * Test of writeToBinaryFile method, of class Revision.
     */
    @Test
    public void testWriteToBinaryFile() {
        System.out.println("writeToBinaryFile");      
        String path = "revision.dat";
        rev2.writeToBinaryFile(path);
        Revision rev3 = Revision.FromBinaryFile(path).get(0);
        assertEquals(rev2, rev3);
    }

    /**
     * Test of toString method, of class Revision.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Revision{id=1, anotaciones=hola)";
        String result = rev2.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of data method, of class Revision.
     */
    @Test
    public void testData() {
        System.out.println("data");
        String expResult = "0||||0|0|";
        String result = rev1.data();
        assertEquals(expResult, result);
    }

    /*
    Metodo sin implementar
    @Test
    public void testGetAllRevision() {
        System.out.println("getAllRevision");
        Revision instance = new Revision();
        ArrayList<Revision> expResult = null;
        ArrayList<Revision> result = instance.getAllRevision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
    Metodo sin implementar
    @Test
    public void testGetRevisionById() {
        System.out.println("getRevisionById");
        long id = 0L;
        Revision instance = new Revision();
        Revision expResult = null;
        Revision result = instance.getRevisionById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
    Pide entrada por pantalla
    @Test
    public void testNuevaRevision() throws Exception {
        System.out.println("nuevaRevision");
        Revision expResult = null;
        Revision result = Revision.nuevaRevision();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
    
}
