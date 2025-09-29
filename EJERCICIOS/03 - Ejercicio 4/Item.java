import java.util.List;

public class Item {
    private String nombre;
    private String tipo; //defiende o ataca
    private int efecto;

    public Item(String nombre, String tipopcion, int efecto) {
        this.nombre = nombre;
        this.tipo = tipopcion;
        this.efecto = efecto;
    }

    public void aplicarEfecto(Enemigo enemigo, Jugador jugador, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        if (this.tipo.equals("ATACAR")) {
            enemigo.recibirAtaque(efecto, enemigos, jugadores, e, j, cantEnemigos, cantJugadores);
        } else {
            int vida = jugador.getVidaActual();
            int vidaNueva = vida += efecto;
            if (vidaNueva > jugador.getVidaTotal()) {
                jugador.setVidaActual(jugador.getVidaTotal());
            } else {
                jugador.setVidaActual(vidaNueva)
            }
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "(" + nombre + ", " + tipo + ", " + efecto + ")"
    }
}