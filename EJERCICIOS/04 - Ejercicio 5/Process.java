public abstract class Process {
    protected int PID;
    protected String nombre;
    protected static int contador = 0;

    public Process(String nombre){
    this.nombre = nombre;
    this.PID = contador++;
    }

    public abstract String ejecutar(); //agregar firma

    public int getPID() {
        return this.PID;
    }

    public String getNombre() {
        return this.nombre;
    }
}