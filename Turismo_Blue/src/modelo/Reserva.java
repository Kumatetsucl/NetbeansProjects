
package modelo;


public class Reserva {
    private int nro_reserva;
    private Pasajero pasajero;
    private Habitacion habitacion;
    private Vehiculo vehiculo;
    private int dias;
    private boolean desayuno;

    public Reserva() {
    }

    public Reserva(int nro_reserva, Pasajero pasajero, Habitacion habitacion, Vehiculo vehiculo, int dias, boolean desayuno) {
        setNro_reserva(nro_reserva);
        this.pasajero = pasajero;
        this.habitacion = habitacion;
        this.vehiculo = vehiculo;
        setDias(dias);
        this.desayuno = desayuno;
    }

    public int getNro_reserva() {
        return nro_reserva;
    }

    public void setNro_reserva(int nro_reserva) {
        int largo = (String.valueOf(nro_reserva)).length();
        if (largo==5) {
            this.nro_reserva = nro_reserva;
        } else {
            throw
             new IllegalArgumentException("reserva laro 5");
        }
        
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        if (dias>=2) {
            this.dias = dias;
        } else {
            throw
              new IllegalArgumentException("dias >= 2");
        }
        
    }

    public boolean isDesayuno() {
        return desayuno;
    }

    public void setDesayuno(boolean desayuno) {
        this.desayuno = desayuno;
    }

    @Override
    public String toString() {
        return "Reserva{" + "nro_reserva=" + nro_reserva + ", pasajero=" + pasajero + ", habitacion=" + habitacion + ", vehiculo=" + vehiculo + ", dias=" + dias + ", desayuno=" + desayuno + '}';
    }
    
}
