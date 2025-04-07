package view;

import controller.ClienteController;
import view.dto.ClienteDTO;

public class ClienteView {
    private final ClienteController controller = new ClienteController();

    public Long adicionarCliente(String nome) {
        Long idCliente = controller.adicionarCliente(nome);
        if (idCliente == null) {
            System.err.printf("Não foi possível adicionar o cliente %s\n", nome);
        }
        return idCliente;
    }

    public ClienteDTO buscarCliente(Long id) {
        return controller.buscarCliente(id);
    }
}
