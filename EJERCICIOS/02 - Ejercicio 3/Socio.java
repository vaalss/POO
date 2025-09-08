public class Socio {
    private String nombre; 
    private String genero; //Masculino, femenino, otro
    private String meta; //Bajar de peso, ganar masa, mantenerse
    private String tipoMembresia; //Normal, Premium
    private int edad, id; //número identificador del socio
    private double peso; //en kilogramos
    private double altura; //en metros
    private Rutina rutinaAsignada; //se inicia como null porque no tiene rutina asignada
    private static int contador = 1; // lleva el control de los id

    public Socio (String nombre, String genero, String meta, String tipoMembresia, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.genero = genero;
        this.meta = meta;
        this.tipoMembresia = tipoMembresia;
        this.edad = edad;
        this.id = contador++;
        this.peso = peso;
        this.altura = altura;
        this.rutinaAsignada = null; //se inicializa sin rutina asignada, hasta que la selecciona 
    }

    public String calcularIMC() {
        double IMC = 0;
        if (altura > 0) {
            IMC = peso / (altura * altura);
        }
        return String.format ("%.2f", IMC); //devuelve el IMC como un string con dos decimales 
    }

    //Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getMeta() {
        return this.meta;
    }

    public String getTipoMembresia() {
        return this.tipoMembresia;
    }

    public int getEdad() {
        return this.edad;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public Rutina getRutinaAsignada() {
        return this.rutinaAsignada;
    }

    public int getId() {
        return this.id;
    }

    //Setters
    public void setRutinaAsignada(Rutina r) {
        this.rutinaAsignada = rutinaAsignada;
    }

    public void setTipoMembresia() {
        this.tipoMembresia = tipoMembresia;
    }

    public void setMeta() {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "Socio #" + id +": " + nombre + " [Edad:  " + edad + " años, Género: " + genero +", Meta: " + meta + ", Tipo de membresía: " + tipoMembresia +
        ", Peso: " + peso + ", Altura: " + altura + ", IMC: " + calcularIMC() + ", Rutina asignada: " + (rutinaAsignada != null ? rutinaAsignada.getObjetivo() : "Ninguna") + "]";
    }

}