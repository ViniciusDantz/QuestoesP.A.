package questão07;
public class Questão07 {
    public static void main(String[] args) {
        EmpresaDemo demo = new EmpresaDemo();
        String nomeEmp = demo.empresa[0].getNome();//nome da empresa de suposto menor número de funcionários e maior capital
        int menorFunc = demo.empresa[0].getnFuncionarios();//Número de funcionarios a ser comparado
        for (int i = 0; i < 5; i++) {
            if(menorFunc > demo.empresa[i].getnFuncionarios()){
                nomeEmp = demo.empresa[i].getNome();
                menorFunc = demo.empresa[i].getnFuncionarios();
            }
        }
        System.out.println("Empresa com menor número de funcionários:\nNome: " +nomeEmp+
        "\nNúmero de Funcionários: " +menorFunc);
        Double maiorCap = demo.empresa[0].getCapital();
        for (int i = 0; i < 5; i++) {
            if(maiorCap < demo.empresa[i].getCapital()){
                nomeEmp = demo.empresa[i].getNome();
                maiorCap = demo.empresa[i].getCapital();
            }
        }
        System.out.println("\nEmpresa com maior capital:\nNome: " +nomeEmp+
        "\nCapital: " +maiorCap+ " reais");
    }
}