package questão12;
public class ConsultordeVendas extends Funcionario{
    private double valorBonusMensal;
    public ConsultordeVendas(String nome, String[] dependentes, char sexo, char nivel) {
        super(nome, dependentes, sexo, nivel);
    }
    public double getValorBonusMensal() {
        return valorBonusMensal;
    }
    public void setValorBonusMensal(double valorBonusMensal) {
        this.valorBonusMensal = valorBonusMensal;
    }
    @Override
    public String calcularSalario(){
        double salario;
        if(this.nivel == 'T' || this.nivel == 't'){
            salario = 2000 + this.valorBonusMensal;
            return String.valueOf(salario);
        }else if(this.nivel == 'P' || this.nivel == 'p'){
            salario = 3500 + this.valorBonusMensal;
            return String.valueOf(salario);
        }else if(this.nivel == 'S' || this.nivel == 's'){
            salario = 5000 + this.valorBonusMensal;
            return String.valueOf(salario);
        }
        return "";
    }
}