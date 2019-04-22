package questão07;
public class Empresa {
    private String nome;
    private double capital;
    private int nFuncionarios;
    public Empresa(String nome, double capital, int nFuncionarios){
        this.nome = nome;
        this.capital = capital;
        this.nFuncionarios = nFuncionarios;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getCapital() {
        return capital;
    }
    public void setCapital(double capital) {
        this.capital = capital;
    }
    public int getnFuncionarios() {
        return nFuncionarios;
    }
    public void setnFuncionarios(int nFuncionarios) {
        this.nFuncionarios = nFuncionarios;
    }
}