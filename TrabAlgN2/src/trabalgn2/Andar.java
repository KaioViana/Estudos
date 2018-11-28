package trabalgn2;

public class Andar {
    private int andar; // o número do andar
    private Apartamento apartamentos[]; // uma matriz de objetos da classe Apartamento
    private static int quantidadeMoradores; // quantidade de moradores no andar

    // construtor cheio recebe apenas o número do andar
    public Andar(int andar) {
        this.andar = andar;
        
        // vamos inicializar os objetos da classe Apartamento e numerá-los de 1 até 10
        apartamentos = new Apartamento[10];
        for(int i = 0; i < apartamentos.length; i++){
            apartamentos[i] = new Apartamento(i + 1);
        }
    }

    // construtor vazio
    public Andar() {
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public Apartamento[] getApartamentos() {
        return apartamentos;
    }

    public void setApartamentos(Apartamento[] apartamentos) {
        this.apartamentos = apartamentos;
    }
    
    public int getQuantMoradores(){

	quantidadeMoradores = 0;

        // para pegar a quantidade de moradores do andar faz um loop pela matriz apartamentos
        for(Apartamento apartamento : apartamentos){
            if(apartamento.getMorador() != null){
                quantidadeMoradores++; //  e incrementa 1 se o apartamento estiver ocupado
                
            }
        }
        
        return quantidadeMoradores; // e retorna a quantidade 
    }
}
