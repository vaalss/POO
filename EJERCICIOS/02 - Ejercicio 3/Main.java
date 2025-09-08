import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Gimnasio gimnasio = new Gimnasio();
        Scanner sc = new Scanner(System.in);

        int salir = -1;
        while (salir == -1) {
            System.out.println("\n=== Gestión de Gimnasio ===");
            System.out.println("\nMenú de opciones:");
            System.out.println("1. Registrar nuevo socio");
            System.out.println("2. Registrar nuevo entrenador");
            System.out.println("3. Registrar nueva rutina");
            System.out.println("4. Seleccionar entrenador");
            System.out.println("5. Seleccionar rutina");
            System.out.println("6. Ver estadísticas");
            System.out.println("7. Salir");
            System.out.print("\nSelecciona una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n=== Registro de un nuevo socio ==="); //Ingreso de datos para registrar un nuevo socio
                    System.out.print("\nIngresa tu nombre: ");
                    String nombreEntrenador = sc.nextLine();
                    System.out.println("\n1. Masculino");
                    System.out.println("2. Femenino");
                    System.out.print("\nSelecciona tu genero: ");
                    int gen = sc.nextInt();
                    sc.nextLine();
                    String genero = " ";
                    if (gen == 1) {
                        genero = "Masculino";
                    } else if (gen == 2) {
                        genero = "Femenino";
                    } else {
                        System.out.println("Opción inválida");
                    }
                    System.out.println("\n1. Bajar de peso");
                    System.out.println("2. Ganar masa muscular");
                    System.out.println("3. Mejorar resistencia");
                    System.out.println("4. Tonificación");
                    System.out.println("5. Otra");
                    System.out.print("\nSelecciona tu meta: ");
                    int met = sc.nextInt(); //meta
                    sc.nextLine();
                    String meta = " ";
                    if (met == 1) {
                        meta = "Bajar de peso";
                    } else if (met == 2) {
                        meta = "Ganar masa muscular";
                    } else if (met == 3) {
                        meta = "Mejorar resistencia";
                    } else if (met == 4) {
                        meta = "Tonificación";
                    } else if (met == 5) {
                        meta = "Otro";
                    } else {
                        System.out.println("Opción inválida");
                    }
                    System.out.print("Ingresa tu tipo de membresía (Normal/Premium): ");
                    String tipoMembresia = sc.nextLine();
                    System.out.print("Ingresa tu edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingresa tu peso en kg: ");
                    double peso = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ingresa tu altura en m: ");
                    double altura = sc.nextDouble();
                    sc.nextLine();
                    Socio socio = new Socio (nombreEntrenador, genero, meta, tipoMembresia, edad, peso, altura); //registro del socio con los datos ingresados
                    gimnasio.registrarSocio(socio);
                    System.out.println("\nSocio registrado exitosamente\n" + socio);
                    break;
                
                case 2:
                    System.out.println("\n=== Registro de un nuevo entrenador ==="); //Ingreso de datos para registrar un nuevo entrenador
                    System.out.print("\nIngresa tu nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("\n1. Pesas");
                    System.out.println("\n2. Cardio");
                    System.out.println("\n3. CrossFit");
                    System.out.println("\n4. Otro");
                    System.out.print("Ingresa tu especialidad: ");
                    int esp = sc.nextInt();
                    sc.nextLine();
                    String especialidad = " ";
                    if (esp == 1) {
                        especialidad = "Pesas";
                    } else if (esp == 2) {
                        especialidad = "Cardio";
                    } else if (esp == 3) {
                        especialidad = "CrossFit";
                    } else if (esp == 4) {
                        especialidad = "Otro";
                    } else {
                        System.out.println("Opción inválida");
                    }
                    System.out.print("\nIngresa tu máximo de alumnos: ");
                    int maxAlumnos = sc.nextInt();
                    sc.nextLine();
                    Entrenador entrenador = new Entrenador (nombre, especialidad, maxAlumnos); //resgistro del entrenador con los datos ingresados
                    gimnasio.registrarEntrenador (entrenador);
                    System.out.println("\nEntrenador registrado exitosamente\n" + entrenador);
                    break;
                
                case 3:
                    System.out.println("\n=== Registro de nueva rutina ==="); //ingreso de datos para registrar rutina
                    System.out.println("\n1. Bajar de peso");
                    System.out.println("2. Ganar masa muscular");
                    System.out.println("3. Mejorar resistencia");
                    System.out.println("4. Tonificación");
                    System.out.println("5. Otra");
                    System.out.print("\nSelecciona el objetivo de la rutina: ");
                    int obj = sc.nextInt();
                    sc.nextLine();
                    String objetivo = " ";
                    if (obj == 1) {
                        objetivo = "Bajar de peso";
                    } else if (obj == 2) {
                        objetivo = "Ganar masa muscular";
                    } else if (obj == 3) {
                        objetivo = "Mejorar resistencia";
                    } else if (obj == 4) {
                        objetivo = "Tonificación";
                    } else if (obj == 5) {
                        objetivo = "Otra";
                    } else {
                        System.out.println("Opción inválida");
                    }
                    System.out.println("\n1. Fácil");
                    System.out.println("2. Intermedia");
                    System.out.println("3. Difícil");
                    System.out.print("\nSelecciona la dificultad de la rutina: ");
                    int dif = sc.nextInt();
                    sc.nextLine();
                    String dificultad = " ";
                    if (dif == 1) {
                        dificultad = "Fácil";
                    } else if (dif == 2) {
                        dificultad = "Intermedia";
                    } else if (dif == 3) {
                        dificultad = "Difícil";
                    } else {
                        System.out.println("Opción inválida");
                    }
                    System.out.print("\nIngresa la duración de la rutina en min: ");
                    int duracion = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nIngresa el tipo de rutina (Normal/Premium): ");
                    String tipo = sc.nextLine();
                    Rutina rutina = new Rutina (objetivo, dificultad, duracion, tipo); 
                    int salirEjer = -1;
                    while (salirEjer == -1){
                        System.out.println("\n1. Sí");
                        System.out.println("2. No");
                        System.out.print("¿Agregar ejercicios? ");
                        int ejer = sc.nextInt();
                        sc.nextLine();
                        if (ejer == 1){
                            System.out.print("\nIngresa el ejercicio: ");
                            String ejercicio = sc.nextLine();
                            rutina.agregarEjercicios(ejercicio); //agrega ejercicios a la rutina
                        } else if (ejer == 2) {
                            salirEjer = 0;
                        } else {
                            System.out.println("Opción inválida");
                        }
                    }
                    gimnasio.registrarRutina(rutina); //registra la rutina con os datos
                    System.out.println("\nRutina registrada exitosamente\n" + rutina);
                    break;
                
                case 4:
                    System.out.println("\n=== Seleccionar entrenador ==="); //permite al socio seleccionar su entrenador
                    System.out.println("\nLista de entrenadores:");
                    for (Entrenador e : gimnasio.getEntrenadores()) {
                        System.out.println(e); //muestra todos los entrenadores registrados
                    }
                    System.out.print("\nIngresa el ID del socio: ");
                    int idSocio = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nIngresa el ID del entrenador: ");
                    int idEntrenador = sc.nextInt();
                    sc.nextLine();

                    Socio sSelec = null; //busca dentro de a lista al socio seleccionado
                    for (Socio s : gimnasio.getSocios()) {
                        if (s.getId() == idSocio)
                        sSelec = s;
                    }
                    Entrenador eSelec = null; //busca dentro de la lista al entrenador seleccionado
                    for (Entrenador e : gimnasio.getEntrenadores()) {
                        if (e.getId() == idEntrenador)
                        eSelec = e;
                    }

                    if (sSelec != null && eSelec != null) {
                        if (eSelec.puedeAgregarAlumno()) {
                            eSelec.agregaAlumno(sSelec);
                            System.out.println("\nEntrenador asignado correctamente"); //si se puede, se agrega el socio como alumno del entrenador
                        } else {
                            System.out.println("\nEl entrenador ya alcanzó su límite de alumnos"); //si el entrenador ya alcanzó su máximo, no se puede asignar como alumno
                        }
                    } else {
                        System.out.println("\nEntrenador o socio no encontrado");
                    }
                    break;
                
                case 5:
                    System.out.println("=== Seleccionar rutina ==="); //permite al socio seleccionar su rutina
                    System.out.print("\nIngresa el ID del socio: ");
                    int numSocio = sc.nextInt();
                    sc.nextLine();
                    Socio sSelecc = null;
                    for (Socio s : gimnasio.getSocios()) {
                        if (s.getId() == numSocio) {
                        sSelecc = s;
                        } else {
                            System.out.println("Socio no encontrado");
                        }
                    }
                    System.out.println("\nRutinas recomendadas:");
                    System.out.println(gimnasio.rutinasRecomendadas(sSelecc)); //muestra las rutinas seleccionadas según el tipo de membresía

                    System.out.print("\nIngresa el número de la rutina: ");
                    int numRutina = sc.nextInt();
                    sc.nextLine();
                    Rutina rSelec = null;
                    for (Rutina r : gimnasio.getRutinas()) {
                        if (r.getId() == numRutina) {
                        rSelec = r;
                        } else {
                            System.out.println("Rutina no encontrada");
                        }
                    }
                    if (sSelecc != null && rSelec != null) {
                        sSelecc.setRutinaAsignada(rSelec);
                        rSelec.asignarSocio(sSelecc);
                        System.out.println("Rutina asignada correctamente.");
                    } else {    
                        System.out.println("No se pudo asignar la rutina.");
                    }
                    break;
                
                case 6:
                    System.out.println("\n=== Estadísticas generales ==="); //muestra las estadísticas generales del gimnasio
                    Rutina popular = gimnasio.rutinaMasPracticada();
                    if (popular != null) { //turina con mas practicantes
                        System.out.println("\nRutina más practicada: Rutina #" + popular.getId() + " para " + popular.getObjetivo() + " con " + popular.getPracticantes() + " practicantes");
                    } else {
                        System.out.println("\nNo hay rutinas registradas");
                    }
                    
                    Entrenador masAlumnos = gimnasio.entrenadorConMasAlumnos(); //entrenador con mas alumnos
                    if (masAlumnos != null) {
                        System.out.println("Entrenador con más alumnos: " + masAlumnos.getNombre() + " con " + masAlumnos.cantidadAlumnos() + " alumnos.");
                    } else {
                        System.out.println("No hay entrenadores registrados.");
                    }

                    System.out.println("Hay " + gimnasio.getRutinas().size() + " rutinas activas"); //cantidad de rutinas registradas
                    break;

                case 7:
                    salir = 0; //sale del ciclo while
                    break;
                default:
                    System.out.println("\nOpción inválida");
            }
        }
    }
}