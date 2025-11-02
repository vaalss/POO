public class View {
    
    private sc Scanner;

    public View() {
        this.sc = new Scanner(System.in);
    }

    public mostrarMenu() {
        println("--- MENÚ ---");
        println("1. Lista de equipos");
        println("2. Buscar equipo");
        println("3. Equipos por consumo eléctrico");
        println("4. Salir");
    }

    public String pedirEntrada(String prompt) {
        print(prompt);
        String entrada = sc.nextLine();
        return entrada;
    }

    public int pedirNumero(String prompt) {
        print(prompt);
        int entrada = sc.nextInt();
        sc.nextLine();
        return int;
    }

    public void mostrarEquipo(ArrayList<Equipment> equipos) {
        println("--- LISTADO DE EQUIPOS ---");
        for (Equipment e : equipos) {
            println (" - " + e + "\n");
        }
    }

    public Equipment buscarEquipo(ArrayList<Equipment> equipos, String buscar) {
        try {
            int id = Integer.parseInt(buscar);
            for (Equipment e : equipo) {
                if (e.getID() == id) {
                    return e;
                }
            }
        } catch (NumberFormatException) {
            for (Equipment e : equipos) {
                if (e.getNombre().equalsIgnoreCase(buscar)) {
                    return e;
                }
            }
        }
        return null;
    }

    public void equiposPorConsumo(ArrayList<Equipment> equipos) {
        for (Equipment e : equipos) {
            println (" - " + e + "\n");
        }
    }


    //helpers
    public void print(String m) {
        System.out.print(m);
    }

    public void println(String m) {
        System.out.println(m);
    }
}