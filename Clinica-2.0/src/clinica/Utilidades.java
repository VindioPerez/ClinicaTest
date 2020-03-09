/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica;

import clinica.Paciente;
import excepciones.PacienteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAW109
 */
public class Utilidades {

    public static Date leerFecha(){
        Scanner in = new Scanner(System.in);
        System.out.println("Escriba la fecha en formato dd/MM/yyyy");
        String fechaComoTexto = in.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha=null;
        try {
            fecha = sdf.parse(fechaComoTexto);
        } catch (ParseException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fecha;
    }

    public static boolean leerBoleano() {
        Scanner in = new Scanner(System.in);
        char c;
        do {
            System.out.println("Introduzca solo 's' o 'n'.");
            c = in.nextLine().charAt(0);

        } while (c != 's' && c != 'n' && c != 'S' && c != 'N');

        if (c == 's' || c == 'S') {

            return true;
        } else {

            return false;
        }

    }
    public Paciente PACIENTES[] = new Paciente[5];

    //Caso de uso REGISTRAR PACIENTE hecho por Alberto
    public static void registraPaciente(Paciente p) throws PacienteException {

//        Paciente p = new Paciente();
//        Scanner in= new Scanner(System.in);  
        String nombre = "";
        String apellidos = "";
        String NIF = "";
        String telefono = "";
        String direccion = "";

        //NOMBRE       
        System.out.println("Nombre:");
        nombre = p.getNombre(); //in.nextLine();
        if(! PacienteException.validarNombre(nombre)){
           System.out.println("error al validar el nombre del paciente.");
       }


        //APELLIDO
        System.out.println("Apellido:");
        apellidos = p.getApellidos();// in.nextLine();
        if(! PacienteException.validarApellido(apellidos)){
          System.out.println("error al validar el apellido del paciente.");
       }

        
        //NIF
        System.out.println("NIF:");
        NIF = p.getNIF();//in.nextLine();
        if(! PacienteException.validarNif(NIF)){
          System.out.println("error al validar el NIF del paciente.");
       }


        //TELEFONO
        System.out.println("Telefono:");
        telefono = p.getTelefono();//in.nextLine();
         if(! PacienteException.validarTelefono(telefono)){
          System.out.println("error al validar el telefono del paciente.");
       }
        
        
        //DIRECCION
        System.out.println("Direccion:");
        direccion = p.getDireccion();//in.nextLine();       
        p.setDireccion(direccion);
       }

    public Utilidades() {
        try {
            this.PACIENTES = new Paciente[]{
                new Paciente(1, "Luis", "Gijon Mondragon", "455566T", "942779900", "C/Menor Mallorca 45667"),
                new Paciente(2, "Ana", "Fervias Baixas", "764898U", "912331188", "C/Ulises Huelva 32457"),
                new Paciente(3, "Bruno", "Barcelona Puig", "899322T", "932432245", "C/Mayor Bilbao 40899"),
                new Paciente(4, "Carla", "Ramirez Dieguez", "0949384Z", "975073211", "C/Percebe Ourense 40978"),
                new Paciente(5, "Ramona", "Perez Montoya", "223832Y", "942779900", "C/Andorra Valencia 85627")};
        } catch (PacienteException ex) {
            System.out.println("Se ha producido una PacienteException." + ex.getMessage());
        }
    }

 

}
