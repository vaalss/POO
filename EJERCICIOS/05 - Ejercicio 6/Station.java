public class Sensor extends Equipment implements IAccionable, IRegistrar, IMedible {
    
    public String accion;
    public String registrar;
    public String medir;

    public Drone(String nombre, double consumo) {
        super(nombre, consumo);
    }


    //getters
    public String getAccion() {
        return this.accion;
    }

    public String getRegistrar() {
        return this.registrar;
    }

    public String getMedir() {
        return this.medir;
    }
}