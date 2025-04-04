package modulo_7.topico_5;

public class Animal {

    private String especie;

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Animal(String especie) {
        this.especie = especie;
    }

    public void mostrarEspecie() {
        System.out.println("Sou um animal da espécie: " + this.especie);
    }

    public void fazerSom() {
        System.out.println("O animal fez um som");
    }
}
