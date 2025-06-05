package Menues;

import Entidades.ComplejoIndustrial;
import Entidades.Contrato;
import Entidades.Proveedor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import static Menues.Main.listaCI;
import static Menues.Main.listaPro;
import static Menues.Main.listaCont;

public class GestionContratos{
    Scanner sc;

    boolean running;
    int opcion;

    //constructor
    public GestionContratos() {
        this.sc = new Scanner(System.in);
        this.running = true;
        this.opcion = 0;
    }

    public void startMenu (){
        //metodo para lanzar el menu de opciones para la gestion de contratos
        int ci, pro, nroCont;
        String tipoCont, sFecD, sFecH;
        long volMax, volMin;
        LocalDate fecDesde = null, fecHasta=null;
        double precio;
        boolean flag = true;

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (running) {
            System.out.println("___________________________________________________________");
            System.out.println("MENU GESTION DE CCONTRATOS - SGGN - ANDOR S.A.");
            System.out.println("___________________________________________________________");
            System.out.println("1. Agregar Contrato (Implementado)");
            System.out.println("2. Modificar Contrato ");
            System.out.println("3. Borrar Contrato");
            System.out.println("4. Listar Contratos (Implementado)");
            System.out.println("5. Salir");

            volMin = 9999999;
            try {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> {
                        //se muestran los CI disponibles o se informa que no hay CI disponibles
                        //para que se cargen previamente
                        if (listaCI.isEmpty()){
                            System.out.println("No Hay complejos Industriales cargados");
                            System.out.println("Favor de Ingresar al menos un Complejo Industrial");
                            running = false;
                        }else{
                            System.out.println(("Hay " + listaCI.size() + " Complejos Industriales, " +
                                    "seleccione 1"));
                            listarCi(listaCI);
                            ci = sc.nextInt();
                            //se muestran los proveedores disponibles o se informa que no hay Proveedores
                            //disponibles para que se cargen previamente
                            if (listaPro.isEmpty()){
                                System.out.println("No Hay Proveedores cargados");
                                System.out.println("Favor de Ingresar al menos un Proveedor");
                                running = false;
                            }else{
                                System.out.println(("Hay " + listaPro.size() + " Proveedores, " +
                                        "seleccione 1"));
                                listarPro(listaPro);
                                pro = sc.nextInt();
                                System.out.println("Ingrese el numero de contrato");
                                nroCont =  sc.nextInt();
                                sc.nextLine();
                                System.out.println("Ingrese el tipo de contrato");
                                tipoCont = sc.nextLine();
                                System.out.println("Ingrese el volumen maximo contratado");
                                volMax = sc.nextLong();
                                sc.nextLine();
                                //se solicita que ingrese el volumen minimo y verifica que sea menor que el
                                //volumen maximo cargado previamente
                                while (volMin > volMax) {
                                    System.out.println("Ingrese el volumen minimo contratado (debe ser " +
                                            "menor que el volumen maximo");
                                    volMin = sc.nextLong();
                                    sc.nextLine();
                                }
                                while (flag) {
                                    System.out.print("Ingresa la fecha de inicio del contrato (dd/MM/yyyy): ");
                                    sFecD = sc.nextLine();
                                    try {
                                        fecDesde = LocalDate.parse(sFecD, formato);
                                        flag = false;
                                    } catch (DateTimeParseException e) {
                                        System.out.println("Formato de fecha inválido. Usa dd/MM/yyyy " +
                                                "(por ejemplo, 01/06/2025).");
                                    }
                                }
                                flag = true;
                                while (flag){
                                    System.out.print("Ingresa la fecha de fin del contrato (dd/MM/yyyy): ");
                                    sFecH = sc.nextLine();
                                    try{
                                        fecHasta = LocalDate.parse(sFecH, formato);
                                        //Comprobacion que las fechas son validas, fecha de inicio menor que fecha de fin
                                        if (fecHasta.isAfter(fecDesde)){
                                            System.out.println("La Fecha de fin debe ser menor a la de inicio");
                                            flag = true;
                                        }else{
                                            flag = false;
                                        }
                                    }catch (DateTimeParseException e) {
                                        System.out.println("Formato de fecha inválido. Usa dd/MM/yyyy " +
                                                "(por ejemplo, 01/06/2025).");
                                    }
                                }

                                System.out.println("Ingrese el precio acordado en el contrato");
                                precio =  sc.nextDouble();
                                sc.nextLine();
                                listaCont.add(new Contrato(nroCont, tipoCont,volMax,volMin,fecDesde,
                                        fecHasta, precio,listaCI.get(ci-1), listaPro.get(pro-1)));
                            }
                        }

                    }
                    case 2 -> {
                        System.out.println("Caracteristica no desarrollada hasta el momento");
                    }
                    case 3 -> {
                        System.out.println("Caracteristica no desarrollada hasta el momento");
                    }
                    case 4 -> {
                        listarContratos(listaCont);
                    }
                    case 5 -> {
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
        //metodo para listar los distintos CI para seleccionar el complejo que se involucra en el contrato
        System.out.printf("%-8s %-20s %-15s%n","Orden", "Complejo Industrial", "Razon Social");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < lista.size(); i++){

            System.out.printf("%-8d %-20s %-15s%n", i+1,lista.get(i).getDenominacion(), lista.get(i).getRazonSocial());
        }
    }

    public void listarPro(LinkedList<Proveedor> lista){
        //metodo para listar los proveedores que hay registrados para seleccionar la parte
        //oferente del contrato
        System.out.printf("%-8s %-20s %-15s%n","Orden", "Razon Social", "Tipo");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < lista.size(); i++){

            System.out.printf("%-8d %-20s %-15s%n", i+1,lista.get(i).getRazonSocial(), lista.get(i).getTipo());
        }
    }

    public void listarContratos(LinkedList<Contrato> lista){
        //metodo para listar los contratos que se registraron hasta el momento
        System.out.printf("%-8s %-20s %-15s %-15s %-15s%n","Orden", "Complejo Industrial",
                "Porveedoer", "Volumen Maximo", "Volumen Minimo");
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < lista.size(); i++){
            //Se muestran solo algunos de los atributos de los contratos
            System.out.printf("%-8d %-20s %-15s %-15d %-15d%n", i+1,lista.get(i).getCi().getDenominacion(),
                    lista.get(i).getProveedor().getRazonSocial(), lista.get(i).getVolumenMaximo(), lista.get(i).getVolumenMinimo());
        }
    }
}
