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
        this.ID += this.contador++;
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
        if (this.tipo.toLowerCase().contains("consulta") || this.tipo.toLowerCase().contains("chequeo")) {
            for (Medico m : trabajadores) { //si quiere una cita consulta o chequeo, va con un doctor
                if (m.getClass().getSimpleName().equals("Doctor")) {
                    especialistas.add(m);
                    if(this.descripcion.contains("pediátra")) {
                        for (Medico M : especialistas) {
                            if(!M.departamento.contains("PEDIATRÍA")) {
                                especialistas.remove(M);
                            }
                        }
                    } else if (this.descripcion.contains("dermatólogo")) {
                        for (Medico M : especialistas) {
                            if(!M.departamento.contains("DERMATOLOGÍA")) {
                                especialistas.remove(M);
                            }
                        }
                    } else if (this.descripcion.contains("cardiólogo")) {
                        for (Medico M : especialistas) {
                            if(!M.departamento.contains("CARDIOLOGÍA")) {
                                especialistas.remove(M);
                            }
                        }
                    }
                }
            }
        } else if (this.tipo.toLowerCase().contains("cirujía") || this.tipo.toLowerCase().contains("operación")) {
            for (Medico m : trabajadores) {
                if (m.getClass().getSimpleName().equals("Cirujano")) {
                    especialistas.add(m);
                    if(this.descripcion.contains("pediátra")) {
                        for (Medico M : especialistas) {
                            if(!M.departamento.contains("PEDIATRÍA")) {
                                especialistas.remove(M);
                            }
                        }
                    } else if (this.descripcion.contains("dermatólogo")) {
                        for (Medico M : especialistas) {
                            if(!M.departamento.contains("DERMATOLOGÍA")) {
                                especialistas.remove(M);
                            }
                        }
                    } else if (this.descripcion.contains("cardiólogo")) {
                        for (Medico M : especialistas) {
                            if(!M.departamento.contains("CARDIOLOGÍA")) {
                                especialistas.remove(M);
                            }
                        }
                    }
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
        } else { //si no tiene especificación, se va con un enfermero general
            for (Medico m : trabajadores) {
                if (m.getClass().getSimpleName().equals("Enfermero")) {
                    especialistas.add(m);
            }
        }
        int indice = rand.nextInt(especialistas.size());
        Medico trabajador = especialistas.get(indice);
        this.trabajador = trabajador;
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
        return "Cita #" + this.ID + ": \n- Paciente: " + this.nombre + "\n- Médico asignado: " + this.trabajador + "\n- Fecha: " +
        "\n- Hora: " + this.horaInicio + " hrs \n- Tipo de cita: " + this.tipo + "\n- Descripción: " + this.descripcion + 
        "\n- Estado: " + this.estado;
    }
}