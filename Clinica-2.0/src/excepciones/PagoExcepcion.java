/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author DAW109
 */
public class PagoExcepcion extends Exception {

    public PagoExcepcion(String msj) {
        super(msj);
    }

    public static boolean validarImporte(double importe) throws PagoExcepcion {
        boolean importeValido = false;
        if (importe <0) {
            importeValido = false;
            throw new PagoExcepcion("No se puede crear un importe de pago negativo.");
        }

        importeValido = true;
        return importeValido;
    }

    public static boolean validarMetodoDePago(String metp) throws PagoExcepcion {

        boolean metodoValido = false;

        for (int i = 0; i < metp.length(); i++) {

            char c = metp.charAt(i);

            if (Character.isDigit(c)) {
                throw new excepciones.PagoExcepcion("No se permiten digitos en el método de pago.");
            }
            int tamaniometp = metp.length();
            if (tamaniometp < 2) {
                throw new excepciones.PagoExcepcion("El nombre de metodo de pago es demasiado corto");
            }
            if (tamaniometp > 10) {
                throw new excepciones.PagoExcepcion("El nombre de metodo de pago es demaiado largo");
            }
        }

        metodoValido = true;
        return metodoValido;
    }

}
