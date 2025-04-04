package modulo_12.aula_ao_vivo;

public class Empreiteiro extends Funcionario {
    private float valorEmpreita;

    public Empreiteiro(int numeroRegistro, String nome, float valorEmpreita) {
        super(numeroRegistro, nome);
        this.valorEmpreita = valorEmpreita;
    }

    public float getValorEmpreita() {
        return valorEmpreita;
    }

    public void setValorEmpreita(float valorEmpreita) {
        this.valorEmpreita = valorEmpreita;
    }

    @Override
    public float calcularSalario() {
        // valor Empreita
        return valorEmpreita;
    }
}
