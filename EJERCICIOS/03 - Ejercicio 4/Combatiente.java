import java.util.List;

public abstract class Combatiente {
    protected String nombre;
    protected int vidaTotal;
    protected int vidaActual;
    protected int ataque; //valor numérico de su ataque
    protected String bando; //JUGADOR / ENEMIGO
    protected String tipo; //Normal o Jefe (enemigos) / Explorador o Guerrero (Jugadores)

    public Combatiente(String nombre, int vidaTotal, int ataque, String bando, String tipo) {
        this.nombre = nombre;
        this.vidaTotal = vidaTotal;
        this.vidaActual = vidaTotal; //la vida actual inicia como su vida total al inicio de la batalla
        this.ataque = ataque;
        this.bando = bando;
        this.tipo = tipo;
    }


    public void recibirAtaque(int cantidad, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        this.vidaActual -= cantidad; //valor del ataque que se recibe
        if (vidaActual <= 0) { //si la vida actual es menor a 0, se establece en 0 y el combatiente muere
            vidaActual = 0;
            if (bando.equals("JUGADOR")) {
            jugadores.remove(j);
            cantJugadores = jugadores.size(); //si muere un jugador, se elimina de la lista de jugadores que están en la batalla
            } else {
            enemigos.remove(e);
            cantEnemigos = enemigos.size(); //si muere un enemigo, se elimina de la lista de enemigos que están en la batalla
            }
        }
    }

    public boolean vivo() {
        return vidaActual > 0; //verifica si un combatiente sigue en batalla o no
    }

    //getters
    public String getNombre() {
        return this.nombre;
    }

    public int getVidaTotal() {
        return this.vidaTotal;
    }

    public int getVidaActual() {
        return this.vidaActual;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public String getBando() {
        return this.bando;
    }

    public String getTipo() {
        return this.tipo;
    }

    //setters
    public void setVidaActual(int vida) {
        this.vidaActual = vida;
    }

    public String status() { //muestra el estado de un combatiente
        return "Vida " + nombre + ": " + vidaActual + "/" + vidaTotal;
    }
}