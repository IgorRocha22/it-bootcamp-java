package model.entity;

import java.time.LocalDateTime;

public class ReservaRefeicao extends Reserva {
    private int numeroMesa;

    public ReservaRefeicao() {
    }

    public ReservaRefeicao(Long id, String descricao, String local, LocalDateTime dataReserva, double valor, int numeroMesa) {
        super(id, descricao, local, dataReserva, valor);
        this.numeroMesa = numeroMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }
}
