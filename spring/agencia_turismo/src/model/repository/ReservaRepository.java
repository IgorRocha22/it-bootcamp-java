package model.repository;

import model.entity.Reserva;

import java.util.HashSet;
import java.util.Set;

public class ReservaRepository {
    private static Long id = 0L;
    private final static Set<Reserva> reservasArmazenadas = new HashSet<>();

    public boolean armazenarReserva(Reserva reserva) {
        return reservasArmazenadas.add(reserva);
    }

    public synchronized static Long gerarNovoId() {
        return id += 1;
    }

    public static Reserva getReserva(Long id) {
        return reservasArmazenadas.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }
}
