
package modelo;


public class Vehiculo {
    private String patente, marca, modelo;
    private int ano, valor_diario;

    public Vehiculo() {
    }

    public Vehiculo(String patente, String marca, String modelo, int ano, int valor_diario) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAno(ano);
        setValor_diario(valor_diario);
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        int largo = patente.length();
        if (largo==6) {
           this.patente = patente; 
        } else {
            throw
              new IllegalArgumentException("patente largo 6");
        }
        
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca.equalsIgnoreCase("nissan") || 
            marca.equalsIgnoreCase("kia") ||
            marca.equalsIgnoreCase("chevrolet")    
            ) 
        {
            this.marca = marca;
        } else {
            throw 
              new IllegalArgumentException("marcas solo nissan, kia, chevrolet");
        }
        
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        if (modelo.equalsIgnoreCase("suv") || 
            modelo.equalsIgnoreCase("automovil") ||
            modelo.equalsIgnoreCase("hatchback")   
            ) 
        {
            this.modelo = modelo;
        } else {
            throw
              new IllegalArgumentException("modelo solo suv, automovil, hatchback");
        }
        
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano>=2000 && ano<=2022) {
           this.ano = ano; 
        } else {
            throw
             new IllegalArgumentException("año entre 2000 y 2022");
        }
        
    }

    public int getValor_diario() {
        return valor_diario;
    }

    public void setValor_diario(int valor_diario) {
        if (valor_diario>20000) {
           this.valor_diario = valor_diario; 
        } else {
            throw 
              new IllegalArgumentException("valor diario > 20.000");
        }
        
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "patente=" + patente + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", valor_diario=" + valor_diario + '}';
    }
    
    
}
