package cl.chadoskyx.utils;

import java.io.Serializable;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class ValidaUtils implements Serializable {

    // Definimos una clase que nos permitirá almacenar información en archivos de texto (logs)
    private static final Logger logger = LoggerFactory.getLogger(ValidaUtils.class);

    /**
     * Constructor. Las clases utilitarias no se pueden instanciar. Si alguien
     * lo intenta, le enviaremos una excepción.
     */
    private ValidaUtils() {
        throw new AssertionError();
    }

    /**
     * Crear un Mensaje hasta que se ingrese un valor válido
     *
     * @param label Texto que se mostrará en pantalla
     * @return Un valor boolean
     */
    public static boolean entradaBooleana(String label) {
        boolean error = false;

        Boolean test = null;
        // Vamos a iterar hasta que el usuario entregue un valor válido (en este caso un boolean)
        while (test == null) {
            try {
                // Elimina cualquier cosa que quede en la salida
                System.out.flush();
                // crea el objeto que escanea el teclado
                Scanner scanner = new Scanner(System.in);

                // mostramos el mensaje en pantalla, si me caigo lo vuelvo a mostrar las veces que sean necesarias
                System.out.print(String.format("\n%s", label));

                // trata de capturar la salida
                test = scanner.nextBoolean();
            } catch (Exception e) {
                // Cualquier excepción hará que el bucle se repita
                test = null;
                logger.error("Error al parsear valor: {}", e.toString());
            }
        }
        // Si salimos del while quiere decir que tenemos un booleano válido;
        error = test;
 
        // Lo retornamos
        return error;
    }
    
    /**
     * Crear un Mensaje hasta que se ingrese un valor válido
     *
     * @param label Texto que se mostrará en pantalla
     * @return Un valor Entero
     */
    public static Integer entradaEntera(String label) {
        Integer numero = null;
        // @TODO Hay que crear el cuerpo del método.
        return numero;
    }
}
