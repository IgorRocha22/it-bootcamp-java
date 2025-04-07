package modulo_13.aula_ao_vivo.controller;

import modulo_13.aula_ao_vivo.model.entity.Cliente;
import modulo_13.aula_ao_vivo.model.entity.Pacote;
import modulo_13.aula_ao_vivo.model.entity.Reserva;
import modulo_13.aula_ao_vivo.model.repository.ClienteRepository;
import modulo_13.aula_ao_vivo.model.repository.PacoteRepository;
import modulo_13.aula_ao_vivo.model.repository.ReservaRepository;

public class PacoteController {

    private PacoteRepository repository = new PacoteRepository();

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
