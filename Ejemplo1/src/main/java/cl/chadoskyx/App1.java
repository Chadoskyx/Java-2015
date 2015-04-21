package cl.chadoskyx;

import cl.chadoskyx.utils.ArchivoUtils;
import cl.chadoskyx.utils.EdadUtils;
import cl.chadoskyx.utils.FechaUtils;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import org.apache.commons.lang3.text.WordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Valery
 */
public class App1 implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(App1.class);
    private static final Locale localeChileno = new Locale("es", "CL");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int dia, mes, anio;
        System.out.println("Introduzca su dia de nacimiento: ");
        dia = in.nextInt();
        System.out.println("ingrese su mes: ");
        mes = in.nextInt();
        System.out.println("ingrese año: ");
        anio = in.nextInt();

        Date crearFecha = FechaUtils.crearFecha(dia, mes, anio);
        String fechaEscrita = FechaUtils.fechaEscrita(crearFecha);
        boolean ok = ArchivoUtils.agregarLineas(fechaEscrita);
        System.out.printf("Fecha: '%s' # Resultado de escribirlo en archivo: '%s'", fechaEscrita, ok);

        Date fechahoy = new Date();
        String texto = FechaUtils.fechaEscrita(fechahoy);
        System.out.println("\nFecha hoy es: " + texto);

        String edad = EdadUtils.calcularEdad(fechahoy, crearFecha);
        System.out.println("La edad en milisegundos: " + edad);

        Calendar now = new GregorianCalendar();
        Calendar nac = new GregorianCalendar(anio, mes, dia);
        

        long anios = now.get(GregorianCalendar.YEAR) - nac.get(GregorianCalendar.YEAR);
        long diff = nac.get(GregorianCalendar.MONTH) - now.get(GregorianCalendar.MONTH);
        long diass = (now.get(GregorianCalendar.DAY_OF_MONTH) - nac.get(GregorianCalendar.DAY_OF_MONTH))+31; //31 dias del mes
        
        System.out.println("La edad es: "+anios+ " años " + diff +" meses "+ diass +" dias");
        logger.info("la fecha '{}' ingresada esta ok", fechaEscrita);

    }

}
