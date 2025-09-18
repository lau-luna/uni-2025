import java.util.ArrayList;

public class SalaEstudio {
    private ArrayList<Reserva> reservas;

    public SalaEstudio() {
        reservas = new  ArrayList<>();

        if (!repOK())
            throw new IllegalStateException("Invariante de clase incumplida");
    }

    /**
     * Intenta agregar una reserva a la sala. No se permiten reservas superpuestas.
     * @param r la reserva a agregar
     * @throws IllegalArgumentException si r es nula o se superpone con otra
     */
    public void agregarReserva(Reserva r) {
        if (r == null)
            throw new IllegalArgumentException("reserva nula");

        if (estaOcupada(r.obtenerHoraInicio()))
            throw new IllegalArgumentException("La hora " + r.obtenerHoraInicio() + "hs ya esta reservada");

        reservas.add(r);

        if (!repOK())
            throw new IllegalStateException("Invariante de clase incumplida");
    }

    /**
     * Retorna true si hay una reserva activa en esa hora específica.
     */
    public boolean estaOcupada(int hora) {
        for (Reserva r : reservas)
            if (hora >= r.obtenerHoraInicio() && hora < r.obtenerHoraFin())
                return true;

        return false;
    }

    public void imprimirReservas() {
        for (Reserva r : reservas)
            System.out.println(r.toString());
    }

    public boolean repOK() {
        if (reservas == null)
            return false;

        for (int i = 0; i < reservas.size(); i++) {
            if (!reservas.get(i).repOK())
                return false;

            for (int j = i+1; j < reservas.size(); j++) {
                if (reservas.get(i).obtenerHoraInicio() >= reservas.get(j).obtenerHoraInicio() && reservas.get(i).obtenerHoraInicio() <= reservas.get(j).obtenerHoraFin())
                    return false;
            }
        }

        return true;
    }
}
