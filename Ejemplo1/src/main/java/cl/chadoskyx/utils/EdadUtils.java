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
    
    long fechainicioMs = fechahoy.getTime(); //fecha en milisegundos
    long fechafinalMs = crearFecha.getTime();//fecha en milisegundos
    long intervalo = fechainicioMs - fechafinalMs;
    long aniohoy = (((intervalo)/3600000*24*365));
    long intervalo2 = (intervalo - aniohoy);
    long meseshoy = (((intervalo)/3600000*24*30)-intervalo2);
    long intervalo3 = (intervalo2 - meseshoy);
    long dias = (((intervalo)/3600000 * 24)- intervalo3);
    
    String valor = String.format("%d %d %d", aniohoy, meseshoy, dias);
    
        
    return ((String) valor);
    
    
    
}

}