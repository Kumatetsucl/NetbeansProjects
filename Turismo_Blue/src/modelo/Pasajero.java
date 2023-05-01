
package modelo;

public class Pasajero {
    private String nombre;
    private int edad;
    private String nacionalidad;
    private char tipo_pasajero;

    public Pasajero() {
    }

    public Pasajero(String nombre, int edad, String nacionalidad, char tipo_pasajero) {
        this.nombre = nombre;
        setEdad(edad);
        setNacionalidad(nacionalidad);
        setTipo_pasajero(tipo_pasajero);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad>=18) {
           this.edad = edad; 
        } else {
            throw
              new IllegalArgumentException("edad > a 18");
        }
        
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        if (nacionalidad.equalsIgnoreCase("chilena") ||
            nacionalidad.equalsIgnoreCase("extranjero")
            ) 
        {
            this.nacionalidad = nacionalidad;
        } else {
            throw
              new IllegalArgumentException("solo chilena o extranjero");
        }
        
    }

    public char getTipo_pasajero() {
        return tipo_pasajero;
    }

    public void setTipo_pasajero(char tipo_pasajero) {
        if (tipo_pasajero=='F' || tipo_pasajero=='O') {
            this.tipo_pasajero = tipo_pasajero;
        } else {
            throw
              new IllegalArgumentException("tipo pasajero solo F / O");
        }
        
    }

    @Override
    public String toString() {
        return "Pasajero{" + "nombre=" + nombre + ", edad=" + edad + ", nacionalidad=" + nacionalidad + ", tipo_pasajero=" + tipo_pasajero + '}';
    }
 
    //customer
    public void listarDatoPasajero(){
        System.out.println("DATOS DEL PASAJERO");
        System.out.println("Nombre:"+getNombre());
        System.out.println("Nacionalidad:"+getNacionalidad());
        System.out.println("Tipo:"+(getTipo_pasajero()=='F'?"Frecuente":"Ocasional"));
        System.out.println("Edad:"+(getEdad()<35?"Joven":"Adulto"));
        
    }
    
    
    
}
