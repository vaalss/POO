import java.util.Random;

public class HabilidadEspecial
{
    private String nombre, efecto; //nombre de la habilidad especial y el efecto que tiene (ataque, defensa, daño a enemigo)
    private int valor, probabilidad; //valor numérico de la habilidad especial y la probabilidad que tiene de ser activado (1-100%)

    public HabilidadEspecial (String nombre, String efecto, int valor, int probabilidad) //constructor
    {
        this.nombre = nombre;
        this.efecto = efecto;
        this.valor = valor;
        this.probabilidad = probabilidad;      
    }

    public boolean activar()
    {
        Random rand = new Random(); 
        int numero = rand.nextInt(1, 101); //se selecciona un número al azar
        return numero <= probabilidad; //se verifica si el número está dentro de la probabilidad de la habilidad especial esta se activa
    }

    //Getters
    public String getNombre()
    {
        return nombre;
    }

    public String getEfecto()
    {
        return efecto;
    }

    public int getValor()
    {
        return valor;
    }

    public int getProbabilidad()
    {
        return probabilidad;
    }
}