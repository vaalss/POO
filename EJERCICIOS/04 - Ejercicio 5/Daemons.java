//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Sección 40
//Valeria Hernández Maldonado 25086

//Modelo

import java.time.LocalTime;

public class Daemons extends Process { //hereda de proceso
    private static boolean activo; //estado de activación compartido por todas las instancias

    public Daemons(String nombre) {
        super(nombre); //llama al constructor de la clase "padre"
        this.activo = true; //se inicializa como activo, porque siempre debe de correr en "segundo plano"
    }

    public String ejecutar() {
            String tipo = this.getNombre(); //nombre = tipo de acción que realiza
            switch (tipo) {
                case "Monitoreo":
                    if (activo) {
                        return "Proceso Daemon activo, monitoreando procesos...";
                    } else {
                        return "Monitoreo detenido.";
                    }
                case "Hora Actual":
                    LocalTime hora = LocalTime.now();//toma la hora del instante
                    return "La hora actual es " + hora;
                case "Apagar sistema":
                    this.activo = false;
                    return "Apagando el sistema...";
                default:
                    return "No se reconoce el proceso";
            }
    }

    @Override 
     public String toString() {
        return "Proceso de Daemons " + this.getPID() + ": '" + this.getNombre() + "'";
    }
}