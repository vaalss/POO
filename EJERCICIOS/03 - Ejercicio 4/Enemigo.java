import java.util.List;
import java.util.ArrayList;

public abstract class Enemigo extends Combatiente { //enemigo hereda de Combatiente y hereda a EnemigoNormal y EnemigoJefe
    protected List<Habilidad> habilidades; //los enemigos tiene una lista de habilidades

    public Enemigo(String nombre, int vidaTotal, int ataque, String tipo) {
        super(nombre, vidaTotal, ataque, "ENEMIGO", tipo); //llama al constructor de Combatiente
        this.habilidades = new ArrayList<Habilidad>();
    }

    public void usarHabilidad(int i, Enemigo enemigo, Jugador jugador, List<Enemigo> enemigos, List<Jugador> jugadores, int e, int j, int cantEnemigos, int cantJugadores) {
        habilidades.get(i).aplicarEfecto(enemigo, jugador, enemigos, jugadores, e, j, cantEnemigos, cantJugadores); //método para usar una habilidad
        //recibe el enemigo que usa la habilidad, el jugador sobre el que se usa, la lista de jugadores y de enemigos, los índices, y la cantidad de jugadores y de enemigos
    }

    public List<Habilidad> getHabilidades() {
        return this.habilidades; //permite acceder a la lista de habilidades
    }

    @Override //sobrescritura del método toString
    public String toString() {
        return nombre + " [Vida total: " + vidaTotal + ", tipo: " + tipo + ", ataque: " + ataque + ", habilidades: " + habilidades + " ]";
    }
}