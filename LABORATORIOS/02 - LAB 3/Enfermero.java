public class Enfermero extends Medico {
    public String turno;
    public String nivel;
    public double bonificacion;

    public Enfermero(String turno, String nivel, double bonificacion) {
        super(nombre, experiencia, salarioBase, disponible);
        this.turno = turno;
        this.nivel = nivel;
        this.bonificacion = bonificacion;
    }

    public String getTurno() {
        return this.turno;
    }

    public String getNivel() {
        return this.nivel;
    }

    public double getBonificacion() {
        return this.bonificacion;
    }

    public boolean bonificacionActiva() {
        if (this.turno.equals("NOCHE")) {
            return true;
        } else {
            return false;
        }
    }
}