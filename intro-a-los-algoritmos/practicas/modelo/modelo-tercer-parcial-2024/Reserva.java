
/**
 * Representa una reserva de una sala de estudio hecha por un estudiante.
 */
public class Reserva {
    private String estudiante;
    private int horaInicio; // en formato 24hs (por ej. 13 representa 13:00)
    private int duracionHoras; // cantidad de horas reservadas (entre 1 y 4)

    /**
     * @pre estudiante != null && !estudiante.isEmpty()
     * @pre horaInicio >= 8 && horaInicio <= 20
     * @pre duracionHoras >= 1 && duracionHoras <= 4
     */
    public Reserva(String estudiante, int horaInicio, int duracionHoras) {
        if (estudiante == null || estudiante.isEmpty())
            throw new IllegalArgumentException("estudiante nulo o vacio.");

        if (horaInicio < 8 || horaInicio > 20)
            throw new IllegalArgumentException("Hora de inicio invalida. Debe estar entre las 8hs y las 20hs");

        if (duracionHoras < 1 || duracionHoras > 4)
            throw new IllegalArgumentException("Duracion de horas invalida. Debe ser entre 1 y 4 horas");

        this.estudiante = estudiante;
        this.horaInicio = horaInicio;
        this.duracionHoras = duracionHoras;

        if (!repOK())
            throw new IllegalStateException("Invariante de clase incumplida");
    }

    public String obtenerEstudiante() {
        return estudiante;
    }

    public int obtenerHoraInicio() {
        return horaInicio;
    }

    public int obtenerHoraFin() {
        return horaInicio + duracionHoras;
    }

    public String toString() {
        return String.format("%s reservó de %d a %d hs", estudiante, horaInicio, obtenerHoraFin());
    }

    public boolean repOK() {
        if (estudiante == null || estudiante.isEmpty())
            return false;

        if (horaInicio < 8 || horaInicio > 20)
            return false;

        if (duracionHoras < 1 || duracionHoras > 4)
            return false;

        return true;
    }
}
