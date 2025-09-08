import java.util.Scanner;

public class Main
{
    public static void mostrarMenu()
        {
            System.out.println("\n=== Menú de opciones ===\n");
            System.out.println("1. Nuevo comprador");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.println("Selecciona una opción: \n");
        }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in); //crea una instancia de scanner para permitir al usuario ingresar sus respuestas

        Localidad[] localidades = new Localidad[3]; //Se instancian las 3 localidades
        localidades[0] = new Localidad ("Localidad 1", 100.0);
        localidades[1] = new Localidad ("Localidad 5", 500.0);
        localidades[2] = new Localidad ("Localidad 10", 1000.0);
        
        Comprador compradorActual = null;  //se inicia sin comprador actual 
        int opcion = 0;

        while (opcion != 6)
        {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion)
            {
                case 1: 
                    System.out.println("---Registro de comprador---"); //la opción 1 permite registrar un nuevo comprador
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Cantidad de boletos: ");
                    int cantidadBoletos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Presupuesto: ");
                    double presupuesto = scanner.nextDouble();
                    scanner.nextLine();
                    if (!nombre.isEmpty() && !email.isEmpty() && cantidadBoletos > 0 && presupuesto > 0.0)
                    {
                        compradorActual =  new Comprador(nombre, email, cantidadBoletos, presupuesto);
                        System.out.println("Comprador registrado con éxito"); //se registra el comprador solo si todos los campos se llenaron todos los campos
                    }
                    else
                    {
                        System.out.println("Error en registro. Campos faltantes");
                    }
                    break;
                case 2:
                    if (compradorActual != null) //solo si hay comprador actual se inicia una solicitud
                    {
                        System.out.println("---Solicitud de compra---"); //la opción 2 permite realizar una solicitud de boletos
                        if (compradorActual.getYaSolicito())
                        {
                            System.out.println("No puedes realizar más de una solicitud"); //no se le permite al mismo comprador realizar mas de una solicitud
                        }
                        else
                        {
                            SolicitudBoleto solicitud = compradorActual.solicitarCompra();
                            if (solicitud.getValidez())
                            {
                                System.out.println("La solicitud fue seleccionada para realizar una compra"); 
                                solicitud.asignarLocalidad(localidades); //si la solicitud pasa la vreificación de números, se asigna la localidad
                                Localidad localidad = solicitud.getLocalidadAsignada();
                                System.out.println("Localidad asignada: "+ localidad.getNombre());

                                if (localidad.hayEspacio(compradorActual))
                                {
                                    int vendidos = localidad.venderBoletos(compradorActual);
                                    if (vendidos > 0)
                                    {
                                        System.out.println("Compra exitosa. Boletos comprados: " + vendidos); //se finaliza la compra si el presupuesto y espacio es suficiente
                                    }
                                    else
                                    {
                                        System.out.println("La compra no se pudo completar por presupuesto insuficiente"); //no se finaliza la compra si no hay suficiente presupuesto
                                    }
                                }
                                else
                                {
                                    System.out.println("La compra no se pudo completar por espacio insuficiente");//no se finaliza la compra si ya no hay espacio
                                }
                                
                            }
                            else
                            {
                                System.out.println("La solicitud no fue seleccionada para realizar una compra");//se para el proceso si no se pasa la primera verificación
                            }
                        }
                        
                    }
                    else
                    {
                        System.out.println("Registra un comprador para iniciar una nueva solicitud");
                    }
                    break;
                case 3:
                    System.out.println("---Disponibilidad total---");//la 3 opción permite ver la disponibilidad total
                    for (Localidad loc: localidades)
                    {
                        System.out.println(loc.getNombre() + ": " + loc.getBoletosDisponibles() + " boletos disponibles"); //disponibilidad de cada localidad
                    }
                    int total_boletos = localidades[0].getBoletosDisponibles() + localidades[1].getBoletosDisponibles() + localidades[2].getBoletosDisponibles();
                    System.out.println("Disponibilidad total: " + total_boletos); //disponibilidad total
                    break;
                case 4:
                    System.out.println("---Disponibilidad Individual---");//la opcion 4 permite ver la disponibilidad de una localidad específica
                    System.out.println("1. Localidad 1");
                    System.out.println("2. Localidad 5");
                    System.out.println("3. Localidad 10");
                    System.out.print("Selecciona una opción: ");
                    int opcion_loc = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcion_loc)
                    {
                        case 1:
                            System.out.println("Disponibilidad en " + localidades[0].getNombre() + ": " + localidades[0].getBoletosDisponibles());
                            break;
                        case 2:
                            System.out.println("Disponibilidad en " + localidades[1].getNombre() + ": " + localidades[1].getBoletosDisponibles());
                            break;
                        case 3:
                            System.out.println("Disponibilidad en " + localidades[2].getNombre() + ": " + localidades[2].getBoletosDisponibles());
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                    break;
                case 5:
                    System.out.println("---Reporte de caja---"); //la opción 5 permite ver el total de caja (dinero generado)
                    System.out.println("Localidad 1: $" + localidades[0].totalVendido());
                    System.out.println("Localidad 5: $" + localidades[1].totalVendido());
                    System.out.println("Localidad 10: $" + localidades[2].totalVendido());
                    double total = localidades[0].totalVendido() + localidades[1].totalVendido() + localidades[2].totalVendido();
                    System.out.println("Total: $" + total);
                    break;
                case 6:
                    opcion = 6; //la opción 6 es la salida del programa
                    break;
                default: //si el usuaio ingresa un numero inválido, se da un mensaje de error
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}