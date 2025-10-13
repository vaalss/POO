public abstract class Medico {
    protected int ID;
    protected static int contador = 0;
    protected String nombre;
    protected String departamento;
    protected int experiencia;
    protected double salarioBase;
    protected boolean disponible;
    protected int horasTrabajadas;
    protected int atendidos;

    public Medico(String nombre, String departamento, int experiencia, double salarioBase, boolean disponible) {
        this.ID = this.contador++;
        this.nombre = nombre;
        this.departamento = departamento;
        this.experiencia = experiencia;
        this.salarioBase = salarioBase;
        this.disponible = disponible;
        this.horasTrabajadas = 0;
        this.atendidos = 0;
    }

    public abstract void recibirCita();
    
    public abstract double calcularSalario();

    @Override 
    public abstract String toString();

    public String calcularEficiencia() {
        if (horasTrabajadas != 0) {
            int eficiencia = (double)this.atendidos / this.horasTrabajadas;
            double redondeado = Double.parseDouble(String.format("%.2f", eficiencia));
            return this.nombre + " - eficiencia del: " + redondeado + "%";
        } else {
            return this.nombre " no ha trabajado"
        }
    }

    public int getID() {
        return this.ID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDepartamento() {
        return this.departamento;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public double getSalarioBase() {
        return this.salarioBase;
    }

    public boolean getDisponibilidad() {
        return this.disponible;
    }

    public int getHorasTrabajadas() {
        return this.horasTrabajadas;
    }

    public int getAtendidos() {
        return this.atendidos;
    }

    public void setDisponible (boolean disponible) {
        this.disponible = disponible;
    }

    public void setHorasTrabajadas(int horas) {
        this.horasTrabajadas += horas
    }

    public void setAtendidos() {
        this.atendidos ++;
    }
}