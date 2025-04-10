package controller;

import model.entity.Cliente;
import model.repository.ClienteRepository;
import view.dto.ClienteDTO;

public class ClienteController {
    private final ClienteRepository repository = new ClienteRepository();

    public Long adicionarCliente(String nome) {
        Long idCliente = ClienteRepository.gerarId();
        if (repository.armazenarCliente(new Cliente(idCliente, nome))) {
            return idCliente;
        }
        return 0L;
    }

    public ClienteDTO buscarCliente(Long id) {
        return repository.buscarCliente(id);
    }
}
