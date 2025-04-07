package modulo_13.aula_ao_vivo.controller;

import modulo_13.aula_ao_vivo.model.entity.*;
import modulo_13.aula_ao_vivo.model.repository.ReservaRepository;
import modulo_13.aula_ao_vivo.view.dto.ReservaDTO;

public class ReservaController {
    private ReservaRepository repository = new ReservaRepository();

    public Long gerarReserva(ReservaDTO dto) {
        Reserva reserva = switch (dto.getTipoReserva()) {
            case HOTEL ->
                    new ReservaHotel(ReservaRepository.gerarNovoId(), dto.getDescricao(), dto.getLocal(), dto.getDataReserva(), dto.getValor(), dto.getNumeroQuarto());
            case REFEICAO ->
                    new ReservaRefeicao(ReservaRepository.gerarNovoId(), dto.getDescricao(), dto.getLocal(), dto.getDataReserva(), dto.getValor(), dto.getNumeroMesa());
            case PASSAGEM ->
                    new ReservaPassagem(ReservaRepository.gerarNovoId(), dto.getDescricao(), dto.getLocal(), dto.getDataReserva(), dto.getValor(), dto.getLocalEmbarque(), dto.getLocalDesembarque());
            case TRANSPORTE ->
                    new ReservaTransporte(ReservaRepository.gerarNovoId(), dto.getDescricao(), dto.getLocal(), dto.getDataReserva(), dto.getValor(), dto.getDistancia());
        };
        if (repository.armazenarReserva(reserva)) {
            return reserva.getId();
        }
        return 0L;
    }

    public Reserva buscaReserva(Long id) {
        return repository.getReserva(id);
    }
}
