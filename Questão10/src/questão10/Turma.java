package questão10;
public class Turma {
    private String[] nomeAluno;
    private double[] notaAluno;
    public Turma(String[] nomesAlunos, double[] notasAlunos){
        nomeAluno = new String[10];
        notaAluno = new double[10];
        this.nomeAluno = nomesAlunos;
        this.notaAluno = notasAlunos;
    }
    public float calcularMediaNota(double[] notaAluno){
        float media = 0;
        for (int i = 0; i < 10; i++) {
            media += notaAluno[i];
        }
        return (media/10);
    }
    public String imprimirAlunos(String[] nomeAluno, double[] notaAluno){
        String nomeNotas = "";
        for (int i = 0; i < 10; i++) {
            nomeNotas += this.nomeAluno[i] + " ----- " + this.notaAluno[i] + "\n";
        }
        return nomeNotas;
    }
    public String[] getNomeAluno() {
        return nomeAluno;
    }
    public void setNomeAluno(String[] nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
    public double[] getNotaAluno() {
        return notaAluno;
    }
    public void setNotaAluno(double[] notaAluno) {
        this.notaAluno = notaAluno;
    }
}