import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Batalla {
    private Consola vista;
    private List<Jugador> jugadoresG; //lista de posibles jugadores guerreros
    private List<Jugador> jugadoresE; //lista de posibles jugadores exploradores
    private List<Jugador> jugadores; //lista de jugadores escogidos por el usuario
    private List<Enemigo> enemigosN; //lista de posibles enemigos normales
    private List<Enemigo> enemigosJ; //lista de posibles enemigos jefes
    private List<Enemigo> enemigos; //lista de enemigos escogidos de forma aleatoria
    private List<String> acciones; //lista de las acciones realizadas
    private int turno;
    private Random rand;


    public Batalla() {
        this.vista = new Consola();
        this.rand = new Random();
        this.jugadoresG = new ArrayList<Jugador>();
        this.jugadoresE = new ArrayList<Jugador>();
        this.jugadores = new ArrayList<Jugador>();
        this.enemigosN = new ArrayList<Enemigo>();
        this.enemigosJ = new ArrayList<Enemigo>();
        this.enemigos = new ArrayList<Enemigo>();
        this.acciones = new ArrayList<String>();
        this.turno = 0;
    }

    public void iniciar() {
        Item i1 = new Item("Veneo", "ATACAR", 20); //se instancian los posibles items
        Item i2 = new Item("Bomba", "ATACAR", 100);
        Item i3 = new Item("Inyección letal", "ATACAR", 200);
        Item i4 = new Item("Puñalada", "ATACAR", 50);
        Item i5 = new Item("Flecha envenenada", "ATACAR", 70);
        Item i6 = new Item("Posión curativa", "DEFENDER", 70);
        Item i7 = new Item("Medicina", "DEFENDER", 50);
        Item i8 = new Item("Escudo mágico", "DEFENDER", 100);
        Item i9 = new Item("Barrera de luz", "DEFENDER", 80);
        Item i10 = new Item("Cura suprema", "DEFENDER", 200);

        Habilidad h1 = new Habilidad("Golpe relámpago", "ATACAR", 20); //se instancias las posibles habilidades
        Habilidad h2 = new Habilidad("Tormenta eléctrica", "ATACAR", 50);
        Habilidad h3 = new Habilidad("Lluvia mortal", "ATACAR", 200);
        Habilidad h4 = new Habilidad("Puño de hierro", "ATACAR", 30);
        Habilidad h5 = new Habilidad("Infección", "ATACAR", 100);
        Habilidad h6 = new Habilidad("Muro de energía", "DEFENDER", 80);
        Habilidad h7 = new Habilidad("Escudo de luz", "DEFENDER", 70);
        Habilidad h8 = new Habilidad("Refugio", "DEFENDER", 50);
        Habilidad h9 = new Habilidad("Curación divina", "DEFENDER", 200);
        Habilidad h10 = new Habilidad("Bendición protectora", "DEFENDER", 100);

        Guerrero j1 = new Guerrero("Paladin", 80, 40); j1.inventario.add(i1); j1.inventario.add(i6); //se instancias los posibles jugadores guerreros
        Guerrero j2 = new Guerrero("Gladiador", 75, 45); j2.inventario.add(i2); j2.inventario.add(i7); //se añaden sus items
        Guerrero j3 = new Guerrero("Bárbaro", 65, 42); j3.inventario.add(i3); j3.inventario.add(i8);
        Guerrero j4 = new Guerrero("Caballero", 75, 47); j4.inventario.add(i4); j4.inventario.add(i9);
        Guerrero j5 = new Guerrero("Centurión", 85, 45 ); j5.inventario.add(i5); j5.inventario.add(i10);

        Explorador j6 = new Explorador("Cazador", 30, 26); j6.inventario.add(i1); j6.inventario.add(i7); j6.inventario.add(i3); //se instancias los posibles jugadores exploradores
        Explorador j7 = new Explorador("Acechador", 40, 28); j7.inventario.add(i2); j7.inventario.add(i5); j7.inventario.add(i9);
        Explorador j8 = new Explorador("Tirador", 35, 29); j8.inventario.add(i3); j8.inventario.add(i8); j8.inventario.add(i4);
        Explorador j9 = new Explorador("Asesino", 42, 28); j9.inventario.add(i6); j9.inventario.add(i10); j9.inventario.add(i3);
        Explorador j10 = new Explorador("Samurai", 28, 29); j10.inventario.add(i10); j10.inventario.add(i2); j10.inventario.add(i7);

        EnemigoNormal e1 = new EnemigoNormal("Bestia", 70, 22); e1.habilidades.add(h1);//se instancian los posibles enemigos normales
        EnemigoNormal e2 = new EnemigoNormal("Hechicero", 90, 23); e2.habilidades.add(h2); //se añaden sus habilidades
        EnemigoNormal e3 = new EnemigoNormal("Bruja", 80, 25); e3.habilidades.add(h3);
        EnemigoNormal e4 = new EnemigoNormal("Fantasma", 92, 30); e4.habilidades.add(h4);
        EnemigoNormal e5 = new EnemigoNormal("Esqueleto", 75, 40); e5.habilidades.add(h5);

        EnemigoJefe e6 = new EnemigoJefe("Hidra", 60, 36); e6.habilidades.add(h1); e6.habilidades.add(h6); //se instancian los posibles enemigos jefes
        EnemigoJefe e7 = new EnemigoJefe("Zombie", 80, 40); e7.habilidades.add(h2); e7.habilidades.add(h7);
        EnemigoJefe e8 = new EnemigoJefe("Zorro", 85, 23); e8.habilidades.add(h3); e8.habilidades.add(h8);
        EnemigoJefe e9 = new EnemigoJefe("Demonio", 65, 28); e9.habilidades.add(h4); e9.habilidades.add(h9);
        EnemigoJefe e10 = new EnemigoJefe("Espectro", 75, 32); e10.habilidades.add(h5); e10.habilidades.add(h10);

        //se agregan los jugadores a la lista de posibles elecciones del usuario según su tipo
        jugadoresG.add(j1); jugadoresG.add(j2); jugadoresG.add(j3); jugadoresG.add(j4); jugadoresG.add(j5);
        jugadoresE.add(j6); jugadoresE.add(j7); jugadoresE.add(j8); jugadoresE.add(j9); jugadoresE.add(j10);
        //se agregan los enemigos a la lista de posibles combatientes según su tipo
        enemigosN.add(e1); enemigosN.add(e2); enemigosN.add(e3); enemigosN.add(e4); enemigosN.add(e5);
        enemigosJ.add(e6); enemigosJ.add(e7); enemigosJ.add(e8); enemigosJ.add(e9); enemigosJ.add(e10);
    }

    public void jugar() {
        int cantEnemigosN = rand.nextInt(3) + 1; //número random entre 1 y 3
        int cantEnemigosJ = rand.nextInt(3) + 1; // dos números para asegurarse que se escoga al menos un jugador de cada tipo
        int cantJugadoresG = rand.nextInt(3) + 1; //número random entre 1 y 3
        int cantJugadoresE = rand.nextInt(3) + 1; //dos números para asegurarse que se escoga el menos un enemigo de cada tipo
        int cantEnemigos = cantEnemigosJ + cantEnemigosN; //cantidad total de enemigos en la batalla
        int cantJugadores = cantJugadoresE + cantJugadoresG; //cantidad total de jugadores en la batalla
        
        vista.bienvenida(cantEnemigos, cantJugadores); //se muestran las reglas del juego

        for (int i = 0; i < cantJugadoresE; i++) { //seleccion de jugadores exploradores
            vista.menuSeleccionE(jugadoresE);
            int e = vista.pedirNumero("Selecciona tu explorador: ");
            jugadores.add(jugadoresE.get(e-1));//se agregan a la lista de jugadores que participan en la batalla
            jugadoresE.remove(e-1);//se eliminan de la lista de posibles opciones para evitar repetición
        }
        for (int i = 0; i < cantJugadoresG; i++) { //se asegura de que hayan tanto exploradores como guerreros
            vista.menuSeleccionG(jugadoresG);
            int g = vista.pedirNumero("Selecciona tu guerrero: ");
            jugadores.add(jugadoresG.get(g-1));
            jugadoresG.remove(g-1); 
        }
        for (int i = 0; i < cantEnemigosN; i++) { //selección al azar de los enemigos
            int aleatorio = rand.nextInt(enemigosN.size());
            enemigos.add(enemigosN.get(aleatorio)); //se agregan a la lista de enemigos que participan en la batalla
            enemigosN.remove(aleatorio); //se eliminan de la lista de posibles opciones para evitar repetición
        }
        for (int i = 0; i < cantEnemigosJ; i++) { //se asegura de que haya enemigos tanto jefes como normales
            int aleatorio = rand.nextInt(enemigosJ.size());
            enemigos.add(enemigosJ.get(aleatorio)); 
            enemigosJ.remove(aleatorio);
        }

        vista.mostrarCombatientes(jugadores, enemigos); //muestra a los combatientes ya seleccionados

        int salir = 0;
        while (salir == 0) {
            int turnoJ = turno % jugadores.size(); //determina el índice del jugador que le toca
            Jugador jugadorTurno = jugadores.get(turnoJ); //jugador del turno 
            int turnoE = turno % enemigos.size(); //determina el índice del enemigo que le toca
            Enemigo enemigoTurno = enemigos.get(turnoE); //enemigo del turno

            vista.menuAcciones(turno); //muestra las posibles acciones según el tipo de combatiente
            String opcion = vista.pedirEntrada("Selecciona tu acción para " + (turno % 2 == 0 ? jugadorTurno.getNombre() : enemigoTurno.getNombre()) + ": ").trim().toUpperCase();
            
            switch (opcion){
                case "ATACAR":
                    if (turno % 2 == 0) { //turno de los jugadores
                        vista.mostrarMensaje(jugadorTurno.mostrarMensajeInicio()); //si un jugador ataca, entra a la batalla y muestra su mensaje de inicio
                        int objetivo_A_J_I = rand.nextInt(enemigos.size()); //indice del enemigo que recibe el ataque del jugador (aleatorio)
                        Enemigo objetivo_A_J = enemigos.get(objetivo_A_J_I); //enemigo que recibe el ataque
                        objetivo_A_J.recibirAtaque(jugadorTurno.getAtaque(), enemigos, jugadores, objetivo_A_J_I, turnoJ, cantEnemigos, cantJugadores); //el enemigo recibe el ataque del jugador
                        if (objetivo_A_J.vivo()) { //se agrega la acció a la lista de acciones 
                            acciones.add(jugadorTurno.getNombre() + " ha atacado a " + objetivo_A_J.getNombre());
                        } else { //si el jugador mata al enemigo
                            acciones.add(jugadorTurno.getNombre() + " ha matado a " + objetivo_A_J.getNombre());
                        }
                    } else { //turno de los enemigos
                        int objetivo_A_E_I = rand.nextInt(jugadores.size()); //índice del jugador que recibe el ataque del enemigo (aleatorio)
                        Jugador objetivo_A_E = jugadores.get(objetivo_A_E_I); //jugador que recibe el ataque
                        objetivo_A_E.recibirAtaque(enemigoTurno.getAtaque(), enemigos, jugadores, turnoE, objetivo_A_E_I, cantEnemigos, cantJugadores); //el jugador recibe el ataqeu del enemigo
                        if (objetivo_A_E.vivo()) { //se agrega la acción a la lista de acciones
                            acciones.add(enemigoTurno.getNombre() + " ha atacado a " + objetivo_A_E.getNombre());
                        } else { //si el enemigo mató al jugador
                            acciones.add(enemigoTurno.getNombre() + " ha matado a " + objetivo_A_E.getNombre());
                            vista.mostrarMensaje(objetivo_A_E.mostrarMensajeFinal()); //si el jugador muere muestra su mensaje final
                        }
                    }
                    turno++; //se suma para pasar al siguiente turno
                    vista.mostrarStatus(jugadores, enemigos); //se muestra el estado de todos los combatientes de la batalla
                    vista.mostrarAcciones(acciones); //se muestran las ultimas tres acciones que se realizaron
                    break;
                case "PASAR EL TURNO":
                    if (turno % 2 == 0) { //no se realiza ninguna acción, solo se pasa al siguiente turno
                        acciones.add("Los jugadores han pasado el turno");
                    } else {
                        acciones.add("Los enemigos han pasado el turno");
                    }
                    turno++; 
                    vista.mostrarStatus(jugadores, enemigos);
                    vista.mostrarAcciones(acciones);
                    break;
                case "USAR ITEM":
                    int objetivo_I_J_I = rand.nextInt(enemigos.size()); //escoge un enemigo aleatorio para recibir el item del jugador
                    Enemigo objetivo_I_J = enemigos.get(objetivo_I_J_I); //enemigo que recibe el efecto del item
                    vista.mostrarItems(jugadorTurno); //muestra los items disponibles del jugador que tiene el turno
                    int item = vista.pedirNumero("Selecciona el número del item que quieras usar: ");
                    jugadorTurno.usarItem(item-1, objetivo_I_J, jugadorTurno, enemigos, jugadores, objetivo_I_J_I, turnoJ, cantEnemigos, cantJugadores); //se usa el item del jugador
                    if (objetivo_I_J.vivo()) { //se agrega la acción a la lista de acciones
                        acciones.add(jugadorTurno.getNombre() + " ha utilizado un item sobre " + objetivo_I_J.getNombre());
                    } else {
                        acciones.add(jugadorTurno.getNombre() + " ha utilizado un item sobre " + objetivo_I_J.getNombre() + " y lo ha matado");
                    }
                    turno++;
                    vista.mostrarStatus(jugadores, enemigos);
                    vista.mostrarAcciones(acciones);
                    break;
                case "USAR HABILIDAD":
                    int objetivo_H_E_I = rand.nextInt(jugadores.size()); //escoge un jugador aleatorio para recibir el ataque
                    Jugador objetivo_H_E = jugadores.get(objetivo_H_E_I); //jugador que recibe el efecto de la habilidad
                    vista.mostrarHabilidades(enemigoTurno); //muestra las habilidades disponibles del enemigo que tiene el turno
                    int habilidad = vista.pedirNumero("Selecciona el número de la habilidad que quieras usar: ");
                    enemigoTurno.usarHabilidad(habilidad-1, enemigoTurno, objetivo_H_E, enemigos, jugadores, turnoE, objetivo_H_E_I, cantEnemigos, cantJugadores); //se usa la habilidad del enemigo
                    if (objetivo_H_E.vivo()) { //se agrega la acción a la lista de acciones
                        acciones.add(enemigoTurno.getNombre() + " ha utilizado una habilidad especial sobre " + objetivo_H_E.getNombre());
                    } else {
                        acciones.add(enemigoTurno.getNombre() + " ha utilizado una habilidad especial sobre " + objetivo_H_E.getNombre() + " y lo ha matado");
                        vista.mostrarMensaje(objetivo_H_E.mostrarMensajeFinal()); //si el jugador muere muestra su mensaje final
                    }
                    turno++;
                    vista.mostrarStatus(jugadores, enemigos);
                    vista.mostrarAcciones(acciones);
                    break;
                case "SALIR":
                    salir = 1; //se termina el ciclo si se decide sali
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
                    break; 
            }
            if (verificarFin()) {
                salir = 1; //si todos los jugadores o todos los enemigos están muertos se temrina el juego
            }
        }
        ganador();
    }

    public boolean verificarFin() {
        boolean jVivos = false;
        for (Jugador j : jugadores) {
            if(j.getVidaActual() > 0) {
                jVivos = true; //al menos un jugador sigue vivo
            }
        }
        boolean eVivos = false;
        for (Enemigo e : enemigos) {
            if(e.getVidaActual() > 0) {
                eVivos = true; //al menos un enemigo sigue vivo
            }
        }
        return (!jVivos || !eVivos); //si alguno de los dos es false, quiere decir que ya murieron todos los de ese equipo
    }

    public void ganador() {
        boolean jVivos = false;
        for (Jugador j : jugadores) {
            if(j.getVidaActual() > 0) {
                jVivos = true; //al menos un jugador sigue vivo
            }
        }
        boolean eVivos = false;
        for (Enemigo e : enemigos) {
            if(e.getVidaActual() > 0) {
                eVivos = true; //al menos un enemigo sigue vivo
            }
        }
        if (!jVivos && eVivos) {
            vista.mostrarMensaje("¡Han ganado los enemigos!");
        } else if (jVivos && !eVivos) {
            for (Jugador j : jugadores) { //los jugadores que no han muerto muestran su mensaje de final
                vista.mostrarMensaje(j.mostrarMensajeFinal());
            }
            vista.mostrarMensaje("¡Han ganado los jugadores!");
        } else {
            vista.mostrarMensaje("¡La batalla ha finalizado en empate!");
        }
    }
}