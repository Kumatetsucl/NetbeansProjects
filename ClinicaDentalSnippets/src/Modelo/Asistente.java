
package Modelo;


public class Asistente extends Persona{
    private int IdAsistente;
    private int Sueldo;

    public Asistente() {
    }

    public Asistente(int IdAsistente, int Sueldo, String nombre, int num_rut, String Direccion, int celular) {
        super(nombre, num_rut, Direccion, celular);
        this.IdAsistente = IdAsistente;
        this.Sueldo = Sueldo;
    }

    public int getIdAsistente() {
        return IdAsistente;
    }

    public void setIdAsistente(int IdAsistente) {
        this.IdAsistente = IdAsistente;
    }

    public int getSueldo() {
        return Sueldo;
    }

    public void setSueldo(int Sueldo) {
        this.Sueldo = Sueldo;
    }

    @Override
    public String toString() {
        return super.toString()+"Asistente{" + "IdAsistente=" + IdAsistente + ", Sueldo=" + Sueldo + '}';
    }
    

    @Override
    public String mensaje() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
}
