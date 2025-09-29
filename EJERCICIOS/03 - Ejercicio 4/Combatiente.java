import java.util.List;

public abstract class Combatiente {
    protected String nombre;
    protected int vidaTotal;
    protected int vidaActual;
    protected int ataque;
    protected String bando;
    protected String tipo;

    public Combatiente(String nombre, int vidaTotal, int ataque, String bando, String tipo) {
        this.nombre = nombre;
        this.vidaTotal = vidaTotal;
        this.vidaActual = vidaTotal;
        this.ataque = ataque;
        this.bando = bando;
        this.tipo = tipo;
    }


    public void recibirAtaque(int cantidad, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        this.vidaActual -= cantidad;
        if (vidaActual <= 0) {
            vidaActual = 0;
            if (bando.equals("JUGADOR")) {
            jugadores.remove(j);
            cantJugadores = jugadores.size();
            } else {
            enemigos.remove(e);
            cantEnemigos = enemigos.size();
            }
        }
    }

    public boolean vivo() {
        return vidaActual > 0;
    }

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

    public void setVidaActual(int vida) {
        this.vidaActual = vida;
    }

    public String status() {
        return "Vida " + nombre + ": " + vidaActual + "/" + vidaTotal;
    }
}