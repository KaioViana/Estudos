package companhiaAerea;

public class Assento {
    
    private int numero;
    private Passageiro passageiro; // se passageiro for null, 
    //o assento está vazio

    public Assento() {
        
    }

    public Assento(int numero, Passageiro passageiro) {
        this.numero = numero;
        this.passageiro = passageiro;
        
    }

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }
    
    @Override
    public String toString(){
        
        return String.format("Passageiro: %s%nAssento: %d%n",
                passageiro.getNome(), numero);
        
    }
}
