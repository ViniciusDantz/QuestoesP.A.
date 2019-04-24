package questão4;

import java.util.Scanner;

public class ProdutoDemo {
    Produto[] produtos = new Produto[5];
    Scanner input = new Scanner(System.in);
    public void main(){
        produtos[0] = new Produto("Liquidificador", 70.99, 10);
        produtos[1] = new Produto("Batedeira", 120.99, 30);
        produtos[2] = new Produto("Ferro de passar", 49.99, 13);
        produtos[3] = new Produto("Geladeira", 398.99, 50);
        produtos[4] = new Produto("TV", 1859.99, 30);
        String resposta;
        do{
            System.out.println("\nProcure por um produto! Nome: ");
            resposta = input.next();
            if(resposta.equalsIgnoreCase("Ferro")){
                resposta = resposta +" "+ input.next();
                resposta = resposta +" "+ input.next();
            }
            int i;
            for (i = 0; i < 5; i++) {
                if(resposta.equalsIgnoreCase(produtos[i].getDescricao())){
                    System.out.println("\nNome: " +produtos[i].getDescricao()+ "\nPreço: " +produtos[i].getPreco()+
                    "\nSaldo: " +produtos[i].getSaldo()+ "\n");
                    break;
                }
                
            }
            if(i == 5){
                System.out.println("\nProduto inexistente no catálogo\nDigite (fim) para sair\n");
            }
        }while(!resposta.equalsIgnoreCase("Fim"));
        
    }
}