package modulo_2;

public class Main {
    public static void main(String[] args) {
        String[] cidades = {"Londres", "Madrid", "Nova York", "Buenos Aires", "Assunção", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35} };

        String cidadeTempBaixa = "";
        String cidadeTempAlta = "";
        int tempBaixa = 999;
        int tempAlta = -999;

        for (int i = 0; i < cidades.length; i++) {
            String cidadePosAtual = cidades[i];
            if (temperaturas[i][0] < tempBaixa) {
                tempBaixa = temperaturas[i][0];
                cidadeTempBaixa = cidadePosAtual;
            }
            if (temperaturas[i][1] > tempAlta) {
                tempAlta = temperaturas[i][1];
                cidadeTempAlta = cidadePosAtual;
            }
        }

        System.out.println("Cidade com menor temperatura " + cidadeTempBaixa + " " + tempBaixa + "º");
        System.out.println("Cidade com maior temperatura " + cidadeTempAlta + " " + tempAlta + "º");

    }
}