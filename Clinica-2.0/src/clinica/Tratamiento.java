/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;
import excepciones.PagoExcepcion;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * version 2
 * @author DAW109
 */
public class Tratamiento {
 
    Informe informe;
    Paciente paciente;
    Cobro cobro;
    
    long idCobro;
    long idPaciente;
    long idInforme;
    
    protected long id;
    //Identificador del tratamiento relacionado con el paciente TIENE QUE TENER VALOR MAYOR A CERO
    private String nombre;
    //Nombre del tratamiento Ej; Endodoncia... 
    private String fechaInicio;
    //Fecha de inicio del tratamiento pueden ser tratamientos de semanas... TIENE QUE TENER FORMATO DIA/MES/AÑO
    private boolean consentimiento;
    // Consentimiento del paciente al ser solo acepto o no se pone un boolean, OLO SE ACEPTAN VALORES DE VERDADERO (ACEPTA Y FALSO (NO ACEPTA)
    private ArrayList <Cita> citas;
    
    /**
     * Contructor por defecto
     */
    
    public Tratamiento() {
    }

    /**
     * Contructor por parametros
     * @param id devuelve el id del tratamiento
     * @param nombre devuelve el nombre del tratamiento
     * @param fechaInicio devuelve la fecha inicio del tratamiento
     * @param consentimiento devuelve el consentimiento
     */
    
    public Tratamiento(long id, String nombre, String fechaInicio, boolean consentimiento) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.consentimiento = consentimiento;
    }
    
    /**
     * Contructor de copia
     * @param t 
     */
    
    public Tratamiento (Tratamiento t) {
        this.id = t.getId ();
        this.nombre = t.getNombre();
        this.fechaInicio = t.getFechaInicio();
        this.consentimiento = t.isConsentimiento();
        this.idInforme = t.getIdInforme();
        this.idPaciente = t.getIdPaciente();
        this.idCobro = t.getIdCobro();
       
    }

    public Tratamiento(Informe informe, Paciente paciente, Cobro cobro, long idCobro, long idPaciente, long idInforme, long id, String nombre, String fechaInicio, boolean consentimiento, ArrayList<Cita> citas) {
        this.informe = informe;
        this.paciente = paciente;
        this.cobro = cobro;
        this.idCobro = idCobro;
        this.idPaciente = idPaciente;
        this.idInforme = idInforme;
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.consentimiento = consentimiento;
        this.citas = citas;
    }
 
    // Getter y setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public long getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(long idInforme) {
        this.idInforme = idInforme;
    }

    
    public long getIdCobro() {
        return idCobro;
    }

    public void setIdCobro(long idCobro) {
        this.idCobro = idCobro;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isConsentimiento() {
        return consentimiento;
    }

    public void setConsentimiento(boolean consentimiento) {
        this.consentimiento = consentimiento;
    }

    public Informe getInforme() {
        return informe;
    }

    public void setInforme(Informe informe) {
        this.informe = informe;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Cobro getCobro() {
        return cobro;
    }

    public void setCobro(Cobro cobro) {
        this.cobro = cobro;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    //Finalización de getter y setter
    
    
    
    /**
     * Metodo toString
     * @return Sobreescritura que devuelve los atributos de la clase
     */
    
    @Override
    public String toString() {
        return "Tratamiento{" + "idTratamiento=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", consentimiento=" + consentimiento + '}';
    }
     
    
    /**
     * Metodo Data
     * @return indica los datos de la propia clase
     */
    
    public String Data (){
     return getIdInforme() + " | " + getIdCobro() + " | " + getIdPaciente()+ " | " + this.getId() + " | " + this.getIdCobro() + " | " + this.getIdPaciente() + " | " + this.getIdInforme() + " | " + this.getNombre() + " | " + this.getFechaInicio() + " | " + this.isConsentimiento ();
    }
    
    /**
     * Metodo GetAllTratamiento
     * @return ArrayList de tratamiento.
     */
    
    public ArrayList<Tratamiento> getAllTratamiento (){
    ArrayList <Tratamiento> tratamientos = new ArrayList <Tratamiento>();
    return tratamientos ;
    }
    
    
    /**
     * Metodo getTratamientoById
     * @param id
     * @return devuelve el id de tratamiento
     */
    
    public Tratamiento getTratamientoById (long id){
        Tratamiento t = new Tratamiento();
         return t;
    }
 
    
    /**
     * Crea un tratamiento añadiendo los argumentos por teclado. 
     * 
     * @return un objeto de tipo Tratamiento
     * @throws ParseException cuando el formato de fecha no es valido
     * @throws PagoExcepcion cuando el formato de alguno de los campos de <code>Pago</code> no es correcto.
     */
    
    public static Tratamiento nuevoTratamiento() throws ParseException, PagoExcepcion{
            Tratamiento t = new Tratamiento();
            Scanner in = new Scanner(System.in);
            
            boolean correcto;
            
            do{
            
            System.out.println("Introduzca el paciente: ");
            Paciente paciente = Paciente.nuevoPaciente();
            String Paciente = in.nextLine();
            t.setPaciente(paciente);
            
            System.out.println("Introduzca el informe:");
            Informe informe = Informe.nuevoInforme();
            String Informe = in.nextLine();
            t.setInforme(informe);
        
           System.out.println("Introduzca el nombre del tratamiento:");
           String nom = in.nextLine();
           t.setNombre(nom);
           
           System.out.println("Introduzca la fecha de inicio del tratammiento");
           String fin =in.nextLine();
           t.setFechaInicio(fin);
           
           System.out.println(" ¿El paciente da el consentimiento?");
           char consentimiento;
           boolean consen = Utilidades.leerBoleano();
           
           if(consen){
               
               boolean consen2;
           
             do {
                
                System.out.println("Es necesario el consentimiento para realizar un tratamiento");
                consentimiento = in.nextLine().charAt(0);
                consen2 = Utilidades.leerBoleano();
                
            } while (!consen2);
             
             t.setConsentimiento(consen);

           }
           
                System.out.println("Introduzca el cobro del tratamiento:");
                Cobro cobro = null;
                try {
                    cobro = Cobro.nuevoCobro();
                } catch (PagoExcepcion ex) {
                    Logger.getLogger(Tratamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
                String Cobro = in.nextLine();
                t.setCobro(cobro);
           
              
                System.out.println("Los datos introducidos son: "+t);
                System.out.println("¿Son correctos los datos introducidos?");
                correcto = Utilidades.leerBoleano();
    
     }    while (!correcto);

    return t;
}

    private void setPaciente(String paciente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


