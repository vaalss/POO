public class Celda {
    private final String emoji; //emoji asignado a la celda
    private boolean emparejada; //true si ya encontró la pareja
    private boolean visibleTemporal; //true si la celda está revelada temporalmente por el turno

    public Celda(String emoji) {
        this.emoji = emoji;
        this.emparejada = false;
        this.visibleTemporal = false;
    }

    //Getters
    public String getEmoji() {
        return this.emoji;
    }

    public boolean isEmparejada() {
        return this.emparejada;
    }

    public boolean isVisibleTemporal() {
        return this.visibleTemporal;
    }

    //Setters
    public void setEmparejada(boolean emparejada) {
        this.emparejada = emparejada;
    }

    public boolean setVisibleTemporal(boolean visibleTemporal) {
        this.visibleTemporal = visibleTemporal;
    }

    @Override
    public String toString() {
        if (this.emparejada || this.visibleTemporal) {
            return this.emoji;
        }
        return ".";
    }


}