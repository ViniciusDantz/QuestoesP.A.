package questão5;
public class MotorDemo {
    public void main(){
        Motor[] motor = new Motor[5];
        motor[0] = new Motor("Batedeira", 10);
        motor[1] = new Motor("Carrinho de brinquedo", 5);
        motor[2] = new Motor("Moto", 20);
        motor[3] = new Motor("Mini", 1);
        motor[4] = new Motor("Carro", 35);
        motor[0].liga();
        motor[3].liga();
        motor[4].liga();
        for (int i = 0; i < 5; i++) {
            if(motor[i].getEstado() == false){
                System.out.println("\n\nNome: " +motor[i].getNome()+ "\nPotencia: " +motor[i].getPotencia()+ " W\nVetor: " +(i+1));
            }
        }
    }
}