package questão11;
public class Mercadoria {
    private String nome;
    private double valor;
    private int qtdEstoque;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    public Mercadoria(String nome, double valor, int qtdEstoque){
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.valor = valor;
    }
    public double Comprar(){
        qtdEstoque = qtdEstoque - 1;
        return valor;
    }
    public double Comprar(int qtdItens){
        qtdEstoque = qtdEstoque - qtdItens;
        return (valor * qtdItens);
    }
    public double Comprar(int qtdItens, double desconto){
        qtdEstoque = qtdEstoque - qtdItens;
        desconto = desconto / 100;
        valor = valor * qtdItens;
        valor = valor - (valor / desconto);
        return valor;
    }
}