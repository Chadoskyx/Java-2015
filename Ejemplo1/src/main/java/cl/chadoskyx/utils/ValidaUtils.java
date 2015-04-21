/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.chadoskyx.utils;

import java.io.Serializable;
import java.util.Scanner;


/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class ValidaUtils implements Serializable {
    private static Object scan;

    public static void errorEntrada(int dia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ValidaUtils() {
        throw new AssertionError();
    }




public static boolean errorEntrada(String entrada){
    boolean error = false;
    while(!error){
    try{
    entrada = scan.nextlnt();
    error = true;
    }catch(Exception ex){
    System.out.println("No esta ingresando un numero, intente otra vez");
    }
    }
    System.out.println("Ingreso un numero ok!");
    return error;
}
}