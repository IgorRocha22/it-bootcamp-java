package modulo_13.aula_ao_vivo.view;

import modulo_13.aula_ao_vivo.controller.ClienteController;
import modulo_13.aula_ao_vivo.view.dto.ClienteDTO;

public class ClienteView {
    private ClienteController controller = new ClienteController();

    public Long adicionarCliente(String nome) {
        Long idCliente = controller.adicionarCliente(nome);
        if (idCliente == null) {
            System.err.printf("Não foi possível adicionar o cliente %d\n", nome);
        }
        return idCliente;
    }

    public ClienteDTO buscarCliente(Long id) {
        return controller.buscarCliente(id);
    }
}
