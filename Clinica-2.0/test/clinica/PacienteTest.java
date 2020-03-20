/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import excepciones.PacienteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Paciente pac1 = null;
    Paciente pac2 = null;
    
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
        pac1 = new Paciente();
        Historial h = null;
        pac2 = new Paciente(h, 1, 1, "Pedro", "Perez Perez", "12345678A", "666666666", "cerca");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Prueba del metodo getIdHistorial de Paciente, con valores por defecto
     */
    @Test
    public void testGetIdHistorial001() {
        System.out.println("getIdHistorial");
        long expResult = 0;
        long result = pac1.getIdHistorial();
        assertEquals(expResult, result);
    }
    
    /**
     * Prueba del metodo getIdHistorial de Paciente, con valor inicializado a 1
     */
    @Test
    public void testGetIdHistorial002() {
        System.out.println("getIdHistorial");
        long expResult = 1;
        long result = pac2.getIdHistorial();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente valido (entero largo positivo)
     */
    @Test
    public void testSetIdHistorial001() {
        System.out.println("setIdHistorial");
        long idHistorial = 10;
        pac1.setIdHistorial(idHistorial);
        assertEquals(idHistorial, pac1.getIdHistorial());
    }
    
    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente invalido (0)
     */
    @Test
    public void testSetIdHistorial002() {
        System.out.println("setIdHistorial");
        long idHistorial = 0;
        pac1.setIdHistorial(idHistorial);
        assertEquals(idHistorial, pac1.getIdHistorial());
        fail("Se esperaba una excepcion");
    }
    
    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente invalido (entero largo negativo)
     */
    @Test
    public void testSetIdHistorial003() {
        System.out.println("setIdHistorial");
        long idHistorial = -10;
        pac1.setIdHistorial(idHistorial);
        assertEquals(idHistorial, pac1.getIdHistorial());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getId method, of class Paciente.
     */
    @Test
    public void testGetId001() {
        System.out.println("getId");
        long expResult = 0;
        long result = pac1.getIdHistorial();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getId method, of class Paciente.
     */
    @Test
    public void testGetId002() {
        System.out.println("getId");
        long expResult = 1;
        long result = pac1.getIdHistorial();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente valido (entero largo positivo)
     */
    @Test
    public void testSetId001() {
        System.out.println("setIdHistorial");
        long idHistorial = 10;
        pac1.setIdHistorial(idHistorial);
        assertEquals(idHistorial, pac1.getIdHistorial());
    }
    
    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente invalido (0)
     */
    @Test
    public void testSetId002() {
        System.out.println("setIdHistorial");
        long idHistorial = 0;
        pac1.setIdHistorial(idHistorial);
        assertEquals(idHistorial, pac1.getIdHistorial());
        fail("Se esperaba una excepcion");
    }
    
    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente invalido (entero largo negativo)
     */
    @Test
    public void testSetId003() {
        System.out.println("setIdHistorial");
        long idHistorial = -10;
        pac1.setIdHistorial(idHistorial);
        assertEquals(idHistorial, pac1.getIdHistorial());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getNombre method, of class Paciente.
     */
    @Test
    public void testGetNombre001() {
        System.out.println("getNombre");
        String expResult = "";
        String result = pac1.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Paciente.
     */
    @Test
    public void testGetNombre002() {
        System.out.println("getNombre");
        String expResult = "Pedro";
        String result = pac1.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre001() {
        System.out.println("setNombre");
        String nombre = "Luis";
        pac1.setNombre(nombre);
        assertEquals(nombre, pac1.getNombre());
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre002() {
        System.out.println("setNombre");
        String nombre = "1234";
        pac1.setNombre(nombre);
        assertEquals(nombre, pac1.getNombre());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre003() {
        System.out.println("setNombre");
        String nombre = "*+^¨$";
        pac1.setNombre(nombre);
        assertEquals(nombre, pac1.getNombre());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getApellidos method, of class Paciente.
     */
    @Test
    public void testGetApellidos001() {
        System.out.println("getApellidos");
        String expResult = "";
        String result = pac1.getApellidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getApellidos method, of class Paciente.
     */
    @Test
    public void testGetApellidos002() {
        System.out.println("getApellidos");
        String expResult = "Perez Perez";
        String result = pac2.getApellidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setApellidos method, of class Paciente.
     */
    @Test
    public void testSetApellidos001() {
        System.out.println("setApellidos");
        String apellidos = "Gonzalez Gonzalez";
        pac1.setApellidos(apellidos);
        assertEquals(apellidos, pac1.getApellidos());
    }

    /**
     * Test of setApellidos method, of class Paciente.
     */
    @Test
    public void testSetApellidos002() {
        System.out.println("setApellidos");
        String apellidos = "1234";
        pac1.setApellidos(apellidos);
        assertEquals(apellidos, pac1.getApellidos());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setApellidos method, of class Paciente.
     */
    @Test
    public void testSetApellidos003() {
        System.out.println("setApellidos");
        String apellidos = "*+^¨$";
        pac1.setApellidos(apellidos);
        assertEquals(apellidos, pac1.getApellidos());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getNIF method, of class Paciente.
     */
    @Test
    public void testGetNIF001() {
        System.out.println("getNIF");
        String expResult = "";
        String result = pac1.getNIF();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNIF method, of class Paciente.
     */
    @Test
    public void testGetNIF002() {
        System.out.println("getNIF");
        String expResult = "12345678A";
        String result = pac2.getNIF();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNIF method, of class Paciente.
     */
    @Test
    public void testSetNIF001() {
        System.out.println("setNIF");
        String NIF = "98765432Z";
        pac1.setNIF(NIF);
        assertEquals(NIF, pac1.getNIF());
    }

    /**
     * Test of setNIF method, of class Paciente.
     */
    @Test
    public void testSetNIF002() {
        System.out.println("setNIF");
        String NIF = "98765432";
        pac1.setNIF(NIF);
        assertEquals(NIF, pac1.getNIF());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setNIF method, of class Paciente.
     */
    @Test
    public void testSetNIF003() {
        System.out.println("setNIF");
        String NIF = "Hola";
        pac1.setNIF(NIF);
        assertEquals(NIF, pac1.getNIF());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setNIF method, of class Paciente.
     */
    @Test
    public void testSetNIF004() {
        System.out.println("setNIF");
        String NIF = "999999999";
        pac1.setNIF(NIF);
        assertEquals(NIF, pac1.getNIF());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getTelefono method, of class Paciente.
     */
    @Test
    public void testGetTelefono001() {
        System.out.println("getTelefono");
        String expResult = "";
        String result = pac1.getTelefono();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelefono method, of class Paciente.
     */
    @Test
    public void testGetTelefono002() {
        System.out.println("getTelefono");
        String expResult = "666666666";
        String result = pac2.getTelefono();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono001() {
        System.out.println("setTelefono");
        String telefono = "633456456";
        pac1.setTelefono(telefono);
        assertEquals(telefono, pac1.getTelefono());
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono002() {
        System.out.println("setTelefono");
        String telefono = "Hola";
        pac1.setTelefono(telefono);
        assertEquals(telefono, pac1.getTelefono());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono003() {
        System.out.println("setTelefono");
        String telefono = "656465";
        pac1.setTelefono(telefono);
        assertEquals(telefono, pac1.getTelefono());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono004() {
        System.out.println("setTelefono");
        String telefono = "945623216454213";
        pac1.setTelefono(telefono);
        assertEquals(telefono, pac1.getTelefono());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono005() {
        System.out.println("setTelefono");
        String telefono = "355645987";
        pac1.setTelefono(telefono);
        assertEquals(telefono, pac1.getTelefono());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getDireccion method, of class Paciente.
     */
    @Test
    public void testGetDireccion001() {
        System.out.println("getDireccion");
        String expResult = "";
        String result = pac1.getDireccion();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDireccion method, of class Paciente.
     */
    @Test
    public void testGetDireccion002() {
        System.out.println("getDireccion");
        String expResult = "cerca";
        String result = pac2.getDireccion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDireccion method, of class Paciente.
     */
    @Test
    public void testSetDireccion001() {
        System.out.println("setDireccion");
        String direccion = "lejos";
        pac1.setDireccion(direccion);
        assertEquals(direccion, pac1.getDireccion());
    }

    /**
     * Test of setDireccion method, of class Paciente.
     */
    @Test
    public void testSetDireccion002() {
        System.out.println("setDireccion");
        String direccion = "";
        pac1.setDireccion(direccion);
        assertEquals(direccion, pac1.getDireccion());
        fail("Se esperaba una excepcion");
    }

    /*
    Dejo este metodo de prueba comentado porque no se muy bien contra que podria contrastar el paciente que se importa al no tener un .txt valido disponible
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
    */
    /*
    Dejo este metodo de prueba comentado porque no se muy bien contra que podria contrastar el paciente que se importa al no tener un .dat valido disponible
    @Test
    public void testReadClientefromBinaryFile() {
        System.out.println("readClientefromBinaryFile");
        String path = "";
        ArrayList<Paciente> expResult = null;
        ArrayList<Paciente> result = Paciente.readClientefromBinaryFile(path);
        assertEquals(expResult, result);
    }
    */

    /**
     * Test of toTextFile method, of class Paciente.
     */
    @Test
    public void testToTextFile() {
        System.out.println("toTextFile");
        String path = "paciente.txt";
        pac2.toTextFile(path);
        Paciente pac2 = Paciente.readPacientefromTextFile("paciente.txt").get(0);
        assertEquals(pac1, pac2);
    }

    /**
     * Test of writeClienteToBinaryFile method, of class Paciente.
     */
    @Test
    public void testWriteClienteToBinaryFile() throws Exception {
        System.out.println("writeClienteToBinaryFile");
        String path = "paciente.dat";
        pac2.writeClienteToBinaryFile(path);
        Paciente pac2 = Paciente.readClientefromBinaryFile("paciente.dat").get(0);
        assertEquals(pac1, pac2);
    }

    /**
     * Test of toString method, of class Paciente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Paciente(ID=1, nombre=Pedro, apellidos=Perez Perez, NIF=12345678A, telefono=666666666, direccion=cerca)";
        String result = pac2.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of data method, of class Paciente.
     */
    @Test
    public void testData() {
        System.out.println("data");
        String expResult = "1|Pedro|Perez Perez|12345678A|666666666|cerca|1";
        String result = pac2.data();
        assertEquals(expResult, result);
    }

    /*
    Metodo sin funcionalidad implementada aun
    @Test
    public void testGetAllPaciente() {
        System.out.println("getAllPaciente");
        ArrayList<Paciente> expResult = null;
        ArrayList<Paciente> result = pac1.getAllPaciente();
        assertEquals(expResult, result);
    }
    ^/

    /*
    Metodo sin funcionalidad implementada aun
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
    */

    /*
    Requiere entrada de datos por pantalla
    @Test
    public void testNuevoPaciente() {
        System.out.println("nuevoPaciente");
        Paciente expResult = null;
        Paciente result = Paciente.nuevoPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
    Requiere de entrada de datos por pantalla
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
    */
    
}
