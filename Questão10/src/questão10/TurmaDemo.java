package questão10;
public class TurmaDemo {
    public static void main(){
        String[] nomesAlunos = {
            "vinicius", "josé", "ronaldo", "lara", "matheus", "felipe", "fran", "eduardo", "guilherme", "luca"
        };
        double[] notasAlunos = {
            7, 5.5, 9.7, 4.1, 3.2, 7.7, 7.3, 8, 9, 5.6
        };
        Turma turma = new Turma(nomesAlunos, notasAlunos);
        System.out.println("Média: " +turma.calcularMediaNota(notasAlunos));
        System.out.println(turma.imprimirAlunos(nomesAlunos, notasAlunos));
    }
}