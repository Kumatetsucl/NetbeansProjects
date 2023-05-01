package aplicacionmusica;

public class Cancion {

    private String titulo;
    private Artista artista;
    private int duracion;
    private boolean favorita, descarga;

    public Cancion() {
    }

    public Cancion(String titulo, Artista artista, int duracion, boolean favorita, boolean descarga) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
        this.favorita = favorita;
        this.descarga = descarga;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public void setFavorita(boolean favorita) {
        this.favorita = favorita;
    }

    public boolean isDescarga() {
        return descarga;
    }

    public void setDescarga(boolean descarga) {
        this.descarga = descarga;
    }

    @Override
    public String toString() {
        return "Cancion{" + "titulo=" + titulo + ", artista=" + artista + ", duracion=" + duracion + ", favorita=" + favorita + ", descarga=" + descarga + '}';
    }

    public int adelantar(int segundos) {
        if (getDuracion() > segundos) {
            int restante = getDuracion() - segundos;
            return restante;
        } else {
            return 0;
        }
    }
    
    public void imprimir(){
        System.out.println("Titulo:"+getTitulo());
        System.out.println("Artista:"+getArtista().getNombre());
        int minutos = getDuracion() / 60;
        int segundos = getDuracion() % 60;
        System.out.println("Duracion:"+minutos+":"+segundos);
    }
    public String imprimir2(){
        int m = getDuracion() / 60;
        int s = getDuracion() % 60;
        return "Titulo:"+getTitulo()+
                "\n Artista:"+getArtista().getNombre()+
                "\n Duracion:"+m+":"+s;
    }
    public String duracionCancion(){
        if (getDuracion()>=300) {
            return "larga";
        } else {
            return "corta";
        }
    }
}
