package modulo_12.aula_ao_vivo;

public class Comissionado extends Funcionario {
    private float salarioBase;
    private float comissao;

    public Comissionado(int numeroRegistro, String nome, float salarioBase, float comissao) {
        super(numeroRegistro, nome);
        this.salarioBase = salarioBase;
        this.comissao = comissao;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    @Override
    public float calcularSalario() {
        // salario Base + salarioBase * comissao / 100
        return salarioBase + salarioBase * comissao / 100;
    }
}
