//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Seccion 40
//Valeria Hernández Maldonado 25086


public class Cirujano extends Medico {
    private String tipo; //tipo de cirujano
    private int horasDisponible; //cantidad de horas disponible para trabajar
    private double tarifa; //tarifa por hora
    private double bonificacion; //monto de bonificación por operación riesgosa
    private boolean bono; //indica si debe sumarse el bono por riesgo o no

    public Cirujano(String nombre, String departamento, int experiencia, double salarioBase, boolean disponible, String tipo, int horasDisponible, double tarifa, double bonificacion) {
        super(nombre, departamento, experiencia, salarioBase, disponible);
        this.tipo = tipo;
        this.horasDisponible = horasDisponible;
        this.tarifa = tarifa;
        this.bonificacion = bonificacion;
        this.bono = false; //se inicializa como false siempre
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

    public double getBonificacion() {
        return this.bonificacion;
    }

    public void recibirCita(Cita c) { 
        this.atendidos++; //al recibir una cita se incrementa el número de pacientes que ha atendido
        int horas = c.getHoraFinal() - c.getHoraInicio(); 
        this.horasDisponible -= horas; //disminuye la cantidad de horas que aún puede trabajar según la duración de la cita
        if (this.horasDisponible < 0) {
            this.horasDisponible = 0;
        }
        this.horasTrabajadas += horas;
        if(c.getDescripcion().toLowerCase().contains("riesgo")) { //determina si tiene bono por operación riesgos
            this.bono = true;
        }

    }

    public double calcularSalario() {
        double salario = this.salarioBase + (this.horasTrabajadas * this.tarifa);
        if (bono) { //calcula el salario por su tarifa y horas trabajadas y ssegún si tiene o no el bono
            salario += this.bonificacion;
        }
        return salario;
    }
    
    public boolean getDisponibilidad() { //determina si todavía puede recibir otra cita o ya no
        if (this.horasTrabajadas < this.horasDisponible) {
            this.disponible = true;
            return this.disponible;
        } else {
            this.disponible = false;
            return this.disponible;
        }
    }

    @Override
    public String toString() {
        return "Cirujano #" + this.ID + ": \n- Nombre:" + this.nombre + "\n- Departamento: " + this.departamento + 
        "\n- Experiencia: " + this.experiencia + " años \n- Salario base: Q." + this.salarioBase + "\n- Salario final: Q." + calcularSalario() +
        "\n- Horas Trabajadas: " + this.horasTrabajadas + "\n- Pacientes atendidos: " + this.atendidos + "\n- Tipo de cirujano: " + this.tipo + 
        "\n- Horas disponibles: " + this.horasDisponible + "\n- Tarifa por cirujía: " + this.tarifa + "\n- Bonificación por riesgo: " + this.bonificacion;    
    }
}