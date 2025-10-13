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
        Medico m1 = new Doctor("Carlos", "PEDIATRÍA", 30, 2500.00, true, "PEDIATRÍA", 10, 150.00);
        Medico m2 = new Farmaceutico("Raúl", "FARMACIA", 22, 1500.00, true, 55, 120.00, true);
        Medico m3 = new Enfermero("Inés", "ENFERMERÍA", 30, 2000.00, true, "DIA", "Intensivo", 1500.00);
        Medico m4 = new Cirujano("Ricardo", "CARDIOLOGÍA", 35, 3500.00, true, "CARDIÓLOGO", 15, 350.00, 1500.00);
        Medico m5 = new Doctor("Lucky", "DERMATOLOGÍA", 15, 1600.50, false, "DERMATÓLOGO", 17, 100.00);
        Medico m6 = new Farmaceutico("Alessandra", "FARMACIA", 7, 1000.50, true, 40, 95.00, false);
        Medico m7 = new Enfermero("Andrea", "ENFERMERÍA", 6, 1750.00, true "NOCHE", "GENERAL", 1000.00);
        Medico m8 = new Cirujano("Daniel", "PEDIATRÍA", 20, 3500.50, true, "CIRUJÁNO_PEDÍATRICO", 10, 300.00, 2000.00);
        Medico m9 = new Doctor("Alejandro", "CARDIOLOGÍA", 20,2000.00, true, "CARDIÓLOGO", 20, 200.50);
        Medico m10 = new Farmaceutico("Manuel", "FARMACIA", 10, 1250.50, false, 50, 100.00, true);
        Medico m11 = new Enfermero("Sandra", "ENFERMERÍA", 27, 2000.00, true, "NOCHE", "ESPECIALISTA", 1200.00);
        Medico m12 = new Cirujano("Oscar", "DERMATOLOGÍA",20, 3500.00, false, "CIRUJÁNO PLÁSTICO", 15, 400.00, 1700.00);
        Cita c1 = new Cita("Valeria", "18/10/2025", 8, 10, "Consulta General", "Consulta con pediátra");
        Cita c2 = new Cita("Javier", "18/10/2025", 8, 10, "Chequeo General", "Consulta con pediátra"),
        Cita c3 = new Cita("Diego", "13/10/2025", 13, 23, "Operación de corazón", "Cirujía de alto riesgo");
        Cita c4 = new Cita("Daniela", "14/10/2025", 10, 11, "Compra de medicamentos", "");
        Cita c5 = new Cita("Adrián". "15/10/2025", 11, 12, "Control de vacunas", "");
        Cita c6 = new Cita("José Andrés", "20/10/2025", 8, 20, "Operación de rodilla", "Operación rutinaria");
        Cita c7 = new Cita("Marianna", "01/11/2025", 14, 15, "Consulta", "Consulta con dermatólogo");
        Cita c8 = new Cita("David", "22/10/2025", , "", "");
        Cita c9 = new Cita("Jorge", "21/10/2025", 9, 10, "Diagnóstico", "Consulta general");
        Cita c10 = new Cita("Verónica", "19/10/2025", 10, 11, "Verificación de receta", "Cotización de medicamentos");
        Cita c11 = new Cita("Mario", "02/11/2025", 11, 12, "Consulta general", "Control con cardiólogo");
        Cita c12 = new Cita("José Fernando", "10/11/2025", 10, 12, "Diagnóstico de enfermedad", "Exámenes de sangre");
        Cita c13 = new Cita("Sebastián", "16/10/2025", 9, 10, "Control general", "Control de niveles de azúcar");
        Cita c14 = new Cita("Lucía", "19/10/2025", 19, 21, "Cirujía plástica", "Consulta previa con Dermatólogo");
    }

    public void iniciar() {

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
            if (C.getFecha().equals(fecha) && C.getHoraInicio() == hora) {
                return false;
            } 
        }
        return true;
    }

    public String reagendarCita(Cita c) {
        if (!verificarDisponibilidadMedico(c)) {
            while (!verificarDisponibilidadMedico(c)) {
                c.asignarMedico();
            }
            c.setEstado("REAGENDADA");
            return "Cita #" + c.getID() + " reagendada por falta de disponibilidad del trabajador asignado\n- Nuevo trabajador: " + c.getTrabajador();
        } else id (!verificarDisponibilidadFecha(c)) {
            while (!verificarDisponibilidadFecha(c)) {
                String partes[] = c.getFecha().split("/");
                int dia = IntegerparseInt(partes[0]);
                int mes = IntegerparseInt(partes[1]);
                int año = IntegerparseInt(partes[2];)
                dia++;
                String nuevaFecha = String.format("%02d/%02d/%04d", dia, mes, año);
                c.setFecha(nuevaFecha);
            }
            c.setEstado("REAGENDADA");
            return "Cita #" + c.getID() + " reagendada por choque de fechas\n- Nueva fecha: " + c.getFecha();
        }

    }
}