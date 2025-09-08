import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        CentroEventos centro = new CentroEventos(10, 100, 1000); // Crear centro de eventos con espacio para 10 salones, 100 reservas, 1000 en espera

        //Se crean los salones
        centro.registrarSalon (new Salon (1, "Pequeño", 30, 10, 100));
        centro.registrarSalon (new Salon (2, "Pequeño", 40, 15, 150));
        centro.registrarSalon (new Salon (3, "Mediano", 100, 30, 300));
        centro.registrarSalon (new Salon (4, "Mediano", 200, 75, 620));
        centro.registrarSalon (new Salon (5, "Grande", 500, 150, 800));
        centro.registrarSalon (new Salon (6, "Grande", 800, 270, 1000));

        int bandera = -1;
        while (bandera == -1) {
            System.out.println("\n=== Menú Centro de Eventos ===");
            System.out.println("\n1. Registrar evento");
            System.out.println("2. Ver salones disponibles");
            System.out.println("3. Ver lista de espera");
            System.out.println("4. Ver estadísticas generales");
            System.out.println("5. Ver estadísticas mensuales");
            System.out.println("6. Salir");
            System.out.print("\nSelecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n=== Ingreso de datos para registrar evento ===");
                    System.out.print("\nIngresa el nombre del evento: ");
                    String nombreEvento = sc.nextLine();
                    System.out.print("Ingresa el nombre del encargado del evento: ");
                    String encargado = sc.nextLine();
                    System.out.print("Ingresa el tipo de evento (Normal/VIP): ");
                    String tipoEvento = sc.nextLine();
                    System.out.print("Ingresa la cantidad de personas que asistirán: ");
                    int cantidadPersonas = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingresa la fecha del evento (dd/mm/aa): ");
                    String fecha = sc.nextLine();
                    System.out.print("Ingresa la hora de inicio de tu evento en formato 24h (solo horas en punto): ");
                    int horaInicio = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingresa la duración de tu evento en horas (solo horas enteras): ");
                    int duracionHoras = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Estás dispuesto a pagar el 20% del costo total como depósito inicial (Si/No): ");
                    String respuesta = sc.nextLine();
                    boolean depositoPagado = respuesta.equalsIgnoreCase("Si");

                    Evento evento = new Evento (nombreEvento, encargado, tipoEvento, fecha, cantidadPersonas, horaInicio, duracionHoras, depositoPagado);

                    Reserva r = centro.registrarEvento(evento);

                    if (r != null && r.isConfirmado()) {
                        double depositoInicial = r.getCostoTotal() * 0.20;
                        System.out.println("\nReserva confirmada en salón " + r.getSalon().getNumeroSalon());
                        System.out.println("Costo total: Q." + r.getCostoTotal());
                        System.out.println("Depósito inicial (20%): Q. " + depositoInicial);
                    } else {
                        System.out.println("\nEl evento ha sido envíado a la lista de espera");
                    }
                    break;

                case 2:
                    System.out.println("\n=== Salones disponibles ===");
                    for (int i = 0; i < centro.getContSalones(); i++) {
                        Salon s = centro.getSalones()[i];
                        System.out.println ("\nSalón #" + s.getNumeroSalon() + "-" + s.getTipoSalon() + "(Capacidad: " + s.getCapacidadMinima() + "-" 
                        + s.getCapacidadMaxima() + ", Q." + s.getCostoHora() + "/hora)"); 
                    }
                    break;
                
                case 3:
                    System.out.println("\n=== Lista de espera ===");
                    if (centro.getCantidadEnEspera() == 0) {
                        System.out.println("\nNo hay eventos en lista de espera");
                    } else {
                        for (int i = 0; i < centro.getCantidadEnEspera(); i++) {
                            Evento e = centro.getListaEspera()[i];
                            System.out.println(e.getNombreEvento() + " - Encargado: " + e.getEncargado() + " (" + e.getFecha() + " " + e.getHoraInicio() + ":00)");
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n=== Estadísticas del Centro de Eventos ===");
                    System.out.println("\nEventos realizados: " + centro.calcularEventosRealizados());
                    System.out.println("Ingresos totales: Q." + centro.calcularIngresosTotales());
                    System.out.println("Ingresos en salones pequeños: Q." + centro.ingresosPorTipoSalon("Pequeño"));
                    System.out.println("Ingresos en salones medianos: Q." + centro.ingresosPorTipoSalon("Mediano"));
                    System.out.println("Ingresos en salones grandes: Q." + centro.ingresosPorTipoSalon("Grande"));
                    break;

                case 5:
                    System.out.println("\n=== Estadísticas mensuales ===");
                    System.out.print("\nIngresa el mes del que deseas ver las estadísticas (mm): ");
                    String mes = sc.nextLine();
                    System.out.println("\nEventos en mes " + mes + ": " + centro.eventosPorMes(mes));
                    System.out.println("Ingresos en mes " + mes + ": Q." + centro.IngresosPorMes(mes));
                    break;

                case 6:
                    bandera = 0;
                    break;
            }
        }
    }
}