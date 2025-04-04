package modulo_10.interfaces;

public interface Imprimivel {

    public void imprimir();

    public static void imprimirDocumento(Imprimivel documento){
        documento.imprimir();
    }
}
