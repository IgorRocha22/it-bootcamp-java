package modulo_12.aula_ao_vivo;

public class Horista extends Funcionario {
    private float valorHora;
    private int numeroHoras;

    public Horista(int numeroRegistro, String nome, float valorHora, int numeroHoras) {
        super(numeroRegistro, nome);
        this.valorHora = valorHora;
        this.numeroHoras = numeroHoras;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public float calcularSalario() {
        // valor Hora * numero Horas
        return valorHora * numeroHoras;
    }
}
