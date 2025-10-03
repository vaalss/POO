import java.util.ArrayList;

public class Controller {
    private ArrayList<Process> procesos;
    private View consola;

    public Controller() {
        this.procesos = new ArrayList<Process>();
        this.consola = new View();
    }

    public void registrarProcesos() {
        Process p1 = new CPU("Memoria Restante"); procesos.add(p1);
        Process p2 = new IO("Mostrar fecha"); procesos.add(p2);
        Process p3 = new Daemons("Monitoreo"); procesos.add(p3);
        Process p4 = new CPU("Dividir"); procesos.add(p4);
        Process p5 = new Daemons("Hora actual"); procesos.add(p5);
        Process p6 = new IO("Pedir nombre"); procesos.add(p6);
        Process p7 = new IO("Pedir edad"); procesos.add(p7);
        Process p8 = new CPU("Suma"); procesos.add(p8);
        Process p9 = new CPU("Multiplicar"); procesos.add(p9);
        Process p10 = new Daemons("Apagar sistema"); procesos.add(p10);
    }

    public void correr () {
        int salir = 0;
        while (salir == 0){
            this.registrarProcesos();
            consola.mostrarMenu();
            int opcion = consola.pedirNumero("Selecciona una opción: ");
            switch (opcion) {
                case 1:
                    consola.mostrarProcesos(procesos);
                case 2:
                    salir = 1;
            }
        }
    }

}