public abstract class Jugador extends Combatiente {
    protected List<Item> inventario;

    public Jugador(String nombre, int vidaTotal, int ataque) {
        super(nombre, vidaTotal, ataque);
        this.inventario = new ArrayList<>();
    }
}