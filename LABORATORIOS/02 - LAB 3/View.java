//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Seccion 40
//Valeria Hernández Maldonado 25086

import java.util.Scanner;
import java.util.ArrayList;

public class View {
    private Scanner sc;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu() { //muestra el menú de ocpiones al usuario
        println("");
        println("--- MENÚ DE OPCIONES ---");
        println("1. Agendar Cita");
        println("2. Cancelar Cita");
        println("3. Confirmar Cita");
        println("4. Ver medicos disponibles");
        println("5. Ver reporte de citas");
        println("6. Ver reporte de personal");
        println("7. Ver análisis de eficiencia");
        println("8. Ver reportes de nómina");
        println("9. Ver análisis financiero");
        println("10. Ver historial de cambios");
        println("11. Salir");
        println("");
    }

    public void mostrarMensaje(String m) { //imprime un mensaje en consola
        println(m);
    }

    public int pedirEntrada(String prompt) { //pide una entrada numérica al usuario
        print(prompt);
        int entrada = sc.nextInt();
        sc.nextLine();
        return entrada;
    }

    public String pedirString(String prompt) { //pide una entrada tipo String al usuario
        print(prompt);
        String entrada = sc.nextLine();
        return entrada;
    }

    public void mostrarHistorial(ArrayList<String> historial) { //muestra el historial de cambios
        println("--- Registro de cambios -");
        for (String h : historial) {
            println(" - " + h);
            println("");
        }
    }

    public void mostrarPersonal(ArrayList<Medico> trabajadores) { //muestra la información de todo el personal
        println("--- Reporte de Personal ---");
        for (Medico m : trabajadores) {
            println(" - " + m);
            println("");
        }
    }

    public void mostrarEficiencia(ArrayList<Medico> trabajadores) { //muestra la eficiencia de todo el personal
        println("--- Reporte de eficiencia ---");
        for (Medico m : trabajadores) {
            println(" - " + m.getNombre() + ": " + m.calcularEficiencia());
        }
    }

    public void mostrarCitas(ArrayList<Cita> citas, ArrayList<Medico> trabajadores) { //muestra las citas por estado y por trabajador
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

    public void citasEstado(ArrayList<Cita> citas, String estado, String titulo ){ //muestra la cita según el estado qeu se le pida
        println("- " + titulo + ": ");
        boolean hayCitas = false;
        for (Cita c : citas) {
            if (c.getEstado().equals(estado)) {
                println(" - " + c);
                println("");
                hayCitas = true;
            }
        }
        if (!hayCitas) { //si no hay citas en el estado que se pidió
            println("No hay citas " + estado);
        }
    }

    public void citasMedico(ArrayList<Cita> citas, ArrayList<Medico> trabajadores) { //muestra las citas para cada trabajador del hospital
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
            if (!hayCitas) { //si no hay citas con ese médico
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