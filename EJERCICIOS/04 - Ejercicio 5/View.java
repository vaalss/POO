import java.util.ArrayList;

import java.util.Scanner;

public class View {
    private Scanner sc;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        println("\n--- MENU ---");
        println("   1. Correr procesos");
        println("   2. Salir");
    }

    public int pedirNumero(String prompt) {
        print(prompt);
        int entrada = sc.nextInt();
        sc.nextLine();
        return entrada;
    }

    public String pedirEntrada(String prompt) {
        print(prompt);
        String entrada = sc.nextLine();
        return entrada;
    }

    public void mostrarProcesos(ArrayList<Process> procesos) {
        println("--- Procesos --- \n");
        for (Process p : procesos) {
            System.out.print("- " + p + ": ");
            System.out.println(p.ejecutar());
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