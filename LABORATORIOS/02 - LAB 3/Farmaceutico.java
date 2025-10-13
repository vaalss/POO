public class Farmaceutico extends Medico {
    private int prescripciones;
    private double comision;
    private boolean licencia;

    public Farmaceutico(String nombre, int experiencia, double salarioBase, boolean disponible, int prescripciones, double comision, boolean licencia) {
        super(nombre, experiencia, salarioBase, disponible);
        this.prescripciones = prescripciones;
        this.comision = comision;
        this.licencia = licencia;
    }

    public int getPrescripciones() {
        return this.prescripciones;
    }

    public boolean getLicencia() {
        return this.licencia;
    }

    public void recibirCita() {
        this.atendidos ++;
    }

    public double calcularSalario() {
        double salario = this.salarioBase + (this.atendidos * this.comision);
        return salario;
    }

    @Override
    public String toString() {
        return "Farmaceútico #" + this.ID + ": \n- " + this.nombre + "\n- Departamento: " + this.departamento + 
        "\n- Experiencia: " + this.experiencia + " años \n- Salario base: Q." + this.salarioBase + "\n- Salario final: Q." + calcularSalario() +
        "\n- Horas Trabajadas: " + this.horasTrabajadas + "\n- Pacientes atendidos: " + this.atendidos + "\n- Prescripciones por día: " + this.prescripciones +
        "\n- Comision por procedimiento: " + this.comision + ((licencia) ? "\n- Licencia para sustancias controladas" : "\n- Sin licencia para sustancias controladas");    
    }
}