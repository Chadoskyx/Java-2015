/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.chadoskyx.utils;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class FechaUtils implements Serializable {

    private static final Locale localeChileno = new Locale("es", "CL");


    private FechaUtils() {
        throw new AssertionError();
    }

    /**
     *
     * @param dia
     * @param mes
     * @param anio
     * @return
     */
    public static Date crearFecha(int dia, int mes, int anio) {
        Date fecha = null;

        Calendar calendario = new GregorianCalendar();
        calendario.set(Calendar.DAY_OF_MONTH, dia);
        calendario.set(Calendar.MONTH, mes - 1);
        calendario.set(Calendar.YEAR, anio);

        // Seteamos las 0 horas
        calendario.set(Calendar.HOUR, 0);
        calendario.set(Calendar.MINUTE, 0);
        calendario.set(Calendar.SECOND, 0);
        calendario.set(Calendar.MILLISECOND, 0);

        fecha = calendario.getTime();

        return fecha;
    }

    /**
     *
     * @param fecha
     * @return
     */
    public static String fechaEscrita(Date fecha) {
        String texto = StringUtils.EMPTY;
        if (fecha != null) {
            DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, localeChileno);
            texto = WordUtils.capitalize(df.format(fecha));
        }

        return texto;
    }

}
