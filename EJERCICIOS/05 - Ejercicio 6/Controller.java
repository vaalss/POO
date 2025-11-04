import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    
    private ArrayList<Equipment> equipos;
    private View vista;

    public Controller() {
        this.equipos = new ArrayList<Equipment>();
        this.vista = new View();
    }

    public void init() {
        Equipment e1 = new Drone("HydroDroneV1", 220); 
        e1.trabajo("", "Nivel de humedad del cultivo y cobertura vegetal mediante cámara multiespectral", 
        "Almacena mapas de humedad y rendimiento del terreno en la base de datos");
        equipos.add(e1);

        Equipment e2 = new Station("MeteoBaseAlpha", 90); 
        e2.trabajo("Envía alertas climáticas automáticas a los sistemas de riego", 
        "Temperatura, velocidad del viento y radiación solar", 
        "Registra datos climáticos horarios en el sistema de monitoreo"); 
        equipos.add(e2);
        
        Equipment e3 = new Sensor("ThermoSenseA", 15); 
        e3.trabajo("Envía alerta cuando la temperatura del suelo supera el umbral óptimo", 
        "", "Registra lecturas de temperatura del suelo cada 10 minutos"); 
        equipos.add(e3);

        Equipment e4 = new Sensor("HygroTrackB", 18); 
        e4.trabajo("Activa el sistema de riego cuando detecta sequedad en el sustrato", "", 
        "Registra valores de humedad y contenido de agua en el suelo"); 
        equipos.add(e4);

        Equipment e5 = new Sensor("SoilProbeC", 20); 
        e5.trabajo("Informa sobre compactación del suelo al sistema central", "",
        "Registra resistencia y densidad del suelo"); 
        equipos.add(e5);

        Equipment e6 = new Station("ClimaNode07", 85); 
        e6.trabajo("Activa sistemas de ventilación en invernaderos según condiciones", 
        "Presión atmosférica, humedad relativa y punto de rocío",
        "Registra promedios diarios de condiciones ambientales"); 
        equipos.add(e6);
        
        Equipment e7 = new Drone("AgroSprayX2", 250); 
        e7.trabajo("", "Detección de plagas en superficie mediante visión térmica", 
        "Registra zonas afectadas y calcula cantidad de pesticida aplicada"); 
        equipos.add(e7);
        
        Equipment e8 = new Drone("AeroScanX1", 175); 
        e8.trabajo("", "Captura imágenes aéreas de crecimiento de cultivos",
        "Guarda los mapas NDVI generados en el servidor central"); 
        equipos.add(e8);
        
        Equipment e9 = new Drone("RainMakerLite", 210); 
        e9.trabajo("", "Evalúa humedad atmosférica y temperatura ambiente desde altura",
        "Registra los patrones climáticos detectados para predicción de lluvias"); 
        equipos.add(e9);
        
        Equipment e10 = new 
        Station("TemporaStation", 100); 
        e10.trabajo("Controla automáticamente los paneles de sombra según temperatura",
        "Temperatura ambiente y radiación solar", "Guarda historial de temperaturas por hora"); 
        equipos.add(e10);
        
        Equipment e11 = new Station("AtmosHubLite", 95); 
        e11.trabajo("Sincroniza datos meteorológicos con la nube cada 30 minutos",
        "Índice UV y nivel de precipitación", "Genera reportes diarios de las condiciones del clima"); 
        equipos.add(e11);
        
        Equipment e12 = new Sensor("RootSenseD", 22); 
        e12.trabajo("Monitorea la actividad radicular en tiempo real", "",
        "Registra datos sobre conductividad eléctrica y nutrientes en raíces"); 
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