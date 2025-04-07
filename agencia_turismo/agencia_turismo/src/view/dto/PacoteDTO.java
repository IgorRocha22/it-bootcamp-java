package view.dto;

import java.util.List;

public record PacoteDTO(Long id, ClienteDTO cliente, List<ReservaDTO> reservas, double valor) {

    public String gerarRecibo() {
        StringBuilder recibo = new StringBuilder("Pacote nº" + id + "\n"
                + "\tCliente: " + cliente.nome() + "\n"
                + "\tReservas: \n");
        for (ReservaDTO reserva : reservas) {
            recibo.append("\t\tReserva ");
            recibo.append(reserva.getTipoReserva());
            recibo.append(" - ");
            recibo.append(reserva.getDescricao());
            recibo.append(": R$");
            recibo.append(reserva.getValor());
            recibo.append("\n");
        }
        recibo.append("Total: ");
        recibo.append(valor);
        return recibo.toString();
    }
}
