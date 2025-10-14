import java.util.Scanner;
import java.util.ArrayList;

public class View {
    private Scanner sc;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        println("");
        println("--- MENÚ DE OPCIONES ---");
        println("1. Cancelar Cita");
        println("2. Ver medicos disponibles");
        println("3. Ver reporte de citas");
        println("4. Ver reporte de personal");
        println("5. Ver análisis de eficiencia");
        println("6. Ver reportes de nómina");
        println("7. Ver análisis financiero");
        println("8. Ver historial de cambios");
        println("9. Salir");
        println("");
    }

    public void mostrarMensaje(String m) {
        println(m);
    }

    public int pedirEntrada(String prompt) {
        print(prompt);
        int entrada = sc.nextInt();
        sc.nextLine();
        return entrada;
    }

    public void mostrarHistorial(ArrayList<String> historial) {
        println("--- Registro de cambios -");
        for (String h : historial) {
            println(" - " + h);
            println("");
        }
    }

    public void mostrarPersonal(ArrayList<Medico> trabajadores) {
        println("--- Reporte de Personal ---");
        for (Medico m : trabajadores) {
            println(" - " + m);
            println("");
        }
    }

    public void mostrarEficiencia(ArrayList<Medico> trabajadores) {
        println("--- Reporte de eficiencia ---");
        for (Medico m : trabajadores) {
            println(" - " + m.getNombre() + ": " + m.calcularEficiencia());
        }
    }

    public void mostrarCitas(ArrayList<Cita> citas, ArrayList<Medico> trabajadores) {
        println("--- Registro de citas ---");
        citasEstado(citas, "PROGRAMADA", "Citas programadas");
        println("");
        citasEstado(citas, "CONFIRMADA", "Citas confirmadas");
        println("");
        citasEstado(citas, "EN PROGRESO", "Citas en progreso");
        println("");
        citasEstado(citas, "COMPLETADA", "Citas completadas");
        println("");
        citasEstado(citas, "CANCELADA", "Citas canceladas");
        println("");
        citasEstado(citas, "REAGENDADA", "Citas reagendadas");
        println("");
        citasMedico(citas, trabajadores);

    }

    public void citasEstado(ArrayList<Cita> citas, String estado, String titulo ){
        println("- " + titulo + ": ");
        boolean hayCitas = false;
        for (Cita c : citas) {
            if (c.getEstado().equals(estado)) {
                println(" - " + c);
                println("");
                hayCitas = true;
            }
        }
        if (!hayCitas) {
            println("No hay citas " + estado);
        }
    }

    public void citasMedico(ArrayList<Cita> citas, ArrayList<Medico> trabajadores) {
        for (Medico m : trabajadores) {
            boolean hayCitas = false;
            println("- Citas de " + m.getNombre() + ": ");
            for (Cita c : citas) {
                if (c.getTrabajador().equals(m)) {
                    println(" - " + c);
                    println("");
                    hayCitas = true;
                }
            }
            if (!hayCitas) {
                println("No hay citas con " + m.getNombre());
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