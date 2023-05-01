
package modelo;

public class Pasajero {
    private String rut,nombre;
    private char sexo;
    private int fono;

    public Pasajero() {
    }

    public Pasajero(String rut, String nombre, char sexo, int fono) {
        this.rut = rut;
        this.nombre = nombre;
        setSexo(sexo);
        this.fono = fono;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo=='F' || sexo=='M') {
            this.sexo = sexo;
        } else {
            System.out.println("sexo solo F o M");
        }
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }
    //curtomer
    public void listadoPasajero(){
        System.out.println("Datos Pasajeros");
        System.out.println("Nombre:"+getNombre()+"/Rut:"
                +getRut()+"/Sexo"+(getSexo()=='F'?"Femenino":"Masculino"));
    }
    
    
}
