
package trendelrecuerdo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TrenDelRecuerdo {
 
    public static void main(String[] args) throws ParseException  {
        // TODO code application logic here
        SimpleDateFormat fmto=new SimpleDateFormat("dd/MM/yyyy");
        Date fecha_hoy=new Date();
        System.out.println("Fecha Hoy:"+fmto.format(fecha_hoy));
        Date mi_fecha = fmto.parse("01/05/2022");
        System.out.println("Mi Fecha:"+fmto.format(mi_fecha));
        if (fecha_hoy.before(mi_fecha)) {
            System.out.println("tu fecha fue despues del dia de hoy");
        } else {
            System.out.println("tu fecha fue antes del dia de hoy");
        }
    }
    
}
