public abstract class Equipment implements Comparable {

    protected int ID;
    protected static int contador;
    protected String nombre;
    protected double consumo;

    public Equipment(String nombre, double consumo) {
        this.ID = contador++;
        this.nombre = nombre;
        this.consumo = consumo;
    }

    @Override
    public int compareTo(Equipment otro) {
        return Integer.compare(this.consumo, otro.consumo);
    }
}