/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import excepciones.MedicacionException;
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
 * version 3.0
 *
 * @author DAW109
 */
public class Medicamento {

    Alergia alergia;

    protected long id;
    //Identificador del medicamento. VALOR SUPERIOR A CERO
    private String nombre;
    // Nombre del medicamento por ejemplo, aspirina... 
    private String principioActivo;
    // Principio activo del medicamento
    private int dosisMaxDiaria;
    // Dosis máxima diaria en mg puesto, por tanto tiene que ser un int porque debe ser un numero entero, NO PUEDE SER VALOR 0

    
    
    /** 
     * Constructor por defecto
     */
    public Medicamento() {
    }

    /**
     * Contructor por parametos
     * @param idMedicamento indica el id del medicamento
     * @param nombre indica el nombre de medicamento
     * @param principioActivo indica el principio activo del medicamento
     * @param dosisMaxDiaria indica la dosis maxima diaria que se puede ingerir del medicamento
     * @throws MedicacionException 
     */
    
    public Medicamento(long idMedicamento, String nombre, String principioActivo, int dosisMaxDiaria) throws MedicacionException {
        this.id = idMedicamento;
        if (MedicacionException.validarNombre(nombre)) {
            this.nombre = nombre;
        } else {

        }
        if (MedicacionException.validarPrincipioActivo(principioActivo)) {
            this.principioActivo = principioActivo;
        } else {

        }
        if (MedicacionException.validarDosisMaxDiaria(dosisMaxDiaria)) {
            this.dosisMaxDiaria = dosisMaxDiaria;
        } else {

        }
        
    }
    
    /**
     * Constructor de copia
     * @param m
     * @throws MedicacionException 
     */

    public Medicamento(Medicamento m) throws MedicacionException {
        this.id = m.getId();
        this.nombre = m.getNombre();

        this.principioActivo = m.getPrincipioActivo();
        this.dosisMaxDiaria = (int) m.getDosisMaxDiaria();
    }

    // Getter y Setter
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws MedicacionException {
        this.nombre = nombre;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) throws MedicacionException {
        this.principioActivo = principioActivo;
    }

    public float getDosisMaxDiaria() {
        return dosisMaxDiaria;
    }

    public void setDosisMaxDiaria(int dosisMaxDiaria) throws MedicacionException {
        this.dosisMaxDiaria = dosisMaxDiaria;
    }

    public Alergia getAlergia() {
        return alergia;
    }

    public void setAlergia(Alergia alergia) {
        this.alergia = alergia;
    }
    
    //Finalización de getter y setter
    
    /**
     * Metodo to String
     * @return sobreescritura de String que devuelve los datos de la clase
     */

    @Override
    public String toString() {
        return "Medicamento{" + "idMedicamento=" + id + ", nombre=" + nombre + ", principioActivo=" + principioActivo + ", dosisMaxDiaria=" + dosisMaxDiaria + '}';
    }
    
    /**
     * Metodo Data
     * @return String de los datos propios de la clase
     */

    public String Data() {
        return this.getId() + " | " + this.getNombre() + " | " + this.getPrincipioActivo() + " | " + this.getDosisMaxDiaria();
    }

    /**
     * Metodo getAllMedicamento
     * @return ArrayList de medicamentos
     */
    
    public ArrayList<Medicamento> getAllMedicamento() {
        ArrayList<Medicamento> medicamentos = new ArrayList<Medicamento>();
        return medicamentos;
    }

    
    /**
     * Metodo getMedicamentoById
     * @param id
     * @return delvuelve el id del medicamento
     */
    public Medicamento getMedicamentoById(long id) {
        Medicamento m = new Medicamento();
        return m;
    }

    /**
     * Metodo nuevo Medicamento
     * @return un nuevo medicamento
     * @throws MedicacionException 
     */
    
    public static Medicamento nuevoMedicamento() throws MedicacionException {

        Medicamento m = new Medicamento();
        Scanner in = new Scanner(System.in);
        boolean correcto;

        do {

            System.out.println("Introduzca el nombre del medicamento:");
            String nmed = in.nextLine();
            try {
                if (MedicacionException.validarNombre(nmed)) {
                    m.setNombre(nmed);
                }
            } catch (MedicacionException ex) {
                System.out.println("Se ha producido una MedicacionException con el nombre del medicamento." + ex.getMessage());
            }

            System.out.println("Introduzca el principio activo del medicamento: ");
            String prina = in.nextLine();
            m.setPrincipioActivo(prina);
            try {
                if (MedicacionException.validarPrincipioActivo(prina)) {
                    m.setPrincipioActivo(prina);
                }
             } catch (MedicacionException ex) {
                System.out.println("Se ha producido una MedicacionException con el principio activo del medicamento." + ex.getMessage());
            }

            System.out.println("Introduza la dosis maxima diaria en mg:");
            int dmaxd = in.nextInt();
            m.setDosisMaxDiaria(dmaxd);
            try {
                if (MedicacionException.validarDosisMaxDiaria(dmaxd)) {
                    m.setDosisMaxDiaria(dmaxd);
                }
             } catch (MedicacionException ex) {
                System.out.println("Se ha producido una MedicacionException con el principio activo del medicamento." + ex.getMessage());
            }

            System.out.println("Introduzca la alergia: ");
            Alergia alergia = Alergia.nuevaAlergia();
            String aler = in.nextLine();
            m.setAlergia(alergia);

            System.out.println("Los datos introducidos son: " + m);
            System.out.println("¿Son correctos los datos introducidos?");
            correcto = Utilidades.leerBoleano();
        } while (!correcto);

        return m;
    }

    // Un setter 
    private void setCita(ArrayList<Cita> citas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    //Metodos de entrada y salida
    
        /**
         * Metodo fromTextFile
         * @param path
         * @return ArrayList de medicamento a traves de un fichero de texto
         */
        public static ArrayList<Medicamento> fromTextFile (String path) {
        ArrayList<Medicamento> med = new ArrayList<>();
        File fichero = new File(path);
        FileReader medica = null;
        BufferedReader buffer = null ;
        try {
            try {
                medica = new FileReader(fichero);
                buffer = new BufferedReader(medica);
                String linea;
                while((linea=buffer.readLine())!=null){
                    String[] campos = linea.split("\\|");
                    long id = Long.parseLong(campos[0]);
                    String nombre = campos[10];
                    String principioActivo = campos[10];
                    int dosisMaxDiaria = Integer.parseInt(campos[0]);
                    Medicamento m = new Medicamento (id, nombre, principioActivo, dosisMaxDiaria);
                    med.add(m);                   
                }
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(medica!=null)
                    medica.close();
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
        return med;
    }
        
        
        /**
         * Metodo fromBinaryFile
         * @param path
         * @return ArrayList medicamento a traves de un fichero binario
         */
        
        public static ArrayList<Medicamento> fromBinaryFile (String path) {
        ArrayList<Medicamento> med = new ArrayList<>();
        FileInputStream medica = null;
        ObjectInputStream medObjeto = null;
        try{
            try{
                medica = new FileInputStream(path);
                medObjeto = new ObjectInputStream(medica);
                Medicamento m;
                while((m = (Medicamento)medObjeto.readObject())!=null)
                    med.add(m);
            }finally{
                if(medica!=null)
                    medica.close();
                if(medObjeto!=null)
                    medObjeto.close();
            }
        }
        catch(FileNotFoundException m){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException m){
            System.out.println("Se ha producido una IOException");
        }
        catch(ClassNotFoundException m){
            System.out.println("Se ha producido una ClassNotFoundException");
        }
        catch(Exception m){
            System.out.println("Se ha producido una Exception");
        }
        return med;
    }
    
        
       /**
        * Metodo toTextFile crea un fichero de texto
        * @param path 
        */ 
        
    public void toTextFile (String path){
        File medica = new File(path);
        FileWriter medicacion = null;
        PrintWriter buffer = null ;
        try {
            try {
                medicacion = new FileWriter(medica);
                buffer = new PrintWriter(medicacion);
                buffer.println(this.Data());
            }finally{
                if(buffer!=null)
                    buffer.close();
                if(medicacion!=null)
                    medicacion.close();
            }
        }
        catch(FileNotFoundException m){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException m){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception m){
            System.out.println("Se ha producido una Exception");
        }
    }

   
    /**
     * Metodo toBinaryFile crea un fichero binario
     * @param path 
     */
    
    public void toBinaryFile (String path) {
        FileOutputStream medica = null;
        ObjectOutputStream medObjeto = null;
        try{
            try{
                medica = new FileOutputStream(path);
                medObjeto = new ObjectOutputStream(medica);
                medObjeto.writeObject(this);
            }finally{
                if(medica!=null)
                    medica.close();
                if(medObjeto!=null)
                    medObjeto.close();
            }
        }
        catch(FileNotFoundException m){
            System.out.println("Se ha producido una FileNotFoundException");
        }
        catch(IOException m){
            System.out.println("Se ha producido una IOException");
        }
        catch(Exception m){
            System.out.println("Se ha producido una Exception");
        }
    }
  
        
        
    
    

}
