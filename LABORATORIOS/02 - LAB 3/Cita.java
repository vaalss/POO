import java.util.Random;
import java.util.ArrayList;

public class Cita {
    private int ID;
    private static int contador = 1;
    private String nombre;
    private Medico trabajador;
    private String fecha;
    private int horaInicio;
    private int horaFinal;
    private String tipo;
    private String descripcion;
    private String estado;
    
    public Cita(String nombre, String fecha, int horaInicio, int horaFinal, String tipo, String descripcion) {
        this.ID += contador++;
        this.nombre = nombre;
        this.trabajador = null;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = "PROGRAMADA";
    }


    public void asignarMedico(ArrayList<Medico> trabajadores) { //arreglar, según departamento
        Random rand = new Random();
        ArrayList<Medico> especialistas = new ArrayList<Medico>();

        String tipoL = this.tipo.toLowerCase();
        String descL = this.descripcion.toLowerCase();

        String claseBuscada = "Enfermero"; //si no pide especialista o si no hay ese especialista, se va con un enfermero
        if (tipoL.contains("consulta") || tipoL.contains("chequeo")) {
            claseBuscada = "Doctor";
        } else if (tipoL.contains("cirujía") || tipoL.contains("operación")) {
            claseBuscada = "Cirujano";
        } else if (tipoL.contains("medicamentos") || tipoL.contains("receta")) {
            claseBuscada = "Farmaceutico";
        } else if (tipoL.contains("diagnóstico") || tipoL.contains("control")) {
            claseBuscada = "Enfermero";
        }   

        for (Medico m : trabajadores) { //filtra a los trabajadores por clase
            if (m.getClass().getSimpleName().equals(claseBuscada)) {
                especialistas.add(m);
            }
        }

        if (descL.contains("pedi")) { //filtra a los trabajadores según su departamento
            especialistas.removeIf(m -> !m.getDepartamento().equalsIgnoreCase("PEDIATRÍA"));
        } else if (descL.contains("dermat")) {
            especialistas.removeIf(m -> !m.getDepartamento().equalsIgnoreCase("DERMATOLOGÍA"));
        } else if (descL.contains("cardio")) {
            especialistas.removeIf(m -> !m.getDepartamento().equalsIgnoreCase("CARDIOLOGÍA"));
        }

        if (!especialistas.isEmpty()) { //si la lista de especialistas no está vacía se escoge uno de forma aleatoria
            this.trabajador = especialistas.get(rand.nextInt(especialistas.size()));
        } else {
            this.trabajador = null; // si está vacía, se queda un null
        }
    }

    public int getID() {
        return this.ID;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Medico getTrabajador() {
        return this.trabajador;
    }

    public String getFecha() {
        return this.fecha;
    }

    public int getHoraInicio() {
        return this.horaInicio;
    }

    public int getHoraFinal() {
        return this.horaFinal;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Cita #" + this.ID + ": \n- Paciente: " + this.nombre + "\n- Médico asignado: " + this.trabajador.getNombre() + "\n- Fecha: " + fecha +
        "\n- Hora: " + this.horaInicio + " hrs \n- Tipo de cita: " + this.tipo + "\n- Descripción: " + this.descripcion + 
        "\n- Estado: " + this.estado;
    }
}