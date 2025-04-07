package modulo_13.aula_ao_vivo.controller;

import modulo_13.aula_ao_vivo.model.repository.ClienteRepository;
import modulo_13.aula_ao_vivo.view.dto.ClienteDTO;
import modulo_13.aula_ao_vivo.model.entity.Cliente;

public class ClienteController {
    private ClienteRepository repository = new ClienteRepository();

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
