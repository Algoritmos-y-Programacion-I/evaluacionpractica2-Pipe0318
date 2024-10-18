package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {

        control = new Controller();
        reader = new Scanner(System.in);

    }

    public static void main(String[] args) {

        Executable exe = new Executable();
        exe.menu();
    }
    
    /** 
     * Descripcion: Despliega el menu principal de funcionalidades al usuario
    */
    public void menu() {

        boolean flag = true;

        do {

            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pillar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    flag = false;
                    break;

                default:
                    System.out.println("Opcion invalida, intente nuevamente");
                    break;
            }

        } while (flag);

    }

    /** 
     * Descripcion: Solicita al usuario la informacion necesaria para registrar un Project 
     * en un Pillar en el sistema
    */
    public void registerProject() {
        boolean status;
        int pillarType;
        int statusInt;
        do {
        System.out.println("Ingrese el pilar al que se va a añadir el proyecto");
        System.out.println("1) Biodiversidad \n 2) Agua \n 3) Tratamiento de Basuras \n 4) Energía");
        pillarType = reader.nextInt();
        } while (pillarType < 1 || pillarType > 4);
        reader.nextLine();
        System.out.println("Ingrese el id del proyecto");
        String id = reader.nextLine();
        System.out.println("Ingrese el nombre del proyecto");
        String name = reader.nextLine();
        System.out.println("Ingrese la descripcion del proyecto");
        String description = reader.nextLine();
        System.out.println("Ingrese el estado del proyecto (1. Activo o 2. Inactivo)");
        statusInt = reader.nextInt();
        
        
        if (statusInt == 1){
            status = true;
        } else if (statusInt == 2) {
            status = false;
        } else {
            System.out.println("Opcion invalida");
            return;
        }


        if (control.registerProjectInPillar(0, id, name, description,status)==true){
            System.out.println("Projecto registrado correctamente");

        } else {
            System.out.println("No se pudo registrar el projecto");
        }

        reader.nextLine();

    }

    /** 
     * Descripcion: Muestra al usuario los Projects registrados en un Pillar 
    */
    public void showProjectsByPillar() {
        int pillarType;
        do{
        System.out.println("Digite el Pilar a consultar:");
        System.out.println("1) Biodiversidad \n 2) Agua \n 3) Tratamiento de Basuras \n 4) Energía");
        pillarType = reader.nextInt();
        } while (pillarType < 1 || pillarType > 4);

        System.out.println(control.queryProjectsByPillar(pillarType));
        reader.nextLine();

    }

}