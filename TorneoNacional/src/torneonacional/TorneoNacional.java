
package torneonacional;

import modelo.Club;
import modelo.Jugador;

public class TorneoNacional {


    public static void main(String[] args) {
        Jugador j1=new Jugador("Peter Veneno", 25, "Del", 7, true, 5);
        Jugador j2=new Jugador("Messi Soto", 25, "Med", 10, true, 50);
        Jugador j3=new Jugador("MBP Junior Sidane Marambio", 15, "Arq", 1, true, 50000);
        
        Club c1=new Club("CDS Real DuocPA", "Guaton Perez", "Frente a la muni", 500);
        c1.addJugador(j1);
        c1.addJugador(j2);
        c1.addJugador(j3);
        
        c1.listJugadores();
        
    }
    
}
