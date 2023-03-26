package Modelo;

import java.util.Date;

public class Atencion {
    
    private int Id_atencion;
    private int IdPaciente;
    private int NumRutPaciente;
    private String NombrePaciente;
    private String DireccionPaciente;
    private String PrevisionPaciente;
    private int IdDoctor;
    private int numRutDoctor;
    private String NombreDoctor;
    private String EspecialidadDoctor;
    private int IdAsistente;
    private int RutAsistente;
    private String NombreAsistente;
    private int IdServicio;
    private String DescripcionServicio;
    private int ValorServicio;
    private Date fechaAtencion;
    

    public Atencion() {          
    }

    public Atencion(int IdServicio, String DescripcionServicio) {
        this.IdServicio = IdServicio;
        this.DescripcionServicio = DescripcionServicio;
    }

    public Atencion(int Id_atencion, int IdPaciente, int NumRutPaciente, String NombrePaciente, String DireccionPaciente, String PrevisionPaciente, int IdDoctor, int numRutDoctor, String NombreDoctor, String EspecialidadDoctor, int IdAsistente, int RutAsistente, String NombreAsistente, int IdServicio, String DescripcionServicio, int ValorServicio, Date fechaAtencion) {
        this.Id_atencion = Id_atencion;
        this.IdPaciente = IdPaciente;
        this.NumRutPaciente = NumRutPaciente;
        this.NombrePaciente = NombrePaciente;
        this.DireccionPaciente = DireccionPaciente;
        this.PrevisionPaciente = PrevisionPaciente;
        this.IdDoctor = IdDoctor;
        this.numRutDoctor = numRutDoctor;
        this.NombreDoctor = NombreDoctor;
        this.EspecialidadDoctor = EspecialidadDoctor;
        this.IdAsistente = IdAsistente;
        this.RutAsistente = RutAsistente;
        this.NombreAsistente = NombreAsistente;
        this.IdServicio = IdServicio;
        this.DescripcionServicio = DescripcionServicio;
        this.ValorServicio = ValorServicio;
        this.fechaAtencion = fechaAtencion;
    }
    
    

    public Atencion(int Id_atencion, int ValorServicio, int IdDoctor, int IdPaciente, int IdAsistente, int IdServicio, Date fechaAtencion) {
        this.Id_atencion = Id_atencion;
        this.ValorServicio = ValorServicio;
        this.IdDoctor = IdDoctor;
        this.IdPaciente = IdPaciente;
        this.IdAsistente = IdAsistente;
        this.IdServicio = IdServicio;
        this.fechaAtencion = fechaAtencion;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    
    
    public int getRutAsistente() {
        return RutAsistente;
    }

    public void setRutAsistente(int RutAsistente) {
        this.RutAsistente = RutAsistente;
    }

    public String getNombreAsistente() {
        return NombreAsistente;
    }

    public void setNombreAsistente(String NombreAsistente) {
        this.NombreAsistente = NombreAsistente;
    }
    
    public int getIdDoctor() {
        return IdDoctor;
    }

    public void setIdDoctor(int IdDoctor) {
        this.IdDoctor = IdDoctor;
    }

    public int getIdPaciente() {
        return IdPaciente;
    }

    public void setIdPaciente(int IdPaciente) {
        this.IdPaciente = IdPaciente;
    }

    public int getIdAsistente() {
        return IdAsistente;
    }

    public void setIdAsistente(int IdAsistente) {
        this.IdAsistente = IdAsistente;
    }

    public int getIdServicio() {
        return IdServicio;
    }

    public void setIdServicio(int IdServicio) {
        this.IdServicio = IdServicio;
    }

    public String getEspeciaidadDoctor() {
        return EspecialidadDoctor;
    }

    public void setEspecialidadDoctor(String EspeciaidadDoctor) {
        this.EspecialidadDoctor = EspeciaidadDoctor;
    }

    public int getNumRutPaciente() {
        return NumRutPaciente;
    }

    public void setNumRutPaciente(int NumRutPaciente) {
        this.NumRutPaciente = NumRutPaciente;
    }

    public int getId_atencion() {
        return Id_atencion;
    }

    public void setId_atencion(int Id_atencion) {
        this.Id_atencion = Id_atencion;
    }

    public String getNombrePaciente() {
        return NombrePaciente;
    }

    public void setNombrePaciente(String NombrePaciente) {
        this.NombrePaciente = NombrePaciente;
    }

    public String getDireccionPaciente() {
        return DireccionPaciente;
    }

    public void setDireccionPaciente(String DireccionPaciente) {
        this.DireccionPaciente = DireccionPaciente;
    }

    public String getPrevisionPaciente() {
        return PrevisionPaciente;
    }

    public void setPrevisionPaciente(String PrevisionPaciente) {
        this.PrevisionPaciente = PrevisionPaciente;
    }

    public String getNombreDoctor() {
        return NombreDoctor;
    }

    public void setNombreDoctor(String NombreDoctor) {
        this.NombreDoctor = NombreDoctor;
    }

    public int getNumRutDoctor() {
        return numRutDoctor;
    }

    public void setNumRutDoctor(int numRutDoctor) {
        this.numRutDoctor = numRutDoctor;
    }

    public String getDescripcionServicio() {
        return DescripcionServicio;
    }

    public void setDescripcionServicio(String DescripcionServicio) {
        this.DescripcionServicio = DescripcionServicio;
    }

    public int getValorServicio() {
        return ValorServicio;
    }

    public void setValorServicio(int ValorServicio) {
        this.ValorServicio = ValorServicio;
    }

    @Override
    public String toString() {
        return "Atencion{" + "Id_atencion=" + Id_atencion + ", IdPaciente=" + IdPaciente + ", NumRutPaciente=" + NumRutPaciente + ", NombrePaciente=" + NombrePaciente + ", DireccionPaciente=" + DireccionPaciente + ", PrevisionPaciente=" + PrevisionPaciente + ", IdDoctor=" + IdDoctor + ", numRutDoctor=" + numRutDoctor + ", NombreDoctor=" + NombreDoctor + ", EspecialidadDoctor=" + EspecialidadDoctor + ", IdAsistente=" + IdAsistente + ", RutAsistente=" + RutAsistente + ", NombreAsistente=" + NombreAsistente + ", IdServicio=" + IdServicio + ", DescripcionServicio=" + DescripcionServicio + ", ValorServicio=" + ValorServicio + ", fechaAtencion=" + fechaAtencion + '}';
    }

    

    
    
    
    
    

    
}
