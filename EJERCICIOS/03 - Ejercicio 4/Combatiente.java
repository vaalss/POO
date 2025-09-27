public abstract class Combatiente {
    protected String nombre;
    protected int vidaActual;
    protected int vidaTotal;
    protected int ataque;
    protected boolean vivo;

    public Combatiente(String nombre, int vidaTotal, int ataque) {
        this.nombre = nombre;
        this.vidaActual = vidaActual;
        this.vidaTotal = vidaTotal;
        this.ataque = ataque;
        this.vivo = true; //todos los combatientes inician vivos
    }

    public abstract void tomarTurno(List<Combatiente> objetivos); //método abstracto para que las subclases implementen su propio método

    public void atacar(Combatiente objetivo) {
        objetivo.recibirAtaque(ataque);
    }

    public void recibirAtaque(int cantidad) {
        vidaActual -= cantidad;
        if (vidaActual > vidaTotal) {
            vidaActual = vidaTotal;
        }
        if (vidaActual <= 0) {
            vidaActual = 0;
            vivo = false;
            mensajeFinal();
        }
    }
}