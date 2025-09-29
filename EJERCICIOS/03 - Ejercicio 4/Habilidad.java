import java.util.List;

public class Habilidad {
    private String nombre;
    private String tipo; //defiende o ataca
    private int efecto;//valor numérico de su efecto

    public Habilidad(String nombre, String tipo, int efecto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.efecto = efecto;
    }

    //aplicarEfecto recibe como parametros el jugador al que se ataca, el enemigo que ataca o que se defiende, la lista de jugadores y enemigos, los índices y la cantidad de combatientes
    public void aplicarEfecto(Enemigo enemigo, Jugador jugador, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        if (this.tipo.equals("ATACAR")) { //si la habilidad es para atacar, el jugador que lo recibe recibe el daño
            jugador.recibirAtaque(efecto, enemigos, jugadores, e, j, cantEnemigos, cantJugadores);
        } else { //si la habilidad es para defenderse
            int vida = jugador.getVidaActual();
            int vidaNueva = vida += efecto; //se suma el efecto a la vida actual del jugador
            if (vidaNueva > jugador.getVidaTotal()) { //si la vida actual supera la vida total (máxima), se establece la vida actual como la totas
                enemigo.setVidaActual(vida);
            } else {
                enemigo.setVidaActual(vidaNueva); //si la vida actual no es superior a la máxima, se queda ese valor
            }
        }
    }

    @Override //sobresritura dl emétodo toString
    public String toString() {
        return "(" + nombre + ", " + tipo + ", " + efecto + ")";
    }
}