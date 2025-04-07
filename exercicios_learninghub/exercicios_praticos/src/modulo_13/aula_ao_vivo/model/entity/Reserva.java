package modulo_13.aula_ao_vivo.model.entity;

import modulo_13.aula_ao_vivo.model.interfaces.IReserva;

import java.time.LocalDateTime;

public abstract class Reserva implements IReserva {
    private Long id;
    private String descricao;
    private String local;
    private LocalDateTime dataReserva;
    private double valor;

    public Reserva() {
    }

    public Reserva(Long id, String descricao, String local, LocalDateTime dataReserva, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.local = local;
        this.dataReserva = dataReserva;
        this.valor = valor;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
