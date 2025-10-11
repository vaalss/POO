public abstract class Medico {
    protected int ID;
    protected static int contador = 0;
    protected String nombre;
    protected int experiencia;
    protected double salarioBase;
    protected boolean disponible;
    protected int horasTrabajadas;
    protected int atendidos;

    public Medico(String nombre, int experiencia, double salarioBase, boolean disponible) {
        this.ID = this.contador++;
        this.nombre = nombre;
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
        if (horasTrabajadas =! 0) {
            double eficiencia = this.atendidos / this.horasTrabajadas;
            double redondeado = Double.parseDouble(String.format("%.2f", eficiencia));
            return this.nombre + " - eficiencia del: " + redondeado + "%";
        } else {
            return this.nomre " no ha trabajado"
        }
    }
}