
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
//import java.util.*;
/**
 * @version 2.0
 * @author DAW106
 * Clase del Historial de la clinica
 */
public class Historial {
    
    protected long id;//Lleva el identificador del historial
    private String descripcion;//Descripcion del historial
    private ArrayList<Alergia> alergias;
  //private List<Alergia>alergias=new ArrayList<Alergia>();
    private long idPaciente;
    
    //Constructor por defecto. Crea un Empleado con los atributos por defecto
    
    public Historial() {
    }
    
    /**Constructor por parametros. 
     * 
     * @param idHistoria identificador del historial
     * @param descripcion descripcion del historial
     */
    
    public Historial(int idHistoria, String descripcion) {
        this.id = idHistoria;
        this.descripcion = descripcion;
    }
    
    /**Constructor de copia. Crea un Empleado cogiendo los atributos de otro
     * 
     * @param h 
     */
    
    public Historial(Historial h){
        this.descripcion=h.getDescripcion();
        this.id=h.getId();
    }
    
    /**Otro constructor
     * 
     * @param id
     * @param descripcion
     * @param idPaciente 
     */
    
    public Historial(long id, String descripcion, long idPaciente) {
    }
    
    //Getters y Setters
    
    public ArrayList<Alergia> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<Alergia> alergias) {
        this.alergias = alergias;
    }
    
    public long getId() {
        return id;
    }

    public void setIdHistoria(int idHistoria) {
        this.id = idHistoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    //Final Getters y Setters
    
    /**
    Método toString de la clase Historial
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    
    @Override
    public String toString() {
        return "Historial{" + "idHistoria=" + id + ", descripcion=" + descripcion + '}';
    }
    
    /** Metodo Data
    Metodo que devuelve los atributos de la clase separados por '|'
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    
    public String data() {
        return getId() + " | " + getDescripcion() + " | " + getIdPaciente() ;
    }
    
    /**Metodo getAllHistorial
     * Metodo que devuelve todos los historiales
     * @return un <code>ArrayList</code>
     */
    
    public ArrayList<Historial> getAllHistorial (){
    ArrayList <Historial> historiales = new ArrayList <Historial>();
    return historiales ;
    }
    
    /**Metodo ById
     * Recorre el <code>ArrayList</code> de Historial
     * @param id id del Historial
     * @return un <code>Historial</code>
     */
    
    public Historial getHistorialById (long id){
        Historial h = new Historial();
         return h;
    }
    
    /**
     * Metodo nuevoHistorial
     * @return un <code>Historial</code> con los datos puestos por el usuario
     * @throws ParseException 
     */
    
          public static Historial nuevoHistorial()
     {
        Historial h = new Historial();
        Scanner in = new Scanner(System.in);     
        
        System.out.println("Introduzca la descripcion");
        String descripcion = in.nextLine();
        h.setDescripcion(descripcion);
        
        System.out.println("Introduzca nº de alergias");
        int num = Integer.parseInt(in.nextLine());
        
        ArrayList<Alergia>ale=new ArrayList<Alergia>();
        
        for (int i=0; i<num;i++){
        
        System.out.println("Introduce alergia");
        String al= in.nextLine();
        
        Alergia a= new Alergia(i+1,al);
        ale.add(a);
        }
        
        h.setAlergias (ale);
        
        System.out.println("Lista alergias");
        h.getAlergias();
        
        ArrayList<Alergia>alerg=h.getAlergias();
        
        for (int i=0; i<alerg.size();i++){
        
        System.out.println(alerg.get(i).getNombreAlergia());
        
        }
        
        return h;

     }
    
    /**
     * Metodo readHistorialfromTextFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException
     * @exception  Exception
     * @return un <code>ArrayList</code>
     */ 
          
       public static ArrayList<Historial> readHistorialfromTextFile (String path) {
        ArrayList<Historial> ret = new ArrayList<>();
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
                    String descripcion = campos[10];
                    long idPaciente = Long.parseLong(campos[0]);
                    Historial z = new Historial(id, descripcion, idPaciente);
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
       
    public static ArrayList<Historial> fromBinaryFile (String path) {
        ArrayList<Historial> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Historial c;
                while((c = (Historial)lectorObjeto.readObject())!=null)
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

