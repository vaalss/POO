public class Evento {
    private String nombreEvento, encargado, tipoEvento, fecha; //tipo del evento (normal, VIP)
    private int cantidadPersonas, horaInicio, duracionHoras; 
    private boolean depositoPagado; //si o no ha pagado el depósito inicial

    //Constructor
    public Evento (String nombreEvento, String encargado, String tipoEvento, String fecha, 
    int cantidadPersonas, int horaInicio, int duracionHoras, boolean depositoPagado) {
        this.nombreEvento = nombreEvento;
        this.encargado = encargado;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.cantidadPersonas = cantidadPersonas;
        this.horaInicio = horaInicio;
        this.duracionHoras = duracionHoras;
        this.depositoPagado = depositoPagado;
    }

    //Getters
    public boolean isDepositoPagado() {
        return depositoPagado;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getEncargado() {
        return encargado;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }
}