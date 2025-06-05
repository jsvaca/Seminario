package Menues;

import Entidades.ComplejoIndustrial;
import Entidades.ReferenteCI;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import static Menues.Main.listaCI;

public class GestionCI {
    Scanner sc;

    boolean running;
    int opcion;

    //constructor
    public GestionCI() {
        this.sc = new Scanner(System.in);
        this.running = true;
        this.opcion = 0;
    }

    public void startMenu (){
        //metodo para lanzar el menu de gestion de CI
        int cod;
        String denom, rs, ubi;
        ReferenteCI refe = new ReferenteCI(01,"Juan Perez","jperez@gmail.com",
                "03576485967", 4568);
        while (running) {
            System.out.println("___________________________________________________________");
            System.out.println("MENU GESTION DE COMPLEJOS UNDUSTRIALES - SGGN - ANDOR S.A.");
            System.out.println("___________________________________________________________");
            System.out.println("1. Agregar Complejo Industrial");
            System.out.println("2. Modificar Complejo Industrial");
            System.out.println("3. Borrar Complejo Industrial");
            System.out.println("4. Listar Complejos industriales");
            System.out.println("5. Salir");

            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        //se solicitan los datos para agregar un nuevo CI
                        System.out.println("Ingrese el Codigo del CI");
                        cod = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese La denominación del CI");
                        denom = sc.nextLine();
                        System.out.println("Ingrese La ubicación del CI");
                        ubi = sc.nextLine();
                        System.out.println("Ingrese La razon social del CI");
                        rs = sc.nextLine();
                        //se agrega el nuevo CI a la lista
                        listaCI.add(new ComplejoIndustrial(cod,denom,ubi,rs,refe));
                        System.out.println("CI guardado");
                    }
                    case 2 -> {
                        System.out.println("Caracteristica no desarrollada hasta el momento");
                    }
                    case 3 -> {
                        System.out.println("Caracteristica no desarrollada hasta el momento");
                    }
                    case 4 -> {
                        //Se muestran los CI agregados
                        listarCi(listaCI);
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

    public void listarCi(LinkedList<ComplejoIndustrial> lista){
        //metodo para listar los distintos CI
        System.out.printf("%-8s %-20s %-15s%n","Orden", "Complejo Industrial", "Razon Social");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < lista.size(); i++){

            System.out.printf("%-8d %-20s %-15s%n", i+1,lista.get(i).getDenominacion(), lista.get(i).getRazonSocial());
        }
    }
}
