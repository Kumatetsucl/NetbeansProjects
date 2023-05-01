/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinaria;

/**
 *
 * @author DUOC
 */
public class Veterinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dueno dueño=new Dueno();
        dueño.setRut(14257941);
        dueño.setDv('3');
        System.out.println("Resp:"+dueño.validarRut());
    }
    
}
