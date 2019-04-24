package questão1;
public class Questão1 {
    public static void main(String[] args) {
        LampadaDemo demo = new LampadaDemo();
        if(demo.lamp.getEstado()){
            System.out.println("Lâmpada Ligada!");
        }else{
            System.out.println("Lâmpada Desligada!");
        }
        System.out.println("Potência: " +demo.lamp.getPotencia()+ " watts");
        demo.lamp.setPotencia(70);
        if(!demo.lamp.ligar()){
            System.out.println("Lâmpada já está ligada!");
        }else{
            System.out.println("Lâmpada Ligada!");
        }
        if(!demo.lamp.desligar()){
            System.out.println("Lâmpada já está desligada!");
        }else{
            System.out.println("Lâmpada Desligada!");
        }
        System.out.println("Potência: " +demo.lamp.getPotencia()+ " watts");
    }
}