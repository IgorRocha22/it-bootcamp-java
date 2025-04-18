package model.repository;

import model.entity.Cliente;
import view.dto.ClienteDTO;

import java.util.HashSet;
import java.util.Set;

public class ClienteRepository {
    private static Long id = 0L;
    private final static Set<Cliente> clientes = new HashSet<>();

    public boolean armazenarCliente(Cliente cliente) {
        return clientes.add(cliente);
    }

    public static Cliente getCliente(Long id) {
        return clientes.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public ClienteDTO buscarCliente(Long id) {
        Cliente cliente = getCliente(id);
        if (cliente != null) {
            return new ClienteDTO(cliente.getId(), cliente.getNome());
        }
        return new ClienteDTO(0L, "Cliente não localizado");
    }

    public void atribuirPacote(Long idCliente, Long idPacote) {
        Cliente cliente = getCliente(idCliente);
        cliente.adicionarPacote(idPacote);
    }
    public synchronized static Long gerarId() {
        return id += 1L;
    }
}
