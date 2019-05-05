package questão12;
public class Funcionario {
    protected String nome;
    protected char sexo;
    protected char nivel;
    protected String[] dependentes;
    public Funcionario(String nome, String[] dependentes, char sexo, char nivel){
        this.nome = nome;
        this.dependentes = dependentes;
        this.setNivel(nivel);
        this.setSexo(sexo);
        this.validaSexo();
    }
    public boolean validaSexo(){
        if(!(this.sexo == 'F' || this.sexo == 'M' || this.sexo == 'm' || this.sexo == 'f')){
            System.out.println("Sexo inválido");
            return false;
        }
        return true;
    }
    public String calcularSalario(){
        if(this.nivel == 'T' || this.nivel == 't'){
            return "R$ 2.000";
        }else if(this.nivel == 'P' || this.nivel == 'p'){
            return "R$ 3.500";
        }else if(this.nivel == 'S' || this.nivel == 's'){
            return "R$ 5.000";
        }
        return "";
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        if(sexo == 'F' || sexo == 'M' || sexo == 'm' || sexo == 'f'){
            this.sexo = sexo;
        }
    }
    public char getNivel() {
        return nivel;
    }
    public void setNivel(char nivel) {
        if(nivel == 'T' || nivel == 't'){
            this.nivel = nivel;
        }else if(nivel == 'P' || nivel == 'p'){
            this.nivel = nivel;
        }else if(nivel == 'S' || nivel == 's'){
            this.nivel = nivel;
        }
    }
    public String[] getDependentes() {
        return dependentes;
    }
    public void setDependentes(String[] dependentes) {
        this.dependentes = dependentes;
    }
}