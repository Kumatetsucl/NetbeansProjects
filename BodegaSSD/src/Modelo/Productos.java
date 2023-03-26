package Modelo;

public class Productos {
    private int IdVehiculo;
    private String ChasisVehiculo;
    private String PatenteVehiculo;
    private int AnoFabricacion;
    private String MarcaVehiculo;
    private String ModeloVehiculo;

    public Productos() {
    }
    
    public Productos(int IdVehiculo,String ChasisVehiculo, String PatenteVehiculo, int AnoFabricacion, String MarcaVehiculo, String ModeloVehiculo) {
        this.IdVehiculo = IdVehiculo;
        this.ChasisVehiculo = ChasisVehiculo;
        this.PatenteVehiculo = PatenteVehiculo;
        this.AnoFabricacion = AnoFabricacion;
        this.MarcaVehiculo = MarcaVehiculo;
        this.ModeloVehiculo = ModeloVehiculo;
    }

    public int getIdVehiculo() {
        return IdVehiculo;
    }

    public void setIdVehiculo(int IdVehiculo) {
        this.IdVehiculo = IdVehiculo;
    }

    
    public String getChasisVehiculo() {
        return ChasisVehiculo;
    }

    public void setChasisVehiculo(String ChasisVehiculo) {
        this.ChasisVehiculo = ChasisVehiculo;
    }

    public String getPatenteVehiculo() {
        return PatenteVehiculo;
    }

    public void setPatenteVehiculo(String PatenteVehiculo) {
        this.PatenteVehiculo = PatenteVehiculo;
    }

    public int getAnoFabricacion() {
        return AnoFabricacion;
    }

    public void setAnoFabricacion(int AnoFabricacion) {
        this.AnoFabricacion = AnoFabricacion;
    }

    public String getMarcaVehiculo() {
        return MarcaVehiculo;
    }

    public void setMarcaVehiculo(String MarcaVehiculo) {
        this.MarcaVehiculo = MarcaVehiculo;
    }

    public String getModeloVehiculo() {
        return ModeloVehiculo;
    }

    public void setModeloVehiculo(String ModeloVehiculo) {
        this.ModeloVehiculo = ModeloVehiculo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "IdVehiculo=" + IdVehiculo + ", ChasisVehiculo=" + ChasisVehiculo + ", PatenteVehiculo=" + PatenteVehiculo + ", AnoFabricacion=" + AnoFabricacion + ", MarcaVehiculo=" + MarcaVehiculo + ", ModeloVehiculo=" + ModeloVehiculo + '}';
    }


    
}
