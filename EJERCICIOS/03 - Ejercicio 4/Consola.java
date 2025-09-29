import java.util.Scanner;
import java.util.List;

public class Consola {
    private Scanner sc;

    public Consola() {
        this.sc = new Scanner(System.in);
    }

    public void bienvenida(int e, int j) { //mensaje de bienvenida con las reglas del juego y la cantidad de combatientes por bando
        println("");
        println("--- 💣 COMBATE MORTAL 💣 ---");
        println("REGLAS:");
        println("       - Los turnos se alternan entre jugadores y enemigos, y entre los integrantes de cada bando");
        println("       - En cada turno decides si atacas, pasas el turno o usas tu habilidad/item");
        println("       - Puedes escoger que jugadores usas pero no cuales enemigos");
        println("       - Puedes escribir salir en cualquier momento para salir dle juego");
        println("");
        println("La batalla tendrá " + e + " enemigos y " + j + " jugadores");
    }

    public void menuSeleccionG(List<Jugador> jugadoresG) { //método que muestra los posibles jugadores guerreros para escoger
        println("");
        println("--- 🪖 Jugadores Guerreros: 🪖 ---");
        int contadorJ = 1;
        for (Jugador j : jugadoresG) {
            println(contadorJ + ". " + j);
            contadorJ++;
        }
        println("");
    }

    public void menuSeleccionE(List<Jugador> jugadoresE) { //método que muestra los posibles jugadores exploradores para escoger
        println("");
        int contadorJ = 1;
        println("--- 🔍 Jugadores Exploradores: 🔍 ---");
        for (Jugador j : jugadoresE) {
            println(contadorJ + ". " + j);
            contadorJ++;
        }
        println("");
    }

    public void mostrarCombatientes(List<Jugador> jugadores, List<Enemigo> enemigos) { //muestra todos los combatientes de la batalla
        println("");
        println("--- COMBATIENTES ---");
        println("");
        println("--- 🔍 Jugadores: 🪖 ---");
        println("");
        int contadorJ = 1;
        for (Jugador j : jugadores) {
            println (contadorJ + ". " + j);
        }
        println("");
        println("--- 🦹 Enemigos: 🦹 ---");
        println("");
        int contadorE = 1;
        for (Enemigo e : enemigos) {
            println (contadorE + ". " + e);
        }
    }

    public void menuAcciones(int turno) { //muestra las posibles acciones a tomar según el tipo de combatiente
        if (turno%2 == 0) {
            println("");
            println("Turno: Jugadores ⬅️ - Enemigos");
            println("");
            println("ACCIONES:");
            println("         -💥 Atacar");
            println("         -➡️ Pasar el turno");
            println("         -⭐ Usar item");
            println("         - Salir ");
            println("");
        } else {
            println("");
            println("Turno: Jugadores - Enemigos ⬅️");
            println("");
            println("ACCIONES:");
            println("         -💥 Atacar");
            println("         -➡️ Pasar el turno");
            println("         -⭐ Usar habilidad");
            println("         - Salir");
            println("");

        }
    }

    public void mostrarStatus(List<Jugador> jugadores, List<Enemigo> enemigos) { //muestra el estado de cada uno de los combatientes de la batalla
        println("");
        println("Status de los combatientes: ");
        println("- 🪖🔍Jugadores:");
        for (Jugador j : jugadores) {
            println("  - " + j.status());
        }
        println("- 🦹Enemigos:");
        for (Enemigo e : enemigos) {
            println("  - " + e.status());
        }
    }

    public void mostrarItems(Jugador j) { //muestra todos los items del inventario de un jugador
        println("");
        println("Items: ");
        int contadorI = 1;
        for (Item i : j.getInventario()) {
            println(contadorI + ". " + i);
            contadorI ++;
        }
    }
    
    public void mostrarHabilidades(Enemigo e){ //muestra todas las habilidades de un enemigo
        println("");
        println("Habilidades especiales: ");
        int contadorH = 1;
        for (Habilidad h : e.getHabilidades()) {
            println(contadorH + ". " + h);
            contadorH ++;
        }
    }

    public void mostrarAcciones(List<String> acciones) { //muestra las últimas 3 acciones realizadas
        println("");
        println("Últimas acciones: ");
        if (acciones.size() > 3) { //si la lista tiene más de 3 elementos se resta 3 al tamaño para acceder al índide de los ultimos tres elementos
            for (int i = acciones.size() - 3; i < acciones.size(); i++) {
                println("   - " + acciones.get(i));
            }
        } else { //si la lista tiene menos de 3 elementos, se imprimen todos
            for (int j = 0; j < acciones.size(); j++) {
                println("   - " + acciones.get(j));
            }
        }
        println("");
    }

    public int pedirNumero(String prompt) { //recibe un número del usuario
        print(prompt);
        int num = this.sc.nextInt();
        this.sc.nextLine();
        return num;
    }

    public String pedirEntrada(String prompt) { //recibe un String del usuario
        print(prompt);
        return this.sc.nextLine();
    } 

    public void mostrarMensaje(String promt) { //muestra un mensaje al usuario
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