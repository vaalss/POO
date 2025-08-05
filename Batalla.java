public class Batalla
{
    private Entrenador entrenador1, entrenador2; //instancio los dos entrenadores
    private Pokemon p1, p2, p3, p4, p5, p6, p7, p8; //instancio 16 pokemones, que son los que puede escoger el entrenador para cada ronda
    private Pokemon p9, p10, p11, p12, p13, p14, p15, p16;


    public Batalla (Entrenador entrenador1, Entrenador entrenador2) //constructor
    {
        this.entrenador1 = entrenador1;
        this.entrenador2 = entrenador2;

        //Opciones de pokemones
        p1 = new Pokemon("Pikachu", "Eléctrico", 58, 52, new HabilidadEspecial("Impacto Relámpago", "dañoEnemigo", 10, 30));
        p2 = new Pokemon("Charizard", "Fuego", 77, 46, new HabilidadEspecial("Llama Final", "ataque", 15, 40));
        p3 = new Pokemon("Blastoise", "Agua", 58, 36, new HabilidadEspecial("Tsunami", "defensa", 20, 35));
        p4 = new Pokemon("Venusaur", "Planta", 57, 52, new HabilidadEspecial("Fotosíntesis", "defensa", 15, 25));
        p5 = new Pokemon("Gengar", "Fantasma", 70, 30, new HabilidadEspecial("Sombra Nocturna", "ataque", 20, 25));
        p6 = new Pokemon("Machamp", "Lucha", 60, 40, new HabilidadEspecial("Puño Dinámico", "ataque", 25, 20));
        p7 = new Pokemon("Snorlax", "Normal", 62, 48, new HabilidadEspecial("Descanso Total", "defensa", 25, 30));
        p8 = new Pokemon("Dragonite", "Dragón", 78, 39, new HabilidadEspecial("Ráfaga Dragón", "ataque", 30, 20));
        p9 = new Pokemon("Lucario", "Lucha", 57, 43, new HabilidadEspecial("Aura Esférica", "ataque", 20, 25));
        p10 = new Pokemon("Garchomp", "Tierra", 56, 40, new HabilidadEspecial("Colmillo de Arena", "ataque", 20, 20));
        p11 = new Pokemon("Eevee", "Normal", 61, 57, new HabilidadEspecial("Adaptación", "defensa", 10, 40));
        p12 = new Pokemon("Jolteon", "Eléctrico", 64, 48, new HabilidadEspecial("Voltio Cruel", "ataque", 18, 35));
        p13 = new Pokemon("Flareon", "Fuego", 66, 35, new HabilidadEspecial("Llama Interior", "ataque", 22, 30));
        p14 = new Pokemon("Vaporeon", "Agua", 78, 31, new HabilidadEspecial("Ola Curativa", "defensa", 18, 35));
        p15 = new Pokemon("Bulbasaur", "Planta", 53, 41, new HabilidadEspecial("Raíces Sanadoras", "defensa", 12, 45));
        p16 = new Pokemon("Squirtle", "Agua", 56, 44, new HabilidadEspecial("Burbuja Protectora", "defensa", 10, 50));
    } 

    //Getter
    public Pokemon getPokemonIndice(int indice) //me permite devolver el pokemon según el índice seleccionado
    {
        switch(indice) {
            case 1: return p1;
            case 2: return p2;
            case 3: return p3;
            case 4: return p4;
            case 5: return p5;
            case 6: return p6;
            case 7: return p7;
            case 8: return p8;
            case 9: return p9;
            case 10: return p10;
            case 11: return p11;
            case 12: return p12;
            case 13: return p13;
            case 14: return p14;
            case 15: return p15;
            case 16: return p16;
            default: return null;
        }
    }

    public boolean validarSeleccion(Entrenador entrenador, int indice) //me permite ver si el pokemon ya fue usado o no por los entrenadores
    {
        Pokemon p = getPokemonIndice(indice);
        if (p == null) return false; //si el indice no es válido, devuelve false
        if (entrenador.equals(entrenador1)) return !p.getUsadoEntrenador1(); 
        else return !p.getUsadoEntrenador2();
    }

    public String seleccionarPokemon(Entrenador entrenador, int indice) //asigna el pokemon escogido a "pokemon actual"
    {
        Pokemon p = getPokemonIndice(indice);
        if (p == null) 
        {
            return "Índice inválido, intenta de nuevo."; //mensaje de error si el índice ingresado no es válido
        }

        if (entrenador.equals(entrenador1)) //selección para el entrenador 1
        {
            if (p.getUsadoEntrenador1()) 
            {
                return "Pokémon ya usado por " + entrenador.getNombre() + ", elige otro."; //mensaje de error si getUsadoEntrenador1 = true (el pokemon ya fue usado por el entrenador)
            }
            p.setUsadoEntrenador1(); //si el pokemon no se habia usado, al ser seleccionado se cambia el valor de getUsadoEntrenador1 = true, para que no se pueda usar otra vez
            entrenador.setPokemonActual(p); //el pokemon escogido se selecciona como el Pokemon actual
            return entrenador.getNombre() + " eligió a " + p.getNombre();
        } 
        else
        {
            if (p.getUsadoEntrenador2()) { //selección para el entrenador 2 (mismo proceso que entrenador 1)
                return "Pokémon ya usado por " + entrenador.getNombre() + ", elige otro.";
            }
            p.setUsadoEntrenador2();
            entrenador.setPokemonActual(p);
            return entrenador.getNombre() + " eligió a " + p.getNombre();
        } 
    }


    public String jugarRonda(int ronda) //método para jugar cada una de las 4 rondas
    {
        Pokemon p_1 = entrenador1.getPokemonActual(); //tomo el pokemon actual del entrenador1
        Pokemon p_2 = entrenador2.getPokemonActual(); //tomo el pokemon actual del entrenador2

        //si el entrenador no tiene la habilidad activa, y sí se pasó la verificación aleatorio para que se active, se activa la habilidad
        if (!entrenador1.habilidadActiva() && p_1.getHabilidad().activar()) 
            entrenador1.activarHabilidad(); 
        if (!entrenador2.habilidadActiva() && p_2.getHabilidad().activar())
            entrenador2.activarHabilidad();
            
        //se calculan los poderes totales para la ronda de cada entrenador
        int poder1 = calcularPoder(p_1, p_2, entrenador1.habilidadActiva(), entrenador2.habilidadActiva());
        int poder2 = calcularPoder(p_2, p_1, entrenador2.habilidadActiva(), entrenador1.habilidadActiva());

        String ganador = "Empate"; //por "default" se establece empate
        if (poder1 > poder2) //el poder del entrenador 1 es mayor que el del entrenador 2
        {
            entrenador1.ganarRonda(); //se suma 1 a las rondas ganadas del entrenador 1
            ganador = entrenador1.getNombre(); //se establece al entrenador 1 como el ganador de la ronda
        }
        else if (poder2 > poder1) //si el poder del entrenador 2 es mayor que el del entrenador 1, el entrenador 2 gana la ronda
        {
            entrenador2.ganarRonda();
            ganador = entrenador2.getNombre();
        }

        //al final de cada ronda se actualizan las rondas que quedan de la habilidad especial (para que se use solo 2 rondas)
        entrenador1.actualizarHabilidad();
        entrenador2.actualizarHabilidad();

        //Resumen de resultados de la ronda
        String resumen = "Ronda " + ronda + ":\n"
        + p_1.getNombre() + " vs " + p_2.getNombre() + "\n"
        + p_1.getNombre() + " - Ataque: " + p_1.getAtaque() + ", Defensa: " + p_1.getDefensa()
        + ", Habilidad activa: " + entrenador1.habilidadActiva()
        + " (" + p_1.getHabilidad().getEfecto() + ")\n"
        + p_2.getNombre() + " - Ataque: " + p_2.getAtaque() + ", Defensa: " + p_2.getDefensa()
        + ", Habilidad activa: " + entrenador2.habilidadActiva()
        + " (" + p_2.getHabilidad().getEfecto() + ")\n"
        + "Poder total: " + poder1 + " vs " + poder2 + "\n"
        + "Ganador de la ronda: " + ganador;

        return resumen;

    }

    private int calcularPoder(Pokemon propio, Pokemon enemigo, boolean habilidadPropio, boolean habilidadEnemigo) //calcula el poder total de la ronda de cada uno de los entrenadores
    {
        int ataque = propio.getAtaque();
        int defensa = propio.getDefensa();
        int defensaEnemigo = enemigo.getDefensa();
        int ventajaTipo = calcularVentajaTipo(propio.getTipo(), enemigo.getTipo()); //ventaja tipo se refiere a la diferencia de tipos de los pokemones (planta, fuego, agua, electricidad)

        if (habilidadPropio)  //si mi habilidad está activo, determino su efecto y su valor numérico
        {
            String efecto = propio.getHabilidad().getEfecto();
            int valor = propio.getHabilidad().getValor();

            if (efecto.equals("ataque")) 
            {
                ataque += valor; //si mi habilidad tiene efecto "ataque", le suma su valor a mi valor base de ataque
            } 
            else if (efecto.equals("defensa")) 
            {
                defensa += valor; //si mi habilidad tiene efecto "defensa", le suma su valor a mi valor base de defensa
            } 
            else if (efecto.equals("dañoEnemigo")) 
            {
                defensaEnemigo -= valor; //si mi habilidad tienen efecto "dañoEnemigo", le resta su valor a la defensa del enemigo
            }
        }

        if (habilidadEnemigo) //si la habilidad del otro está activa, determino su efecto y valor numérico
        {
            String efecto = enemigo.getHabilidad().getEfecto();
            int valor = enemigo.getHabilidad().getValor();

            if (efecto.equals("defensa")) 
            {
                defensaEnemigo += valor; //si el efecto del otro es "defensa", se le suma el valor a su defensa base
            } 
            else if (efecto.equals("dañoEnemigo")) 
            {
                defensa -= valor; //si el efecto del otro es "daño enemigo", se resta su valor a mi defensa
            }
    
        }

        int poder = ataque - defensaEnemigo + ventajaTipo; //el poder total de la ronda se calcula al restar la defensa del enemigo a mi ataque y sumar la ventaja del tipo
        return poder; //el valor del efecto de la habilidad especial ya se incluye en el valor de ataque o defensa enemigo
    }

    private int calcularVentajaTipo(String tipoAtacante, String tipoDefensor) //calcula la venta dependiendo del tipo de pokemon
    {
        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Planta")) return 20;
        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Agua")) return 20;
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Fuego")) return 20;
        if (tipoAtacante.equals("Eléctrico") && tipoDefensor.equals("Agua")) return 20;

        if (tipoAtacante.equals("Fuego") && tipoDefensor.equals("Agua")) return -10;
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Planta")) return -10;
        if (tipoAtacante.equals("Planta") && tipoDefensor.equals("Fuego")) return -10;
        if (tipoAtacante.equals("Agua") && tipoDefensor.equals("Eléctrico")) return -10;

        return 0; //si no es ninguna de las anteriores, el valor del efecto de la habilidad es 0
    }
}