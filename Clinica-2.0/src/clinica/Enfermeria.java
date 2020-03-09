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
 * @version 2
 * @author DAW109
 * @see Empleado */

public class Enfermeria extends Empleado{
   
    private char categoria;
    /**Dado que la categoría tiene que estar solo representado por una letra es un char
     * PUEDE TENER LOS VALORES QUE SE QUIERAN 
     * PUESTO QUE PUEDEN PONER LAS CATEGORÍAS COMO CATEGORÍA A,0, 1... SOLO PUEDE SER UN CARACTER.*/
    private ArrayList <Intervencion> intervenciones;
    
    
    
    //Constructor por defecto
    public Enfermeria() {
        super();
    }
    
    /** Contructor por parametros
     * @param nombre indica el nombre del enfermero
     * @param apellido indica el apellido del enfermero   
     * @param telefono indica el telefeno del enfermero
     * @param nif indica el nif del enfermero
     * @param direccion indica la dirección del enfermero
     */

    public Enfermeria(String nombre, String apellido, String telefono, String nif, String direccion) {
        super (nombre, apellido, telefono, nif, direccion);
        this.categoria = categoria;
    }
    /**Constructor de copia
     * 
     * @param e 
     */
    
    public Enfermeria (Enfermeria e){
        super (e);
        this.categoria=e.getCategoria();
    
    }
    
    //Getter y Setters
    
    public Enfermeria (Empleado e, char categoria) {
        super (e);
        this.categoria= categoria;
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }

    public ArrayList<Intervencion> getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(ArrayList<Intervencion> intervenciones) {
        this.intervenciones = intervenciones;
    }
  
    //FINALIZACIÓN DE LOS GETTER Y SETTER
    
    
    /**
     * Metodo Data
     * @return Muestra los datos propios de la clase mas el id de Empleado <code> long <code>
     */
 
    public String Data () {
        
        return super.data() + this.getCategoria() + id;
    }

    /**
     * Metodo String
     * @return una sobreescritura del metodo To String muestra los datos de la clase.
     */
    @Override
    public String toString() {
        return super.toString()+  "Enfermeria{" + "categoria=" + categoria + '}';
    }
    
    /**
     * Metodo getEnfermeriaById
     * @param id
     * @return el id
     */
    public Enfermeria getEnfermeriaById (long id){
        Enfermeria e = new Enfermeria ();
         return e;
    }
 
    /**
     * Metodo getAllEnfermeria
     * @return ArrayList de enfermeros
     */
  public ArrayList<Enfermeria> getAllEnfermeria (){
      
      ArrayList<Enfermeria> enfermerias = new ArrayList <Enfermeria>();
      
      return enfermerias;
              
  }
  
  
  /**
   * Metodo nuevoEnfermeria
   * @return un nuevo enfermero
   * @throws ParseException si hay un fallo en la fecha
   */
  public static Enfermeria nuevoEnfermeria() throws ParseException{
       Enfermeria e = new Enfermeria();
       Scanner in = new Scanner (System.in);
       boolean correcto;
       
       do {
           
           Empleado em = Empleado.nuevoEmpleado();
           
           System.out.println("Introduzca la categoria de los enfermeros/as.");
           char cat;
           cat = in.nextLine().charAt(0);
           e.setCategoria(cat);
           
           ArrayList <Intervencion> intervenciones = new ArrayList();
           System.out.println("¿Quiere introducir las intervenciones?");
           Intervencion intr;
           
           boolean resp = Utilidades.leerBoleano();
           
           if(resp){
               
               boolean resp2;
           do{
               
               intr = Intervencion.nuevaIntervencion();
               intervenciones.add(intr);
               System.out.println("¿Quiere introducir otra intervención?");
               resp2 = Utilidades.leerBoleano();
               
           } while (resp2);
          
                   }
           System.out.println("Los datos introducidos son:"+e);
           System.out.println("¿Son correctos los datos introducidos?");
           correcto = Utilidades.leerBoleano();
      
  } while (!correcto);
    
    return e;
}
  
  
  //Metodos de entrada y salida 
  /**
   * Metodo readEnfermeriafromTextFile
   * @param path
   * @return ArrayList de ficheros de Enfermeria
   */
  public static ArrayList<Enfermeria> readEnfermeriaFromTextFile (String path) {
        ArrayList<Enfermeria> enf = new ArrayList<>();
        File fichero = new File(path);
        FileReader enfermero = null;
        BufferedReader buffer = null ;
        try {
            try {
                enfermero = new FileReader(fichero);
                buffer = new BufferedReader(enfermero);
                String linea;
                while((linea=buffer.readLine())!=null){
                    String[] campos = linea.split("\\|");
                    //super long id = long.parseLong(campos[0]);
                    char categoria;
                    Enfermeria c = new Enfermeria();
                    enf.add(c);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(enfermero!=null)
                    enfermero.close();
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
        return enf;
    }
  
  /**
   * Metodo readEnfermeriaFromBinaryFile
   * @param path
   * @return Arraylist de enfermeros a traves de un fichero en binario
   */
          public static ArrayList<Enfermeria> readEnfermeriaFromBinaryFile (String path) {
        ArrayList<Enfermeria> enf = new ArrayList<>();
        FileInputStream enfermero = null;
        ObjectInputStream enfObjeto = null;
        try{
            try{
                enfermero = new FileInputStream(path);
                enfObjeto = new ObjectInputStream(enfermero);
                Enfermeria e;
                while((e = (Enfermeria)enfObjeto.readObject())!=null)
                    enf.add(e);
            }finally{
                if(enfermero!=null)
                    enfermero.close();
                if(enfObjeto!=null)
                    enfObjeto.close();
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
        return enf;
    }
    
          
    /**
     * Metodo toTextFile crea un fichero de texto
     * @param path 
     * 
     */
    public void toTextFile (String path){
        File enfermero = new File(path);
        FileWriter enfermeria = null;
        PrintWriter buffer = null ;
        try {
            try {
                enfermeria = new FileWriter(enfermero);
                buffer = new PrintWriter(enfermeria);
                buffer.println(this.Data());
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(enfermeria!=null)
                    enfermeria.close();
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
    * Metodo toBinaryFile crea un fichero en binario
    * @param path 
    */
    public void toBinaryFile (String path) {
        FileOutputStream enfermeria = null;
        ObjectOutputStream enfObjeto = null;
        try{
            try{
                enfermeria = new FileOutputStream(path);
                enfObjeto = new ObjectOutputStream(enfermeria);
                enfObjeto.writeObject(this);
            }finally{
                if(enfermeria!=null)
                    enfermeria.close();
                if(enfObjeto!=null)
                    enfObjeto.close();
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

