public abstract class Equipment implements Comparable<Equipment> {

    protected int ID;
    protected static int contador;
    protected String nombre;
    protected int consumo;

    public Equipment(String nombre, int consumo) {
        this.ID = contador++;
        this.nombre = nombre;
        this.consumo = consumo;
    }

    public abstract void trabajo(String accion, String medicion, String resgistro);

    //getters
    public String getNombre() {
        return this.nombre;
    }

    public int getID() {
        return this.ID;
    }

    public int getConsumo() {
        return this.consumo;
    }

    @Override
    public int compareTo(Equipment otro) {
        return Integer.compare(this.consumo, otro.consumo);
    }
}