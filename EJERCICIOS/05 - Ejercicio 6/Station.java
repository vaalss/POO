public class Sensor extends Equipment implements IAccionable, IRegistrar, IMedible {

    private String accion, medicion, registro;

    public Drone(String nombre, double consumo) {
        super(nombre, consumo);
    }


    @Override
    public void realizarAccion(String accion) {
        this.accion = "Realiza la siguiente acción: " + accion;
    }

    @Override
    public void realizarMedicion(String medicion) {
        this.medicion =  "Realiza la siguiente medición: " + medicion;
    }

    @Override
    public void realizarRegistro(String registro) {
        this.registro =  "Realiza el siguiente registro: " + registro;
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
        "\n- Capacidades: \n  - " + this.accion + "\n  - " + this.medicion + "\n  - " + this.registro;  
    }
}