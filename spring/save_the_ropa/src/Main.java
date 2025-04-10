import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Roupa camisa = new Roupa("Lacoste", "Camisa T-Shirt");
        Roupa calca = new Roupa("Renner", "Calça Jeans");

        List<Roupa> roupas = new ArrayList<>();
        roupas.add(camisa);
        roupas.add(calca);

        GuardaRoupa guardaRoupa = new GuardaRoupa();
        guardaRoupa.guardarRoupas(roupas);
        guardaRoupa.mostrarRoupas();

        System.out.println("\nGuardando as roupas da supreme...\n");

        Roupa camisaSupreme = new Roupa("Supreme", "Camisa Branca com vermelho");
        Roupa jaquetaSupreme = new Roupa("Supreme", "Jaqueta da supreme corta-vento");
        List<Roupa> roupasSupreme = new ArrayList<>();
        roupasSupreme.add(camisaSupreme);
        roupasSupreme.add(jaquetaSupreme);
        guardaRoupa.guardarRoupas(roupasSupreme);

        guardaRoupa.mostrarRoupas();

        System.out.println("\nMostrando as roupas da lacoste e renner...\n");
        List<Roupa> roupasDevolvidas = guardaRoupa.devolverRoupa(1);
        for (Roupa roupa : roupasDevolvidas) {
            System.out.println("Roupa devolvida do armário");
            System.out.printf("\t%s: %s\n", roupa.getMarca(), roupa.getModelo());
        }

    }
}