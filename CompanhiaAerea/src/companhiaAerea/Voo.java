package companhiaAerea;

public class Voo {

    private int numero;
    private String origem;
    private String destino;
    private Assento[] assentos;// Vetor de assentos

    public Voo() {

    }

    public Voo(int numero, String origem, String destino, int quantAssentos) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.assentos = new Assento[quantAssentos];

        for (int i = 0; i < quantAssentos; i++) {
            this.assentos[i] = new Assento((i + 1), null);
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Assento[] getAssentos() {
        return assentos;
    }

    public void setAssentos(Assento[] assentos) {
        this.assentos = assentos;
    }
    
    @Override
    public String toString(){
        
        int livres = 0;
        
        for(Assento assento : assentos){
            if(assento.getPassageiro() == null){
                
                livres++;
            }
        }
        
        return String.format("Número: %d%nOrigem: %s%nDestino: %s%n"
                + "Quantidade de assentos: %d%nAssentos livres: %d", numero, origem, destino,
                assentos.length, livres);
    }

}
