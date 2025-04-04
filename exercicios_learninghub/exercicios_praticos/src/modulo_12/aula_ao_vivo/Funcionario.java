package modulo_12.aula_ao_vivo;

import java.util.Objects;

public abstract class Funcionario {
    private int numeroRegistro;
    private String nome;

    public Funcionario(int numeroRegistro, String nome) {
        this.numeroRegistro = numeroRegistro;
        this.nome = nome;
    }

    public int getNumeroRegistro() {
        return numeroRegistro;
    }

    public abstract float calcularSalario();

    public void exibirReciboPagamento() {
        System.out.println("#" + numeroRegistro + " - " + nome + ": R$" + calcularSalario());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return numeroRegistro == that.numeroRegistro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroRegistro);
    }
}
