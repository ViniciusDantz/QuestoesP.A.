package questão11;
public class Questão11 {
    public static void main(String[] args) {
        Mercadoria mercadoria = new Mercadoria("Sabão", 10, 100);
        System.out.println(mercadoria.Comprar() +"\n");
        System.out.println(mercadoria.Comprar(9) +"\n");
        System.out.println(mercadoria.Comprar(10, 10) +"\n");
        System.out.println("Estoque: " +mercadoria.getQtdEstoque());
    }
}