
package modelo;

import java.util.ArrayList;


public class Club {
    //atributos
    private String nombre,tecnico,estadio;
    private int torneos_ganados;
    private ArrayList<Jugador> plantilla=new ArrayList<Jugador>() ;
    
    //constructor

    public Club() {
    }

    public Club(String nombre, String tecnico, String estadio, int torneos_ganados) {
        this.nombre = nombre;
        this.tecnico = tecnico;
        this.estadio = estadio;
        this.torneos_ganados = torneos_ganados;
    }
    // get y set

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getTorneos_ganados() {
        return torneos_ganados;
    }

    public void setTorneos_ganados(int torneos_ganados) {
        this.torneos_ganados = torneos_ganados;
    }

    public ArrayList<Jugador> getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(ArrayList<Jugador> plantilla) {
        this.plantilla = plantilla;
    }
    //toString()

    @Override
    public String toString() {
        return "Club{" + "nombre=" + nombre + ", tecnico=" + tecnico + ", estadio=" + estadio + ", torneos_ganados=" + torneos_ganados + ", plantilla=" + plantilla + '}';
    }
    
    // metodos agregar y listar jugadores
    public void addJugador(Jugador jugador){
        plantilla.add(jugador);
    }
    public void listJugadores(){
        for (Jugador item : plantilla) {
            System.out.println(item.toString());
        }
    }
    
}
