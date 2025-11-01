public class Drone extends Equipment implements IMedible, IRegistrar {

    public Drone(String nombre, double consumo) {
        super(nombre, consumo);
    }

    @Override
    public String realizarMedicion(String medicion) {
        return  "Realiza la siguiente medición: \n" + medicion;
    }

    @Override
    public String realizarRegistro(String registro) {
        return "Realiza el siguiente registro: \n" + registro;
    }

    @Override

    //getters
    public String getNombre() {
        return this.nombre;
    }

    public int getID() {
        return this.ID;
    }

     @Override
    public String toString() {
        return "Dron #" + this.ID + ": \n- Nombre: " + this.nombre + "\n- Consumo de energía: " + this.comsumo +
        "\n- Capacidades: \n  - " + "\n  - " + this.realizarMedicion() + "\n  - " + this.realizarRegistro();  
    }
}