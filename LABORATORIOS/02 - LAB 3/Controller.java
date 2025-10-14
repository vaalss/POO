import java.util.ArrayList;

public class Controller {
    private ArrayList<Medico> trabajadores;
    private ArrayList<Cita> citas;
    private ArrayList<String> historial;
    private View consola;

    public Controller() {
        this.trabajadores = new ArrayList<Medico>();
        this.citas = new ArrayList<Cita>();
        this.historial = new ArrayList<String>();
        this.consola = new View();
    }

    public void instanciar() {
        Medico m1 = new Doctor("Carlos", "PEDIATRÍA", 30, 2500.00, true, "PEDIATRÍA", 10, 150.00); trabajadores.add(m1);
        Medico m2 = new Farmaceutico("Raúl", "FARMACIA", 22, 1500.00, true, 55, 120.00, true); trabajadores.add(m2);
        Medico m3 = new Enfermero("Inés", "ENFERMERÍA", 30, 2000.00, true, "DIA", "Intensivo", 1500.00); trabajadores.add(m3);
        Medico m4 = new Cirujano("Ricardo", "CARDIOLOGÍA", 35, 3500.00, true, "CARDIÓLOGO", 15, 350.00, 1500.00); trabajadores.add(m4);
        Medico m5 = new Doctor("Lucky", "DERMATOLOGÍA", 15, 1600.50, false, "DERMATÓLOGO", 17, 100.00); trabajadores.add(m5);
        Medico m6 = new Farmaceutico("Alessandra", "FARMACIA", 7, 1000.50, true, 40, 95.00, false); trabajadores.add(m6);
        Medico m7 = new Enfermero("Andrea", "ENFERMERÍA", 6, 1750.00, true, "NOCHE", "GENERAL", 1000.00); trabajadores.add(m7);
        Medico m8 = new Cirujano("Daniel", "PEDIATRÍA", 20, 3500.50, true, "CIRUJÁNO PEDÍATRICO", 10, 300.00, 2000.00); trabajadores.add(m8);
        Medico m9 = new Doctor("Alejandro", "CARDIOLOGÍA", 20,2000.00, true, "CARDIÓLOGO", 20, 200.50);  trabajadores.add(m9);
        Medico m10 = new Farmaceutico("Manuel", "FARMACIA", 10, 1250.50, false, 50, 100.00, true); trabajadores.add(m10);
        Medico m11 = new Enfermero("Sandra", "ENFERMERÍA", 27, 2000.00, true, "NOCHE", "ESPECIALISTA", 1200.00); trabajadores.add(m11);
        Medico m12 = new Cirujano("Oscar", "DERMATOLOGÍA",20, 3500.00, false, "CIRUJÁNO PLÁSTICO", 15, 400.00, 1700.00); trabajadores.add(m12);
        Cita c1 = new Cita("Valeria", "18/10/2025", 8, 10, "Consulta General", "Consulta con pediátra"); c1.asignarMedico(trabajadores); c1.setEstado("EN PROGRESO"); citas.add(c1);
        Cita c2 = new Cita("Javier", "18/10/2025", 8, 10, "Chequeo General", "Consulta con pediátra"); c2.asignarMedico(trabajadores); citas.add(c2);
        Cita c3 = new Cita("Diego", "13/10/2025", 13, 23, "Operación de corazón", "Cirujía de alto riesgo"); c3.asignarMedico(trabajadores); citas.add(c3);
        Cita c4 = new Cita("Daniela", "14/10/2025", 10, 11, "Compra de medicamentos", ""); c4.asignarMedico(trabajadores); citas.add(c4);
        Cita c5 = new Cita("Adrián", "15/10/2025", 11, 12, "Control de vacunas", ""); c5.asignarMedico(trabajadores); citas.add(c5);
        Cita c6 = new Cita("José Andrés", "20/10/2025", 8, 20, "Operación de rodilla", "Operación rutinaria"); c6.asignarMedico(trabajadores); citas.add(c6);
        Cita c7 = new Cita("Marianna", "01/11/2025", 14, 15, "Consulta", "Consulta con dermatólogo"); c7.asignarMedico(trabajadores); citas.add(c7);
        Cita c8 = new Cita("David", "22/10/2025",7 , 9, "Diagnóstico", "Consulta general"); c8.asignarMedico(trabajadores); citas.add(c8);
        Cita c9 = new Cita("Jorge", "21/10/2025", 9, 10, "Diagnóstico", "Consulta general"); c9.asignarMedico(trabajadores); c9.setEstado("COMPLETADA"); citas.add(c9);
        Cita c10 = new Cita("Verónica", "19/10/2025", 10, 11, "Verificación de receta", "Cotización de medicamentos"); c10.asignarMedico(trabajadores); c10.setEstado("COMPLETADA"); citas.add(c10);
        Cita c11 = new Cita("Mario", "02/11/2025", 11, 12, "Consulta general", "Control con cardiólogo"); c11.asignarMedico(trabajadores); citas.add(c11);
        Cita c12 = new Cita("José Fernando", "10/11/2025", 10, 12, "Diagnóstico de enfermedad", "Exámenes de sangre"); c12.asignarMedico(trabajadores); citas.add(c12);
        Cita c13 = new Cita("Sebastián", "16/10/2025", 9, 10, "Control general", "Control de niveles de azúcar"); c13.asignarMedico(trabajadores); citas.add(c13);
        Cita c14 = new Cita("Lucía", "19/10/2025", 19, 21, "Cirujía plástica", "Consulta previa con dermatólogo"); c14.asignarMedico(trabajadores); citas.add(c14);
    }

    public void iniciar() {
        instanciar();
        int salir = 0;
        while (salir == 0) {
            consola.mostrarMenu();
            int opcion = consola.pedirEntrada("Selecciona la opción que deseas realizar: ");
            switch (opcion) {
                case 1:
                    consola.mostrarMensaje("--- Agendar Cita ---");
                    String nombre = consola.pedirString("Ingresa el nombre del paciente: ");
                    String fecha = consola.pedirString("Ingresa la fecha de la cita (dd/mm/aaaa): ");
                    int horaInicio = consola.pedirEntrada("Ingresa la hora de inicio: ");
                    int horaFinal = consola.pedirEntrada("Ingresa la hora de final: ");
                    String tipo = consola.pedirString("Ingresa el tipo de cita: ");
                    String descripcion = consola.pedirString("Ingresa la descripción de la cita: ");
                    Cita citaNueva = new Cita(nombre, fecha, horaInicio, horaFinal, tipo, descripcion); citaNueva.asignarMedico(trabajadores); citas.add(citaNueva);
                    break;
                case 2:
                    int citas_cancelar = 1; 
                    consola.mostrarMensaje("--- Citas ---");
                    for (Cita c : citas) {
                        consola.mostrarMensaje("- " + citas_cancelar + ". Cita #" + c.getID() + ": " + c.getNombre());
                        citas_cancelar ++;
                    }
                    int cancelar = consola.pedirEntrada("Seleccióna el número de cita que deseas cancelar: ");
                    Cita C1 = citas.get(cancelar-1);
                    C1.setEstado("CANCELADA");
                    historial.add("Cita #" + C1.getID() + " cancelada");
                    break;
                case 3:
                    int citas_confirmar = 1; 
                    consola.mostrarMensaje("--- Citas ---");
                    for (Cita c : citas) {
                        consola.mostrarMensaje("- " + citas_confirmar + ". Cita #" + c.getID() + ": " + c.getNombre());
                        citas_confirmar ++;
                    }
                    int confirmar = consola.pedirEntrada("Seleccióna el número de cita que deseas confirmar: ");
                    Cita C2 = citas.get(confirmar-1);
                    if (!verificarDisponibilidadFecha(C2) || !verificarDisponibilidadMedico(C2)) {
                        if ( reagendarCita(C2)) {
                            consola.mostrarMensaje("Cita reagendada");
                            historial.add("Cita #" + C2.getID() + " reagendada y confirmada");
                        } else {
                            consola.mostrarMensaje("Se ha cancelado la cita porque no se ha podido reagendar ni confirmar la cita");
                            historial.add("CIta #" + C2.getID() + " no ha sido cancelada");
                            C2.setEstado("CANCELADA");
                        }
                    } else {
                        C2.setEstado("CONFIRMADA");
                        historial.add("Cita #" + C2.getID() + " confirmada");
                        Medico medico = C2.getTrabajador();
                        medico.recibirCita(C2);
                    }
                    break;
                case 4:
                    int contador_personal = 1;
                    consola.mostrarMensaje("--- Personal Disponible ---");
                    for (Medico m : trabajadores) {
                        if(m.getDisponibilidad()) {
                            consola.mostrarMensaje("- " + contador_personal + ". Personal #" + m.getID() + ", Nombre: " + m.getNombre() + ", Especialización: " + m.getClass().getSimpleName() + ", Departamento: " + m.getDepartamento());
                            contador_personal ++;
                        }
                    }
                    break;
                case 5:
                    consola.mostrarCitas(citas, trabajadores);
                    break;
                case 6:
                    consola.mostrarPersonal(trabajadores);
                    break;
                case 7:
                    consola.mostrarEficiencia(trabajadores);
                    break;
                case 8:
                    consola.mostrarMensaje("--- Reporte de Nómia ---");
                    consola.mostrarMensaje("\n - Pediatría:");
                    consola.mostrarMensaje("Q." + nominaDepartamento("PEDIATRÍA"));
                    consola.mostrarMensaje("\n - Enfermería:");
                    consola.mostrarMensaje("Q." + nominaDepartamento("ENFERMERÍA"));
                    consola.mostrarMensaje("\n - Farmacia:");
                    consola.mostrarMensaje("Q." + nominaDepartamento("FARMACIA"));
                    consola.mostrarMensaje("\n - Dermatología:");
                    consola.mostrarMensaje("Q." + nominaDepartamento("DERMATOLOGÍA"));
                    consola.mostrarMensaje("\n - Cardiología:");
                    consola.mostrarMensaje("Q." + nominaDepartamento("CARDIOLOGÍA"));
                    break;
                case 9:
                    consola.mostrarMensaje("--- Análisis financiero ---");
                    consola.mostrarMensaje("\n- Q." + nominaTotal());
                    break;
                case 10: 
                    consola.mostrarHistorial(historial);
                    break;
                case 11:
                    salir = 1;
                    break;
                default:
                    consola.mostrarMensaje("Opción inválida");
            }
        }

    }


    public double nominaDepartamento(String departamento) {
        double nomina = 0;
        for (Medico m : trabajadores) {
            if (m.getDepartamento().equalsIgnoreCase(departamento)) {
                nomina += m.calcularSalario();
            }
        }
        return nomina;
    }

    public double nominaTotal() {
        double nomina = 0;
        for (Medico m : trabajadores) {
            nomina += m.calcularSalario();
        }
        return nomina;
    }

    public boolean verificarDisponibilidadMedico(Cita c) {
        Medico trabajador = c.getTrabajador();
        if (trabajador.getDisponibilidad()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarDisponibilidadFecha(Cita c) {
        String fecha = c.getFecha();
        int hora = c.getHoraInicio();
        for (Cita C : citas) {
            if (C != c && C.getFecha().equals(fecha) && C.getHoraInicio() == hora) {
                return false;
            } 
        }
        return true;
    }

    public boolean reagendarCita(Cita c) {
        int intentos = 0;
        int maxIntentos = 5;
        
        if (!verificarDisponibilidadMedico(c)) {
            while (!verificarDisponibilidadMedico(c) && intentos < maxIntentos) {
                c.asignarMedico(trabajadores);
                intentos ++;
            }
            if (intentos >= maxIntentos) {
                consola.mostrarMensaje("No se ha encontrado un médico disponible para agendar la cita");
                historial.add("Cita #" + c.getID() + " no se ha podido reagendar");
                return false;
            }
            
            c.setEstado("REAGENDADA");
            historial.add("Cita #" + c.getID() + " reagendada por falta de disponibilidad del trabajador asignado\n- Nuevo trabajador: " + c.getTrabajador());
            return true;
        } else if (!verificarDisponibilidadFecha(c)) {
            intentos = 0;
            while (!verificarDisponibilidadFecha(c) && intentos < maxIntentos) {
                String partes[] = c.getFecha().split("/");
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int año = Integer.parseInt(partes[2]);
                dia++;
                String nuevaFecha = String.format("%02d/%02d/%04d", dia, mes, año);
                c.setFecha(nuevaFecha);
                intentos ++;
            }
            if (intentos >= maxIntentos) {
                consola.mostrarMensaje("No se ha encontrado una fecha disponible para agendar la cita");
                historial.add("Cita #" + c.getID() + " no se ha podido reagendar");
                return false;
            }
            c.setEstado("REAGENDADA");
            historial.add("Cita #" + c.getID() + " reagendada por choque de fechas\n- Nueva fecha: " + c.getFecha());
            return true;
        }
        return false;
    }
}