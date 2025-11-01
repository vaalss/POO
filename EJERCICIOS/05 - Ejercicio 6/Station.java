public class Sensor extends Equipment implements IAccionable, IRegistrar, IMedible {

    public Drone(String nombre, double consumo) {
        super(nombre, consumo);
    }


    @Override
    public String realizarAccion(String accion) {
        return "Realiza la siguiente acción: \n" + accion;
    }

    @Override
    public String realizarMedicion(String medicion) {
        return  "Realiza la siguiente medición: \n" + medicion;
    }

    @Override
    public String realizarRegistro(String registro) {
        return "Realiza el siguiente registro: \n" + registro;
    }

    //getters
    public String getNombre() {
        return this.nombre;
    }

    public int getID() {
        return this.ID;
    }

    @Override
    public String toString() {
        return "Estación meteorológica #" + this.ID + ": \n- Nombre: " + this.nombre + "\n- Consumo de energía: " + this.comsumo +
        "\n- Capacidades: \n  - " + this.realizarAccion() + "\n  - " + this.realizarMedicion() + "\n  - " + this.realizarRegistro();  
    }
}