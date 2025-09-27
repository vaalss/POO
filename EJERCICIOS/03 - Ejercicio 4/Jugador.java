public abstract class Jugador extends Combatiente {
    protected List<Item> inventario;

    public Jugador(String nombre, int vidaTotal, int ataque) {
        super(nombre, vidaTotal, ataque);
        this.inventario = new ArrayList<>();
    }

    public void usarItem(Item item, Combatiente objetivo) {
        item.aplicarEfecto(objetivo);
        inventario.remove(item); //para que no se usa más de una vez
    }

    public abstract int elegirAccion();
    public abstract Combatiente elegirObjeto(List<Combatiente> posibles);

    public List<Item> getInventario() {
        return this.inventario;
    }
}