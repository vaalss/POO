public class Entrenador
{
    private String nombre; //nombre del entrenador
    private Pokemon pokemonActual; //pokemon que el entrenador usa en la ronda actual
    private boolean efectoActivo; //controla si la habilidad está activa o no
    private int rondasGanadas, rondasHabilidad; //"rondasHabilidad" lleva el control de cuántas rondas se ha usado la habilidad especial 

    public Entrenador (String nombre) //constructor
    {
        this.nombre = nombre;
        this.pokemonActual = null; //se inicia sin un pokemon actual, y al seleccionar el pokemon le "caigo encima" al atributo
        this.rondasGanadas = 0; //se inicia con 0 rondas ganadas
        this.efectoActivo = false; //se inicia con el efecto apagado
        this.rondasHabilidad = 0; //se inicia con 0 rondas restantes para usar la habilidad especial
    }

    //Setter
    public Pokemon setPokemonActual(Pokemon p) //se establece el pokemon escogido como el pokemon actual
    {
        this.pokemonActual = p;
        return p;
    }

    //Getters
    public Pokemon getPokemonActual()
    {
        return pokemonActual;
    }

    public int getRondasGanadas()
    {
        return rondasGanadas;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void ganarRonda()
    {
        rondasGanadas++;
    }


    public boolean habilidadActiva() //me deja saber si la habilidad especial está activa
    {
        return efectoActivo;
    }

    public void activarHabilidad() //activa la habilidad si se pasó la verificación
    {
        efectoActivo = true;
        rondasHabilidad = 2; //la habilidad se activa por dos rondas (la actual y la siguiente)
    }

    public void actualizarHabilidad() //lleva el control de las rondas que se han usado la habilidad especial
    {
        if (rondasHabilidad > 0) //si aún me quedan rondas, le resto a las que me quedan
        {
            rondasHabilidad--;
        }
        if (rondasHabilidad == 0) //si ya no me quedan rondas, "apago" el efecto de la actividad
        {
            efectoActivo = false;
        }
    }
}