package Menues;

import Entidades.Proveedor;
import Entidades.ReferenteProveedor;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import static Menues.Main.listaPro;

public class GestionProveedores {
    Scanner sc;

    boolean running;
    int opcion;

    //constructor
    public GestionProveedores() {
        this.sc = new Scanner(System.in);
        this.opcion = 0;
        this.running = true;

    }

    public void startMenu (){
        //metodo para lanzar el menu de gestion de Proveedores
        int cod;
        String denom, rs;
        ReferenteProveedor refe = new ReferenteProveedor(1,"Juan Perez",
                "jperez@gmail.com","03576485967");
        while (running) {
            System.out.println("___________________________________________________________");
            System.out.println("MENU GESTION DE PROVEEDORES - SGGN - ANDOR S.A.");
            System.out.println("___________________________________________________________");
            System.out.println("1. Agregar Proveedores");
            System.out.println("2. Modificar Proveedores");
            System.out.println("3. Borrar Proveedores");
            System.out.println("4. Listar Proveedores");
            System.out.println("5. Salir");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        //se solicitan los datos para agregar un nuevo Proveedor
                        System.out.println("Ingrese el Codigo del Proveedor");
                        cod = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese La Tipo de proveedor");
                        denom = sc.nextLine();
                        System.out.println("Ingrese La razon Social del proveedor");
                        rs = sc.nextLine();

                        listaPro.add(new Proveedor(cod, denom, rs, refe));
                        System.out.println("Proveedor guardado");
                    }
                    case 2 -> {
                        System.out.println("Caracteristica no desarrollada hasta el momento");
                    }
                    case 3 -> {
                        System.out.println("Caracteristica no desarrollada hasta el momento");
                    }
                    case 4 -> {
                        //Se muestran los proveedores agregados
                        listarPro(listaPro);
                    }
                    case 5 -> {
                        //se vuelve al menu principal
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

    public void listarPro(LinkedList<Proveedor> lista){
        //metodo para listar los proveedores que hay registrados
        System.out.printf("%-8s %-20s %-15s%n","Orden", "Razon Social", "Tipo");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < lista.size(); i++){

            System.out.printf("%-8d %-20s %-15s%n", i+1,lista.get(i).getRazonSocial(), lista.get(i).getTipo());
        }
    }
}
