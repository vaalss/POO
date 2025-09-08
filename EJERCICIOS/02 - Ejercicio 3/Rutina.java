import java.util.ArrayList;

public class Rutina {
    private String objetivo; //Bajar de peso, ganar masa muscular, etc.
    private String dificultad; //Fácil, intermedia, difícil
    private int duracion; //en minutos
    private ArrayList<String> ejercicios; //lista de ejercicios agregados a cada rutina
    private ArrayList<Socio> practicantes; //lista de socios que practican la rutina
    private int id; //número identificador de la rutina
    private static int contador = 1; // lleva el control de los id
    private String tipo; //Normal, Premium

    public Rutina (String objetivo, String dificultad, int duracion, String tipo) {
        this.objetivo = objetivo;
        this.dificultad = dificultad;
        this.duracion = duracion;
        this.ejercicios = new ArrayList<>();
        this.practicantes = new ArrayList<>();
        this.id = contador++;
        this.tipo = tipo;
    }

    public void agregarEjercicios(String ejercicio) {
        ejercicios.add(ejercicio); //agrega un ejercicio ingresado a la lista de ejercicios de la rutina
    }

    public void asignarSocio(Socio socio) {
        practicantes.add(socio); //agrega un socio a la lista de practicantes de la rutina
    }

    public int cantidadPracticantes() {
        return practicantes.size(); //devuelve la cantidad de socios que practican la rutina
    }

    //Getters
    public int getId() {
        return this.id;
    }

    public String getObjetivo() {
        return this.objetivo;
    }

    public String getDificultad() {
        return this.dificultad;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public ArrayList<Socio> getPracticantes() {
        return this.practicantes;
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public String toString() {
        return "Rutina #" + id + " [Dificultad: " + dificultad + ", Duración: " + duracion + ", Número de practicantes: " + 
        practicantes.size() + ", Ejercicios: " + ejercicios + "]";
    }

}