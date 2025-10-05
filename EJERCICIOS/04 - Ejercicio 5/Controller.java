//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Sección 40
//Valeria Hernández Maldonado 25086

//controlador

import java.util.ArrayList;

public class Controller {
    private ArrayList<Process> procesos;
    private View consola;

    public Controller() {
        this.procesos = new ArrayList<Process>();
        this.consola = new View();
    }

    public void registrarProcesos() { //se instancias algunos procesos para simular el sistema
        Process p1 = new CPU("Memoria Restante"); procesos.add(p1);
        Process p2 = new IO("Mostrar fecha"); procesos.add(p2);
        Process p3 = new Daemons("Monitoreo"); procesos.add(p3);
        Process p4 = new CPU("Dividir"); procesos.add(p4);
        Process p5 = new Daemons("Hora actual"); procesos.add(p5);
        Process p6 = new IO("Pedir nombre"); procesos.add(p6);
        Process p7 = new CPU("Multiplicar"); procesos.add(p7);
        Process p8 = new IO("Pedir edad"); procesos.add(p8);
        Process p9 = new CPU("Suma"); procesos.add(p9);
        Process p10 = new CPU("Multiplicar"); procesos.add(p10);
        Process p11 = new Daemons("Apagar sistema"); procesos.add(p11);
        Process p12 = new Daemons("Monitoreo"); procesos.add(p12);
    }

    public void correr () {
        this.registrarProcesos();
        int salir = 0;
        while (salir == 0){
            consola.mostrarMenu(); //el usuario escoge entre salir y correr los procesos
            int opcion = consola.pedirNumero("Selecciona una opción: ");
            switch (opcion) {
                case 1:
                    consola.mostrarProcesos(procesos);
                    break;
                case 2:
                    salir = 1; //se termina el ciclo hasta que el usuario lo pida
                    break;
            }
        }
    }

}