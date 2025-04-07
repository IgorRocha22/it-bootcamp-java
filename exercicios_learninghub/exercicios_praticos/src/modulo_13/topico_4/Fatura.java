package modulo_13.topico_4;

import java.util.List;

public class Fatura {
    private Cliente cliente;
    private List<Item> itens;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public float getTotalCompra() {
        return itens.stream().map(i -> i.getQuantidadeComprada() * i.getCusto()).reduce((acc, i) -> acc += i).orElseGet(null);
    }
}
