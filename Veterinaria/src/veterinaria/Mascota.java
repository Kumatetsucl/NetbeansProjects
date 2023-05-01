
package veterinaria;


public class Mascota {
    private String nombre;
    private int chip;
    private int edad;
    private String raza;

    public Mascota() {
    }

    public Mascota(String nombre, int chip, int edad, String raza) {
        this.nombre = nombre;
        this.chip = chip;
        this.edad = edad;
        this.raza = raza;
    }
    // metodos getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getChip() {
        return chip;
    }

    public void setChip(int chip) {
        this.chip = chip;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad>=0 && edad<=20) {
            this.edad = edad;
        } else {
            System.out.println("edad entre 0 y 20");
        }
        
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + nombre + ", chip=" + chip + ", edad=" + edad + ", raza=" + raza + '}';
    }
    
    public String estadoMascota(){
        if (edad>=0 && edad<=3) {
            return "Joven";
        }
        if (edad>=4 && edad<=8) {
            return "Adulto";
        }
        return "Senior";
    }
}
