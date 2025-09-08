import java.util.Lists;
import java.util.Scanner;

public class Consola {
    private final Scanner sc; //scanner para leer las entradas del usuario

    public Consola() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarInstrucciones(int filas, int cols) {
        println("=== Juego de memoria ===");
        println("Tablero: " + filas + " X " + cols + "(" + (filas*cols) + " celdas)");
        println("Reglas: ")
        println("- Dos jugadores se turnan para destapar dos casillas por turno");
        println("- Si las casillas coinciden, ganan un punto y siguen jugando");
        println("- Si las casillas no coinciden, se tapan y pasa el turno");
        println("- El juego termina cuando todas las parejas están descubiertas");
        println("");
    }

    public void dibujarTablero(Tablero t) {
        int filas = t.getFilas();
        int cols = t.getCols();

        print("   ");
        for (int j = 1; j <= cols; j++) {
            print(j + " ");
        }
        println("");

        for (int i = 0; i < filas; i++) {
            char letraFila = (char) ('A' + i);
            print(letraFila + "  ");
            for (int j = 0; j < cols; j++) {
                print(t.getCelda(i, j).toString() + " ");
            }
            println("");
        }
        println("");
    }

    public void mostrarMarcador(List<Jugador> jugadores, int turnoActual) {
        print("Marcador: ");
        for (int i = 0; i < jugadores.size; i++) {
            Jugador j = jugadores.get(i);
            if (i > 0) {
                print(" | ")
            }
            print(j);
            if (i == turnoActual) {
                print ("⬅️ turno")
            }
        }
        println("");
    }

    public void mostrarMensaje(String mensaje) { ///???? será necesario
        println(mensaje);
    }

    public String pedirEntrada(String prompt) {
        print(prompt);
        return this.sc.nextLine();
    }


    //Helpers
    public void print(String s) {
        System.out.print(s);
    }

    public void println(String s) {
        System.out.prinln(s);
    }
}