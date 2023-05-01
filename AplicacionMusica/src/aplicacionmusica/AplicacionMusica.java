
package aplicacionmusica;


public class AplicacionMusica {

 
    public static void main(String[] args) {
        // TODO code application logic here
        Artista zalo=new Artista("zalo reyes", "romantico", 69);
        Cancion c1=new Cancion("ramito de violetas", zalo, 130, true, false);
        Cancion c2=new Cancion();
        c2.setTitulo("prisionera");
        c2.setArtista(zalo);
        c2.setDuracion(300);
        c2.setFavorita(true);
        c2.setDescarga(true);
        System.out.println("Cancion 1:"+c1.toString());
        System.out.println("Cancion 2:"+c2.toString());
        //utilizar custoner
        c1.imprimir();
        System.out.println(c1.imprimir2());
        System.out.println("Duracion:"+c1.duracionCancion());
        System.out.println("Resta de la Cancion:"+c1.adelantar(50));
    }
    
}
