/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.chadoskyx.utils;

import java.io.BufferedWriter;
import java.io.Serializable;
import java.io.FileWriter;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class ArchivoUtils implements Serializable {

    // Definiremos un nombre que será siempre el mismo
    private static final String NOMBRE_ARCHIVO = "fechas_ingresadas.txt";
    private static final Logger logger = LoggerFactory.getLogger(ArchivoUtils.class);

    private ArchivoUtils() {
        throw new AssertionError();
    }

    /**
     * Agrego líneas de texto a un archivo
     *
     * @param texto Texto a agregar al archivo
     * @return true si se pudo agregar la línea, false en cualquier otro caso
     */
    public static boolean agregarLineas(String texto) {
        boolean ok = false;
        try {
            // Si el texto que ingreso no está vacío lo agrego al archivo
            if (StringUtils.isNotBlank(texto)) {

                String ruta = String.format("%s%s%s",
                        System.getProperty("user.dir"),
                        System.getProperty("file.separator"),
                        NOMBRE_ARCHIVO);

                // FileWriter requiere: la ruta del archivo y si se debe agregar la línea al archivo
                BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
                bw.write(texto);
                bw.newLine();
                bw.close();

                // Si no me he caido, quiere decir que pude escribir bien en el archivo
                ok = true;
            }
        } catch (Exception e) {
            // Si me caigo defino un error en el método.
            ok = false;
            logger.error("Error al guardar línea: {}", e.toString());
            logger.debug("Error al guardar línea: {}", e.toString(), e);
        }
        return ok;
    }
}
