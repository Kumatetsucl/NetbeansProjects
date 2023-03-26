
package Modelo;

import java.util.Date;


public class IngresoBodega {
    private int id_viaje;
    private Proveedor proveedor;
    private Empleado empleado;
    private Productos producto;
    private String direccionInicio;
    private String direccionDestino;
    private boolean IdaYVuelta;
    private Date FechaDeIngreso;

    public IngresoBodega() {
        proveedor = new Proveedor();
        empleado = new Empleado();
        producto = new Productos();
        
    }

    public IngresoBodega(int id_viaje,Proveedor Proveedor, Empleado Empleado, Productos Producto, String direccionInicio, String direccionDestino, boolean IdaYVuelta, Date FechaDeIngreso) {
        this.id_viaje = id_viaje;
        this.proveedor = Proveedor;
        this.empleado = Empleado;
        this.producto = Producto;
        this.direccionInicio = direccionInicio;
        this.direccionDestino = direccionDestino;
        this.IdaYVuelta = IdaYVuelta;
        this.FechaDeIngreso = FechaDeIngreso;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }
   
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor Conductor) {
        this.proveedor = Conductor;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
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

    public Date getFechaDeIngreso() {
        return FechaDeIngreso;
    }

    public void setFechaDeIngreso(Date FechaDeIngreso) {
        this.FechaDeIngreso = FechaDeIngreso;
    }

    @Override
    public String toString() {
        return "Viaje{" + "id_viaje=" + id_viaje + ", conductor=" + proveedor + ", usuario=" + empleado + ", vehiculo=" + producto + ", direccionInicio=" + direccionInicio + ", direccionDestino=" + direccionDestino + ", IdaYVuelta=" + IdaYVuelta + ", FechaDeViaje=" + FechaDeIngreso + '}';
    }

    

    
    
    
    
    
    
}
