public class Sensor extends Equipment implements IAccionable, IRegistrar {

    private String accion, registro;

    public Sensor(String nombre, double consumo) {
        super(nombre, consumo);
    }

    @Override
    public void realizarAccion(String accion) {
        this.accion = "Realiza la siguiente acción: " + accion;
    }

    @Override
    public void realizarRegistro(String registro) {
        this.registro = "Realiza el siguiente registro: " + registro;
    }

    @Override
    public String toString() {
        return "Sensor de suelo #" + this.ID + ": \n- Nombre: " + this.nombre + "\n- Consumo de energía: " + this.comsumo +
        "\n- Capacidades: \n  - " + "\n  - " + this.accion + "\n  - " + this.registro;  
    }
}