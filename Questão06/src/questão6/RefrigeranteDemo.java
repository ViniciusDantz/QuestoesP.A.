package questão6;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class RefrigeranteDemo {
    public void main(){
        double saldoCompra = 0;
        double saldoCliente, troco;
        int quantidade;
        Object[] opçõesRefri = {
            "Cocacola", "FantaUva", "FantaLaranja", "Sprite", "Kuat", "Finalizar compra", "Sair"
        };
        Refrigerante[] refri = new Refrigerante[5];
        refri[0] = new Refrigerante("Cocacola", 1.50, 40);
        refri[1] = new Refrigerante("FantaUva", 0.90, 10);
        refri[2] = new Refrigerante("FantaLaranja", 0.90, 8);
        refri[3] = new Refrigerante("Sprite", 0.80, 20);
        refri[4] = new Refrigerante("Kuat", 1.00, 100);
        DecimalFormat df = new DecimalFormat("0.##");
        String resposta = "";
        System.out.println("\nNome: " +refri[0].getNome()+ "\nPreço: " +refri[0].getPreco());
        System.out.println("\nNome: " +refri[1].getNome()+ "\nPreço: " +refri[1].getPreco());
        System.out.println("\nNome: " +refri[2].getNome()+ "\nPreço: " +refri[2].getPreco());
        System.out.println("\nNome: " +refri[3].getNome()+ "\nPreço: " +refri[3].getPreco());
        System.out.println("\nNome: " +refri[4].getNome()+ "\nPreço: " +refri[4].getPreco());
        do{
            resposta = (String) JOptionPane.showInputDialog(null, "Compre!", "Refrigerantes", JOptionPane.PLAIN_MESSAGE, null, opçõesRefri, null);
            if(resposta.equals("Sair")){
                break;
            }
            if(resposta.equals("Finalizar compra")){
                saldoCliente = 5;
                troco = saldoCliente - saldoCompra;
                System.out.println("\nPreço total: " +saldoCompra);
                System.out.println("Troco: " +df.format(troco));
                saldoCompra = 0;
            }else{
                quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade: "));
                for (int i = 0; i < 5; i++) {
                    if(resposta.equals(refri[i].getNome())){
                        saldoCompra = (refri[i].getPreco() * quantidade) + saldoCompra;
                        refri[i].efetuarVenda(quantidade);
                        break;
                    }
                }
            }
        }while(!resposta.equalsIgnoreCase("Sair"));
        System.out.println("Estoque\n");
        for (int i = 0; i < 5; i++) {
            System.out.println(refri[i].getNome()+ ": " +refri[i].getQtdEstoque()+ "\n");
        }
    }
}