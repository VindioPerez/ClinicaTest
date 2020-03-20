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
public class EmpleadoTest {
    Empleado emp1 = null;
    Empleado emp2 = null;
    
    public EmpleadoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        emp1 = new Empleado();
        emp2 = new Empleado("Pedro", "Perez Perez", "666666666", "12345678A", "cerca");
        emp2.setId(1);
    }
    
    @After
    public void tearDown() {
        emp1 = null;
        emp2 = null;
    }

    /**
     * Test of getId method, of class Paciente.
     */
    @Test
    public void testGetId001() {
        System.out.println("getId");
        long expResult = 0;
        long result = emp1.getId();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getId method, of class Paciente.
     */
    @Test
    public void testGetId002() {
        System.out.println("getId");
        long expResult = 1;
        long result = emp1.getId();
        assertEquals(expResult, result);
    }

    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente valido (entero largo positivo)
     */
    @Test
    public void testSetId001() {
        System.out.println("setId");
        int id = 10;
        emp1.setId(id);
        assertEquals(id, emp1.getId());
    }
    
    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente invalido (0)
     */
    @Test
    public void testSetId002() {
        System.out.println("setId");
        int id = 0;
        emp1.setId(id);
        assertEquals(id, emp1.getId());
        fail("Se esperaba una excepcion");
    }
    
    /**
     * Prueba del metodo setIdHistorial de Paciente, con un valor teoricamente invalido (entero largo negativo)
     */
    @Test
    public void testSetId003() {
        System.out.println("setId");
        int id = -10;
        emp1.setId(id);
        assertEquals(id, emp1.getId());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getNombre method, of class Paciente.
     */
    @Test
    public void testGetNombre001() {
        System.out.println("getNombre");
        String expResult = "";
        String result = emp1.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNombre method, of class Paciente.
     */
    @Test
    public void testGetNombre002() {
        System.out.println("getNombre");
        String expResult = "Pedro";
        String result = emp1.getNombre();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre001() {
        System.out.println("setNombre");
        String nombre = "Luis";
        emp1.setNombre(nombre);
        assertEquals(nombre, emp1.getNombre());
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre002() {
        System.out.println("setNombre");
        String nombre = "1234";
        emp1.setNombre(nombre);
        assertEquals(nombre, emp1.getNombre());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre003() {
        System.out.println("setNombre");
        String nombre = "*+^¨$";
        emp1.setNombre(nombre);
        assertEquals(nombre, emp1.getNombre());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getApellidos method, of class Paciente.
     */
    @Test
    public void testGetApellido001() {
        System.out.println("getApellidos");
        String expResult = "";
        String result = emp1.getApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of getApellidos method, of class Paciente.
     */
    @Test
    public void testGetApellido002() {
        System.out.println("getApellidos");
        String expResult = "Perez Perez";
        String result = emp2.getApellido();
        assertEquals(expResult, result);
    }

    /**
     * Test of setApellidos method, of class Paciente.
     */
    @Test
    public void testSetApellido001() {
        System.out.println("setApellidos");
        String apellidos = "Gonzalez Gonzalez";
        emp1.setApellido(apellidos);
        assertEquals(apellidos, emp1.getApellido());
    }

    /**
     * Test of setApellidos method, of class Paciente.
     */
    @Test
    public void testSetApellido002() {
        System.out.println("setApellidos");
        String apellidos = "1234";
        emp1.setApellido(apellidos);
        assertEquals(apellidos, emp1.getApellido());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setApellidos method, of class Paciente.
     */
    @Test
    public void testSetApellido003() {
        System.out.println("setApellidos");
        String apellidos = "*+^¨$";
        emp1.setApellido(apellidos);
        assertEquals(apellidos, emp1.getApellido());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getNIF method, of class Paciente.
     */
    @Test
    public void testGetNif001() {
        System.out.println("getNIF");
        String expResult = "";
        String result = emp1.getNif();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNIF method, of class Paciente.
     */
    @Test
    public void testGetNif002() {
        System.out.println("getNIF");
        String expResult = "12345678A";
        String result = emp2.getNif();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNIF method, of class Paciente.
     */
    @Test
    public void testSetNif001() {
        System.out.println("setNIF");
        String NIF = "98765432Z";
        emp1.setNif(NIF);
        assertEquals(NIF, emp1.getNif());
    }

    /**
     * Test of setNIF method, of class Paciente.
     */
    @Test
    public void testSetNif002() {
        System.out.println("setNIF");
        String NIF = "98765432";
        emp1.setNif(NIF);
        assertEquals(NIF, emp1.getNif());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setNIF method, of class Paciente.
     */
    @Test
    public void testSetNif003() {
        System.out.println("setNif");
        String Nif = "Hola";
        emp1.setNif(Nif);
        assertEquals(Nif, emp1.getNif());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setNif method, of class Paciente.
     */
    @Test
    public void testSetNif004() {
        System.out.println("setNif");
        String Nif = "999999999";
        emp1.setNif(Nif);
        assertEquals(Nif, emp1.getNif());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getTelefono method, of class Paciente.
     */
    @Test
    public void testGetTelefono001() {
        System.out.println("getTelefono");
        String expResult = "";
        String result = emp1.getTelefono();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTelefono method, of class Paciente.
     */
    @Test
    public void testGetTelefono002() {
        System.out.println("getTelefono");
        String expResult = "666666666";
        String result = emp2.getTelefono();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono001() {
        System.out.println("setTelefono");
        String telefono = "633456456";
        emp1.setTelefono(telefono);
        assertEquals(telefono, emp1.getTelefono());
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono002() {
        System.out.println("setTelefono");
        String telefono = "Hola";
        emp1.setTelefono(telefono);
        assertEquals(telefono, emp1.getTelefono());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono003() {
        System.out.println("setTelefono");
        String telefono = "656465";
        emp1.setTelefono(telefono);
        assertEquals(telefono, emp1.getTelefono());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono004() {
        System.out.println("setTelefono");
        String telefono = "945623216454213";
        emp1.setTelefono(telefono);
        assertEquals(telefono, emp1.getTelefono());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of setTelefono method, of class Paciente.
     */
    @Test
    public void testSetTelefono005() {
        System.out.println("setTelefono");
        String telefono = "355645987";
        emp1.setTelefono(telefono);
        assertEquals(telefono, emp1.getTelefono());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of getDireccion method, of class Paciente.
     */
    @Test
    public void testGetDireccion001() {
        System.out.println("getDireccion");
        String expResult = "";
        String result = emp1.getDireccion();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDireccion method, of class Paciente.
     */
    @Test
    public void testGetDireccion002() {
        System.out.println("getDireccion");
        String expResult = "cerca";
        String result = emp2.getDireccion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDireccion method, of class Paciente.
     */
    @Test
    public void testSetDireccion001() {
        System.out.println("setDireccion");
        String direccion = "lejos";
        emp1.setDireccion(direccion);
        assertEquals(direccion, emp1.getDireccion());
    }

    /**
     * Test of setDireccion method, of class Paciente.
     */
    @Test
    public void testSetDireccion002() {
        System.out.println("setDireccion");
        String direccion = "";
        emp1.setDireccion(direccion);
        assertEquals(direccion, emp1.getDireccion());
        fail("Se esperaba una excepcion");
    }

    /**
     * Test of toString method, of class Empleado.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "Empleado(idEmpleado=1, nombre=Pedro, apellido=Perez Perez, telefono=666666666, nif=12345678A, direccion=cerca)";
        String result = emp2.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of data method, of class Empleado.
     */
    @Test
    public void testData() {
        System.out.println("data");
        String expResult = "1|Pedro|Perez Perez|666666666|12345678A|cerca";
        String result = emp2.data();
        assertEquals(expResult, result);
    }

    /*
    Metodo sin implementar
    @Test
    public void testGetAllCita() {
        System.out.println("getAllCita");
        Empleado instance = new Empleado();
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = instance.getAllCita();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
    Metodo sin implementar
    @Test
    public void testGetEmpleadoById() {
        System.out.println("getEmpleadoById");
        long id = 0L;
        Empleado instance = new Empleado();
        Empleado expResult = null;
        Empleado result = instance.getEmpleadoById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
    Pide entrada de datos por pantalla
    @Test
    public void testNuevoEmpleado() {
        System.out.println("nuevoEmpleado");
        Empleado expResult = null;
        Empleado result = Empleado.nuevoEmpleado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
    Dejo este metodo de prueba comentado porque no se muy bien contra que podria contrastar el empleado que se importa al no tener un .txt valido disponible
    @Test
    public void testFromTextFile() {
        System.out.println("fromTextFile");
        String path = "";
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = Empleado.fromTextFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /*
    Dejo este metodo de prueba comentado porque no se muy bien contra que podria contrastar el empleado que se importa al no tener un .dat valido disponible
    @Test
    public void testFromBinaryFile() {
        System.out.println("fromBinaryFile");
        String path = "";
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = Empleado.fromBinaryFile(path);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of toTextFile method, of class Empleado.
     */
    @Test
    public void testToTextFile() {
        System.out.println("toTextFile");
        String path = "empleado.txt";
        emp2.toTextFile(path);
        Empleado emp3 = Empleado.fromTextFile(path).get(0);
        assertEquals(emp2, emp3);
    }

    /**
     * Test of toBinaryFile method, of class Empleado.
     */
    @Test
    public void testToBinaryFile() {
        System.out.println("toBinaryFile");
        String path = "empleado.dat";
        emp2.toBinaryFile(path);
        Empleado emp3 = Empleado.fromBinaryFile(path).get(0);
        assertEquals(emp2, emp3);
    }
    
}
