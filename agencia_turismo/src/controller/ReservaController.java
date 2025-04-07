package controller;


import model.entity.*;
import model.repository.ReservaRepository;
import view.dto.ReservaDTO;

public class ReservaController {
    private final ReservaRepository repository = new ReservaRepository();

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
        return ReservaRepository.getReserva(id);
    }
}
