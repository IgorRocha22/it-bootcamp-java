package modulo_10.documentos;

import modulo_10.pessoa.Pessoa;
import modulo_10.interfaces.Imprimivel;

public class Livro extends Documento implements Imprimivel {
    private Pessoa autor;
    private String titulo;
    private String genero;

    public Livro(int quantidadePaginas, Pessoa autor, String titulo, String genero) {
        super(quantidadePaginas);
        this.autor = autor;
        this.titulo = titulo;
        this.genero = genero;
    }

    @Override
    public void imprimir() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Genero: " + genero);
        System.out.println("Quantidade de Páginas: " + super.getQuantidadePaginas());
    }
}
