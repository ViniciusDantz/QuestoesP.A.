package questão5;
public class Motor {
    private String nome;
    private double potencia;
    private boolean estado;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPotencia() {
        return potencia;
    }
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }
    public void liga(){
        this.estado = true;
    }
    public void desliga(){
        this.estado = false;
    }
    public boolean getEstado(){
        return this.estado;
    }
    public Motor(String nome, double potencia){
        this.nome = nome;
        this.potencia = potencia;
        this.estado = false;
    }
}