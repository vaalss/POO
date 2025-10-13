import java.util.Random;

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

    public void asignarMedico(ArrayList<Medico> trabajadores) {
        Random rand = new Random();
        ArrayList<Medico> especialistas = new ArrayList<Medico>;
        if (this.tipo.toLowerCase().contains("consulta") || this.tipo.toLowerCase().contains("chequeo")) {
            for (Medico m : trabajadores) {
                if (m.getClass().getSimpleName().equals("Doctor")) {
                    especialistas.add(m);
                }
            }
        } else if (this.tipo.toLowerCase().contains("cirujía") || this.tipo.toLowerCase().contains("operación")) {
            for (Medico m : trabajadores) {
                if (m.getClass().getSimpleName().equals("Cirujano")) {
                    especialistas.add(m);
                }
            }
        } else if (this.tipo.toLowerCase().contains("medicamentos") || this.tipo.toLowerCase().contains("receta")) {
            for (Medico m : trabajadores) {
                if (m.getClass().getSimpleName().equals("Farmaceutico")) {
                    especialistas.add(m);
                }
            }
        } else if (this.tipo.toLowerCase().contains("diagnóstico") || this.tipo.toLowerCase().contains("control")) {
            for (Medico m : trabajadores) {
                if (m.getClass().getSimpleName().equals("Enfermero")) {
                    especialistas.add(m);
                }
            }
        }
        int indice = rand.nextInt(especialistas.size());
        Medico trabajador = especialistas.get(indice);
        this.trabajador = trabajador;
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

    @Override
    public String toString() {
        return "Cita #" + this.ID + ": \n- Paciente: " + this.nombre + "\n- Médico asignado: " + this.trabajador + "\n- Fecha: " +
        "\n- Hora: " + this.horaInicio + " hrs \n- Tipo de cita: " + this.tipo + "\n- Descripción: " + this.descripcion + 
        "\n- Estado: " + this.estado;
    }
}