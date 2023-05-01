
package veterinaria;


public class Dueno {
    private int rut,celular;
    private String nombre,direccion;
    private char dv;

    public Dueno() {
    }

    public Dueno(int rut, int celular, String nombre, String direccion, char dv) {
        this.rut = rut;
        this.celular = celular;
        this.nombre = nombre;
        this.direccion = direccion;
        this.dv = dv;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        int largo = String.valueOf(rut).length();
        if (largo==7 || largo==8) {
            this.rut = rut;
        } else {
            System.out.println("largo rut de 7 u 8");
        }
        
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        int largo = String.valueOf(celular).length();
        if (largo==8) {
            this.celular = celular;
        } else {
            System.out.println("largo celu debe ser de 8");
        }   
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        int largo = nombre.length();
        if (largo>=2) {
            this.nombre = nombre;
        } else {
            System.out.println("nombre largo min.2");
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    @Override
    public String toString() {
        return "Dueno{" + "rut=" + rut + ", celular=" + celular + ", nombre=" + nombre + ", direccion=" + direccion + ", dv=" + dv + '}';
    }
    
    public boolean validarRut(){
        String elRut = String.valueOf(rut);
        int factor=3;
        int suma=0;
        for (int i = 0; i < elRut.length(); i++) {
            char caracter= elRut.charAt(i);
            //System.out.println(caracter+ " x "+factor);
            suma= suma + ( Integer.parseInt(String.valueOf(caracter))*factor);
            factor=factor-1;
            if (factor==1) {
                factor=7;
            }
        }
        //System.out.println("Suma:"+suma);
        int residuo = suma % 11;
        int elDv = 11-residuo;
        //System.out.println("DV:"+elDv);
        char digito = String.valueOf(elDv).charAt(0);
        if (elDv>9) {
            if (elDv==10) {
                digito='K';
            } else {
                digito='0';
            }
        }
        if (dv==digito) {
            return true;
        } else {
            return false;
        }
    }
}
