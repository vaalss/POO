public class Station extends Equipment implements IAccionable, IRegistrable, IMedible {

    private String accion, medicion, registro;

    public Station(String nombre, int consumo) {
        super(nombre, consumo);
    }

    @Override
    public void trabajo(String accion, String medicion, String registro) {
        this.realizarAccion(accion);
        this.realizarMedicion(medicion);
        this.realizarRegistro(registro);
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

    @Override
    public String toString() {
        return "Estación meteorológica #" + this.ID + ": \n- Nombre: " + this.nombre + "\n- Consumo de energía: " + this.consumo +
        "W\n- Capacidades: \n  - " + this.accion + "\n  - " + this.medicion + "\n  - " + this.registro;  
    }
}