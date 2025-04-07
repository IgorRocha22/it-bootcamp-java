package model.entity;

import java.time.LocalDateTime;

public class ReservaTransporte extends Reserva {
    private double distancia;

    public ReservaTransporte() {
    }

    public ReservaTransporte(Long id, String descricao, String local, LocalDateTime dataReserva, double valor, double distancia) {
        super(id, descricao, local, dataReserva, valor);
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
