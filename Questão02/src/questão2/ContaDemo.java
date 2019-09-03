package questão2;
public class ContaDemo {
    public void main(){
        Conta conta = new Conta("Vinicius", 101, 800);
        conta.depositaValor(150);
        conta.retiraValor(40);
        System.out.println("Saldo: " +conta.valorDisponivel()+ " R$");
    }
}