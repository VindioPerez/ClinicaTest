/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import excepciones.PacienteException;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version 4.0
 * @author AdrianSaveli
 */
public class Paciente  implements Serializable {
    
    
    

    protected long id;//Es el identificador del paciente.
    
    private String nombre;//Es el nombre del paciente.Cadena de caracteres.
    private String apellidos;//Es el apellido del paciente.Cadena de caracteres.
    private String NIF;//Es la tarjeta de identidad del paciente.Cadena de caracteres.
    private String telefono;//Es el telefono de contacto del paciente.Cadena de caracteres.
    private String direccion;//Es la dirección de residencia del paciente.Cadena de caracteres.
    Historial historial;
    long idHistorial;
    
    public long getIdHistorial() {    
        return idHistorial;
    }

    //Getters y setters
    public void setIdHistorial(long idHistorial) {    
        this.idHistorial = idHistorial;
    }

    public long getId() {
        return id;
    }

    public void setId(long idPaciente) {
        this.id = idPaciente;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    //Los 4 métodos de lectura y escritura.
    /**
     * 
     * @param path es el parametro de un fichero de texto.
     * @exception  FileNotFoundException si no se encuentra el fichero
     * @exception  IOException  excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception  PacienteException es aquella excepcion que esta regulada en PacienteException.
     * @see Clinica.PacienteException
     * @return  devuelve lo que contenia el archivo de texto del que se leen los datos del Paciente.
     */
    public static ArrayList<Paciente> readPacientefromTextFile (String path) {
        ArrayList<Paciente> ret = new ArrayList<>();
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
                    String nombre = campos[1];
		    String apellido = campos[2];
		    String NIF = campos[1];
                    String telefono = campos[2];
		    String direccion = campos[1];
                    long idHistorial = Long.parseLong(campos[0]);
                    Paciente p = new Paciente(id,nombre,apellido,NIF, telefono,direccion);
                    ret.add(p);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(lector!=null)
                    lector.close();
            }
        }
        catch(PacienteException p){
            System.out.println("Se ha producido una ClienteException"+p.getMessage());
        }
        catch(FileNotFoundException p){
            System.out.println("Se ha producido una FileNotFoundException"+p.getMessage());
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException"+p.getMessage());
        }

        return ret;
    }
    /**
     * 
     * @param path es el parametro de un fichero binario
     * @exception  FileNotFoundException si no se encuentra el fichero
     * @exception  IOException  excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception  Exception es aquella general.
     * @exception EOFException es la excepcion que indica que se ha alcanzado el final del fichero o del stream.
     * @exception ClassNotFoundException es la que indica que no se ha encontrado la clase.
     * @return devuelve lo que contenia el archivo binario del que se leen los datos de Paciente.
     */
     public static ArrayList<Paciente> readClientefromBinaryFile  (String path) {
        ArrayList<Paciente> ret = new ArrayList<>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try{
            try{
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Paciente p;
                 while((p = (Paciente)lectorObjeto.readObject())!=null){
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
            System.out.println("Final de fichero");
        }
        catch(IOException p){
            System.out.println("Se ha producido una IOException"+p.getMessage());
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
 public void toTextFile (String path){
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
     * @throws FileNotFoundException Salta la excepcion.
     * @throws IOException  Salta la excepcion.
     * @exception FileNotFoundException si no se encuentra el fichero.
     * @exception IOException excepciones que se producen mientras se tiene acceso a la información mediante secuencias, archivos y directorios.
     * @exception Exception es aquella general.
     */
    public void writeClienteToBinaryFile (String path) throws FileNotFoundException, IOException {
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
    
    public Paciente() {
    }
    //Constructor con argumentos
    /**
     * 
     * @param idPaciente Es el identificador del Paciente <code>long</code> .
     * @param nombre Es el nombre del Paciente <code>String</code> .
     * @param apellidos Es el apellido del Paciente <code>String</code> .
     * @param NIF Es el NIF del Paciente <code>String</code>.
     * @param telefono Es el telefono del Paciente <code>String</code>.
     * @param direccion Es la direccion del Paciente <code>String</code>.
     * @throws PacienteException salta la excepcion si no se respetan las restricciones.
     */

    public Paciente(long idPaciente, String nombre, String apellidos, String NIF, String telefono, String direccion) throws PacienteException {
        this.id = idPaciente;
        
        try{
        if (PacienteException.validarNombre(nombre)) this.nombre = nombre; 
        }
        catch(PacienteException ex){
            System.out.println("Error al validar el nombre del paciente." + ex.getMessage());
        }
        
        try{
        if (PacienteException.validarApellido(apellidos)) this.apellidos = apellidos;
        }
        catch (PacienteException ex){
             System.out.println("Error al validar el apellido del paciente." + ex.getMessage());
        }
        
        try{
        if (PacienteException.validarNif(NIF)) this.NIF = NIF;
        }
        catch (PacienteException ex){
            System.out.println("Error al validar el NIF del paciente." + ex.getMessage());
        }
        
        try{
        if (PacienteException.validarTelefono(telefono)) this.telefono = telefono;
        }
        catch (PacienteException ex){
            System.out.println("Error al validar el telefono del paciente." + ex.getMessage());
        }
        this.direccion = direccion;
    }
    
    /**
     * 
     * @param historial es un objeto historial
     * @param idHistorial es el id externo <code>long</code>.
     * @param id es el identificador del paciente <code>long</code>.
     * @param nombre es el nombre del Paciente <code>String</code>.
     * @param apellidos es el apellido del Paciente <code>String</code>.
     * @param NIF es el NIF del Paciente <code>String</code>.
     * @param telefono es el telefono del Paciente <code>String</code>.
     * @param direccion es la direccion del Paciente <code>String</code>.
     */
    public Paciente(Historial historial, long idHistorial, long id, String nombre, String apellidos, String NIF, String telefono, String direccion) {
        this.historial = historial;
        this.idHistorial = idHistorial;
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.NIF = NIF;
        this.telefono = telefono;
        this.direccion = direccion;
        
    }


   /**
    * 
    * @param p es el parametro de Paciente que nos vale para hacer el constructor de copia.
    */
    //Constructor de copia
   public Paciente (Paciente p) {
        this.id = p.getId();
        this.nombre = p.getNombre();
        this.apellidos = p.getApellidos();
        this.NIF = p.getNIF();
        this.telefono = p.getTelefono();
        this.direccion = p.getDireccion();
        this.idHistorial = p.getIdHistorial();
        
        }
    //Otros métodos sobreescritos
    /**
     * 
     * @return devuelve un String de Id , nombre ,apellidos,NIF,telefono y direccion.
     */
    @Override
    public String toString() {
        return id + "Paciente{" + "ID" + ", nombre=" + nombre + ", apellidos=" + apellidos + ", NIF=" + NIF + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    /**
     * 
     * @return devuelve los datos de Paciente en orden más el id de Historial que es <code>long</code>.
     */
    public String data() {
        return ""+getId()+"|"+getNombre()+"|"+getApellidos()+"|"+getNIF()+"|"+getTelefono()+"|"+getDireccion()+"|"+getIdHistorial();
    }

    
    /**
     * 
     * @return  devuelve todos los pacientes  que existen en el sistema.
     */
    public ArrayList<Paciente> getAllPaciente (){
    ArrayList <Paciente> pacientes = new ArrayList <Paciente>();
    return pacientes;
    }
    /**
     * 
     * @param id es el identificador de la clase Paciente.Cada Paciente tiene su propio identificador.
     * @return devuelve el paciente en la que coincida el id .
     */
    public Paciente getPacienteById (long id){
        Paciente p = new Paciente();
        /*Este método sirve para que posteriormente se busque el id dado
        y se obtengan los datos de aquel paciente que tenga ese id dado.
        Aunque si no existe ningún paciente con ese id saldra null.  
        */ 
        return p;
    }
    /**
     * 
     * @return devuelve un Paciente nuevo.
     */
    public static Paciente nuevoPaciente (){
        Paciente p = new Paciente();
        Scanner in= new Scanner(System.in);
        
        boolean correcto;
        do{
            
        String nom,ape,nif,tel,dir;
        System.out.println("Dame el nombre:");
        nom=in.nextLine();
        
        try{
            if(!excepciones.PacienteException.validarNombre(nom)){
        p.setNombre(nom);    
            }
            
         System.out.println("Dame el apellido:");
        ape=in.nextLine();
        
        if(!excepciones.PacienteException.validarApellido(ape)){
        p.setApellidos(ape);
        }
        
        System.out.println("Dame el NIF:");
        nif=in.nextLine();
  
        
        if(!excepciones.PacienteException.validarNif(nif)) {
        p.setNIF(nif);  
            
        }
        System.out.println("Dame el telefono:");
        tel=in.nextLine();
        
         if(!excepciones.PacienteException.validarTelefono(tel)){
         
         p.setTelefono(tel);
        }
       
        } catch (PacienteException ex){
            System.out.println("PacienteException: " +ex.getMessage());
        }
        
        System.out.println("Dame la dirección:");
        dir=in.nextLine();
        p.setDireccion(dir);
        
        System.out.println("¿Son correctos los datos del paciente?");
        
        correcto = Utilidades.leerBoleano();
        }
        while (!correcto);
        
        return p;
    }
    
    
    
    //Caso de uso REALIZAR PAGO hecho por Mar Santin.
    
    /**
     * Metodo para realizar un pago de un tratamiento
     * @param t Se le pasa un Tratamiento al metodo.
     * @return Devuelve un boolean de si se ha finalizado el pago o no.
     */
    
    public boolean realizarPago (Tratamiento t){
        
        Scanner in = new Scanner (System.in);
        
        Cobro c = t.getCobro();
        
        Double importePagado= 0.0;
        
        ArrayList<Pago> pagos= c.getPagos();
        
        for (Pago p: pagos){
            
            importePagado += p.getImporte();
            
        }
        
        if (importePagado < c.getImporteTotalEuros()){
            
            System.out.println("El importe total del tratamiento todavía no ha sido abonado, por favor introduzca un nuevo pago.");
            double npago = in.nextDouble();
            c.setPagos(npago);
        
            pagos.add(Pago.nuevoPago());
            
        }
        
        return true;
    }
    
    //FINAL DEL METODO REALIZARPAGO
    
    
    
    
    
    
    
    
    
    
    
    
}
