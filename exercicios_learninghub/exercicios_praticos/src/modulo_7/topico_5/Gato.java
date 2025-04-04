package modulo_7.topico_5;

public class Gato extends Animal {

    private String nome;

    public Gato(String especie, String nome) {
        super(especie);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void mostrarEspecie() {
        super.mostrarEspecie();
        System.out.println("Sou um gato que mia");
    }

    @Override
    public void fazerSom() {
        System.out.println("Miau");
    }
}
