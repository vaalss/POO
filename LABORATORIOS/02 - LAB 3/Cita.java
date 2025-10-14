//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Seccion 40
//Valeria Hernández Maldonado 25086

import java.util.Random;
import java.util.ArrayList;

public class Cita {
    private int ID; //número de cita
    private static int contador = 1; //contador estático para llevar el conteo general de la clase
    private String nombre;
    private Medico trabajador; //trabajador asignado para la cita
    private String fecha;
    private int horaInicio;
    private int horaFinal;
    private String tipo; //tipo de cita
    private String descripcion; //descripción más detallada de la cita
    private String estado; //estado en que se encuentra la cita (CONFIRMADA, PROGRAMADA, )
    
    public Cita(String nombre, String fecha, int horaInicio, int horaFinal, String tipo, String descripcion) {
        this.ID += contador++;
        this.nombre = nombre;
        this.trabajador = null; //se inicializa sin trabajador asignado
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.estado = "PROGRAMADA"; //se inicializa como programada
    }


    public void asignarMedico(ArrayList<Medico> trabajadores) { //asigna trabajador de forma inteligente
        Random rand = new Random();
        ArrayList<Medico> especialistas = new ArrayList<Medico>(); //lista para guardar las posibles opciones de médico

        String tipoL = this.tipo.toLowerCase();
        String descL = this.descripcion.toLowerCase();

        String claseBuscada = "Enfermero"; //si no pide especialista o si no hay ese especialista, se va con un enfermero
        if (tipoL.contains("consulta") || tipoL.contains("chequeo")) { //según el tipo de cita se asigna con cada especialista
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
            this.trabajador = null; // si está vacía, se queda en null
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