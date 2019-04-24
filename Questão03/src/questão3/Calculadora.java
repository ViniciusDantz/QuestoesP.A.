package questão3;
public class Calculadora {
    public double soma(double a, double b){
        return a + b;
    }
    public double subtrair(double a, double b){
        return a - b;
    }
    public double multiplicar(double a, double b){
        return a * b;
    }
    public double dividir(double a, double b){
        if(b == 0){
            System.out.println("Operação não realizada. Favor entrar com um divisor válido");
        }else{
            return a / b;
        }
        return 0;
    }
}