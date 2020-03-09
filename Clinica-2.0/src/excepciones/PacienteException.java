/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author Alberto
 */
public class PacienteException extends Exception {

    public PacienteException(String mensaje) {
        super(mensaje);
    }

    public static boolean validarNombre(String nombre) throws PacienteException{
        boolean nombreValido=false;
        
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (Character.isDigit(c)) {
                nombreValido=false;
                throw new PacienteException("No se permiten digitos en el nombre");
            }
            int tamanhoNombre = nombre.length();
            if (tamanhoNombre < 2) {
                nombreValido=false;
                throw new PacienteException("Demasiado corto.");
            }
            if (tamanhoNombre > 10) {
                nombreValido=false;
                throw new PacienteException("Demasiado largo");
            }
        }
        nombreValido=true;
        return nombreValido;
    }
    
    public static boolean validarApellido(String apellidos) throws PacienteException{
        boolean apellidoValido=false;   
        
        for (int i = 0; i < apellidos.length(); i++) {
            char c = apellidos.charAt(i);
            if (Character.isDigit(c)) {
                throw new PacienteException("No se permiten digitos en el apellido");
            }
        }
        apellidoValido=true;
        return apellidoValido;
        
    }
       
    public static boolean validarNif(String NIF) throws PacienteException{
        boolean nifValido=false;
        NIF = NIF.toUpperCase();
                              
                for (int i = 0; i < NIF.length() - 1; i++) {
            char c = NIF.charAt(i);
            if (Character.isLetter(c)) {
                throw new PacienteException("No se permiten letras en el NIF");
            }
            int tamanhoNIF = NIF.length();            
            if (tamanhoNIF != 9) {
                throw new PacienteException("8 numeros y 1 letra");               
            }
                       
        }
        nifValido=true;
        return nifValido;
    }
    
    public static boolean validarTelefono(String telefono) throws PacienteException{
        boolean telefonoValido=false;
    
        for (int i = 0; i < telefono.length(); i++) {
            char c = telefono.charAt(i);
            if (Character.isLetter(c)) {
                throw new PacienteException("No se permiten letras en el telefono");
            }
            int tamanhoTelefono = telefono.length();
            if (tamanhoTelefono > 9) {
                throw new PacienteException("Demasiado largo");
            }
            if (tamanhoTelefono < 9) {
                throw new PacienteException("Demasiado corto");
            }
        }
         telefonoValido=true;
        return telefonoValido;
}
    
}