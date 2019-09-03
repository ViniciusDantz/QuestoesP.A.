package questão09;
public class Pessoa {
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String sexo;
    public Pessoa(String nome, int idade, double altura, double peso, String sexo){
        this.altura = altura;
        this.idade = idade;
        this.nome = nome;
        this.peso = peso;
        this.sexo = sexo;
    }
    public double calcularIMC(double peso, double altura){
        return (peso/Math.pow(altura, 2));
    }
    @Override
    public String toString(){
        if(this.calcularIMC(this.peso, this.altura) <= 18.5){
            return ("Nome: " +this.nome+ "\nIMC: Abaixo do peso normal");
        }
        if(this.calcularIMC(this.peso, this.altura) <= 25){
            return ("Nome: " +this.nome+ "\nIMC: Peso normal");
        }
        if(this.calcularIMC(this.peso, this.altura) <= 30){
            return ("Nome: " +this.nome+ "\nIMC: Acima do peso normal");
        }
        return ("Nome: " +this.nome+ "\nIMC: Obesidade");
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}