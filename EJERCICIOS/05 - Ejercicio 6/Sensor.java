public class Sensor extends Equipment implements IAccionable, IRegistrar {
    
    public String accion;
    public String registrar;

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
}