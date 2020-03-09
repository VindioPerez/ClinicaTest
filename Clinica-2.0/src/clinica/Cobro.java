/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import excepciones.PagoExcepcion;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @version 2.0
 * @author DAW106
 */
public class Cobro {
    
    protected long id;
    private double importeTotalEuros;
    private Date fechaFinalizacion;
    private ArrayList <Pago> pagos; 
    
    //Constructor por defecto. Crea un cobro con los atributos por defecto
    
    public Cobro() {
    }
    
    /**Constructor por parametros
     * 
     * @param idCobro identificador de cobro
     * @param importeTotalEuros importe total en euros en relacion al pago
     * @param fechaFinalizacion fecha final para realizar el cobro
     * @throws excepciones.PagoExcepcion 
     */
    
    public Cobro(int idCobro, double importeTotalEuros, Date fechaFinalizacion) throws excepciones.PagoExcepcion {
        this.id = idCobro;
        this.importeTotalEuros = importeTotalEuros;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    /**Constructor de copia. Crea un cobro cogiendo los atributos de otro
     * 
     * @param c Cobro a crear
     */
    
    public Cobro(Cobro c) {
        this.id=c.id;
        this.importeTotalEuros=c.getImporteTotalEuros();
        this.fechaFinalizacion=c.getFechaFinalizacion();
    }
    
    /**Otro constructor
     * 
     * @param id
     * @param importeTotalEuros
     * @param fechaFinalizacion 
     */
    
    private Cobro(long id, double importeTotalEuros, Date fechaFinalizacion) {
    }
    
    //Getters y Setters
    
    public long getIdCobro() {
        return id;
    }

    public void setIdCobro(int idCobro) {
        this.id = idCobro;
    }

    public double getImporteTotalEuros() {
        return importeTotalEuros;
    }

    public void setImporteTotalEuros(double importeTotalEuros) {
        this.importeTotalEuros = importeTotalEuros;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public ArrayList<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(ArrayList<Pago> pagos) {
        this.pagos = pagos;
    }
   
    //Final Getters y Setters

    /**
    Método toString de la clase Cobro
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    
    @Override
    public String toString() {
        return "Cobro{" + "idCobro=" + id + ", importeTotalEuros=" + importeTotalEuros + ", fechaFinalizacion=" + fechaFinalizacion + '}';
    }
    
    /** Metodo Data
    Metodo que devuelve los atributos de la clase separados por '|'
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    
    public String data() {
        return getIdCobro() + " | " + getImporteTotalEuros()+ " | " + getFechaFinalizacion() ;
    }
    
    /**Metodo getAllCobro
     * Metodo que devuelve todos los cobros
     * @return un <code>ArrayList</code>
     */
    
    public ArrayList<Cobro> getAllCobro (){
    ArrayList <Cobro> cobros = new ArrayList <Cobro>();
    return cobros;
    }
    
    /**Metodo ById
     * Recorre el <code>ArrayList</code> de Cobro
     * @param id id del cobro
     * @return un <code>Cobro</code>
     */
    
    public Cobro getCobroById (long id){
        Cobro c = new Cobro();
        return c;
    }
    
    /**
     * Metodo nuevoCobro
     * @return un <code>Cobro</code> con los datos puestos por el usuario
     * @throws ParseException 
     */
    
   public static Cobro nuevoCobro () throws ParseException, PagoExcepcion{
       
    Cobro c = new Cobro();
    Scanner in = new Scanner(System.in);
       
    boolean correcto = false;
    do {
            
    //**importe total euros, fecha arraypagos        
         
    System.out.println("Importe total en euros: ");
    double importeTotalEuros = in.nextDouble();
    c.setFechaFinalizacion();
            
    System.out.println("Introduzca la fecha de finalizacion: ");
    Date fecha = Utilidades.leerFecha();
    c.setFechaFinalizacion();        
            
    ArrayList <Pago> pagos = new ArrayList();
    System.out.println("¿Cuantos pagos realizara? ");
    int num = Integer.parseInt(in.nextLine());
    for (int i=0; i<num;i++){
        
        System.out.println("Introduce numero de pagos");
        String cob= in.nextLine();
        
        Pago p = Pago.nuevoPago();
        pagos.add(p);
        }
    
        }
    while (!correcto);
    return c;
        }

    private void setFechaFinalizacion() {
           }

    void setPagos(double npago) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    /**
     * Metodo readCobrofromTextFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException
     * @exception  Exception    
     * @return un <code>ArrayList</code>
     */
    
    public static ArrayList<Cobro> fromTextFile (String path) {
        ArrayList<Cobro> ret = new ArrayList<>();
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
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    long id = Long.parseLong(campos[10]);
                    double importeTotalEuros = Double.parseDouble(campos[1]);
                    Date fechaFinalizacion = df.parse(campos[4]);
                    Cobro z = new Cobro(id, importeTotalEuros, fechaFinalizacion);
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
     * Metodo readCobrofromBinaryFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException  
     * @exception  Exception
     * @exception ClassNotFoundException
     * @return un <code>ArrayList</code>
     */
    
    public static ArrayList<Cobro> fromBinaryFile (String path) {
        ArrayList<Cobro> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Cobro c;
                while((c = (Cobro)lectorObjeto.readObject())!=null)
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
   
