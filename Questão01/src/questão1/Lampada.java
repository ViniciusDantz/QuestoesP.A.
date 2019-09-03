package questão1;
public class Lampada {
    private double potencia;
    private boolean estado;
    public boolean ligar(){
        if(estado){
            return false;
        }else{
            this.estado = true;
            return false;
        }
    }
    public boolean desligar(){
        if(!estado){
            return false;
        }
        this.estado = false;
        return true;
    }
    public Lampada(){
        this.estado = false;
    }
    public Lampada(boolean estado, double potencia){
        this.estado = estado;
        this.potencia = potencia;
    }
    public double getPotencia(){
        return this.potencia;
    }
    public void setPotencia(double potencia){
        this.potencia = potencia;
    }
    public boolean getEstado(){
        return this.estado;
    }
}