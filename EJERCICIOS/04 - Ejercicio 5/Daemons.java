import java.time.LocalTime;

public class Daemons extends Process {
    private boolean activo;

    public Daemons(String nombre) {
        super(nombre);
        this.activo = true;
    }

    public String ejecutar() {
            String tipo = this.getNombre();
            switch (tipo) {
                case "Monitoreo":
                    if (activo) {
                        return "Proceso Daemon activo, monitoreando procesos...";
                    } else {
                        return "Monitoreo detenido.";
                    }
                case "Hora Actual":
                    LocalTime hora = LocalTime.now();
                    try {
                        Thread.sleep(5000); // espera 5 segundo
                    } catch (InterruptedException e) {
                        return e.getMessage();
                    }
                    return "La hora actual es " + hora;
                case "Apagar sistema":
                    this.activo = false;
                    return "Apagando el sistema...";
                default:
                    return "No se reconoce el proceso";
            }
    }

    @Override 
     public String toString() {
        return "Proceso de Daemons " + this.getPID() + ": '" + this.getNombre() + "'";
    }
}