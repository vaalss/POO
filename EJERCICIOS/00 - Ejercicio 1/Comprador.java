public class Comprador
{
    private String nombre, email; //nombre y email del comprador
    private int cantidadBoletos; //cuántos boletos desea comprar
    private double presupuesto; //cúanto dinero está dispuesto a gastar en los boletos
    private boolean yaSolicito; //verifica si el comprador ya ha realizado una solicitud

    public Comprador(String nombre, String email, int cantidadBoletos, double presupuesto)
    {
        this.nombre = nombre;
        this.email = email;
        this.cantidadBoletos = cantidadBoletos;
        this.presupuesto = presupuesto;
        this.yaSolicito = false; //inician con false porque no han realizado ninguna solicitud
    }

    public SolicitudBoleto solicitarCompra() 
    {
        if (yaSolicito) //si el comprador ya realizó una solicitud no se le permite realizar otra
        {
            return null;
        }
        yaSolicito = true; 
        return new SolicitudBoleto(); //si no realizado una solicitud antes se inicia una nueva
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) //guarda el valor que ingresa el usuario
    {
        this.nombre = nombre;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) //guarda el valor que ingresa el usuario
    {
        this.email = email;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) //guarda el valor que ingresa el usuario
    {
        this.cantidadBoletos = cantidadBoletos;
    }

    public double getPresupuesto() 
    {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) //guarda el valor que ingresa el usuario
    {
        this.presupuesto = presupuesto;
    }

    public boolean getYaSolicito() 
    {
        return yaSolicito;
    }
}