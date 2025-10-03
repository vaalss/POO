import java.util.LocalDate;

public class IO extends Process {
    private View consola;
    private LocalDate fecha;

    public IO(String nombre) {
        super(String nombre);
        this.consola = new View();
        this.fecha = LocalDate.now();
    }

    public String ejecutar() {
        String tipo = this.getNombre();
        switch (tipo) {
            case "Mostrar fecha":
                consola.mostrarMensaje("Hoy es " + this.fecha);
                break;
            case "Pedir nombre":
                String nombre = consola.pedirEntrada("Ingresa tu nombre: ");
                consola.mostrarMensaje("Tu nombre es " + nombre);
            case "Pedir edad":
                int edad = consola.pedirNumero("Ingresa tu edad: ");
                consola.mostrarMensaje("Tienes " + edad + " año(s)");
        }   

    }

    @Override 
    public String toString() {
        return "Realizando proceso de I/O..." + "\n Número de proceso: " this.getPID() + " '" + this.getNombre + "'";
    }
}