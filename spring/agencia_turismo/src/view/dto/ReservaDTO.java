package view.dto;

import constantes.TipoReservaEnum;

import java.time.LocalDateTime;

public class ReservaDTO {
    private String descricao;
    private String local;
    private LocalDateTime dataReserva;
    private double valor;
    private TipoReservaEnum tipoReserva;
    private Integer numeroQuarto;
    private String localEmbarque;
    private String localDesembarque;
    private Integer numeroMesa;
    private Double distancia;

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

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoReservaEnum getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReservaEnum tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String getLocalEmbarque() {
        return localEmbarque;
    }

    public void setLocalEmbarque(String localEmbarque) {
        this.localEmbarque = localEmbarque;
    }

    public String getLocalDesembarque() {
        return localDesembarque;
    }

    public void setLocalDesembarque(String localDesembarque) {
        this.localDesembarque = localDesembarque;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
}
