package modulo_10.documentos;

import modulo_10.pessoa.Pessoa;
import modulo_10.interfaces.Imprimivel;

public class Relatorio extends Documento implements Imprimivel {
    private String texto;
    private Pessoa autor;
    private Pessoa revisor;

    public Relatorio(int quantidadePaginas, String texto, Pessoa autor, Pessoa revisor) {
        super(quantidadePaginas);
        this.texto = texto;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }

    public Pessoa getRevisor() {
        return revisor;
    }

    public void setRevisor(Pessoa revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
        System.out.println("Comprimento do texto: " + texto.length());
        System.out.println("Quantidade de Páginas: " + super.getQuantidadePaginas());
    }
}
