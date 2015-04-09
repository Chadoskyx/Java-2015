package cl.chadoskyx.utils;

import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class NumeroUtils implements Serializable {

    private NumeroUtils() {
        throw new AssertionError();
    }

    /**
     * verifica si la entrada es un numero o no
     * @param entrada el texto ingresado por el usuario
     * @return true si es un numero, false en otro caso
     */
    public static boolean esNumero(String entrada) {
        boolean resultado = false;

        if (StringUtils.isNotBlank(entrada)) {
            resultado = StringUtils.isNumeric(entrada);
        }

        return resultado;
    }
    
    
}
