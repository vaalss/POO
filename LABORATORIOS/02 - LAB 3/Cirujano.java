public class Cirujano extends Medico {
    private String tipo;
    private int horasDisponible;
    private double tarifa;
    private double bonificacion;

    public Cirujano(String tipo, int horasDisponible, double tarifa, double bonificacion) {
        super(nombre, experiencia, salarioBase, disponible);
        this.tipo = tipo;
        this.horasDisponible = horasDisponible;
        this.tarifa = tarifa;
        this.bonificacion = bonificacion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getHorasDisponible() {
        return this.horasDisponible;
    }

    public double getTarifa() {
        return this.tarifa;
    }

    public getBonificacion() {
        return this.bonificacion;
    }
}