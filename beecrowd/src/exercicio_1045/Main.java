package exercicio_1045;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        System.out.println("Digite os três lados do triangulo");
        Scanner teclado = new Scanner(System .in);
        final double a, b, c;
        a = teclado.nextDouble();
        b = teclado.nextDouble();
        c = teclado.nextDouble();

        if (a >= b + c) {
            System.out.println("NAO FORMA TRIANGULO\n");
            return;
        }
        if (Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)) {
            System.out.println("TRIANGULO RETANGULO\n");
        }
        if (Math.pow(a, 2) > Math.pow(b, 2) + Math.pow(c, 2)) {
            System.out.println("TRIANGULO OBTUSANGULO\n");
        }
        if (Math.pow(a, 2) < Math.pow(b, 2) + Math.pow(c, 2)) {
            System.out.println("TRIANGULO ACUTANGULO\n");
        }
        if (a == b && b == c) {
            System.out.println("TRIANGULO EQUILATERO\n");
        } else if (a == b || a == c) {
            System.out.println("TRIANGULO ISOSCELES\n");
        }
    }
}
