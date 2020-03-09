/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import java.io.BufferedReader;
import java.io.EOFException;
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
 * @version 3.1
 * @author AdrianSaveli
 */
public class Alergia {
    protected long id;//Es el identificador de las alergia.
    private String nombreAlergia;//Es el nombre de la alergia.Cadena de caracteres.
    private ArrayList<Historial> historiales;
    //Getters y setters

    public ArrayList<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(ArrayList<Historial> historiales) {
        this.historiales = historiales;
    }
    
    public long getID() {
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public String getNombreAlergia() {
        return nombreAlergia;
    }

    public void setNombreAlergía(String nombreAlergía) {
        this.nombreAlergia = nombreAlergía;
    }
    /**
     * 
     * @param path es el parametro de un fichero de texto.
     * @return devuelve lo que contenia el archivo de texto del que se leen los datos de la Alergia.
     * @exception  FileNotFoundException si no se encuentra el fichero
     * @exception  IOException  excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception  Exception es aquella general.
     */
     public static ArrayList<Alergia> FromTextFile (String path) {
        ArrayList<Alergia> ret = new ArrayList<>();
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
                    String nombreAlergia = campos[3];
                    Alergia a = new Alergia(id, nombreAlergia);
                    ret.add(a);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(lector!=null)
                    lector.close();
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException"+p.getMessage());
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception"+p.getMessage());
        }
        return ret;
    }
    /**
     * 
     * @param path es el parametro de un fichero binario
     * @return devuelve lo que contenia el archivo binario del que se leen los datos de Alergia.
     * @exception  FileNotFoundException si no se encuentra el fichero
     * @exception  IOException  excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception  Exception es aquella general.
     * @exception EOFException es la excepcion que indica que se ha alcanzado el final del fichero o del stream.
     * @exception ClassNotFoundException es la que indica que no se ha encontrado la clase.
     */
    public static ArrayList<Alergia> FromBinaryFile (String path) {
        ArrayList<Alergia> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Alergia a;
                while((a = (Alergia)lectorObjeto.readObject())!=null){
                    ret.add(a);
                    lector.skip(4);}
            }finally{
                if(lectorObjeto!=null)
                    lectorObjeto.close();
                if(lector!=null)
                    lector.close();
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(EOFException p){
            System.out.println("Final de fichero"+p.getMessage());
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException: "+p.getMessage());
        }
        catch(ClassNotFoundException p){
            System.out.println("Se ha producido una ClassNotFoundException"+p.getMessage());
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception"+p.getMessage());
        }
        return ret;
    }
    
    /**
     * 
     * @param path es el parametro del archivo de texto que se ira ha escribir.
     * @exception FileNotFoundException si no se encuentra el fichero
     * @exception IOException excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception Exception es aquella general.
     */
    public void writeToTextFile (String path){
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null ;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                buffer.print(this.data()+"\r\n");
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(escritor!=null)
                    escritor.close();
            }
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException"+p.getMessage());
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception"+p.getMessage());
        }
    }
    /**
     * 
     * @param path es el parametro del archivo binario que se ira ha escribir.
     * @exception FileNotFoundException si no se encuentra el fichero.
     * @exception IOException excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception Exception es aquella general.
     */
    public void writeToBinaryFile (String path) {
        try{
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            escritor.writeObject(this);
            escritor.flush();
            escritor.close();
        }       
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException"+p.getMessage());
        }
        catch(Exception p){
            System.out.println("Se ha producido una Exception"+p.getMessage());
        }
    }
    //Constructor por defecto
    public Alergia() {
    }
    /**
     * 
     * @param ID es el parametro del id <code>long</code> 
     * @param nombreAlergía es el parametro del nombre de  alergia <code>String</code> .
     * 
     */
    //Constructor con argumentos
    public Alergia(long ID, String nombreAlergía) {
        this.id = ID;
        this.nombreAlergia = nombreAlergía;
    }
    /**
     * 
     * @param p  alergia que nos vale para hacer el constructor de copia.
     */
    //Constructor de copia
    public Alergia (Alergia p) {
        this.nombreAlergia = p.getNombreAlergia();
        this.id = p.getID();
    }
    //Otros métodos sobreescritos
    /**
     * 
     * @return devuelve un String de Id y nombreAlergia 
     */
    @Override
    public String toString() {
        return "Alerg\u00eda{" + "ID=" + id + ", nombreAlerg\u00eda=" + nombreAlergia + '}';
    }
    /**
     * 
     * @return devuelve los datos de Alergia en orden.
     */
    public String data() {
        return ""+getID()+"|"+getNombreAlergia()+"|"+getHistoriales();
    }
    /**
     * 
     * @return devuelve todas las alergias que existen en el sistema.
     */
    public ArrayList<Alergia> getAllAlergia (){
        
    ArrayList <Alergia> alergias = new ArrayList <Alergia>();
    
    return alergias;
    }
    /**
     * 
     * @param id es el identificador de la clase alergia .Cada alergia tiene su propio identificador.
     * @return  devuelve la alergia en la que coincida el id .
     */
    public Alergia getAlergiaById (long id){
        Alergia a = new Alergia();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquella alergia que tenga ese id dado.
        Aunque si no existe ninguna alergia con ese id saldra null.  
        */ 
        return a;
    }
    /**
     * 
     * @return devuelve una Alergia nueva.
     * @see  package.Historial#member label
     */
        public static Alergia nuevaAlergia () {
  
        Alergia a = new Alergia();
        Scanner in = new Scanner(System.in);
        boolean correcto;
        
        do{
            System.out.println("Introduzca el nombre de la alergia:");
             String nombre = in.nextLine();
            // i.setNombreAlergia(noma);
            
            ArrayList <Historial> historiales = new ArrayList();
            System.out.println("¿Quieres introducir los historiales que padezcan esta alergia? ");
            boolean resp = Utilidades.leerBoleano();
            if(resp){
               boolean resp2;
                do {
                   Historial h = Historial.nuevoHistorial();
                   historiales.add(h);
                   System.out.println("¿Quiere introducir otro historial?");
                   resp2 =Utilidades.leerBoleano();
                }
                while(resp2);
                a.setHistoriales (historiales);
            }
            System.out.println("La alergia introducida es: " + a);
            System.out.println("¿Es correcta la alergia?");
            correcto = Utilidades.leerBoleano();
        }
        while(!correcto);
        
     return a;   
    }   
}
