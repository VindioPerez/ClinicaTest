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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @version 2.0
 * @author DAW106
 * @see Empleado
 */
public class Cirujano extends Empleado{
   
    private ArrayList <Especialidad> especialidades;//Esto deberia implementarse en un lista de Especialidad. 
    private ArrayList<Revision> revisiones;//Esto deberia implementarse en un lista de Revision. 
    public Cirujano() {
        super();
    }
    
    //Constructor por defecto. Crea un cirujano con los atributos por defecto
    
    public Cirujano(String nombre, String apellido, String telefono, String nif, String direccion) {
        super (nombre, apellido, telefono, nif, direccion);
        this.especialidades = especialidades;
    }
    
    /** Constructor de copia. Crea un cirujano cogiendo los atributos de otro
     * 
     * @param c Cirujano a crear
     */
    
    public Cirujano(Cirujano c) {
        super (c);
     
        this.especialidades=c.getEspecialidades();
    
    //Constructor por parametros
        
    }
    public Cirujano(Empleado e, ArrayList especialidades) {
        super(e);
        this.especialidades= especialidades;
             
    }

    //Getters y Setters
    
    public ArrayList<Revision> getRevisiones() {
        return revisiones;
    }

    public void setRevisiones(ArrayList<Revision> revisiones) {
        this.revisiones = revisiones;
    }
    
    /*
    Getter de especialidades.
    */
    public ArrayList<Especialidad> getEspecialidades() {
        return especialidades;
    }
    /*
    Setter de especialidades.
    */
    public void setEspecialidades(ArrayList especialidades) {
        this.especialidades = especialidades;
    }
    /**
    Método toString de la clase Cirujano
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */

    @Override
    public String toString() {
        return super.toString()+ "Cirujano{" + "especialidades=" + especialidades + '}';
    }
    
    /** Metodo Data
    Metodo que devuelve los atributos de la clase separados por '|'
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    @Override
    public String data() {
        return super.data()+getEspecialidades();
    }
    
    /**Metodo getAllCirujano
     * Metodo que devuelve todos los cirujanos
     * @return un <code>ArrayList</code>
     */
    
    public ArrayList<Cirujano> getAllCirujano (){
    ArrayList <Cirujano> cirujanos = new ArrayList <Cirujano>();
    return cirujanos ;
    }
    
    /**Metodo ById
     * Recorre el <code>ArrayList</code> de Cirujano
     * @param id id del cirujano
     * @return un <code>Cirujano</code>
     */
    
    public Cirujano getCirujanoById (long id){
        Cirujano c = new Cirujano();
         return c;
    }
    
    /**
     * Metodo nuevoCirujanos
     * @return un <code>Cirujano</code> con los datos puestos por el usuario
     * @throws ParseException 
     */
    
    public static Cirujano nuevoCirujanos() throws ParseException{
    Cirujano c = new Cirujano();
    Scanner in = new Scanner(System.in);  
        
    boolean correcto;
        
        do{
            
            Empleado em = Empleado.nuevoEmpleado();
            
    ArrayList <Especialidad> especialidad = new ArrayList();
            System.out.println("¿Quieres introducir la especialidad? ");
            boolean resp = Utilidades.leerBoleano();
            if(resp){
               boolean resp2;
                do {
                   Especialidad e;
                   e = Especialidad.nuevaEspecialidad();
                   especialidad.add(e);
                   System.out.println("¿Quiere introducir otra especialidad?");
                   resp2 =Utilidades.leerBoleano();
                }
                while(resp2);    
                c.setEspecialidad (especialidad);
            }
            ArrayList <Revision> revision = new ArrayList();
            System.out.println("¿Quiere introducir las revisiones? ");
            Revision rev;
            boolean resp3 = Utilidades.leerBoleano();
            if(resp3){
               boolean resp4;
                do {
                   
                   rev = Revision.nuevaRevision();
                   revision.add(rev);
                   System.out.println("¿Quiere introducir otra?");
                   resp4 =Utilidades.leerBoleano();
                }
                while(resp4);    
                c.setRevisiones (revision);
            }
            
            System.out.println("Los datos introducidos son:"+c);
            System.out.println("¿Los datos son correctos?");
            correcto= Utilidades.leerBoleano();
        }
         while(!correcto);
      return c;
  }

    private void setEspecialidad(ArrayList<Especialidad> especialidad) {
       
    }
    
    /**
     * Metodo readCirujanofromTextFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException
     * @exception  Exception
     * @return un <code>ArrayList</code>
     */
    
    public static ArrayList<Cirujano> readCirujanofromTextFile (String path) {
        ArrayList<Cirujano> ret = new ArrayList<>();
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
                    
                    Cirujano x = new Cirujano();
                    ret.add(x);                   
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
     * Metodo readCirujanofromBinaryFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException  
     * @exception  Exception
     * @exception ClassNotFoundException
     * @return un <code>ArrayList</code>
     */
    
    public static ArrayList<Cirujano> readCirujanofromBinaryFile (String path) {
        ArrayList<Cirujano> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Cirujano c;
                while((c = (Cirujano)lectorObjeto.readObject())!=null)
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
