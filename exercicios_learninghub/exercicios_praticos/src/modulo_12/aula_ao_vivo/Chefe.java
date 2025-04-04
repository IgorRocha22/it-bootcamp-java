package modulo_12.aula_ao_vivo;

public class Chefe extends Funcionario {
    private float salarioBase;
    private float adicionalFuncao;
    private float beneficioTerno;

    public Chefe(int numeroRegistro, String nome, float salarioBase, float adicionalFuncao, float beneficioTerno) {
        super(numeroRegistro, nome);
        this.salarioBase = salarioBase;
        this.adicionalFuncao = adicionalFuncao;
        this.beneficioTerno = beneficioTerno;
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    public float getAdicionalFuncao() {
        return adicionalFuncao;
    }

    public void setAdicionalFuncao(float adicionalFuncao) {
        this.adicionalFuncao = adicionalFuncao;
    }

    public float getBeneficioTerno() {
        return beneficioTerno;
    }

    public void setBeneficioTerno(float beneficioTerno) {
        this.beneficioTerno = beneficioTerno;
    }

    @Override
    public float calcularSalario() {
        // Salario Base + SalarioBase * adicional Funcao/ 100 + beneficio Terno
        return salarioBase + salarioBase * adicionalFuncao / 100 + beneficioTerno;
    }
}
