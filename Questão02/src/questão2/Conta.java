package questão2;
public class Conta {
    protected String nomeCliente;
    protected int numero;
    protected double saldo;
    public Conta(String nomeCliente, int numero, double deposito){
        this.nomeCliente = nomeCliente;
        this.numero = numero;
        this.depositaValor(deposito);
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public double getSaldo() {
        return saldo;
    }
    public void depositaValor(double valor){
        this.saldo = this.saldo + valor;
    }
    public boolean retiraValor(double valor){
        if(valor <= saldo){
            this.saldo = this.saldo - valor;
            return true;
        }
        return false;
    }
    public double valorDisponivel(){
        return this.saldo;
    }
}