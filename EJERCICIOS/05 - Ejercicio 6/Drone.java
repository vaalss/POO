public class Drone extends Equipment implements IMedible, IRegistrar {

    public Drone(String nombre, double consumo) {
        super(nombre, consumo);
    }


    //getters
    public String getNombre() {
        return this.nombre;
    }

    public int getID() {
        return this.ID;
    }

    public double getConsumo() {
        return this.consumo;
    }
}