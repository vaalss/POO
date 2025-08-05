public class Pokemon
{
    private String nombre, tipo; //nombre del pokemon y su tipo (fuego, agua, planta, eléctrico)
    private int ataque, defensa; //valores base de ataque y defensa
    private HabilidadEspecial habilidad; //atributo de la clase HabilidadEspecial para cada Pokemon
    private boolean usadoEntrenador1, usadoEntrenador2; //lleva el registro de si el Pokemon ya fue seleccionado por los entrenadores

    public Pokemon (String nombre, String tipo, int ataque, int defensa, HabilidadEspecial habilidad) //constructor
    {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
        this.usadoEntrenador1 = false; //al instanciarse, ningún pokemon ha sido usado por ninguno de los dos entrenadores 
        this.usadoEntrenador2 = false; //al instanciarse, ningún pokemon ha sido usado por ninguno de los dos entrenadores 
    }

    //Getters
    public String getNombre()
    {
        return nombre;
    }

    public String getTipo()
    {
        return tipo;
    }

    public int getAtaque()
    {
    return ataque;
    }

    public int getDefensa()     
    {
    return defensa;
    }

    public HabilidadEspecial getHabilidad()
    {
        return habilidad;
    }

    public boolean getUsadoEntrenador1 ()
    {
        return usadoEntrenador1;
    }

    
     public boolean getUsadoEntrenador2 ()
    {
        return usadoEntrenador2;
    }

    //Setters
    public void setUsadoEntrenador1()
    {
        this.usadoEntrenador1 = true;
    }


    public void setUsadoEntrenador2()
    {
        this.usadoEntrenador2 = true;
    }

    //Sobrecargo de método toString para imprimir el Pokemon
    public String toString()
    {
            return "\n" + nombre + "<" + tipo + ">";
    }
}
