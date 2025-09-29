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

    //aplicarEfecto recibe como parametros el enemigo al que se ataca, el jugador que ataca o que se defiende, la lista de jugadores y enemigos, los índices y la cantidad de combatientes
    public void aplicarEfecto(Enemigo enemigo, Jugador jugador, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        if (this.tipo.equals("ATACAR")) { //si el item es para atacar, un enemigo recibe el daño
            enemigo.recibirAtaque(efecto, enemigos, jugadores, e, j, cantEnemigos, cantJugadores);
        } else { //si el item es de defensa
            int vida = jugador.getVidaActual();
            int vidaNueva = vida += efecto; //se suma el valor del item a la vida actual
            if (vidaNueva > jugador.getVidaTotal()) { //si la vida actual supera el máximo de la vida tota, se establece como la vida total
                jugador.setVidaActual(jugador.getVidaTotal());
            } else {
                jugador.setVidaActual(vidaNueva); //si la nueva vida no supera el máximo, el valor permanece
            }
        }
    }

    //Getter
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public String toString() {
        return "(" + nombre + ", " + tipo + ", " + efecto + ")";
    }
}