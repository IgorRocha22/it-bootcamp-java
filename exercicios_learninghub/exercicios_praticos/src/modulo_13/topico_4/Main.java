package modulo_13.topico_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Bart", "Simpsons"));
        clientes.add(new Cliente(2, "Homer", "Simpsons"));
        clientes.add(new Cliente(3, "Marge", "Simpsons"));

        System.out.println("Colecao de clientes criados: ");
        clientes.stream().forEach(System.out::println);
        clientes.remove(0);
        System.out.println("\nColecao de clientes após remocao: ");
        clientes.stream().forEach(System.out::println);

        System.out.println("\nBusca de cliente, digite o identificador: ");
        Scanner teclado = new Scanner(System.in);
        String idCliente = teclado.nextLine();
        Optional<Cliente> clienteOptional = clientes.stream().filter(c -> c.getId() == Integer.parseInt(idCliente)).findFirst();
        clienteOptional.ifPresentOrElse(c -> System.out.println("Cliente localizado! " + c), () -> System.err.println("Cliente não localizado, identificador " + idCliente));
    }
}
