import java.util.List;

public class Habilidad {
    private String nombre;
    private String tipo; //defiende o ataca
    private int efecto;

    public Habilidad(String nombre, String tipo, int efecto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.efecto = efecto;
    }

    public void aplicarEfecto(Enemigo enemigo, Jugador jugador, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        if (this.tipo.equals("ATACAR")) {
            jugador.recibirAtaque(efecto, enemigos, jugadores, e, j, cantEnemigos, cantJugadores);
        } else {
            int vida = jugador.getVidaActual();
            int vidaNueva = vida += efecto;
            if (vidaNueva > jugador.getVidaTotal()) {
                enemigo.setVidaActual(vida)
            } else {
                enemigo.setVidaActual(vidaNueva)
            }
        }
    }

    @Override
    public String toString() {
        return "(" + nombre + ", " + tipo + ", " + efecto + ")";
    }
}