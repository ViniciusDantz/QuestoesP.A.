package questão2;
public class ContaDemo2 {
    public void main(){
        contaEspecial conta2 = new contaEspecial("João", 1234, 100, 500);
        System.out.println("Saldo: " +conta2.valorDisponivel()+ " R$");
        conta2.depositaValor(400);
        if(!conta2.retiraValor(50)){
            System.out.println("Impossível sacar valor!");
        }
        System.out.println("Saldo: " +conta2.valorDisponivel()+ " R$");
        if(!conta2.retiraValor(900)){
            System.out.println("Impossível sacar valor!");
        }
        System.out.println("Saldo: " +conta2.valorDisponivel()+ " R$");
        if(!conta2.retiraValor(100)){
            System.out.println("Impossível sacar valor!");
        }
        conta2.depositaValor(50);
        System.out.println("Saldo: " +conta2.valorDisponivel()+ " R$");
        if(!conta2.retiraValor(100)){
            System.out.println("Impossível sacar valor!");
        }
        System.out.println("Saldo: " +conta2.valorDisponivel()+ " R$");
    }
}