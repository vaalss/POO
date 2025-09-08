import java.util.ArrayList;

public class Gimnasio {
    private ArrayList<Socio> socios; //lista de socios registrados
    private ArrayList<Entrenador> entrenadores; //lista de entrenadores registrados
    private ArrayList<Rutina> rutinas; //lista de rutinas registradas

    public Gimnasio() {
        this.socios = new ArrayList<>();
        this.entrenadores = new ArrayList<>();
        this.rutinas = new ArrayList<>();
    }

    public void registrarSocio (Socio socio) {
        socios.add(socio); //registra un socio
    }

    public void registrarEntrenador (Entrenador entrenador) {
        entrenadores.add(entrenador); //registra un entrenador
    }

    public void registrarRutina (Rutina rutina) {
        rutinas.add(rutina); //registra una rutina
    }

    public Rutina rutinaMasPracticada() { //devuelve la rutina que tenga más practicantes
        Rutina rutinaMasPopular = null;
        int maxPracticantes = 0;

        for (Rutina rutina : rutinas) {
            if (rutina.cantidadPracticantes() > maxPracticantes) {
                rutinaMasPopular = rutina;
                maxPracticantes = rutina.cantidadPracticantes();
            }
        }

        return rutinaMasPopular;
    }

    public Entrenador entrenadorConMasAlumnos() { //devuelve el entrenador con más alumnos asignados
        Entrenador entrenadorMasCargado = null;
        int maxAlumnos = 0;

        for (Entrenador entrenador :  entrenadores) {
            if (entrenador.cantidadAlumnos() > maxAlumnos) {
                entrenadorMasCargado = entrenador;
                maxAlumnos = entrenador.cantidadAlumnos();
            }
        }

        return entrenadorMasCargado;
    }

    public int rutinasActivas() { //devuelve la cantidad de rutinas registradas
        return rutinas.size();
    }

    public ArrayList<Rutina> rutinasRecomendadas(Socio socio) { //recomienda rutinas según el tipo de membresía y la meta del socio
        ArrayList<Rutina> rutinasRecomendadas = new ArrayList<>();
        for (Rutina r : rutinas) {
            if (socio.getTipoMembresia().equalsIgnoreCase("Premium")) { //si tiene membresía premium, reocmienda todas las rutinas (premium o no) que cumplan con su meta
                if (r.getObjetivo().equalsIgnoreCase(socio.getMeta())) {
                    rutinasRecomendadas.add(r);
                }
            } else if (r.getTipo().equalsIgnoreCase("Normal") && r.getObjetivo().equalsIgnoreCase(socio.getMeta())) { //si no tiene membresía premium, recomienda solo rutinas tipo normal que cumplan con su meta
                    rutinasRecomendadas.add(r);
            }
            
        }
        return rutinasRecomendadas;
    }

    //Getters
    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public ArrayList<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public ArrayList<Rutina> getRutinas() {
        return rutinas;
    }
    
}