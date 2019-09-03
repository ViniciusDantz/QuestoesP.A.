package questão09;
public class PessoaDemo {
    public static void main(){
        Pessoa pessoa1 = new Pessoa("A", 20, 1.70, 50, "Masculino");
        Pessoa pessoa2 = new Pessoa("B", 17, 1.85, 65, "Feminino");
        Pessoa pessoa3 = new Pessoa("C", 47, 1.75, 80, "Masculino");
        Pessoa pessoa4 = new Pessoa("D", 18, 1.78, 99, "Feminino");
        pessoa1.calcularIMC(0, 0);
        pessoa2.calcularIMC(0, 0);
        pessoa3.calcularIMC(0, 0);
        pessoa4.calcularIMC(0, 0);
        System.out.println(pessoa1.toString()+ "\n");
        System.out.println(pessoa2.toString()+ "\n");
        System.out.println(pessoa3.toString()+ "\n");
        System.out.println(pessoa4.toString());
    }
}