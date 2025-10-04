//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Sección 40
//Valeria Hernández Maldonado 25086

//clase "padre"

public abstract class Process {
    protected int PID;
    protected String nombre;
    protected static int contador = 0; //contador compartido entre todas las instancias 

    public Process(String nombre){
    this.nombre = nombre;
    this.PID = contador++;
    }

    public abstract String ejecutar();

    public int getPID() {
        return this.PID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public abstract String toString();
}