public class CentroEventos {
    private Salon[] salones; //Arreglo de salones disponibles
    private Reserva[] reservas; //Registro de las reservas confirmadas
    private Evento[] listaEspera; //Lista de espera
    private int contSalones, contReservas, contEspera; //contadores para saber cuantos salones y reservas tengo, y cuantos eventos hay en lista de espera
    
    //Constructor
    public CentroEventos (int maxSalones, int maxReservas, int maxEspera) {
        salones = new Salon[maxSalones];
        reservas = new Reserva[maxReservas];
        listaEspera = new Evento[maxEspera];
    }

    public void registrarSalon (Salon s) {
        if (contSalones < salones.length) { // si aún hay espacio para registrar un salon, se agrega a la lista de salones en el siguiente índice
            salones[contSalones++] = s;
        }
    }

    public Reserva registrarEvento (Evento evento) {
        for (int i = 0; i < contSalones; i++) {
            Salon s = salones[i]; //verifica que hayan salones disponibles y que se cumplan las condiciones para confirmar una reserva
            if (verificarDisponibilidad (s, evento)) {
                double costo = evento.getDuracionHoras() * s.getCostoHora();
                Reserva r = new Reserva (evento, s, true, costo); //Se instancia la nueva reserva si se cumple todo
                reservas[contReservas++] = r; //Se agrega la nueva reserva al registro de eventos confirmados
                return r;
            }
        }   
        agregarAListaEspera (evento); //si no hay salones disponibles o no se cumplen las condiciones, se envía a lista de espera
        return null;
    }

    public boolean verificarDisponibilidad (Salon s, Evento e) {
        if (e.getCantidadPersonas() > s.getCapacidadMaxima())  //verifica que la candidad de personas que asisten al evento no sea mayor a la capacidad máxima del salón
        return false;
        if (e.getCantidadPersonas() < s.getCapacidadMinima()) //verifica que la cantidad de personas no sea menor a la capacidad mínima del salón
        return false;
        if (s.getTipoSalon().equalsIgnoreCase("Grande") && !e.getTipoEvento().equalsIgnoreCase("VIP")) //verifica que los salones grandes solo se utilicen para eventos VIP
        return false;
        if (!e.isDepositoPagado()) //verifica que el depósito inicial esté pagado
        return false;

        for (int i = 0; i < contReservas; i++) {
            Reserva r = reservas[i]; //Verifica que no haya una reserva para un salón en la misma hora y fecha
            if (r.getSalon().getNumeroSalon() == s.getNumeroSalon() && r.getEvento().getFecha().equals(e.getFecha())) {
                
                int inicio1 = r.getEvento().getHoraInicio();
                int fin1 = inicio1 + r.getEvento().getDuracionHoras();

                int inicio2 = e.getHoraInicio();
                int fin2 = inicio2 + e.getDuracionHoras();

                if (inicio2 < fin1) { //verifica que los horarios de dos eventos no se traslapen
                    return false;
                }
            }
        }

        return true;
    }

    public void agregarAListaEspera (Evento evento) {
        if (contEspera < listaEspera.length) {
            listaEspera[contEspera++] = evento;
        }
    }

    //Getters
    public Salon[] getSalones() {
        return salones;
    }

    public Evento[] getListaEspera() {
        return listaEspera;
    }

    public int getCantidadEnEspera() {
        return contEspera;
    }

    public int getContSalones() {
        return contSalones;
    }

    // Métodos para calcular las estadísticas
    
    public int calcularEventosRealizados() {

        return contReservas; //cuenta cuántas reservas se han hecho
    }

    public double calcularIngresosTotales() {
        double total = 0;
        for (int i = 0; i < contReservas; i++) {
            total += reservas[i].getCostoTotal(); //suma el costo total de todas las reservas confirmadas
        }
        return total;
    }

    public double ingresosPorTipoSalon (String tipoSalon) {
        double total = 0;
        for (int i = 0; i < contReservas; i++) {
            if (reservas[i].getSalon().getTipoSalon().equalsIgnoreCase(tipoSalon)) { //calcula los ingresos para salones pequeños, medianos, grandes
                total += reservas[i].getCostoTotal();
            }
        }
        return total;
    }

    public int eventosPorMes (String mes) {
        int total = 0;
        for (int i = 0; i < contReservas; i++) {
            String fecha = reservas[i].getEvento().getFecha(); //fecha en formato dd/mm/aa
            String mesEvento = fecha.split("/")[1]; //separa la fecha para usar solo el mes
            if (mesEvento.equals(mes)) {
                total++;
            }
        }
        return total;
    }

    public double IngresosPorMes (String mes) {
        double total = 0;
        for (int i = 0; i < contReservas; i++) {
            String fecha = reservas[i].getEvento().getFecha(); //fecha en formato dd/mm/aa
            String mesEvento = fecha.split("/")[1];
            if (mesEvento.equals(mes)) {
                total += reservas[i].getCostoTotal();
            }
        }
        return total;
    }
    
}