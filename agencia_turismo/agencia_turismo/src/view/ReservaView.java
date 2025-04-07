package view;


import controller.ReservaController;
import model.entity.Reserva;
import view.builder.ReservaDTOBuilder;
import view.dto.ReservaDTO;

public class ReservaView {
    private final ReservaController controller = new ReservaController();

    public Long gerarReserva(ReservaDTO dto) {
        return controller.gerarReserva(dto);
    }

    public ReservaDTO buscaReserva(Long id) {
        Reserva reserva = controller.buscaReserva(id);
        return ReservaDTOBuilder.newInstance().descricao(reserva.getDescricao()).local(reserva.getLocal()).dataReserva(reserva.getDataReserva()).valor(reserva.getValor()).build();
    }
}
