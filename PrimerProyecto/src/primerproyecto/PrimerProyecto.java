package primerproyecto;

import java.util.Scanner;

public class PrimerProyecto {

    public static void main(String[] args) {
        boolean ciclo = true;
        while (ciclo) {
            try {
                System.out.println("Menu Principal");
                System.out.println("1) Ingresar Ticket");
                System.out.println("2) Listar Ticket");
                System.out.println("3) Salir");
                System.out.println("Seleccione (1-3):");
                // declarar un objeto
                Scanner teclado;
                // instanciar un objeto
                teclado = new Scanner(System.in);
                int opcion;
                opcion = teclado.nextInt();
                System.out.println("selecciono:" + opcion);
                if (opcion >= 1 && opcion <= 3) {
                    switch (opcion) {
                        case 1:
                            //ingresa ticket
                            ingresarTicket();
                            break;
                        case 2:
                            // listar ticket
                            break;
                        case 3:
                            ciclo = false;
                            break;
                    }

                } else {
                    System.out.println("seleccione numero correcto");
                }
            } catch (Exception e) {
                System.out.println("error");
            }
        }

    }

    private static void ingresarTicket() {
        System.out.println("Ingrese ticket");

        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingrese Rut:");
        int rut = teclado.nextInt();
        System.out.println("Ingrese Asiento:");
        int asiento = teclado.nextInt();
        System.out.println("Ingrese Valor:");
        int valor = teclado.nextInt();
        System.out.println("Ingrese Nombre:");
        String nombre = teclado.next();
        try {
            // crear un objeto
            Ticket entrada;
            // instanciar
            entrada = new Ticket();            
            entrada.setRut(rut);            
            entrada.setNombre(nombre);
            entrada.setNumeroAsiento(asiento);
            entrada.setValor(valor);
            // retornar los datos del objeto
            System.out.println("Los datos son:" + entrada.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
