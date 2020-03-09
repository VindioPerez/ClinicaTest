/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import excepciones.PagoExcepcion;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 3.1
 * @author AdrianSaveli
 */
public class Pago {

    protected long id;//Es el identificador del pago.
    private Date fechadePago;//Es la fecha de la realización del pago por parte del paciente.
    private double importe;//Es el importe del pago.Solo son valores númericos.
    private String metododePago;//Es el método por el cual se efectua el pago (Transferencia,efectivo,...).
    Paciente paciente;//Paciente es el que realiza el pago.
    long idPaciente;
    long idCobro;
    //Getters y setters

    public long getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(long idCobro) {
        this.idCobro = idCobro;
    }
    
    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public long getID() {
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public Date getFechaDePago() {
        return fechadePago;
    }

    public void setFechaDePago(Date fechadePago) {
        this.fechadePago = fechadePago;
    }

    public void setImporte(Double importe) {
        this.importe = importe;

    }

    public double getImporte() {
        return importe;
    }

    public String getMetodoDePago() {
        return metododePago;
    }

    public void setMetodoDePago(String metododePago) {
        this.metododePago = metododePago;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    //4 metodos nuevos
    /**
     * 
     * @param path es el parametro de un fichero de texto.
     * @exception  FileNotFoundException si no se encuentra el fichero
     * @exception  IOException  excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception  Exception es aquella excepcion general.
     * @return  devuelve lo que contenia el archivo de texto del que se leen los datos del Pago.
     */
     public static ArrayList<Pago> FromTextFile (String path) {
        ArrayList<Pago> ret = new ArrayList<>();
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
                    long id = Long.parseLong(campos[0]);
                    long idPaciente = Long.parseLong(campos[1]);
                    long idCobro = Long.parseLong(campos[1]);
                    Date fechadePago = df.parse(campos[4]);
		    double importe = Double.parseDouble(campos[1]);
                    String metododePago = campos[3];
                    Pago p = new Pago(id, idPaciente, idCobro,  fechadePago, importe, metododePago);
                    ret.add(p);                   
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
     * @param path es el parametro de un fichero binario.
     * @exception  FileNotFoundException si no se encuentra el fichero
     * @exception  IOException  excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception  Exception es aquella general.
     * @exception EOFException es la excepcion que indica que se ha alcanzado el final del fichero o del stream.
     * @exception ClassNotFoundException es la que indica que no se ha encontrado la clase.
     * @return devuelve lo que contenia el archivo binario del que se leen los datos del Pago.
     */
    public static ArrayList<Pago> readModificacionFromBinaryFile (String path) {
        ArrayList<Pago> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Pago p;
                while((p = (Pago)lectorObjeto.readObject())!=null){
                    ret.add(p);
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
    public void writeModificacionToTextFile (String path){
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
    public void writeModificacionToBinaryFile (String path) {
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
    public Pago() {
    }
       /**
     * 
     * @param id es el id del pago <code>long</code> .
     * @param idPaciente es el id del Paciente que realiza el pago<code>long</code> .
     * @param idCobro es el id del Cobro al que pertenece el pago<code>long</code> .
     * @param fechadePago es la fecha del pago <code>Date</code> .
     * @param importe Es el importe del pago <code>double</code> .
     * @param metododePago Es el metodo de pago <code>char</code> .
     */
    //Constructor con argumentos
    public Pago(long ID, Date FechaDePago, double importe, String MetodoDePago) throws PagoExcepcion {
        this.id = ID;
        this.fechadePago = FechaDePago;
        try {
            if (PagoExcepcion.validarImporte(importe)) {
                this.importe = importe;
            }

        } catch (PagoExcepcion ex) {
            System.out.println("Error al validar el importe del pago.");
        }

        try {
            if (PagoExcepcion.validarMetodoDePago(MetodoDePago)) {
                this.metododePago = MetodoDePago;
            }
        } catch (PagoExcepcion ex) {

            System.out.println("Error al valido el método de pago");
        }

    }
    /**
     * 
     * @param id es el id del pago <code>long</code> .
     * @param idPaciente es el id del Paciente que realiza el pago<code>long</code> .
     * @param idCobro es el id del Cobro al que pertenece el pago<code>long</code> .
     * @param fechadePago es la fecha del pago <code>Date</code> .
     * @param importe Es el importe del pago <code>double</code> .
     * @param metododePago Es el metodo de pago <code>char</code> .
     */
    public Pago(long id, long idPaciente, long idCobro ,Date fechadePago, double importe, String metododePago) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idCobro = idCobro;
        this.fechadePago = fechadePago;
        this.importe = importe;
        this.metododePago = metododePago;


    }

    /**
     * 
     * @param p es el parametro de Pago que nos vale para hacer el constructor de copia.
     */
    //Constructor de copia
    public Pago(Pago p) {
        this.id = p.getID();
        this.fechadePago = p.getFechaDePago();
        this.importe = p.getImporte();
        this.metododePago = p.getMetodoDePago();
        this.idPaciente = p.getIdPaciente();
        this.idPaciente = p.getIdCobro();
    }
    /**
     * 
     * @return devuelve un String de Id fechadePago , importe y metodo de pago .
     */
    @Override
    public String toString() {
        return "Pago{" + "ID=" + id + ", fechaDePago=" + fechadePago + ", importe=" + importe + ", m\u00e9todoDePago=" + metododePago + '}';
    }
    /**
     * 
     * @return  devuelve los datos de Pago en orden más el id de Paciente y Cobro que son <code>long</code>.
     */
    public String data() {
        return "" + getID()+"|"+getPaciente().getId()+"|"+getIdCobro() + "|" + getFechaDePago() + "|" + getImporte() + "|" + getMetodoDePago();
    }
    /**
     * 
     * @return devuelve todos los pagos  que existen en el sistema.
     */
    public ArrayList<Pago> getAllPago() {
        ArrayList<Pago> pagos = new ArrayList<Pago>();
        return pagos;
    }
    /**
     * 
     * @param id es el identificador de la clase Pago.Cada Pago tiene su propio identificador.
     * @return devuelve el pago en la que coincida el id .
     */
    public Pago getPagoById(long id) {
        Pago p = new Pago();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquel pago que tenga ese id dado.
        Aunque si no existe ningún pago con ese id saldra null.  
         */
        return p;
    }
    /**
     * 
     * @return devuelve un pago nuevo
     */
    public static Pago nuevoPago() {
        Pago p = new Pago();
        Scanner in = new Scanner(System.in);
        boolean correcto;
        do {

            System.out.println("Introduzca la fecha del pago: ");
            Date fecha = Utilidades.leerFecha();
            p.setFechaDePago(fecha);

            System.out.println("Introduzca el importe del pago:");
            double importe;
            importe = in.nextDouble();
            try {
                if (!excepciones.PagoExcepcion.validarImporte(importe)) {
                    p.setImporte(importe);
                }
                System.out.println("Introduzca el método de pago: ");
                String metp = in.nextLine();
                if (!excepciones.PagoExcepcion.validarMetodoDePago(metp)) {
                    p.setMetodoDePago(metp);
                }

            } catch (PagoExcepcion ex) {
                System.out.println("PagoExcepcion" + ex.getMessage());;
            }

            System.out.println("La pago introducido es: " + p);
            System.out.println("¿Es correcto el pago?");
            correcto = Utilidades.leerBoleano();

        } while (!correcto);

        return p;
    }

}
