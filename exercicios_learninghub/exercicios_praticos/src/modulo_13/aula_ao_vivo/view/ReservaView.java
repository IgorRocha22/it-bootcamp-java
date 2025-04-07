package modulo_13.aula_ao_vivo.view;

import modulo_13.aula_ao_vivo.constantes.TipoReservaEnum;
import modulo_13.aula_ao_vivo.controller.ReservaController;
import modulo_13.aula_ao_vivo.view.builder.ReservaDTOBuilder;
import modulo_13.aula_ao_vivo.view.dto.ReservaDTO;
import modulo_13.aula_ao_vivo.model.entity.Reserva;

import java.time.LocalDateTime;

public class ReservaView {
    private ReservaController controller = new ReservaController();

    public Long gerarReserva(ReservaDTO dto) {
        Long idReserva = controller.gerarReserva(dto);
        return idReserva;
    }

    public ReservaDTO buscaReserva(Long id) {
        Reserva reserva = controller.buscaReserva(id);
        return ReservaDTOBuilder.newInstance().descricao(reserva.getDescricao()).local(reserva.getLocal()).dataReserva(reserva.getDataReserva()).valor(reserva.getValor()).build();
    }
}
