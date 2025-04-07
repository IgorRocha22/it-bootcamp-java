package modulo_13.aula_ao_vivo.view;

import modulo_13.aula_ao_vivo.constantes.TipoReservaEnum;
import modulo_13.aula_ao_vivo.controller.PacoteController;
import modulo_13.aula_ao_vivo.model.entity.*;
import modulo_13.aula_ao_vivo.view.builder.ReservaDTOBuilder;
import modulo_13.aula_ao_vivo.view.dto.ClienteDTO;
import modulo_13.aula_ao_vivo.view.dto.PacoteDTO;
import modulo_13.aula_ao_vivo.view.dto.ReservaDTO;

import java.util.ArrayList;
import java.util.List;

public class PacoteView {

    private PacoteController controller = new PacoteController();

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
            // String descricao, String local, LocalDateTime dataReserva, double valor, TipoReservaEnum tipoReserva, Integer numeroQuarto, String localEmbarque, String localDesembarque, Integer numeroMesa, Double distancia
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
