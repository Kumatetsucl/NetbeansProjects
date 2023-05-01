
package modelo;


public class Habitacion {
    private int nro_habitacion, dormitorios, banos, valor_diario;

    public Habitacion() {
    }

    public Habitacion(int nro_habitacion, int dormitorios, int banos, int valor_diario) {
        this.nro_habitacion = nro_habitacion;
        setDormitorios(dormitorios);
        setBanos(banos);
        setValor_diario(valor_diario);
    }

    

    public int getNro_habitacion() {
        return nro_habitacion;
    }

    public void setNro_habitacion(int nro_habitacion) {
        this.nro_habitacion = nro_habitacion;
    }

    public int getDormitorios() {
        return dormitorios;
    }

    public void setDormitorios(int dormitorios) {
        if (dormitorios>=1 && dormitorios<=4) {
            this.dormitorios = dormitorios;
        } else {
            throw
              new IllegalArgumentException("dormitorios entre 1 y 4");
        }
        
    }

    public int getBanos() {
        return banos;
    }

    public void setBanos(int banos) {
        if (banos>=1 && banos<=3) {
            this.banos = banos;
        } else {
            throw 
              new IllegalArgumentException("banos entre 1 y 3");
        }
        
    }

    public int getValor_diario() {
        return valor_diario;
    }

    public void setValor_diario(int valor_diario) {
        if (valor_diario>30000) {
            this.valor_diario = valor_diario;
        } else {
            throw
              new IllegalArgumentException("valor diario > 30.000");
        }
        
    }

    @Override
    public String toString() {
        return "Habitacion{" + "nro_habitacion=" + nro_habitacion + ", dormitorios=" + dormitorios + ", banos=" + banos + ", valor_diario=" + valor_diario + '}';
    }
    //customer
    /*
    Si posee más de 2 dormitorio será 
    de 10% del valor del arriendo. 
    Si tiene más de dos dormitorios 
    y más de 1 baño será de 15%. De 
    lo contrario un impuesto de 5%.
    */
    public int impuestoHabitacion(){
        if (getDormitorios()>2) {
            if (getBanos()>1) {
                return (int)(getValor_diario()*0.15);
            } else {
                return (int)(getValor_diario()*0.1);
            }
        } else {
            return (int)(getValor_diario()*0.05);
        }
    }
    
    
    
    
    
}
