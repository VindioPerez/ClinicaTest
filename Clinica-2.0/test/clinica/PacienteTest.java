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
 * @author DAW107
 */
public class PacienteTest {
    
    public PacienteTest() {
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
     * Test of getIdHistorial method, of class Paciente.
     */
    @Test
    public void testGetIdHistorial() {
        System.out.println("getIdHistorial");
        Paciente instance = new Paciente();
        long expResult = 0L;
        long result = instance.getIdHistorial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdHistorial method, of class Paciente.
     */
    @Test
    public void testSetIdHistorial() {
        System.out.println("setIdHistorial");
        long idHistorial = 0L;
        Paciente instance = new Paciente();
        instance.setIdHistorial(idHistorial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Paciente.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Paciente instance = new Paciente();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Paciente.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long idPaciente = 0L;
        Paciente instance = new Paciente();
        instance.setId(idPaciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Paciente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Paciente instance = new Paciente();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidos method, of class Paciente.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellidos method, of class Paciente.
     */
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String apellidos = "";
        Paciente instance = new Paciente();
        instance.setApellidos(apellidos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNIF method, of class Paciente.
     */
    @Test
    public void testGetNIF() {
        System.out.println("getNIF");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getNIF();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNIF method, of class Paciente.
     */
    @Test
    public void testSetNIF() {
        System.out.println("setNIF");
        String NIF = "";
        Paciente instance = new Paciente();
        instance.setNIF(NIF);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefono method, of class Paciente.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "";
        Paciente instance = new Paciente();
        instance.setTelefono(telefono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class Paciente.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class Paciente.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        Paciente instance = new Paciente();
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readPacientefromTextFile method, of class Paciente.
     */
    @Test
    public void testReadPacientefromTextFile() {
        System.out.println("readPacientefromTextFile");
        String path = "";
        ArrayList<Paciente> expResult = null;
        ArrayList<Paciente> result = Paciente.readPacientefromTextFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readClientefromBinaryFile method, of class Paciente.
     */
    @Test
    public void testReadClientefromBinaryFile() {
        System.out.println("readClientefromBinaryFile");
        String path = "";
        ArrayList<Paciente> expResult = null;
        ArrayList<Paciente> result = Paciente.readClientefromBinaryFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toTextFile method, of class Paciente.
     */
    @Test
    public void testToTextFile() {
        System.out.println("toTextFile");
        String path = "";
        Paciente instance = new Paciente();
        instance.toTextFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeClienteToBinaryFile method, of class Paciente.
     */
    @Test
    public void testWriteClienteToBinaryFile() throws Exception {
        System.out.println("writeClienteToBinaryFile");
        String path = "";
        Paciente instance = new Paciente();
        instance.writeClienteToBinaryFile(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Paciente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of data method, of class Paciente.
     */
    @Test
    public void testData() {
        System.out.println("data");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.data();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPaciente method, of class Paciente.
     */
    @Test
    public void testGetAllPaciente() {
        System.out.println("getAllPaciente");
        Paciente instance = new Paciente();
        ArrayList<Paciente> expResult = null;
        ArrayList<Paciente> result = instance.getAllPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPacienteById method, of class Paciente.
     */
    @Test
    public void testGetPacienteById() {
        System.out.println("getPacienteById");
        long id = 0L;
        Paciente instance = new Paciente();
        Paciente expResult = null;
        Paciente result = instance.getPacienteById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoPaciente method, of class Paciente.
     */
    @Test
    public void testNuevoPaciente() {
        System.out.println("nuevoPaciente");
        Paciente expResult = null;
        Paciente result = Paciente.nuevoPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of realizarPago method, of class Paciente.
     */
    @Test
    public void testRealizarPago() {
        System.out.println("realizarPago");
        Tratamiento t = null;
        Paciente instance = new Paciente();
        boolean expResult = false;
        boolean result = instance.realizarPago(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}