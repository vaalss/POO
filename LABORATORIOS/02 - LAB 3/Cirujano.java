public class Cirujano extends Medico {
    private String tipo;
    private int horasDisponible;
    private double tarifa;
    private double bonificacion;

    public Cirujano(String nombre, int experiencia, double salarioBase, boolean disponible, String tipo, int horasDisponible, double tarifa, double bonificacion) {
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

    public void recibirCita(Cita c) {
        this.atendidos++;
        int horas = c.getHoraFinal() - c.getHoraInicio();
        this.horasDisponible -= horas;
        if (this.horasDisponible < 0) {
            this.horasDisponible = 0;
        }

    }

    public double calcularSalario(Cita c) {
        int horas = c.getHoraFinal() - c.getHoraInicio();
        double salario = this.salarioBase + (horas * this.tarifa);
        if(c.getDescripcion().toLowerCase().contains("riesgo")) {
            salario += this.bonificacion;
        }
        return salario;
    }
    
    public boolean getDisponibilidad() {
        if (this.horasTrabajadas < this.horasDisponible) {
            this.disponible = true;
        } else {
            this.disponible = false;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cirujano #" + this.ID + ": \n- " + this.nombre + "\n- Departamento: " + this.departamento + 
        "\n- Experiencia: " + this.experiencia + " años \n- Salario base: Q." + this.salarioBase + "\n- Salario final: Q." + calcularSalario() +
        "\n- Horas Trabajadas: " + this.horasTrabajadas + "\n- Pacientes atendidos: " + this.atendidos + "\n- Tipo de cirujano: " + this.tipo + 
        "\n- Horas disponibles: " + this.horasDisponible + "\n- Tarifa por cirujía: " + this.tarifa + "\n- Bonificación por riesgo: " + this.bonificacion;    
    }
}