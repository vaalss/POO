public class Jugador {
    private final String nombre; //nombre del jugador
    private int pares; //pares encontrados

    public Jugador(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            this.nombre = "Jugador"; //si no se ingresa un nombre se llama "Jugador"
        } else {
            this.nombre = nombre;
        }
        this.pares = 0;
    }

    public void anotarPar() { //suma uno a los pares encontrados
        this.pares ++;
    }

    public void reiniciarPares() { //reinicia los pares encontrados para jugar otra ronda
        this.pares = 0;
    }

    //Getters
    public String getNombre() {
        return this.nombre;
    }

    public int getPares() {
        return this.pares;
    }

    @Override
    public String toString() {
        if (this.pares == 1) {
            return this.nombre + "(" + this.pares + " par encontrado)";
        }
        else {
            return this.nombre + "(" + this.pares + " pares encontrados)";
        }
    }

}