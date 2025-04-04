package modulo_10.documentos;

import modulo_10.pessoa.Pessoa;
import modulo_10.interfaces.Imprimivel;

import java.util.List;

public class Curriculo extends Documento implements Imprimivel {
    private Pessoa pessoa;
    List<String> habilidades;

    public Curriculo(int quantidadePaginas, Pessoa pessoa, List<String> habilidades) {
        super(quantidadePaginas);
        this.pessoa = pessoa;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Nome: " + pessoa);
        System.out.println("--------------------");
        System.out.println("Habilidades:");
        habilidades.stream().forEach(System.out::println);
    }
}
