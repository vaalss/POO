//Universidad del Valle de Guatemala
//Programación Orientada a Objetos Sección 40
//Valeria Hernández Maldonado 25086

//Modelo

import java.time.LocalDate;

public class IO extends Process { //hereda de proceso
    private View consola;

    public IO(String nombre) {
        super(nombre); //llama al consructor de la clase "padre"
        this.consola = new View();
    }

    public String ejecutar() {
        String tipo = this.getNombre(); //nombre = tipo de acción que realiza
        switch (tipo) {
            case "Mostrar fecha":
                LocalDate fecha = LocalDate.now(); //toma la fecha del instante 
                return "Hoy es " + fecha;
            case "Pedir nombre":
                String nombre = consola.pedirEntrada("Ingresa tu nombre: ");
                return "Tu nombre es " + nombre;
            case "Pedir edad":
                int edad = consola.pedirNumero("Ingresa tu edad: ");
                return "Tienes " + edad + " año(s)";
            default:
                return "No se reconoce el proceso";
        }   
    }

    @Override 
    public String toString() {
        return "Proceso de I/O " + this.getPID() + ": '" + this.getNombre() + "'";
    }
}