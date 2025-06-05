package Menues;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionCuencas {
    Scanner sc;

    boolean running;
    int opcion;

    public GestionCuencas() {
        this.sc = new Scanner(System.in);
        this.running = true;
        this.opcion = 0;
    }

    public void startMenu (){

        while (running) {
            System.out.println("___________________________________________________________");
            System.out.println("MENU GESTION DE CUENCAS - SGGN - ANDOR S.A.");
            System.out.println("___________________________________________________________");
            System.out.println("1. Agregar Cuenca");
            System.out.println("2. Modificar Cuenca");
            System.out.println("3. Borrar Cuenca");
            System.out.println("4. Listar Cuencas");
            System.out.println("5. Salir");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                    }
                    case 2 -> {
                    }
                    case 3 -> {
                    }
                    case 4 -> {
                    }
                    case 5 -> {
                        System.out.println("Gracias por utilizar el programa");
                        running = false;
                    }
                    default -> System.out.println("Opción no valida por favor intente nuevamente");
                }
            } catch (InputMismatchException e) {
                System.out.println("La opción ingresada no es un número");
                sc.nextLine();
            }
        }
    }
}
