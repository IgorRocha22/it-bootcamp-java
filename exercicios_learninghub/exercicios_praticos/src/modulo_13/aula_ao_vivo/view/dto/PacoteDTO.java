package modulo_13.aula_ao_vivo.view.dto;

import java.util.List;

public record PacoteDTO(Long id, ClienteDTO cliente, List<ReservaDTO> reservas, double valor) {

    public String gerarRecibo() {
        StringBuilder recibo = new StringBuilder("Pacote nº" + id + "\n"
                + "\tCliente: " + cliente.nome() + "\n"
                + "\tReservas: \n");
        for (ReservaDTO reserva : reservas) {
            recibo.append("\t\tReserva " + reserva.getTipoReserva() + " - " + reserva.getDescricao() + ": R$" + reserva.getValor() + "\n");
        }
        recibo.append("Total: " + valor);
        return recibo.toString();
    }
}
