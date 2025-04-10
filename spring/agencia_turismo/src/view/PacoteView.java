package view;

import constantes.TipoReservaEnum;
import controller.PacoteController;
import model.entity.*;
import view.builder.ReservaDTOBuilder;
import view.dto.ClienteDTO;
import view.dto.PacoteDTO;
import view.dto.ReservaDTO;

import java.util.ArrayList;
import java.util.List;

public class PacoteView {

    private final PacoteController controller = new PacoteController();

    public Long criarPacote(Long idCliente, Long idReserva) {
        return controller.criarPacote(idCliente, idReserva);
    }

    public Long adicionarReserva(Long idPacote, Long idPassagem) {
        return controller.adicionarReserva(idPacote, idPassagem);
    }

    public PacoteDTO buscarPacote(Long idPacote) {
        Pacote pacote = controller.buscarPacote(idPacote);
        ClienteDTO clienteDTO = new ClienteDTO(pacote.getCliente().getId(), pacote.getCliente().getNome());
        List<ReservaDTO> reservasDTO = new ArrayList<>();
        for (Reserva reserva : pacote.getReservas()) {
            ReservaDTOBuilder builder = ReservaDTOBuilder.newInstance().descricao(reserva.getDescricao()).local(reserva.getLocal()).dataReserva(reserva.getDataReserva()).valor(reserva.getValor());
            if (reserva instanceof ReservaHotel) {
                builder.tipoReserva(TipoReservaEnum.HOTEL).numeroQuarto(((ReservaHotel) reserva).getNumeroQuarto());
            }
            if (reserva instanceof ReservaRefeicao) {
                builder.tipoReserva(TipoReservaEnum.REFEICAO).numeroMesa(((ReservaRefeicao) reserva).getNumeroMesa());
            }
            if (reserva instanceof ReservaPassagem) {
                builder.tipoReserva(TipoReservaEnum.PASSAGEM).localEmbarque(((ReservaPassagem) reserva).getLocalEmbarque()).localDesembarque(((ReservaPassagem) reserva).getLocalDesembarque());
            }
            if (reserva instanceof ReservaTransporte) {
                builder.tipoReserva(TipoReservaEnum.TRANSPORTE).distancia(((ReservaTransporte) reserva).getDistancia());
            }
            reservasDTO.add(builder.build());
        }
        return new PacoteDTO(pacote.getId(), clienteDTO, reservasDTO, pacote.getTotalReservas());
    }
}
