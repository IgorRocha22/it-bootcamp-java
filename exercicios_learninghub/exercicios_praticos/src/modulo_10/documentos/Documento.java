package modulo_10.documentos;

import modulo_10.interfaces.Imprimivel;

public abstract class Documento implements Imprimivel {

    private int quantidadePaginas;

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public Documento(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    @Override
    public abstract void imprimir();
}
