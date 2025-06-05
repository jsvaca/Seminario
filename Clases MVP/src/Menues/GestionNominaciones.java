package Menues;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionNominaciones {
    Scanner sc;

    boolean running;
    int opcion;

    public GestionNominaciones() {
        this.sc = new Scanner(System.in);
        this.running = true;
        this.opcion = 0;
    }

    public void startMenu (){

        while (running) {
            System.out.println("___________________________________________________________");
            System.out.println("MENU GESTION DE NOMINACIONES - SGGN - ANDOR S.A.");
            System.out.println("___________________________________________________________");
            System.out.println("1. Agregar Nominación");
            System.out.println("2. Modificar Nominación");
            System.out.println("3. Borrar Nominación");
            System.out.println("4. Listar nominaciones");
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
