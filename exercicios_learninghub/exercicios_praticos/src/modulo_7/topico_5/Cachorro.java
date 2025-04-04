package modulo_7.topico_5;

public class Cachorro extends Animal {

    private String nome;

    public Cachorro(String especie, String nome) {
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
        System.out.println("Sou um cachorro que late");
    }

    @Override
    public void fazerSom() {
        System.out.println("Auau");
    }
}
