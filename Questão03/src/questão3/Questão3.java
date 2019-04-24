package questão3;
import java.util.Scanner;
public class Questão3 {
    public static void main(String[] args) {
        CalculadoraDemo demo = new CalculadoraDemo();
        Scanner input = new Scanner(System.in);
        double b;
        System.out.println("30 + 20 = " +demo.calc.soma(30, 20));
        System.out.println("30 - 20 = " +demo.calc.subtrair(30, 20));
        System.out.println("30 * 20 = " +demo.calc.multiplicar(30, 20));
        do{
            System.out.println("Insira o divisor: ");
            b = input.nextDouble();
        }while(demo.calc.dividir(30, b) == 0);
        System.out.println("30 / " +b+ " = " +demo.calc.dividir(30, b));
    }
}