/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.chadoskyx.utils;

import java.io.Serializable;
import java.io.File;


/**
 *
 * @author Valery Soto Lastra <valery.soto17@gmail.com>
 */
public class ArchivoUtils implements Serializable {
    
    private ArchivoUtils (){
        throw new AssertionError();
    }
    
    public static String crearFichero (String sFichero){
        File fichero = new File (sFichero);
        if (fichero.exists()){
            System.out.println("El fichero existe");
        }
        else{
            System.out.println("El fichero no existe ");
        }
        return sFichero;
    
    }
}