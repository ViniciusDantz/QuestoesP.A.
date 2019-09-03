package questão2;
public class contaEspecial extends Conta{
    private double limite;
    public double getLimite() {
        return limite;
    }
    public void setLimite(double limite) {
        this.limite = limite;
    }
    public contaEspecial(String nomeCliente, int numero, double deposito, double limite) {
        super(nomeCliente, numero, deposito);
        this.limite = limite;
    }
    @Override
    public boolean retiraValor(double valor){
        if(valor <= saldo + limite){
            this.saldo = this.saldo - valor;
            return true;
        }
        return false;
    }
    @Override
    public double valorDisponivel(){
        return (this.saldo + this.limite);
    }
}