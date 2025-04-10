package controller;

import model.entity.Cliente;
import model.entity.Pacote;
import model.entity.Reserva;
import model.repository.ClienteRepository;
import model.repository.PacoteRepository;
import model.repository.ReservaRepository;

public class PacoteController {

    private final PacoteRepository repository = new PacoteRepository();

    public Long criarPacote(Long idCliente, Long idReserva) {
        Cliente cliente = ClienteRepository.getCliente(idCliente);
        Reserva reserva = ReservaRepository.getReserva(idReserva);
        if (cliente.getIdPacotes().size() > 1) {
            return repository.criarPacote(cliente, reserva, 0.05);
        }
        return repository.criarPacote(cliente, reserva);
    }

    public Long adicionarReserva(Long idPacote, Long idReserva) {
        Pacote pacote = PacoteRepository.getPacote(idPacote);
        pacote.adicionarReserva(ReservaRepository.getReserva(idReserva));
        return pacote.getId();
    }

    public Pacote buscarPacote(Long idPacote) {
        return PacoteRepository.getPacote(idPacote);
    }
}
