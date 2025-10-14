//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Seccion 40
//Valeria Hernández Maldonado 25086

public class Farmaceutico extends Medico {
    private int prescripciones; //límite de prescripciones que puede realizar
    private double comision; //comision por procedimiento
    private boolean licencia;//determina si cuenta con licencia para sustancias controladas

    public Farmaceutico(String nombre, String departamento, int experiencia, double salarioBase, boolean disponible, int prescripciones, double comision, boolean licencia) {
        super(nombre, departamento, experiencia, salarioBase, disponible);
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

    public void recibirCita(Cita c) {
        this.atendidos ++;
        int horas = c.getHoraFinal() - c.getHoraInicio();
        this.horasTrabajadas += horas;
    }

    public double calcularSalario() {
        double salario = this.salarioBase + (this.atendidos * this.comision);
        return salario;
    }

    public boolean getDisponibilidad() {
        if (this.atendidos < this.prescripciones) {
            this.disponible = true;
        } else {
            this.disponible = false;
        }
        return this.disponible;
    }

    @Override
    public String toString() {
        return "Farmacéutico #" + this.ID + ": \n- Nombre:" + this.nombre + "\n- Departamento: " + this.departamento + 
        "\n- Experiencia: " + this.experiencia + " años \n- Salario base: Q." + this.salarioBase + "\n- Salario final: Q." + calcularSalario() +
        "\n- Horas Trabajadas: " + this.horasTrabajadas + "\n- Pacientes atendidos: " + this.atendidos + "\n- Prescripciones por día: " + this.prescripciones +
        "\n- Comision por procedimiento: " + this.comision + ((licencia) ? "\n- Licencia para sustancias controladas" : "\n- Sin licencia para sustancias controladas");    
    }
}