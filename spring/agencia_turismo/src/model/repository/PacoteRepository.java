package model.repository;

import model.entity.Cliente;
import model.entity.Pacote;
import model.entity.Reserva;

import java.util.HashSet;
import java.util.Set;

public class PacoteRepository {
    private static Long id = 0L;
    private final static Set<Pacote> pacotesArmazenados = new HashSet<>();

    public Long criarPacote(Cliente cliente, Reserva reserva) {
        Pacote pacote = new Pacote(PacoteRepository.gerarId(), cliente, reserva);
        pacotesArmazenados.add(pacote);
        return pacote.getId();
    }

    public Long criarPacote(Cliente cliente, Reserva reserva, Double desconto) {
        Pacote pacote = new Pacote(PacoteRepository.gerarId(), cliente, reserva);
        if (desconto != null) {
            pacote.setDescontoAplicado(desconto);
        }
        pacotesArmazenados.add(pacote);
        return pacote.getId();
    }

    public static Pacote getPacote(Long id) {
        return pacotesArmazenados.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public boolean armazenarPacote(Pacote pacote) {
        return pacotesArmazenados.add(pacote);
    }

    public static synchronized Long gerarId() {
        return id += 1;
    }
}
