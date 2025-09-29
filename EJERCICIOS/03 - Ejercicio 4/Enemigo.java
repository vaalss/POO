import java.util.List;
import java.util.ArrayList;

public abstract class Enemigo extends Combatiente {
    protected List<Habilidad> habilidades;

    public Enemigo(String nombre, int vidaTotal, int ataque, String tipo) {
        super(nombre, vidaTotal, ataque, "ENEMIGO", tipo);
        this.habilidades = new ArrayList<Habilidad>();
    }

    public void usarHabilidad(int i, Enemigo enemigo, Jugador jugador, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        habilidades.get(i).aplicarEfecto(enemigo, jugador, enemigos, jugadores, e, j, cantEnemigos, cantJugadores);
    }

    public List<Habilidad> getHabilidades() {
        return this.habilidades;
    }

    @Override
    public String toString() {
        return nombre + " [Vida total: " + vidaTotal + ", tipo: " + tipo + ", ataque: " + ataque + ", habilidades: " + habilidades + " ]";
    }
}