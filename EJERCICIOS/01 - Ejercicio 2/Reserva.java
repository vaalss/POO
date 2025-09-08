public class Reserva {
    private Evento evento;
    private Salon salon;
    private boolean confirmado; //si la reserva se confirma o se va a lista de espera
    private double costoTotal; //duración del evento * costo/hora

    //Constructor
    public Reserva (Evento evento, Salon salon, boolean confirmado, double costoTotal) {
        this.evento = evento;
        this.salon = salon;
        this.confirmado = confirmado;
        this.costoTotal = costoTotal;
    }

    //Getters
    public Salon getSalon() {
        return salon;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public Evento getEvento() {
        return evento;
    }
}