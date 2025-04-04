package modulo_10;

import modulo_10.documentos.Curriculo;
import modulo_10.documentos.Livro;
import modulo_10.documentos.Relatorio;
import modulo_10.interfaces.Imprimivel;
import modulo_10.pessoa.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Impressão do Curriculo");
        Pessoa candidato = new Pessoa("Igor");
        List<String> habilidades = new ArrayList<String>();
        habilidades.add("Java");
        habilidades.add("JavaScript");
        habilidades.add("Spring");

        Imprimivel.imprimirDocumento(new Curriculo(1, candidato, habilidades));

        System.out.println("\nImpressão do Livro");
        Livro livro = new Livro(300, new Pessoa("J. K. Rolling"), "Harry Potter", "Fantasia");
        Imprimivel.imprimirDocumento(livro);

        System.out.println("\nImpressão do Relatório");
        Relatorio relatorio = new Relatorio(5, "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", new Pessoa("John"), new Pessoa("Johnson"));
        Imprimivel.imprimirDocumento(relatorio);
    }
}
