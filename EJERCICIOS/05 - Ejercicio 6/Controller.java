public class Controller {
    
    private ArrayList<Equipment> equipos;
    private View vista;

    public Controller() {
        this.equipo = new ArrayList<Equipment>();
        this.vista = new View();
    }

    public init() {

    }

    public void sistema() {
        int salir = -1;
        while (salir == -1) {
            vista.mostrarMenu();
            int opcion = vista.pedirNumero("Selecciona la opción a realizar: ");
            switch (opcion) {
                case 1:
                    vista.mostrarEquipo(equipos);
                    break;
                case 2:
                    String equipo = vista.pedirEntrada("Ingresa el nombre o ID del equipo que desees: ");
                    vista.buscarEquipo(equipos, equipo);
                    break;
                case 3:
                    Collections.sort(equipos);
                    vista.equiposPorConsumo(equipos);
                    break;
                case 4:
                    salir = 0;
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
            }   
        }
    }
}