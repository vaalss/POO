import java.util.Random;

public class CPU extends Process {
    private int a;
    private int b;
    private Random rand;

    public CPU(String nombre) {
        super(nombre)        
        this.rand = new Random();
        this.a = rand.nextInt(1, 1000);
        this.b = rand.nextInt(1, 1000);
    }

    public String ejecutar() {
        String tipo = this.getNombre();
        switch (tipo) {
            case "Suma": {
                int resultado = a + b;
                return a + " + " + b + " = " + resultado;
            }
            case "Resta": {
                if (a > b) {
                    int resultado = a - b;
                    return a + " - " + b + " = " + resultado;
                } else {
                    int resultado = b - a;
                    return b + " - " + a + " = " + resultado;
                } 
            }
            case "Multiplicar": {
                int resultado = a * b;
                return a + " x " + b + " = " + resultado;
            }
            case "Dividir": {
                if (a > 0) {
                    int resultado b / a;
                    return b + " / " + a + " = " + resultado;
                } else {
                    if (b > 0) {
                        int resultado a / b;
                        return a + " / " + b + " = " + resultado;
                    } else {
                        return "No se puede realizar la división"
                    }
                } 
            }
            case "Memoria Restante":
                return "Tienes " + rand.nextInt(1, 368) + " bytes restantes de memoria";
            default:
                return "No se reconoce el proceso";
        }
    }


    @Override 
    public String toString() {
        return "Proceso de CPU: " + this.getPID() + " '" + this.getNombre + "'";
    }
}