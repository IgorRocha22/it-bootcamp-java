package modulo_12.aula_ao_vivo;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("ACME - Construção de Silos Anti Nucleares para o Apocalipse Zumbi");
        System.out.println("Folha de pagamento\n");

        var chefe = new Chefe(1, "Rene", 10000, 0.5f, 1000);
        var comissionado = new Comissionado(2,"Roberto", 1500, 0.02f);
        var horista = new Horista(3,"José", 40, 60);
        var empreiteiro = new Empreiteiro(4,"Leonardo", 500);
        var diretor = new Chefe(5, "Victor", 20000, 0.9f, 1000);
        var diretorDuplicado = new Chefe(5, "Victor", 20000, 0.9f, 1000);

        Set<Funcionario> funcionarios = new HashSet<>();
        funcionarios.add(chefe);
        funcionarios.add(comissionado);
        funcionarios.add(horista);
        funcionarios.add(empreiteiro);
        funcionarios.add(diretor);
        funcionarios.add(diretorDuplicado);

        funcionarios.stream().sorted((a, b) -> a.getNumeroRegistro() - b.getNumeroRegistro()).forEach(Funcionario::exibirReciboPagamento);
    }
}
