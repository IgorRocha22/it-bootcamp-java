package modulo_13.aula_ao_vivo.model.entity;

import java.util.HashSet;
import java.util.Set;

public class Pacote {
    private Long id;
    private Cliente cliente;
    Set<Reserva> reservas = new HashSet<>();
    private double descontoAplicado;

    public Pacote() {
    }

    public Pacote(Long id, Cliente cliente, Reserva reserva) {
        this.id = id;
        this.cliente = cliente;
        this.reservas.add(reserva);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getDescontoAplicado() {
        return descontoAplicado;
    }

    public void setDescontoAplicado(double descontoAplicado) {
        this.descontoAplicado = descontoAplicado;
    }

    public double getTotalReservas() {
        return reservas.stream().map(Reserva::getValor).reduce((valor, acc) -> acc + valor).orElse(0.0);
    }

    public boolean adicionarReserva(Reserva reserva) {
        return this.reservas.add(reserva);
    }
}
