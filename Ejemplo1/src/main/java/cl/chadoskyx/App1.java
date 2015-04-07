/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.chadoskyx;
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
        String entrada;
        System.out.println("Inrtroduce un texto");
        entrada = in.next();
       // StringUtils.isNumeric(entrada == true)
        if(StringUtils.isNumeric(entrada) == true){
            System.out.println("Es un numero");
        } else {
                    System.out.println("No es numero");

        }
        
    }
}

