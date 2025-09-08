import java.util.List;
import java.util.ArrayList;

public class Memoria {
    private Tablero tablero; //tablero
    private final Consola vista; //vista
    private List<Jugador> jugadores; //lista de jugadores
    private int turnoActual; //índice del jugador que juega

    public Memoria() {
        this.vista = new Consola(); //crea la consola
        this.tablero = null; //se inicia sin tablero, porque se tiene que pedir las dimensiones en jugar()
        this.jugadores = new ArrayList<>(); 
        this.turnoActual = 0;
    }

    public void jugar() {
        this.vista.mostrarMensaje("=== Juego de Memoria ===");        
        String nombre1 = this.vista.pedirEntrada("Ingresa el nombre del jugador 1: ");
        String nombre2 = this.vista.pedirEntrada("Ingresa el nombre del jugador 2: ");

        int filas = this.vista.pedirNumero("Ingresa el número de filas (máx 20): ");
        int cols = this.vista.pedirNumero("Ingresa el número de columnas (máx 20): ");

        while ((filas*cols) % 2 != 0) { //válida que hay un número par de casillas
            this.vista.mostrarMensaje("El tablero debe tener un número par de casillas");
            filas = this.vista.pedirNumero("Ingresa el número de filas (máx 20): ");
            cols = this.vista.pedirNumero("Ingresa el número de columnas (máx 20): ");
        }

        this.tablero = new Tablero(filas, cols); //Crea el tablero con las dimensiones ingresadas
        this.tablero.inicializarAleatorio();

        this.jugadores.clear(); //borra a los jugadores de la ronda anterior
        this.jugadores.add(new Jugador(nombre1)); //crea los jugadores con los nombres ingresados
        this.jugadores.add(new Jugador(nombre2));

        this.turnoActual = 0;

        this.vista.mostrarInstrucciones(this.tablero.getFilas(), this.tablero.getCols()); //muestra las instrucciones

        while (!this.tablero.todasEmparejadas()) {
            this.vista.dibujarTablero(this.tablero);
            this.vista.mostrarMarcador(this.jugadores, this.turnoActual);

            String entrada = this.vista.pedirEntrada("Ingresa dos coordenadas (ej. A1 B2): "); //pide la jugada
            entrada = entrada.trim().toUpperCase();

            int[][] coords = parsearEntrada(entrada);

            if (coords == null) { //si las coordenadas son inválidas envía un mensaje de error
                this.vista.mostrarMensaje("Coordenadas inválidas, inténtalo de nuevo");
            } else {
                int[] primera = coords[0]; //separa las dos coordenadas de la entrada del usuario
                int[] segunda = coords[1];

                if (primera[0] == segunda[0] && primera[1] == segunda[1]) { //verifica que no sean la misma casilla
                    this.vista.mostrarMensaje("No puedes elegir la misma coordenada dos veces");
                } else {
                    tablero.getCelda(primera[0], primera[1]).setVisibleTemporal(true); //revelar temporalmente las casillas
                    tablero.getCelda(segunda[0], segunda[1]).setVisibleTemporal(true);

                    this.vista.dibujarTablero(this.tablero); //muestra las casillas reveladas

                    String e1 = tablero.getCelda(primera[0], primera[1]).getEmoji();
                    String e2 = tablero.getCelda(segunda[0], segunda[1]).getEmoji();

                    if (e1.equals(e2)) {
                        tablero.getCelda(primera[0], primera[1]).setEmparejada(true);
                        tablero.getCelda(segunda[0], segunda[1]).setEmparejada(true);
                        jugadores.get(turnoActual).anotarPar();
                        this.vista.mostrarMensaje("¡Adivinaste! Sigue jugando");
                    } else {
                        tablero.getCelda(primera[0], primera[1]).setVisibleTemporal(false);
                        tablero.getCelda(segunda[0], segunda[1]).setVisibleTemporal(false);
                        this.vista.mostrarMensaje("No adivinaste. Pasa el turno");
                        this.turnoActual = (this.turnoActual + 1) % jugadores.size();
                    }
                }
            }
        }
        this.vista.dibujarTablero(this.tablero);
        this.vista.mostrarMensaje(calcularGanador());
    }

    private int[][] parsearEntrada(String entrada) {
        String[] partes = entrada.split(" "); //separa las coordenadas ingresadas por el usuario
        if (partes.length != 2) { //si no se ingresaron dos coordenadas la entrada es inválida
            return null;
        }

        int[][] coords = new int[2][2]; //devuelve un arreglo con dos coordenadas: [[fila1,col1],[fila2,col2]]
        for (int i = 0; i < 2; i++) {
            String casilla = partes[i];

            if (casilla.length() < 2) { //si la casilla no tiene al menos 2 caracteres la entrada es inválida
                return null;
            }

            char letra = casilla.charAt(0); //devuelve el primer caracter (la letra indica la fila)

            if (letra < 'A' || letra > 'A' + tablero.getFilas()) { //si la letra no está dentro del rango del tablero la entrada es inválida
                return null;
            }

            String numero = casilla.substring(1); //el resto de la casilla son los número de la columna
            for (int k = 0; i < numero.length(); k++) {
                if (!Character.isDigit(numero.charAt(k))) {
                    return null; //si no son números la entrada es inválida
                }
            }

            int col = Integer.parseInt(numero); //convierte el número en int
            if (col < 1 || col > tablero.getCols()) { //si el número de columna no está dentro del rango del tbalero la entrada es inválida
                return null;
            }

            coords[i][0] = letra - 'A'; //fila
            coords[i][1] = col -1; //column
        }
        return coords;
    }

    private String calcularGanador() {
        Jugador j1 = jugadores.get(0);
        Jugador j2 = jugadores.get(1);

        if (j1.getPares() > j2.getPares()) { //compara los pares encontrados de cada jugador para determinar el jugador
            return "Ganador: " + j1;
        } else if (j2.getPares() > j1.getPares()) {
            return "Ganador: " + j2; 
        } else {
            return "Empate: " + j1.getPares() + " pares cada uno";
        }
    }
}