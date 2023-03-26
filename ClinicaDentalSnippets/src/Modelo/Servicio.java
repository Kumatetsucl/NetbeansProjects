
package Modelo;

import Enumeradores.EnumServicio;


public class Servicio {
    private EnumServicio Servicio;
    private int ValorServicio;

    public Servicio() {
    }

    public Servicio(EnumServicio Servicio, int ValorServicio) {
        this.Servicio = Servicio;
        this.ValorServicio = ValorServicio;
    }

    public EnumServicio getServicio() {
        return Servicio;
    }

    public int getValorServicio() {
        return ValorServicio;
    }

    public void setServicio(EnumServicio Servicio) {
        this.Servicio = Servicio;
    }

    public void setValorServicio(int ValorServicio) {
        this.ValorServicio = ValorServicio;
    }

    @Override
    public String toString() {
        return "Servicio{" + "Servicio=" + Servicio + ", ValorServicio=" + ValorServicio + '}';
    }

    
    
}
