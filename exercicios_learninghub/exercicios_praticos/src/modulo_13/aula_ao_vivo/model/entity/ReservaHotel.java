package modulo_13.aula_ao_vivo.model.entity;

import java.time.LocalDateTime;

public class ReservaHotel extends Reserva {
    private int numeroQuarto;

    public ReservaHotel() {
    }

    public ReservaHotel(Long id, String descricao, String local, LocalDateTime dataReserva, double valor, int numeroQuarto) {
        super(id, descricao, local, dataReserva, valor);
        this.numeroQuarto = numeroQuarto;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
}
