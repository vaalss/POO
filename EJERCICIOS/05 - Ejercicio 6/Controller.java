public class Controller {
    
    private ArrayList<Equipment> equipos;
    private View vista;

    public Controller() {
        this.equipo = new ArrayList<Equipment>();
        this.vista = new View();
    }

    public init() {
        Equiop e1 = new Drone("HydroDroneV1", 220); 
        e1.realizarMedicion("Nivel de humedad del cultivo y cobertura vegetal mediante cámara multiespectral"); 
        e1.realizarRegistro("Almacena mapas de humedad y rendimiento del terreno en la base de datos");
        equipos.add(e1);

        Equipo e2 = new Station("MeteoBaseAlpha", 90); 
        e2.realizarAccion("Envía alertas climáticas automáticas a los sistemas de riego"); 
        e2.realizarMedicion("Temperatura, velocidad del viento y radiación solar"); 
        e2.realizarRegistro("Registra datos climáticos horarios en el sistema de monitoreo"); 
        equipos.add(e2);
        
        Equipo e3 = new Sensor("ThermoSenseA", 15); 
        e3.realizarAccion("Envía alerta cuando la temperatura del suelo supera el umbral óptimo"); 
        e3.realizarRegistro("Registra lecturas de temperatura del suelo cada 10 minutos"); 
        equipos.add(e3);

        Equipo e4 = new Sensor("HygroTrackB", 18); 
        e4.realizarAccion("Activa el sistema de riego cuando detecta sequedad en el sustrato"); 
        e4.realizarRegistro("Registra valores de humedad y contenido de agua en el suelo"); 
        equipos.add(e4);

        Equipo e5 = new Sensor("SoilProbeC", 20); 
        e5.realizarAccion("Informa sobre compactación del suelo al sistema central"); 
        e5.realizarRegistro("Registra resistencia y densidad del suelo"); 
        equipos.add(e5);

        Equipo e6 = new Station("ClimaNode07", 85); 
        e6.realizarAccion("Activa sistemas de ventilación en invernaderos según condiciones"); 
        e6.realizarMedicion("Presión atmosférica, humedad relativa y punto de rocío"); 
        e6.realizarRegistro("Registra promedios diarios de condiciones ambientales"); 
        equipos.add(e6);
        
        Equipo e7 = new Drone("AgroSprayX2", 250); 
        e7.realizarMedicion("Detección de plagas en superficie mediante visión térmica"); 
        e7.realizarRegistro("Registra zonas afectadas y calcula cantidad de pesticida aplicada"); 
        equipos.add(e7);
        
        Equipo e8 = new Drone("AeroScanX1", 175); 
        e8.realizarMedicion("Captura imágenes aéreas de crecimiento de cultivos"); 
        e8.realizarRegistro("Guarda los mapas NDVI generados en el servidor central"); 
        equipos.add(e8);
        
        Equipo e9 = new Drone("RainMakerLite", 210); 
        e9.realizarMedicion("Evalúa humedad atmosférica y temperatura ambiente desde altura"); 
        e9.realizarRegistro("Registra los patrones climáticos detectados para predicción de lluvias"); 
        equipos.add(e9);
        
        Equipo e10 = new 
        Station("TemporaStation", 100); 
        e10.realizarAccion("Controla automáticamente los paneles de sombra según temperatura"); 
        e10.realizarMedicion("Temperatura ambiente y radiación solar"); 
        e10.realizarRegistro("Guarda historial de temperaturas por hora"); 
        equipos.add(e10);
        
        Equipo e11 = new Station("AtmosHubLite", 95); 
        e11.realizarAccion("Sincroniza datos meteorológicos con la nube cada 30 minutos"); 
        e11.realizarMedicion("Índice UV y nivel de precipitación"); 
        e11.realizarRegistro("Genera reportes diarios de las condiciones del clima"); 
        equipos.add(e11);
        
        Equipo e12 = new Sensor("RootSenseD", 22); 
        e12.realizarAccion("Monitorea la actividad radicular en tiempo real"); 
        e12.realizarRegistro("Registra datos sobre conductividad eléctrica y nutrientes en raíces"); 
        equipos.add(e12);
    }

    public void sistema() {
        int salir = -1;
        while (salir == -1) {
            vista.mostrarMenu();
            int opcion = vista.pedirNumero("Selecciona la opción a realizar: ");
            switch (opcion) {
                case 1:
                    vista.mostrarEquipo(equipos);
                    break;
                case 2:
                    String equipo = vista.pedirEntrada("Ingresa el nombre o ID del equipo que desees: ");
                    vista.buscarEquipo(equipos, equipo);
                    break;
                case 3:
                    Collections.sort(equipos);
                    vista.equiposPorConsumo(equipos);
                    break;
                case 4:
                    salir = 0;
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida");
            }   
        }
    }
}