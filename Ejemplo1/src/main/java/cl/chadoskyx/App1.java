/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.chadoskyx;

import cl.chadoskyx.utils.FechaUtils;
import cl.chadoskyx.utils.NumeroUtils;
import java.util.Date;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Valery
 */
public class App1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //String entrada;
        int dia, mes, anio;
        System.out.println("Introduzca su dia de nacimiento");
        dia = in.nextInt();
        System.out.println("ingrese su mes");
        mes = in.nextInt();
        System.out.println("ingrese año");
        anio = in.nextInt();
        /*entrada = in.next();
        // StringUtils.isNumeric(entrada == true)
        if (NumeroUtils.esNumero(entrada)) {
        System.out.println("Es un numero");
        } else {
        System.out.println("No es numero");
        }*/
        Date crearFecha = FechaUtils.crearFecha(dia, mes, anio);
        String fechaEscrita = FechaUtils.fechaEscrita(crearFecha);
        
        System.out.println(fechaEscrita);
        
    }
}
