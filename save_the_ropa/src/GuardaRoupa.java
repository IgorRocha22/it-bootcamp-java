import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRoupa {
    private Integer id;
    private final Map<Integer, List<Roupa>> roupas;

    public GuardaRoupa() {
        this.id = 1;
        this.roupas = new HashMap<>();
    }

    public Integer guardarRoupas(List<Roupa> listaDeRoupas) {
        Integer idAtual = id;
        roupas.put(idAtual, listaDeRoupas);
        id++;
        return idAtual;
    }

    public void mostrarRoupas() {
        for (Map.Entry<Integer, List<Roupa>> segmentoArmario : roupas.entrySet()) {
            System.out.printf("Espaço nº%d - Roupas\n", segmentoArmario.getKey());
            List<Roupa> roupas = segmentoArmario.getValue();
            for (Roupa roupa : roupas) {
                System.out.printf("\tRoupa: %s - %s\n", roupa.getMarca(), roupa.getModelo());
            }
            System.out.println("--------------------------");
        }
    }

    public List<Roupa> devolverRoupa(Integer id) {
        return roupas.get(id);
    }
}
