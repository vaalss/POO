import java.util.ArrayList;

public class Entrenador {
    private String nombre, especialidad; //cardio, pesas
    private int maxAlumnos; //máximo de almnos antes de estar sobrecargado
    private ArrayList<Socio> alumnos; //lista de alumnos que tiene asignado el entrenador
    private int id; //número identificador del socio
    private static int contador = 1; //lleva el control de los id

    public Entrenador (String nombre, String especialidad, int maxAlumnos) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.maxAlumnos = maxAlumnos;
        this.alumnos = new ArrayList<>();
        this.id = contador++;
    }

    public void agregaAlumno(Socio socio) {
        alumnos.add(socio); //agrega un socio a la lista de alumnos del entrenador
    }

    public boolean puedeAgregarAlumno() { //verifica si se puede agregar un socio al entrenador o si ya está sobrecargado
        if (alumnos.size() < maxAlumnos) {
            return true;
        } else {
            return false;
        }
    }

    public int cantidadAlumnos() { //devuelve la cantidad de alumnos que tiene el entrenador
        return alumnos.size();
    }

    //Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getEspecialidad() {
        return this.especialidad;
    }

    public int getMaxAlumnos() {
        return this.maxAlumnos;
    }

    public ArrayList<Socio> getAlumnos() {
        return this.alumnos;
    }

    public int getId() {
        return this.id;
    }

    //Setters
    public void setEspecialidad() {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Entrenador " + nombre + " [Especialidad: " + especialidad + ", Max Alumnos: " + maxAlumnos + ", Alumnos asignados: " + alumnos.size() + "]";
    }
}