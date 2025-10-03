import java.time.LocalDate;

public class IO extends Process {
    private View consola;
    private LocalDate fecha;

    public IO(String nombre) {
        super(nombre);
        this.consola = new View();
        this.fecha = LocalDate.now();
    }

    public String ejecutar() {
        String tipo = this.getNombre();
        switch (tipo) {
            case "Mostrar fecha":
                return "Hoy es " + this.fecha;
            case "Pedir nombre":
                String nombre = consola.pedirEntrada("Ingresa tu nombre: ");
                return "Tu nombre es " + nombre;
            case "Pedir edad":
                int edad = consola.pedirNumero("Ingresa tu edad: ");
                return "Tienes " + edad + " año(s)";
            default:
                return "No se reconoce el proceso";
        }   
    }

    @Override 
    public String toString() {
        return "Proceso de I/O: " + this.getPID() + " '" + this.getNombre() + "'";
    }
}