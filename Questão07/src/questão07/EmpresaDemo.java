package questão07;
public class EmpresaDemo {
    Empresa[] empresa = new Empresa[5];
    public EmpresaDemo(){
        empresa[0] = new Empresa("EvilCorp", 65432.10, 879);
        empresa[1] = new Empresa("Ferreira Costa", 4567.10, 323);
        empresa[2] = new Empresa("Uber", 45467, 789);
        empresa[3] = new Empresa("Farmácia", 7849, 123);
        empresa[4] = new Empresa("Bancos", 9998988, 3333);
    }
}