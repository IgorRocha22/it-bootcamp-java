package modulo_7.topico_5;

public class Main {

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Cachorro", "Spike");
        cachorro.mostrarEspecie();
        cachorro.fazerSom();

        Animal gato = new Gato("Gato", "Garfield");
        gato.mostrarEspecie();
        gato.fazerSom();

        Animal cachorro2 = cachorro;
        cachorro2.mostrarEspecie();
        cachorro2.fazerSom();
    }
}
