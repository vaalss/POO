public class Sensor extends Equipment implements IAccionable, IRegistrable {

    private String accion, registro;

    public Sensor(String nombre, int consumo) {
        super(nombre, consumo);
    }

    @Override
    public void trabajo(String accion, String medicion, String registro) {
        this.realizarAccion(accion);
        this.realizarRegistro(registro);
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
        return "Sensor de suelo #" + this.ID + ": \n- Nombre: " + this.nombre + "\n- Consumo de energía: " + this.consumo +
        "W\n- Capacidades: \n  - " + "\n  - " + this.accion + "\n  - " + this.registro;  
    }
}