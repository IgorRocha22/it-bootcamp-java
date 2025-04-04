package modulo_4;

public class Inscricao {

    private int id;
    private Categoria categoria;
    private Participante participante;
    private double valor;

    public Inscricao(int id, Categoria categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
        this.calculaValorInscricao();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    private void calculaValorInscricao() {
        int idCategoria = this.categoria.getId();
        int idadeParticipante = this.participante.getIdade();
        switch (idCategoria) {
            case 1:
                this.valor = 1300.0;
                break;
            case 2:
                this.valor = 2000.0;
                break;
            case 3:
                this.valor = 2600.0;
                break;
        }
        if (idadeParticipante > 18) {
            this.valor += 200.0;
        }
    }

    @Override
    public String toString() {
        return this.categoria.getNome() + " - Participante Idade: " + this.participante.getIdade() + " Valor da Inscrição: " + this.valor;
    }
}
