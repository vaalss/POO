public class Drone extends Equipment implements IMedible, IRegistrable {

    private String medicion, registro;

    public Drone(String nombre, int consumo) {
        super(nombre, consumo);
    }

    @Override
    public void trabajo(String accion, String medicion, String registro) {
        this.realizarMedicion(medicion);
        this.realizarRegistro(registro);
    }

    @Override
    public void realizarMedicion(String medicion) {
        this.medicion = "Realiza la siguiente medición: \n" + medicion;
    }

    @Override
    public void realizarRegistro(String registro) {
        this.registro = "Realiza el siguiente registro: \n" + registro;
    }

     @Override
    public String toString() {
        return "Dron #" + this.ID + ": \n- Nombre: " + this.nombre + "\n- Consumo de energía: " + this.consumo +
        "\n- Capacidades: \n  - " + "\n  - " + this.medicion + "\n  - " + this.registro;  
    }
}