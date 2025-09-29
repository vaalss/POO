import java.util.List;
import java.util.ArrayList;

public abstract class Jugador extends Combatiente {
    protected List<Item> inventario; //los jugadores tiene un inventario con items

    public Jugador(String nombre, int vidaTotal, int ataque, String tipo) {
        super(nombre, vidaTotal, ataque, "JUGADOR", tipo); //llama al constructor de Combatiente
        this.inventario = new ArrayList<Item>();
    }

    public String mostrarMensajeInicio() { //mensaje cuando un jugador ataca
        return "\n" + nombre + " ha entrado en combate 🔫" + "\n";
    }

    public String mostrarMensajeFinal() {
        if (this.vivo()) { //mensaje cuando se acaba la batalla
            return "\n" + nombre + " ha ganado la batalla ⭐" + "\n";
        } else {
            return "\n" + nombre + " ha perdido la batalla 👎" + "\n";
        }
    }

    //aplica el efecto del item seleccionado
    public void usarItem(int i, Enemigo enemigo, Jugador jugador, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        inventario.get(i).aplicarEfecto(enemigo, jugador, enemigos, jugadores, e, j, cantEnemigos, cantJugadores);
    }

    public List<Item> getInventario() {
        return this.inventario; //permite acceder a la lista de items disponibles
    }

    @Override //sobrescritura del método toString
    public String toString() {
        return nombre + " [Vida total: " + vidaTotal + ", tipo: " + tipo + ", ataque: " + ataque + ", items: " + inventario + " ]";
    }
}