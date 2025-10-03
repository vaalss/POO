public class Controller {
    private ArrayList<Process> procesos;
    private View consola;

    public Controller() {
        this.procesos = new ArrayList<Process>();
        this.consola = new View();
    }

    public void registrarProcesos() {
        //instanciar los procesos
    }

    public void correr () {
        int salir = 0;
        while (salir == 0){
            this.registrarProcesos();
            consola.mostrarMenu();
            int opcion = consola.pedirNumero();
            switch (opcion) {
                case 1:
                    consola.mostrarProcesos(procesos);
                case 2:
                    salir = 1;
            }
        }
    }

}