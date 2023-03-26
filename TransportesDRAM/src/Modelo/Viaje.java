package Modelo;

import java.util.Date;


public class Viaje {
    private int id_viaje;
    private Conductor conductor;
    private Usuario usuario;
    private Vehiculo vehiculo;
    private String direccionInicio;
    private String direccionDestino;
    private boolean IdaYVuelta;
    private Date FechaDeViaje;

    public Viaje() {
        conductor = new Conductor();
        usuario = new Usuario();
        vehiculo = new Vehiculo();
        
    }

    public Viaje(int id_viaje,Conductor Conductor, Usuario usuario, Vehiculo vehiculo, String direccionInicio, String direccionDestino, boolean IdaYVuelta, Date FechaDeViaje) {
        this.id_viaje = id_viaje;
        this.conductor = Conductor;
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.direccionInicio = direccionInicio;
        this.direccionDestino = direccionDestino;
        this.IdaYVuelta = IdaYVuelta;
        this.FechaDeViaje = FechaDeViaje;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }
   
    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor Conductor) {
        this.conductor = Conductor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getDireccionInicio() {
        return direccionInicio;
    }

    public void setDireccionInicio(String direccionInicio) {
        this.direccionInicio = direccionInicio;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public boolean isIdaYVuelta() {
        return IdaYVuelta;
    }

    public void setIdaYVuelta(boolean IdaYVuelta) {
        this.IdaYVuelta = IdaYVuelta;
    }

    public Date getFechaDeViaje() {
        return FechaDeViaje;
    }

    public void setFechaDeViaje(Date FechaDeViaje) {
        this.FechaDeViaje = FechaDeViaje;
    }

    @Override
    public String toString() {
        return "Viaje{" + "id_viaje=" + id_viaje + ", conductor=" + conductor + ", usuario=" + usuario + ", vehiculo=" + vehiculo + ", direccionInicio=" + direccionInicio + ", direccionDestino=" + direccionDestino + ", IdaYVuelta=" + IdaYVuelta + ", FechaDeViaje=" + FechaDeViaje + '}';
    }

    

    
    
    
    
    
    
}
