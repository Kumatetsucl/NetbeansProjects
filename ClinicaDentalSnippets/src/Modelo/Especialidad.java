
package Modelo;


public class Especialidad {
    private int codigo;
    private String Descripcion;

    public Especialidad() {
    }

    public Especialidad(int codigo, String Descripcion) {
        this.codigo = codigo;
        this.Descripcion = Descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "codigo=" + codigo + ", Descripcion=" + Descripcion + '}';
    }

    
    
    
    
    
    
    
    
    
}
