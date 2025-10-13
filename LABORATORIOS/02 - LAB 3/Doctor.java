public class Doctor extends Medico {
    private String especializacion;
    private int capacidad;
    private double tarifa;

    private Doctor(String nombre, int experiencia, double salarioBase, boolean disponible, String especializacion, int capacidad, double tarifa) {
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

    public void recibirCita() {
        this.atendidos++;
    }

    public double calcularSalario() {
        double bono = this.atendidos * this.tarifa;
        double salario = this.salarioBase + bono;
        return salario;
    }

    public boolean getDisponibilidad() {
        if (this.atendidos < this.capacidad) {
            this.disponible = true;
        } else {
            this.disponible = false;
        }
        return this.disponible;
    }

    @Override
    public String toString() {
        return "Doctor #" + this.ID + ": \n- " + this.nombre + "\n- Departamento: " + this.departamento + 
        "\n- Experiencia: " + this.experiencia + " años \n- Salario base: Q." + this.salarioBase + "\n- Salario final: Q." + calcularSalario() +
        "\n- Horas Trabajadas: " + this.horasTrabajadas + "\n- Pacientes atendidos: " + this.atendidos + "\n- Capacidad máxima/día: " + this.capacidad + 
        "\n- Tarifa por consulta: " + this.tarifa + "\n- Especialización: " + this.especializacion;    
    }
}