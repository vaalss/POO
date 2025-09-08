public class Salon {
    private int numeroSalon, capacidadMaxima, capacidadMinima; //ID del salón, capacidad mínima y máxima de personas
    private String tipoSalon; //Tamaño del salón (pequeño, mediano, grande)
    private double costoHora; //Costo por hora de alquilar el salón

    //Constructor
    public Salon (int numeroSalon, String tipoSalon, int capacidadMaxima, int capacidadMinima, double costoHora) {
        this.numeroSalon = numeroSalon;
        this.capacidadMaxima = capacidadMaxima;
        this.capacidadMinima = capacidadMinima;
        this.tipoSalon = tipoSalon;
        this.costoHora = costoHora;
    }

    //Getters
    public int getNumeroSalon() {
        return numeroSalon;
    }

    public String getTipoSalon() {
        return tipoSalon;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCapacidadMinima() {
        return capacidadMinima;
    }

    public double getCostoHora() {
        return costoHora;
    }
}