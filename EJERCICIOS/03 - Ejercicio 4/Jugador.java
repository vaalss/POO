public abstract class Jugador extends Combatiente {
    protected List<Item> inventario;

    public Jugador(String nombre, int vidaTotal, int ataque, String tipo) {
        super(nombre, vidaTotal, ataque, "JUGADOR", tipo); 
        this.inventario = new ArrayList<Item>();
    }

    public String mostrarMensajeInicio() {
        return "\n" + nombre + " ha entrado en combate" + "\n";
    }

    public String mostrarMensajeFinal() {
        if (this.vivo()) {
            return "\n" + nombre + " ha ganado la batalla" + "\n";
        } else {
            return "\n" + nombre + " ha perdido la batalla" + "\n";
        }
    }

    public void usarItem(int i, Enemigo enemigo, Jugador jugador, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        inventario.get(i).aplicarEfecto(enemigo, jugador, enemigos, jugadores, e, j, cantEnemigos, cantJugadores);
    }

    public List<Item> getInventario() {
        return this.inventario;
    }

    @Override
    public String toString() {
        return nombre + " [Vida total: " + vidaTotal + ", tipo: " + tipo + ", ataque: " + ataque + ", items: " + inventario + " ]";
    }
}