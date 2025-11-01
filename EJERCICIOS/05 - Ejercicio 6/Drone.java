public class Drone extends Equipment implements IMedible, IRegistrar {
    
    public String medir;
    public String registrar;

    public Drone(String nombre, double consumo) {
        super(nombre, consumo);
    }


    //getters
    public String getMedir() {
        return this.medir;
    }

    public String getRegistrar() {
        return this.registrar();
    }
}