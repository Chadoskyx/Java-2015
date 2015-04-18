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

/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class EdadUtils implements Serializable {

    private EdadUtils() {
        throw new AssertionError();
    }
    
public static String calcularEdad(Date fechahoy, Date crearFecha){
    
    DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
    String fechainicio = df.format(fechahoy);
    try{
        fechahoy = df.parse(fechainicio);
    }
    catch(ParseException ex){
    }
    
    String fechafinal = df.format(crearFecha);
    try{
        crearFecha = df.parse(fechafinal);
    }
    catch(ParseException ex){
    }
    
    long fechainicioMs = fechahoy.getTime();
    long fechafinalMs = crearFecha.getTime();
    final long MILLSECS_PER_DAY = 24*60*60*1000;
    long diferencia = ((fechainicioMs - fechafinalMs)/MILLSECS_PER_DAY);
    //double dias = Math.floor(diferencia/(24*60*60*1000));
    //int edadreal = (int) (Math.floor(dias/(365));
    //int mesreal = 
    String edad = Integer.toString((int) diferencia);
    
    return ((String) edad);
}

}