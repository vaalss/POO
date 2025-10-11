public class Doctor extends Medico {
    private String especializacion;
    private int capacidad;
    private double tarifa;

    private Doctor(String especializacion, int capacidad, double tarifa) {
        super(nombre, experiencia, salarioBase, disponible);
        this.especializacion = especializacion;
        this.capacidad = capacidad;
        this.tarifa = tarifa;
    }

    public String getEspecializacion() {
        return this.especializacion;
    } 

    public int getCapacidad() {
        return this.capacidad;
    }

    public double getTarifa() {
        return this.tarifa;
    }
}