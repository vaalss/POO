//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Seccion 40
//Valeria Hernández Maldonado 25086

import java.util.ArrayList;

public class Controller {
    private ArrayList<Medico> trabajadores; //lista ed los trabajadores del hospital
    private ArrayList<Cita> citas; //lista de las citas del hospital
    private ArrayList<String> historial; //historial de cambios 
    private View consola;

    public Controller() {
        this.trabajadores = new ArrayList<Medico>();
        this.citas = new ArrayList<Cita>();
        this.historial = new ArrayList<String>();
        this.consola = new View();
    }

    public void instanciar() { //instancias de médicos y citas
        Medico m1 = new Doctor("Carlos", "PEDIATRÍA", 30, 2500.00, true, "PEDIATRÍA", 10, 150.00); trabajadores.add(m1);
        Medico m2 = new Farmaceutico("Raúl", "FARMACIA", 22, 1500.00, true, 55, 120.00, true); trabajadores.add(m2);
        Medico m3 = new Enfermero("Inés", "ENFERMERÍA", 30, 2000.00, true, "DIA", "INTENSIVO", 1500.00); trabajadores.add(m3);
        Medico m4 = new Cirujano("Ricardo", "CARDIOLOGÍA", 35, 3500.00, true, "CARDIÓLOGO", 15, 350.00, 1500.00); trabajadores.add(m4);
        Medico m5 = new Doctor("Lucky", "DERMATOLOGÍA", 15, 1600.50, false, "DERMATÓLOGO", 17, 100.00); trabajadores.add(m5);
        Medico m6 = new Farmaceutico("Alessandra", "FARMACIA", 7, 1000.50, true, 40, 95.00, false); trabajadores.add(m6);
        Medico m7 = new Enfermero("Andrea", "ENFERMERÍA", 6, 1750.00, true, "NOCHE", "GENERAL", 1000.00); trabajadores.add(m7);
        Medico m8 = new Cirujano("Daniel", "PEDIATRÍA", 20, 3500.50, true, "CIRUJÁNO PEDÍATRICO", 10, 300.00, 2000.00); trabajadores.add(m8);
        Medico m9 = new Doctor("Alejandro", "CARDIOLOGÍA", 20,2000.00, false, "CARDIÓLOGO", 20, 200.50);  trabajadores.add(m9);
        Medico m10 = new Farmaceutico("Manuel", "FARMACIA", 10, 1250.50, false, 50, 100.00, true); trabajadores.add(m10);
        Medico m11 = new Enfermero("Sandra", "ENFERMERÍA", 27, 2000.00, true, "NOCHE", "ESPECIALISTA", 1200.00); trabajadores.add(m11);
        Medico m12 = new Cirujano("Oscar", "DERMATOLOGÍA",20, 3500.00, false, "CIRUJÁNO PLÁSTICO", 15, 400.00, 1700.00); trabajadores.add(m12);
        Medico m13 = new Cirujano("Mónica", "PEDIATRÍA",20, 3570.00, true, "CIRUJÁNO PEDIÁTRICO", 15, 400.00, 1700.00); trabajadores.add(m13);
        Medico m14 = new Farmaceutico("Fabricio", "FARMACIA", 17, 2050.50, false, 50, 95.00, false); trabajadores.add(m14);
        Medico m15 = new Enfermero("Jimena", "ENFERMERÍA", 3, 875.00, true, "NOCHE", " GENERAL", 1500.00); trabajadores.add(m15);
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

    public void iniciar() { //método principal
        instanciar();
        int salir = 0;
        while (salir == 0) {
            consola.mostrarMenu(); //muestra el menú de opciones
            int opcion = consola.pedirEntrada("Selecciona la opción que deseas realizar: ");
            switch (opcion) {
                case 1:
                    consola.mostrarMensaje("--- Agendar Cita ---"); //pide todos los datos para generar una cita nueva
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
                    consola.mostrarMensaje("--- Citas ---"); //muestra un listado de todas las citas
                    for (Cita c : citas) {
                        consola.mostrarMensaje("- " + citas_cancelar + ". Cita #" + c.getID() + ": " + c.getNombre());
                        citas_cancelar ++;
                    }
                    int cancelar = consola.pedirEntrada("Seleccióna el número de cita que deseas cancelar: ");
                    Cita C1 = citas.get(cancelar-1);
                    C1.setEstado("CANCELADA"); //cambia el estado de la cita seleccionada a "cancelada"
                    historial.add("Cita #" + C1.getID() + " cancelada"); //agrega el cambio al historial
                    break;
                case 3:
                    int citas_confirmar = 1; 
                    consola.mostrarMensaje("--- Citas ---"); //muestra un litado de todas las listas
                    for (Cita c : citas) {
                        consola.mostrarMensaje("- " + citas_confirmar + ". Cita #" + c.getID() + ": " + c.getNombre());
                        citas_confirmar ++;
                    }
                    int confirmar = consola.pedirEntrada("Seleccióna el número de cita que deseas confirmar: ");
                    Cita C2 = citas.get(confirmar-1); //intenta verificar la cita
                    if (!verificarDisponibilidadFecha(C2) || !verificarDisponibilidadMedico(C2)) { //Verifica la disponibilidad
                        if ( reagendarCita(C2)) { //si se puede reagendar, se hace y se confirma la cita
                            consola.mostrarMensaje("Cita reagendada"); 
                            historial.add("Cita #" + C2.getID() + " reagendada y confirmada");
                        } else {
                            consola.mostrarMensaje("Se ha cancelado la cita porque no se ha podido reagendar ni confirmar la cita");
                            historial.add("CIta #" + C2.getID() + " no ha sido cancelada"); //si no se puede reagendar la cita, se cancela
                            C2.setEstado("CANCELADA");
                        }
                    } else {
                        C2.setEstado("CONFIRMADA"); //si no es necesario reagendar la cita, solo se confirma
                        historial.add("Cita #" + C2.getID() + " confirmada");
                        Medico medico = C2.getTrabajador();
                        medico.recibirCita(C2);
                    }
                    break;
                case 4:
                    int contador_personal = 1; //muestra un listado del personal disponible
                    consola.mostrarMensaje("--- Personal Disponible ---");
                    for (Medico m : trabajadores) {
                        if(m.getDisponibilidad()) {
                            consola.mostrarMensaje("- " + contador_personal + ". Personal #" + m.getID() + ", Nombre: " + m.getNombre() + ", Especialización: " + m.getClass().getSimpleName() + ", Departamento: " + m.getDepartamento());
                            contador_personal ++;
                        }
                    }
                    break;
                case 5:
                    consola.mostrarCitas(citas, trabajadores); //muestra las citas clasificadas por estado y trabajador
                    break;
                case 6:
                    consola.mostrarPersonal(trabajadores); //muestra la infromación de todo el personal
                    break;
                case 7:
                    consola.mostrarEficiencia(trabajadores); //muestra los reportes de eficiencia de todo el personal
                    break;
                case 8:
                    consola.mostrarMensaje("--- Reporte de Nómia ---"); //reportes de nómina por departamento
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
                    consola.mostrarMensaje("--- Análisis financiero ---"); //análisis financiero (todos los departamentos)
                    consola.mostrarMensaje("\n- Q." + nominaTotal());
                    break;
                case 10: 
                    consola.mostrarHistorial(historial); //muestra el historial de cambios
                    break;
                case 11:
                    salir = 1; //sale del ciclo hasta que el usuario lo indique
                    break;
                default:
                    consola.mostrarMensaje("Opción inválida");
            }
        }

    }


    public double nominaDepartamento(String departamento) { //calcula la nómina del departamento que se pida
        double nomina = 0;
        for (Medico m : trabajadores) {
            if (m.getDepartamento().equalsIgnoreCase(departamento)) {
                nomina += m.calcularSalario();
            }
        }
        return nomina;
    }

    public double nominaTotal() { //calcula la nómina total de todos los trabajadores 
        double nomina = 0;
        for (Medico m : trabajadores) {
            nomina += m.calcularSalario();
        }
        return nomina;
    }

    public boolean verificarDisponibilidadMedico(Cita c) { //verifica la disponibilidad del médico asignado a la cita
        Medico trabajador = c.getTrabajador();
        if (trabajador.getDisponibilidad()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verificarDisponibilidadFecha(Cita c) { //verifica la disponibilidad de fecha y hora de la cita para evitar conflicto con otra
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
        int maxIntentos = 5; //limita la cantidad de veces que se puede intentar reagendar en un ciclo para la misma cita
        
        if (!verificarDisponibilidadMedico(c)) { //si el medico no esá disponible se le asigna otro 
            while (!verificarDisponibilidadMedico(c) && intentos < maxIntentos) {
                c.asignarMedico(trabajadores); //se intenta asignar otro médico hasta encontrar uno disponible o hasta que se agoten los intentos
                intentos ++;
            }
            if (intentos >= maxIntentos) { // si no se encuentra un medico o se agotan los intentos no se puede reagendar la cita
                consola.mostrarMensaje("No se ha encontrado un médico disponible para agendar la cita");
                historial.add("Cita #" + c.getID() + " no se ha podido reagendar");
                return false;
            }
            c.setEstado("REAGENDADA"); //si se encuentra otr médico se reagenda la cita
            historial.add("Cita #" + c.getID() + " reagendada por falta de disponibilidad del trabajador asignado\n- Nuevo trabajador: " + c.getTrabajador());
            return true;
        } else if (!verificarDisponibilidadFecha(c)) { //verifica la disponibilidad de fecha y hora de la cita
            intentos = 0;
            while (!verificarDisponibilidadFecha(c) && intentos < maxIntentos) {
                String partes[] = c.getFecha().split("/");
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int año = Integer.parseInt(partes[2]);
                dia++; //intenta reagendar la cita para el día siguiente
                String nuevaFecha = String.format("%02d/%02d/%04d", dia, mes, año);
                c.setFecha(nuevaFecha);
                intentos ++; //tiene un límite de intentos
            }
            if (intentos >= maxIntentos) {
                consola.mostrarMensaje("No se ha encontrado una fecha disponible para agendar la cita");
                historial.add("Cita #" + c.getID() + " no se ha podido reagendar");
                return false; //si no se encuentra otra fecha o se exceden los intentos no se puede reagendar la cita
            }
            c.setEstado("REAGENDADA"); //si se encuentra otra fecha, se reagenda la cita y se agrega el cambio al historial
            historial.add("Cita #" + c.getID() + " reagendada por choque de fechas\n- Nueva fecha: " + c.getFecha());
            return true;
        }
        return false;
    }
}