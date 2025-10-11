public class Farmaceutico extends Medico {
    private int prescripciones;
    private boolean licencia;

    public Farmaceutico(int prescripciones, boolean licencia) {
        super(nombre, experiencia, salarioBase, disponible);
        this.prescripciones = prescripciones;
        this.licencia = licencia;
    }

    public getPrescripciones() {
        return this.prescripciones;
    }

    public getLicencia() {
        return this.licencia;
    }
}