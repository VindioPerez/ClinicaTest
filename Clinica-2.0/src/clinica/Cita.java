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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version 2.0
 * @author DAW106
 */
public class Cita {

    protected long id; 
    private Date fecha;
    private char rangoHorario;
    private String hora;
    private boolean estado;
    
    private long idTratamiento;
    
    //Constructor por defecto. Crea una cita con los atributos por defecto
       
    public Cita() {
    }

    /**Constructor por parametros
     * 
     * @param fecha fecha de la cita
     * @param rangoHorario rango horario en el cual se llevara a cabo la cita
     * @param hora hora en la cual se llevara a cabo la cita
     * @param estado urgente o no urgente
     */
    
    public Cita(Date fecha, char rangoHorario, String hora, boolean estado) {

        this.fecha = fecha;
        this.rangoHorario = rangoHorario;
        this.hora = hora;
        this.estado = estado;
    }

    /**Constructor de copia. Crea un cobro cogiendo los atributos de otro
     * 
     * @param c Cita a crear
     */
    
    public Cita(Cita c) {
        this.id = c.getId();
        this.fecha = c.getFecha();
        this.rangoHorario = c.getRangoHorario();
        this.hora = c.getHora();
    }
    
    /**Otro constructor
     * 
     * @param id 
     * @param fecha
     * @param rangoHorario
     * @param hora
     * @param estado 
     */
    
    public Cita(long id, Date fecha, char rangoHorario, String hora, boolean estado) {
    }
    
    /**Otro constructor
     * 
     * @param id
     * @param fecha
     * @param hora
     * @param estado 
     */
    
    public Cita(long id, Date fecha, String hora, boolean estado) {
    }
    
    //Getters y Setters
    
    public long getId() {
        return id;
    }

    public void setId(int idCita) {
        this.id = idCita;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public char getRangoHorario() {
        return rangoHorario;
    }

    public void setRangoHorario(char rangoHorario) {
        this.rangoHorario = rangoHorario;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public String getEstado() {
        return hora;
    }
    
    public long getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(long idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    //Final de Getters y Setters
    
    /**
    Método toString de la clase Cita
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    
    @Override
    public String toString() {
        return "Cita{" + "idCita=" + id + ", fecha=" + fecha + ", rangoHorario=" + rangoHorario + ", hora=" + hora + '}';
    }
    
    /** Metodo Data
    Metodo que devuelve los atributos de la clase separados por '|'
    Devuelve un <code>String</code>
    @return un <code>String</code>
    */
    
    public String data() {
        return getId() + " | " + getFecha() + " | " + getRangoHorario() + " | " + getHora() + " | " + getIdTratamiento();

    }
    
    /**Metodo getAllCita
     * Metodo que devuelve todas las citas
     * @return un <code>ArrayList</code>
     */
    
    public ArrayList<Cita> getAllCita() {
        ArrayList<Cita> citas = new ArrayList<Cita>();
        return citas;
    }
    
    /**Metodo ById
     * Recorre el <code>ArrayList</code> de Cita
     * @param id id de la cita
     * @return un <code>Cita</code>
     */
    
    public Cita getCitaById(long id) {
        Cita c = new Cita();
        return c;
    }
    
    /**
     * Metodo nuevoCita
     * @return un <code>Cita</code> con los datos puestos por el usuario
     * @throws ParseException 
     */
    
    public static Cita nuevoCita() throws ParseException {
        Cita c = new Cita();
        boolean correcto;
        do {

            System.out.println("Introduzca la fecha de la cita: ");
            Date fecha = Utilidades.leerFecha();
            c.setFecha(fecha);

            System.out.println("Introduzca el rango horario de la cita 'm' o 't':  ");
            char rango;
            Scanner in = new Scanner(System.in);
            do {
                System.out.println("Introduzca solo 'm' para las mañanas o 't' para las tardes.");
                rango = in.nextLine().charAt(0);

            } while (rango != 'm' && rango != 't' && rango != 'M' && rango != 'T');

            c.setRangoHorario(rango);

            System.out.println("Introduzca la hora de la cita: ");
            String hora = in.nextLine();
            c.setHora(hora);

            System.out.println("¿Es urgente la cita? (s/n)");
            boolean urgente = Utilidades.leerBoleano();
            c.setEstado(urgente);

            System.out.println("La cita introducida es: " + c);
            System.out.println("¿Es correcta la cita?");
            correcto = Utilidades.leerBoleano();

        } while (!correcto);

        return c;
    }
    
    /**
     * Metodo readCitafromTextFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException
     * @exception  Exception
     * @return un <code>ArrayList</code>
     */
    
    public static ArrayList<Cita> fromTextFile (String path) {
        ArrayList<Cita> ret = new ArrayList<>();
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
                    Date fecha = df.parse(campos[4]);
                    //char rangoHorario;
                    String hora = campos[4];
                    boolean estado = Boolean.parseBoolean(campos[6]);
                    long idTratamiento = Long.parseLong(campos[10]);
                    
                    Cita z = new Cita(id, fecha, hora, estado);
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
     * Metodo readCitafromBinaryFile
     * @param path ruta del fichero
     * @exception  FileNotFoundException
     * @exception  IOException  
     * @exception  Exception
     * @exception ClassNotFoundException
     * @return un <code>ArrayList</code>
     */
    
    public static ArrayList<Cita> fromBinaryFile (String path) {
        ArrayList<Cita> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Cita c;
                while((c = (Cita)lectorObjeto.readObject())!=null)
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
