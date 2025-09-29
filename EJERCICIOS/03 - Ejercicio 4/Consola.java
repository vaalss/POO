import java.util.Scanner;
import java.util.List;

public class Consola {
    private Scanner sc;

    public Consola() {
        this.sc = new Scanner(System.in);
    }

    public void bienvenida(int e, int j) {
        println("");
        println("--- COMBATE MORTAL ---");
        println("REGLAS:");
        println("       - Los turnos se alternan entre jugadores y enemigos, y entre los integrantes de cada bando");
        println("       - En cada turno decides si atacas, pasas el turno o usas tu habilidad/item");
        println("       - Puedes escoger que jugadores usas pero no cuales enemigos");
        println("       - Puedes escribir salir en cualquier momento para salir dle juego");
        println("");
        println("La batalla tendrá " + e + " enemigos y " + j + " jugadores");
    }

    public void menuSeleccionG() { //método para seleccionar los jugadores guerreros
        println("");
        println("--- Jugadores Guerreros: ---");
        int contadorJ = 1;
        for (Jugador j : jugadoresG) {
            println(contadorJ + ". " + j);
            contadorJ++;
        }
        println("");
    }

    public void menuSeleccionE() { //método para seleccionar los jugadores exploradores
        println("");
        int contadorJ = 1;
        println("--- Jugadores Exploradores: ---");
        for (Jugador j : jugadoresE) {
            println(contadorJ + ". " + j);
            contadorJ++;
        }
        println("");
    }

    public void mostrarCombatientes() {
        println("");
        println("--- COMBATIENTES ---");
        println("");
        println("--- Jugadores: ---");
        println("");
        int contadorJ = 1;
        for (Jugador j : jugadores) {
            println (contadorJ + ". " + j);
        }
        println("");
        println("--- Enemigos: ---");
        println("");
        int contadorE = 1;
        for (Enemigo e : enemigos) {
            println (contadorE + ". " + e);
        }
    }

    public void menuAcciones(int turno) {
        if (turno%2 == 0) {
            println("");
            println("Turno: Jugadores ⬅️ - Enemigos");
            println("");
            println("ACCIONES:");
            println("         - Atacar");
            println("         - Pasar el turno");
            println("         - Usar item");
            println("         - Salir ");
            println("");
        } else {
            println("");
            println("Turno: Jugadores - Enemigos ⬅️");
            println("");
            println("ACCIONES:");
            println("         - Atacar");
            println("         - Pasar el turno");
            println("         - Usar habilidad");
            println("         - Salir");
            println("");

        }
    }

    public void mostrarStatus() {
        println("");
        println("Status de los combatientes: ");
        println("- Jugadores:");
        for (Jugador j : jugadores) {
            println("  - " + j.status());
        }
        println("- Enemigos:");
        for (Enemigo e : enemigos) {
            println("  - " + e.status());
        }
    }

    public void mostrarAcciones() {
        println("");
        println("Últimas acciones: ");
        if (acciones.size() > 3) {
            for (int i = acciones.size() - 3; i < acciones.size(); i++) {
                println("   - " + acciones.get(i));
            }
        } else {
            for (int j = 0; j < acciones.size(); j++) {
                println("   - " + acciones.get(j));
            }
        }
        println("");
    }

    public int pedirNumero(String prompt) {
        print(prompt);
        int num = this.sc.nextInt();
        this.sc.nextLine();
        return num;
    }

    public String pedirEntrada(String prompt) {
        print(prompt);
        return this.sc.nextLine();
    } 

    public void mostrarMensaje(String promt) {
        print(promt);
    }

    //helpers
    public void print(String s) {
        System.out.print(s);
    }

    public void println(String s) {
        System.out.println(s);
    }
}