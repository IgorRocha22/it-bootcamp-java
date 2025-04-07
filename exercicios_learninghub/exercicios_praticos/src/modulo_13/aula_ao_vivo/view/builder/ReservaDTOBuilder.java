package modulo_13.aula_ao_vivo.view.builder;

import modulo_13.aula_ao_vivo.constantes.TipoReservaEnum;
import modulo_13.aula_ao_vivo.view.dto.ReservaDTO;

import java.time.LocalDateTime;

public class ReservaDTOBuilder {
    private static final ReservaDTO dto = new ReservaDTO();

    public static ReservaDTOBuilder newInstance() {
        return new ReservaDTOBuilder();
    }

    public ReservaDTOBuilder descricao(String descricao) {
        dto.setDescricao(descricao);
        return this;
    }

    public ReservaDTOBuilder local(String local) {
        dto.setLocal(local);
        return this;
    }

    public ReservaDTOBuilder dataReserva(LocalDateTime dataReserva) {
        dto.setDataReserva(dataReserva);
        return this;
    }

    public ReservaDTOBuilder valor(double valor) {
        dto.setValor(valor);
        return this;
    }

    public ReservaDTOBuilder tipoReserva(TipoReservaEnum tipoReservaEnum) {
        dto.setTipoReserva(tipoReservaEnum);
        return this;
    }

    public ReservaDTOBuilder numeroQuarto(Integer numeroQuarto) {
        dto.setNumeroQuarto(numeroQuarto);
        return this;
    }

    public ReservaDTOBuilder localEmbarque(String localEmbarque) {
        dto.setLocalEmbarque(localEmbarque);
        return this;
    }

    public ReservaDTOBuilder localDesembarque(String localDesembarque) {
        dto.setLocalDesembarque(localDesembarque);
        return this;
    }

    public ReservaDTOBuilder numeroMesa(Integer numeroMesa) {
        dto.setNumeroMesa(numeroMesa);
        return this;
    }

    public ReservaDTOBuilder distancia(Double distancia) {
        dto.setDistancia(distancia);
        return this;
    }

    public ReservaDTO build() {
        return dto;
    }
}
