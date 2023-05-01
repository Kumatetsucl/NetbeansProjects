
package modelo;

import java.util.Date;


public class Pasaje {
    private int numero,cantidad;
    private String tipo_pasaje;
    private double descuento;
    private Pasajero pasajero;
    private Date fecha_viaje;

    public Pasaje() {
    }

    public Pasaje(int numero, int cantidad, String tipo_pasaje, double descuento, Pasajero pasajero, Date fecha_viaje) {
        this.numero = numero;
        this.cantidad = cantidad;
        setTipo_pasaje(tipo_pasaje);
        this.descuento = descuento;
        this.pasajero = pasajero;
        this.fecha_viaje = fecha_viaje;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo_pasaje() {
        return tipo_pasaje;
    }

    public void setTipo_pasaje(String tipo_pasaje) {
        if (tipo_pasaje.equalsIgnoreCase("Salon_Turista") ||
                tipo_pasaje.equalsIgnoreCase("Primera_Clase") ||
                tipo_pasaje.equalsIgnoreCase("Super_Salon"))
        {
            this.tipo_pasaje = tipo_pasaje;
        } else {
            System.out.println("solo puede ser: Salon_Turista,Primera_Clase,Super_Salon ");
        }
        
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Date getFecha_viaje() {
        return fecha_viaje;
    }

    public void setFecha_viaje(Date fecha_viaje) {
        Date fecha_hoy=new Date();
        if (fecha_viaje.after(fecha_hoy)) {
            this.fecha_viaje = fecha_viaje;
        } else {
            System.out.println("su fecha de viaje tiene ser despues del dia de hoy");
        }
        
    }

    @Override
    public String toString() {
        return "Pasaje{" + "numero=" + numero + ", cantidad=" + cantidad + ", tipo_pasaje=" + tipo_pasaje + ", descuento=" + descuento + ", pasajero=" + pasajero + ", fecha_viaje=" + fecha_viaje + '}';
    }
    //customer
    public int precioPasaje(){
        int valor=0;
        switch (getTipo_pasaje()) {
            case "Salon_Turista":
                valor=23900;
                break;
            case "Primera_Clase":
                valor=29900;
                break;
            default:
                valor=35900;
        }
        int total= getCantidad()*valor;
        return total;
    }
    
}
