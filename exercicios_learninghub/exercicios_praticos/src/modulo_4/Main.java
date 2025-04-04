package modulo_4;

public class Main {
    public static void main(String[] args) {

        Categoria circuitoPequeno = new Categoria(1, "circuito pequeno", "2 km pela mata e riachos");
        Categoria circuitoMedio = new Categoria(2, "circuito medio", "5 km em meio à selva, riachos e lama");
        Categoria circuitoAvancado = new Categoria(3, "circuito avancado", "10 km de selva, riachos, lama e escalada em rocha");

        Participante p1 = new Participante(1, 21);
        Participante p2 = new Participante(2, 27);
        Participante p3 = new Participante(2, 17);
        Inscricao inscricao = new Inscricao(1, circuitoPequeno, p1);
        Inscricao inscricao2 = new Inscricao(2, circuitoMedio, p2);
        Inscricao inscricao3 = new Inscricao(3, circuitoAvancado, p3);
        System.out.println(inscricao);
        System.out.println(inscricao2);
        System.out.println(inscricao3);
    }
}
