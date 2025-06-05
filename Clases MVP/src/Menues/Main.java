package Menues;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Entidades.ComplejoIndustrial;
import Entidades.Contrato;
import Entidades.Proveedor;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    //Listas enlazadas para simular la base de datos para este prototipo
    public static LinkedList<ComplejoIndustrial> listaCI = new LinkedList<>();
    public static LinkedList<Proveedor> listaPro = new LinkedList<>();
    public static LinkedList<Contrato> listaCont = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        int opcion = 0;
        //Menu principal del sistema, no todas las funcionalidades estan implementadas
        while (running){
            System.out.println("____________________________________");
            System.out.println("MENU PRINCIPAL - SGGN - ANDOR S.A.");
            System.out.println("____________________________________");
            System.out.println("1. Gestión de Complejos industriales" );
            System.out.println("2. Gestión de Proveedores");
            System.out.println("3. Gestión de Cuencas");
            System.out.println("4. Gestión de Contratos");
            System.out.println("5. Gestión de Nominaciones" );
            System.out.println("6. Salir");

            try {
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1 -> {
                        //lleva al menu para la gestion de los CI
                        GestionCI gci = new GestionCI();
                        gci.startMenu();
                    }
                    case 2 -> {
                        //LLeva al menu para la gestion de los proveedores
                        GestionProveedores gpro = new GestionProveedores();
                        gpro.startMenu();
                    }
                    case 3 -> {
                        //lleva al menu para la gestion de las cuencas
                        GestionCuencas gccuenca = new GestionCuencas();
                        gccuenca.startMenu();
                    }
                    case 4 -> {
                        //lleva al menu para la gestion de los contratos
                        GestionContratos gcont = new GestionContratos();
                        gcont.startMenu();
                    }
                    case 5 -> {
                        //lleva al menu para la gestion de las nominaciones
                        GestionNominaciones gnom = new GestionNominaciones();
                        gnom.startMenu();
                    }
                    case 6 -> {
                        //opcion para la salida del programa
                        System.out.println("Gracias por utilizar el programa");
                        running = false;
                    }
                    default -> System.out.println("Opción no valida por favor intente nuevamente");
                }
            }catch (InputMismatchException e){
                System.out.println("La opción ingresada no es un número");
                scanner.nextLine();
            }
        }
    }
}
