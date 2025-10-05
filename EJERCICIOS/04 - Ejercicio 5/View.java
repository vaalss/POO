//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Sección 40
//Valeria Hernández Maldonado 25086

//Vista

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private Scanner sc;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu() { //opciones a escoger por el usuario
        println("\n--- MENU ---");
        println("   1. Correr procesos");
        println("   2. Salir");
    }

    public int pedirNumero(String prompt) { //método para pedir entrada numérica al usuario
        print(prompt);
        int entrada = sc.nextInt();
        sc.nextLine();
        return entrada;
    }

    public String pedirEntrada(String prompt) { //método para pedir entrada al usuario
        print(prompt);
        String entrada = sc.nextLine();
        return entrada;
    }

    public void mostrarMensaje(String mensaje) { //método para mostrar un mensaje en consola
        println(mensaje);
    }

    public void mostrarProcesos(ArrayList<Process> procesos) { //método que muestra todos los procesos de la lista de procesos
        println("--- Procesos --- \n");
        for (Process p : procesos) {
            try {
                System.out.print("- " + p + ": ");
                System.out.println(p.ejecutar());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();;
            }
        }
    }


    //helpers
    public void print(String s) {
        System.out.print(s);
    }

    public void println(String s) {
        System.out.println(s);
    }
}