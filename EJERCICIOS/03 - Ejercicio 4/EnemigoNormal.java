public class EnemigoNormal extends Enemigo { //solo una habilidad
    public EnemigoNormal (String nombre, int vidaTotal, int ataque) {
        super(nombre, vidaTotal, ataque, "Normal"); //llama al constructor de Enemigo
    }
}