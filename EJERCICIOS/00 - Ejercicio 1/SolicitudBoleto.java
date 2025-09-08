import java.util.Random;

public class SolicitudBoleto 
{
    private int numeroBoleto, numeroA, numeroB; //números aleatorios para la verificación de selección
    private boolean validez; //verifica si fue seleccionado para la compra o no
    private Localidad localidadAsignada; //localidad para la solicitud

    public SolicitudBoleto() 
    {
        Random random = new Random();
        this.numeroBoleto = random.nextInt(15000) + 1; //genera los números aleatorios para cada solicitud
        this.numeroA = random.nextInt(15000) + 1; 
        this.numeroB = random.nextInt(15000) + 1;
        this.validez = validarBoleto();
    }

    private boolean validarBoleto() 
    {
        int min = Math.min(numeroA, numeroB); //determina el mínimo del rango
        int max = Math.max(numeroA, numeroB); //determina el máximo del rango
        return numeroBoleto >= min && numeroBoleto <= max; //verifica si el número de solicitud se encuentra en el rango
    }

    public boolean getValidez() //true si el número está en el rango, false si no está
    {
        return validez;
    }


    public void asignarLocalidad(Localidad[] localidades) //escoge aleatoriamente la localidad 
    {
        Random random = new Random();
        int indice = random.nextInt(localidades.length);
        this.localidadAsignada = localidades[indice];
    }

    public Localidad getLocalidadAsignada() 
    {
        return localidadAsignada;
    }
}