public class Sensor extends Equipment implements IAccionable, IRegistrar {

    public Drone(String nombre, double consumo) {
        super(nombre, consumo);
    }

    @Override
        public String realizarAccion(String accion) {
            return "Realiza la siguiente acción: \n" + accion;
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

    public double getConsumo() {
        return this.consumo;
    }
}