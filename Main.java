import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in); //scanner para que los entrenadores puedan ingresar su información

        //nombres de los entrenadores
        System.out.print("Nombre del Entrenador 1: ");
        String nombre1 = sc.nextLine();
        System.out.print("Nombre del Entrenador 2: ");
        String nombre2 = sc.nextLine();

        //se instancian los entrenadores con los nombres ingresados
        Entrenador entrenador1 = new Entrenador(nombre1);
        Entrenador entrenador2 = new Entrenador(nombre2);

        //se inicia una nueva batalla
        Batalla batalla = new Batalla(entrenador1, entrenador2);

       for (int ronda = 1; ronda < 5; ronda++) //4 rondas en total
       {
        //variables para que el entrenador escoga su pokemon según su índice
        int indice1;
        int indice2;
        //banderas para manejar el flujo de los ciclos while
        boolean valido1 = false;
        boolean valido2 = false;

        
        System.out.println("\nRonda " + ronda + ":");
        
        //proceso para seleccion del pokemon para el entrenador1
        for (int i = 1; i < 17; i++) //se imprimen las 16 pokemones disponibles para escoger con su respectivo índice
        {
        Pokemon p = batalla.getPokemonIndice(i);
        System.out.println(i + ". " + p.getNombre());
        }
        System.out.println("\n" + nombre1 + ", escoge tu Pokemon: "); 
        while (!valido1) //el ciclo se repite hasta que la seleccion sea válida (valido1 = true)
        {
            System.out.print("Número del Pokemon: ");
            indice1 = sc.nextInt(); //se ingresa el índice del pokemon que se quiere escoger
            sc.nextLine();
            if (batalla.validarSeleccion(entrenador1, indice1)) //se valida que se pueda realizar la selección
            {
                batalla.seleccionarPokemon(entrenador1, indice1); //si se valida, se realiza la seleccións
                valido1 = true; //se cambia el valor de la bandera para parar el ciclo
            }
            else
            {
                System.out.println("Pókemon ya usado o ínidce incorrecto. Escoge otra vez"); //mensaje de error si no se puede escoger el pokemon seleccionado
            }
        }

        //proceso para la selección del pokemon para el entrenador2
        System.out.println("\n");
        for (int i = 1; i < 17; i++) 
        {
        Pokemon p = batalla.getPokemonIndice(i);
        System.out.println(i + ". " + p.getNombre());
        }
        System.out.println(nombre2 + ", escoge tu Pokemon: ");
        while (!valido2)
        {
            System.out.print("Número del Pokemon: ");
            indice2 = sc.nextInt();
            sc.nextLine();
            if (batalla.validarSeleccion(entrenador2, indice2))
            {
                batalla.seleccionarPokemon(entrenador2, indice2);
                valido2 = true;
            }
            else
            {
                System.out.println("Pókemon ya usado o ínidce incorrecto. Escoge otra vez");
            }
        }

        String resumen = batalla.jugarRonda(ronda); //luego de la selección de los pokemones, se juega la ronda 
        System.out.println("\n" + resumen); //se imprime el resúmen de cada ronda
       }

        //se determina cuantas rondas ganó cada entrenador
        int ganadas1 = entrenador1.getRondasGanadas();
        int ganadas2 = entrenador2.getRondasGanadas();

        //resúmen final
        System.out.println("\n--- Resultado Final ---");
        System.out.println(nombre1 + " ganó " + ganadas1 + " rondas.");
        System.out.println(nombre2 + " ganó " + ganadas2 + " rondas.");

        if (ganadas1 > ganadas2) //si el entrenador1 ganó maás rondas, gana la batalla
        {
            System.out.println("¡" + nombre1 + " ganó la batalla!");
        } 
        else if (ganadas2 > ganadas1)  //si el entrenador2 ganó más rondas, gana la batalla
        {
            System.out.println("¡" + nombre2 + " ganó la batalla!");
        } 
        else 
        {
            System.out.println("¡Empate!"); //si ambos ganaron 2 rondas, la batalla termina en empate
        }       
    }
    
}
