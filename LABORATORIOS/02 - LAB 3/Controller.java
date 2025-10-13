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
        Medico m1 = new 
        Medico m2 = new 
        Medico m3 = new 
        Medico m4 = new 
        Medico m5 = new 
        Medico m6 = new 
        Medico m7 = new 
        Medico m8 = new 
        Medico m9 = new 
        Medico m10 = new 
        Medico m11 = new 
        Medico m12 = new 
        Cita c1 = new 
        Cita c2 = new 
        Cita c3 = new 
        Cita c4 = new 
        Cita c5 = new 
        Cita c6 = new 
        Cita c7 = new 
        Cita c8 = new 
        Cita c9 = new 
        Cita c10 = new 
        Cita c11 = new 
        Cita c12 = new 
        Cita c13 = new 
        Cita c14 = new 
        Cita c15 = new 
        Cita c16 = new 
        Cita c17 = new 
        Cita c18 = new 
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