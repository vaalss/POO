import java.util.Random;

public class Tablero {
    private final int filas; //número de filas del tablero
    private final int cols; //número de columnas del tablero
    private final Celda[][] celdas;
    private static final String[] EMOJI_BASE = {"🍎","🍐","🍊","🍋","🍌","🍉","🍇","🍓","🫐","🍒","🍑","🥭","🍍","🥥","🥝",
    "🍅","🍆","🥑","🥦","🥬","🥒","🌽","🥕","🫛","🧄","🧅","🥔","🍠","🥜","🌰","🍞","🥐","🥖","🥨","🥯","🥞","🧇","🧀",
    "🍖","🍗","🥩","🥓","🍔","🍟","🍕","🌭","🥪","🌮","🌯","🥙","🧆","🥚","🍳","🥘","🍲","🥣","🥗","🍿","🧈","🧂","🥫",
    "🍱","🍘","🍙","🍚","🍛","🍜","🍝","🍠","🍢","🍣","🍤","🍥","🥮","🍡","🧁","🍦","🍧","🍨","🍩","🍪","🎂","🍰","🍫",
    "🍬","🍭","🍮","🍯","🍼","🥛","☕","🍵","🧃","🥤","🧋","🍺","🍻","🥂","🍷","🥃","🍸","🍹","🍾","🫖","⚽","🏀","🏈",
    "⚾","🎾","🏐","🏉","🥏","🎱","🏓","🏸","🥅","🏒","🏑","🏏","🥍","🏹","🎣","🤿","🥊","🥋","🎽","🛹","🛼","🛷","⛸️",
    "🎿","⛷️","🏂","🪂","🏋️","🤼","🤸","⛹️","🤺","🤾","🏌️","🏇","🧘","🎯","🎳","🎮","🕹️","🎰","🎲","🧩","♟️","🧸","🪅",
    "🪆","🪀","🪁","🎴","🎭","🎨","🧵","🧶","🪡","🪢","🪚","🔨","🛠️","⚙️","🧰","🪛","🪤","🪓","🔧","⛏️","⚒️","🧲","🪙",
    "💎","⚖️","💡","🔦","🏮","🪔","🕯️","📔","📕","📖","📗","📘","📙","📚","📓","📒","📃","📜","📄","📰","🗞️","📑","🔖",
    "🏷️"}; //lista de 200 emojis diferentes

    public Tablero(int filas, int cols) {
        if (filas < 1 || filas > 20 || cols < 1 || cols > 20) { //verifica que las dimensiones ingresadas estén dentro del rango permitido
            throw new IllegalArgumentException("Las dimensiones del tablero deben estar entre 1 y 20");
        }

        if ((filas*cols) %2 != 0) { //Verifica que las casillas totales sean pares para poder jugar
            throw new IllegalArgumentException("El número total de casillas debe ser par para poder tener pares");
        }

        this.filas = filas;
        this.cols = cols;
        this.celdas = new Celda[filas][cols]; //crea las celdas según las dimensiones ingresadas
    }

    public void inicializarAleatorio() { //crea el tablero con emojis aleatorios
        int totalCasillas = this.filas * this.cols;
        int paresNecesarios = totalCasillas / 2; //calcula los pares de emojis necesarios

        if (EMOJI_BASE.length < paresNecesarios) {
            throw new IllegalArgumentException("No hay suficientes emojis únicos para este tamaño de tablero");
        }

        for (int i = 0; i < this.filas; i++) { //llena todas las casillas con null
            for (int j = 0; j < this.cols; j++) {
                this.celdas[i][j] = null;
            }
        }

        Random rnd = new Random();

        for (int k = 0; k < paresNecesarios; k++) {
            String emoji = EMOJI_BASE[k];

            int colocados = 0;
            while (colocados < 2) { //coloca cada emoji dos veces en posiciones aleatorias
                int i = rnd.nextInt(this.filas);
                int j = rnd.nextInt(this.cols);

                if (this.celdas[i][j] == null) {
                    this.celdas[i][j] = new Celda(emoji);
                    colocados ++;
                }
            }
        }
    }

    public boolean todasEmparejadas() { //verifica si todas las celdas ya están emparejadas
        for (int i= 0; i < this.filas; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (!this.celdas[i][j].isEmparejada()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Getters
    public int getFilas() {
        return this.filas;
    }

    public int getCols() {
        return this.cols;
    }

    public Celda getCelda(int fila, int col) {
        return this.celdas[fila][col];
    }
}