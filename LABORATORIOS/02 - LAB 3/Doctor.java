//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Seccion 40
//Valeria Hernández Maldonado 25086

public class Doctor extends Medico {
    private String especializacion; //especialización del medico
    private int capacidad; //capacidad máxima de pacientes que atiende
    private double tarifa; //tarifa por consulta 

    public Doctor(String nombre, String departamento, int experiencia, double salarioBase, boolean disponible, String especializacion, int capacidad, double tarifa) {
        super(nombre, departamento, experiencia, salarioBase, disponible);
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

    public void recibirCita(Cita c) {
        this.atendidos++;
        int horas = c.getHoraFinal() - c.getHoraInicio();
        this.horasTrabajadas += horas;
    }

    public double calcularSalario() {
        double bono = this.atendidos * this.tarifa;
        double salario = this.salarioBase + bono;
        return salario; //suma la cantidad de pacientes por la tarifa al salario base
    }

    public boolean getDisponibilidad() { //verifica si todavía puede atender a otro paciente, o ya no
        if (this.atendidos < this.capacidad) {
            this.disponible = true;
        } else {
            this.disponible = false;
        }
        return this.disponible;
    }

    @Override
    public String toString() {
        return "Doctor #" + this.ID + ": \n- Nombre:" + this.nombre + "\n- Departamento: " + this.departamento + 
        "\n- Experiencia: " + this.experiencia + " años \n- Salario base: Q." + this.salarioBase + "\n- Salario final: Q." + calcularSalario() +
        "\n- Horas Trabajadas: " + this.horasTrabajadas + "\n- Pacientes atendidos: " + this.atendidos + "\n- Capacidad máxima/día: " + this.capacidad + 
        "\n- Tarifa por consulta: " + this.tarifa + "\n- Especialización: " + this.especializacion;    
    }
}