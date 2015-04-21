/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.chadoskyx.utils;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class EdadUtils implements Serializable {

    private EdadUtils() {
        throw new AssertionError();
    }

    public static String calcularEdad(Date fechahoy, Date crearFecha) {

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String fechainicio = df.format(fechahoy);
        try {
            fechahoy = df.parse(fechainicio);
        } catch (ParseException ex) {
        }

        String fechafinal = df.format(crearFecha);
        try {
            crearFecha = df.parse(fechafinal);
        } catch (ParseException ex) {
        }

        int years = 0;
        int months = 0;
        int days = 0;

        Calendar birthDay = Calendar.getInstance();
        birthDay.setTimeInMillis(crearFecha.getTime());
        
        long currentTime = System.currentTimeMillis();
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(currentTime);
        
        years = now.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
        int currMonth = now.get(Calendar.MONTH) + 1;
        int birthMonth = birthDay.get(Calendar.MONTH) + 1;
        
        months = currMonth - birthMonth;
        
        if (months < 0) {
            years--;
            months = 12 - birthMonth + currMonth;
            if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
                months--;
            }
        } else if (months == 0 && now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            years--;
            months = 11;
        }
        
        if (now.get(Calendar.DATE) > birthDay.get(Calendar.DATE)) {
            days = now.get(Calendar.DATE) - birthDay.get(Calendar.DATE);
        } else if (now.get(Calendar.DATE) < birthDay.get(Calendar.DATE)) {
            int today = now.get(Calendar.DAY_OF_MONTH);
            now.add(Calendar.MONTH, -1);
            days = now.getActualMaximum(Calendar.DAY_OF_MONTH) - birthDay.get(Calendar.DAY_OF_MONTH) + today;
        } else {
            days = 0;
            if (months == 12) {
                years++;
                months = 0;
            }
        }
        String valor = String.format("%d años %d meses %d dias.", years, months, days);

        return ((String) valor);

    }

}
