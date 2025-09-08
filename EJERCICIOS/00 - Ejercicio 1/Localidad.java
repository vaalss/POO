public class Localidad 
{
    private String nombre; //nombre de la localidad
    private double precio; //precio de la localidad
    private int capacidadMaxima, boletosVendidos; //capacidad máxima y cúantos boletos se han vendido para cada localidad

    public Localidad(String nombre, double precio) 
    {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidadMaxima = 20; //la capacidad máxima para cada localidad es 20
        this.boletosVendidos = 0; //todas las localidades empiezan con 0 boletos vendidos
    }

    public boolean hayEspacio(Comprador compradorActual) //verifica si hay suficiente espacio para la cantidad de boletos que quiere el comprador
    {
        int cantidadAVender = compradorActual.getCantidadBoletos();
        return (boletosVendidos + cantidadAVender) <= capacidadMaxima; //true si hay espacio, false si no hay
    }

    public int venderBoletos(Comprador compradorActual) 
    {
        int cantidadAVender = compradorActual.getCantidadBoletos();
        if (hayEspacio(compradorActual) && precio * cantidadAVender <= compradorActual.getPresupuesto()) //verifica que el presupuesto del comprador sea suficiente para comprar los boletos
        {
            boletosVendidos += cantidadAVender; //suma la cantidad vendida al comprador a los boletos vendidos de la localidad
            return cantidadAVender;
        }
        else //si el presupuesto no es suficiente, no se vende ningun boleto
        {
            return 0;
        }
    }

    public double totalVendido() //calcula el total de dinero por localidad
    {
        return boletosVendidos * precio;
    }

    public String getNombre()
    {
        return nombre;
    }

    public double getPrecio()
    {
        return precio;
    }

    public int getBoletosVendidos()
    {
        return boletosVendidos;
    }

    public int getBoletosDisponibles() //calcula cuántos boletos quedan disponibles en cada localidad
    {
        int boletosDisponibles = capacidadMaxima - boletosVendidos;
        return boletosDisponibles;
    }
}