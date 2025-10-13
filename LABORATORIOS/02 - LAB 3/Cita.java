public class Cita {
    private int ID;
    private static int contador;
    private String nombre;
    private Medico trabajador;
    private String fecha;
    private int horaInicio;
    private int horaFinal;
    private String tipo;
    private String decripcion;
    private String estado;
    
    public Cita(String nombre, String fecha, int horaInicio, int horaFinal, String tipo, String descripcion) {
        this.ID += this.contador++;
        this.nombre = nombre;
        this.trabajador = null;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.tipo = tipo;
        this.descripcion = descripcion
        this.estado = "PROGRAMADA";
    }

    
}