/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @version 2.0
 * @author DAW106
 */
public class Empleado{

    
    protected long id; //id del empleado
    private String nombre; //nombre del empleado
    private String apellido; //apellido del empleado
    private String telefono; //telefono del empleado
    private String nif; //nif del empleado
    private String direccion; //Direccion del empleado
    
    //Constructor por defecto. Crea un Empleado con los atributos por defecto
    
    public Empleado() {
    }
    
    /**Constructor por parametros
     * 
     * @param nombre nombre del empleado
     * @param apellido apellido del empleado
     * @param telefono telefono del empleado
     * @param nif nif del empleado
     * @param direccion direccion del empleado
     */
    
    public Empleado( String nombre, String apellido, String telefono, String nif, String direccion) {
    
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.nif = nif;
        this.direccion= direccion;
    }
    
    /**Constructor de copia. Crea un Empleado cogiendo los atributos de otro
     * 
     * @param e Empleado a crear
     */
    
    public Empleado(Empleado e) {

        this.id=e.getId();

        this.nombre=e.getNombre();
        this.apellido=e.getApellido();
        this.telefono=e.getTelefono();
        this.nif=e.getNif();
        this.direccion=e.getDireccion();
        
    }

    /**Otro constructor
     * 
     * @param id
     * @param nombre
     * @param apellido
     * @param telefono
     * @param nif
     * @param direccion 
     */
    
    private Empleado(long id, String nombre, String apellido, String telefono, String nif, String direccion) {
    }

    //Getters y Setters
    
    public long getId() {

        return id;
    }


    public void setId(int id) {
        this.id = id;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //Final Getters Setters
    
    /**
    Método toString de la clase Empleado
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    
    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", nif=" + nif + ", direccion=" + direccion + '}';
    }
    
    /** Metodo Data
    Metodo que devuelve los atributos de la clase separados por '|'
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    
    public String data() {
      
        return this.getId() + " | " + this.getNombre() + " | " + this.getApellido() + " | " + this.getTelefono() + " | " + this.getNif() + " | " + this.getDireccion();
    }
    
    /**Metodo getAllEmpleado
     * Metodo que devuelve todos los empleados
     * @return un <code>ArrayList</code>
     */
    
    public ArrayList<Empleado> getAllCita (){
    ArrayList <Empleado> empleados = new ArrayList <Empleado>();
    return empleados ;
    }
    
    /**Metodo ById
     * Recorre el <code>ArrayList</code> de Empleado
     * @param id id del Empleado
     * @return un <code>Cita</code>
     */
    
    public Empleado getEmpleadoById (long id){
        Empleado e = new Empleado();
         return e;
    }
    
    /**
     * Metodo nuevoEmpleado
     * @return un <code>Empleado</code> con los datos puestos por el usuario
     * @throws ParseException 
     */
    
            public static Empleado nuevoEmpleado(){
     
        Empleado em = new Empleado();
        Scanner in = new Scanner(System.in);  
        
        boolean correcto;
        
        do{
        
        System.out.println("Introduzca el Nombre del empleado");
        String nombre = in.nextLine();
        em.setNombre(nombre);
        
        System.out.println("Introduzca el Apellido del empleado");
        String apellido = in.nextLine();
        em.setApellido(apellido);
        
        
        System.out.println("Introduzca el Telefono del empleado");
        String telefono = in.nextLine();
        em.setTelefono(telefono);
        
        System.out.println("Introduzca el NIF del empleado");
        String nif = in.nextLine();
        em.setNif(nif);
        
        System.out.println("Introduzca el Direccion del empleado");
        String direccion = in.nextLine();
        em.setDireccion(direccion);
        
        System.out.println("Estos son los datos del empleado:"+em);
        System.out.println("¿Los datos del empleado son correctos?");
        String correct = in.nextLine();
        correcto = Utilidades.leerBoleano();
        }
        while(!correcto);
        
        return em;

     }
            
    /**
     * Metodo readEmpleadofromTextFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException
     * @exception  Exception
     * @return un <code>ArrayList</code>
     */       
            
        public static ArrayList<Empleado> fromTextFile (String path) {
        ArrayList<Empleado> ret = new ArrayList<>();
        File fichero = new File(path);
        FileReader lector = null;
        BufferedReader buffer = null ;
        try {
            try {
                lector = new FileReader(fichero);
                buffer = new BufferedReader(lector);
                String linea;
                while((linea=buffer.readLine())!=null){
                    String[] campos = linea.split("\\|");
                    long id = Long.parseLong(campos[0]);
                    String nombre = campos[15];
                    String apellido = campos[15];
                    String telefono = campos[9]; 
                    String nif = campos[9];
                    String direccion = campos[20];
                    Empleado z = new Empleado(id, nombre, apellido, telefono, nif, direccion);
                    ret.add(z);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(lector!=null)
                    lector.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception");
        }
        return ret;
    }
    
    /**
     * Metodo readEmpleadofromBinaryFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException  
     * @exception  Exception
     * @exception ClassNotFoundException
     * @return un <code>ArrayList</code>
     */
        
    public static ArrayList<Empleado> fromBinaryFile (String path) {
        ArrayList<Empleado> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Empleado c;
                while((c = (Empleado)lectorObjeto.readObject())!=null)
                    ret.add(c);
            }finally{
                if(lector!=null)
                    lector.close();
                if(lectorObjeto!=null)
                    lectorObjeto.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException");
        }
        catch(ClassNotFoundException e){
            System.out.println("Se ha producido una ClassNotFoundException");
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception");
        }
        return ret;
    }
    
    /**
     * Metodo toTextFile
     * @param path ruta del fichero
     * @exception FileNotFoundException
     * @exception IOException
     * @exception Exception
     */
    
    public void toTextFile (String path){
        File archivo = new File(path);
        FileWriter writer = null;
        PrintWriter buffer = null ;
        try {
            try {
                writer = new FileWriter(archivo);
                buffer = new PrintWriter(writer);
                buffer.println(this.data());
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(writer!=null)
                    writer.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception");
        }
    }
    
    /**
     * Metodo toBinaryFile
     * @param path ruta del fichero
     * @exception FileNotFoundException
     * @exception IOException 
     * @exception Exception
     */
    
    public void toBinaryFile (String path) {
        FileOutputStream writer = null;
        ObjectOutputStream writerObjeto = null;
        try{
            try{
                writer = new FileOutputStream(path);
                writerObjeto = new ObjectOutputStream(writer);
                writerObjeto.writeObject(this);
            }finally{
                if(writer!=null)
                    writer.close();
                if(writerObjeto!=null)
                    writerObjeto.close();
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException e){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception e){
            System.out.println("Se ha producido una Exception");
        }
    }
            
}
