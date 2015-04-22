package cl.chadoskyx.utils;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class NumeroUtils implements Serializable {

    // Definimos una clase que nos permitirá almacenar información en archivos de texto (logs)
    private static final Logger logger = LoggerFactory.getLogger(NumeroUtils.class);

    /**
     * Constructor. Las clases utilitarias no se pueden instanciar. Si alguien
     * lo intenta, le enviaremos una excepción.
     */
    private NumeroUtils() {
        throw new AssertionError();
    }

    /**
     * verifica si la entrada es un numero o no
     *
     * @param entrada el texto ingresado por el usuario
     * @return true si es un numero, false en otro caso
     */
    public static boolean esNumero(String entrada) {
        boolean resultado = false;
        try {
            // Esta función determina si el string no es nulo, ni vació, ni tiene espacios o tabuladores
            if (StringUtils.isNotBlank(entrada)) {
                // Determinamos si el string sólo son números
                resultado = StringUtils.isNumeric(entrada);
            }
        } catch (Exception e) {
            // En caso de ocurra un error inesperado, devolveremos false y loguearemos el por qué se cayó
            resultado = false;
            logger.error("Error al determinar si el string es un número: {}", e.toString());
        }
        return resultado;
    }

}
