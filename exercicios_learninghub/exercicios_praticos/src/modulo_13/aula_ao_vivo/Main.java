package modulo_13.aula_ao_vivo;

import modulo_13.aula_ao_vivo.constantes.TipoReservaEnum;
import modulo_13.aula_ao_vivo.view.ClienteView;
import modulo_13.aula_ao_vivo.view.PacoteView;
import modulo_13.aula_ao_vivo.view.ReservaView;
import modulo_13.aula_ao_vivo.view.builder.ReservaDTOBuilder;
import modulo_13.aula_ao_vivo.view.dto.ClienteDTO;
import modulo_13.aula_ao_vivo.view.dto.PacoteDTO;
import modulo_13.aula_ao_vivo.view.dto.ReservaDTO;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        ClienteView clienteView = new ClienteView();
        ReservaView reservaView = new ReservaView();
        PacoteView pacoteView = new PacoteView();

        System.out.println("Adicionar Cliente");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = teclado.nextLine();
        Long idClienteAdicionado = clienteView.adicionarCliente(nomeCliente);

        ClienteDTO clienteDTO = clienteView.buscarCliente(idClienteAdicionado);
        System.out.printf("Cliente %s inserido", clienteDTO.nome());

        System.out.printf("\nGerando reserva de Hotel para o cliente...");
        ReservaDTO reservaHotelDto = ReservaDTOBuilder.newInstance().descricao("Hotel Bom Demais").local("Cancun - MX").dataReserva(LocalDateTime.now()).valor(500.0).tipoReserva(TipoReservaEnum.HOTEL).numeroQuarto(12).build();
        Long idReserva = reservaView.gerarReserva(reservaHotelDto);
        ReservaDTO reservaInserida = reservaView.buscaReserva(idReserva);
        System.out.printf("\nReserva %s cadastrada\n", reservaInserida.getDescricao());

        System.out.printf("\nCriando pacote para o cliente %d com a reserva %d...\n", idClienteAdicionado, idReserva);
        Long idPacote = pacoteView.criarPacote(idClienteAdicionado, idReserva);

        System.out.printf("\nGerando reserva de Passagem para o cliente...");
        ReservaDTO reservaPassagemDto = ReservaDTOBuilder.newInstance().descricao("Passagem aerea para Cancun").local("Aeroporto internacional de Guarulhos - SP").dataReserva(LocalDateTime.now()).valor(2500.0).tipoReserva(TipoReservaEnum.PASSAGEM).localEmbarque("Terminal Internacional Guarulhos - GRU").localDesembarque("Terminal Internacional Mexico - T2 - CNX").build();
        Long idPassagem = reservaView.gerarReserva(reservaPassagemDto);
        pacoteView.adicionarReserva(idPacote, idPassagem);
        PacoteDTO pacoteDTO = pacoteView.buscarPacote(idPacote);
        System.out.println("\n" + pacoteDTO.gerarRecibo());
    }
}
