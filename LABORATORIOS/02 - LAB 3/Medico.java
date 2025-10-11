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

    
}