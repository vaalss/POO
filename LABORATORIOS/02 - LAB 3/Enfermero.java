public class Enfermero extends Medico {
    public String turno;
    public String nivel;
    public double bonificacion;

    public Enfermero(String nombre, int experiencia, double salarioBase, boolean disponible, String turno, String nivel, double bonificacion) {
        super(nombre, experiencia, salarioBase, disponible);
        this.turno = turno;
        this.nivel = nivel;
        this.bonificacion = bonificacion;
    }

    public String getTurno() {
        return this.turno;
    }

    public String getNivel() {
        return this.nivel;
    }

    public double getBonificacion() {
        return this.bonificacion;
    }

    public boolean bonificacionActiva() {
        if (this.turno.equals("NOCHE")) {
            return true;
        } else {
            return false;
        }
    }

    public void recibirCita() {
        this.atendidos++;
    }

    public double calcularSalario() {
        if (this.turno.equals("NOCHE")) {
            double salario = this.salarioBase + this.bonificacion;
        } else {
            double salario = this.salarioBase;
        }
        return salario;
    }

    public boolean getDisponibilidad() {
        return this.disponible;
    }

    @Override
    public String toString() {
        return "Enfermero #" + this.ID + ": \n- " + this.nombre + "\n- Departamento: " + this.departamento + 
        "\n- Experiencia: " + this.experiencia + " años \n- Salario base: Q." + this.salarioBase + "\n- Salario final: Q." + calcularSalario() +
        "\n- Horas Trabajadas: " + this.horasTrabajadas + "\n- Pacientes atendidos: " + this.atendidos + "\n- Turno: " + this.turno + "\n- Nivel: " + this.nivel +
        ((this.turno.equals("NOCHE")) ? ("\n- Bonificación por turno de noche: " + this.bonificacion) : "");    
    }
}