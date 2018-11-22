package trabalgn2;

public class Predio {
    private String nome; // nome do prédio
    private String endereco; // endereço do prédio
    private Andar andares[]; // matriz de andares

    // construtor cheio recebe o nome e endereço do prédio
    public Predio(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        
        // vamos inicializar os objetos da classe Andar e numerá-los de 1 até 5
        andares = new Andar[5];
        for(int i = 0; i < andares.length; i++){
            andares[i] = new Andar(i + 1);
        }
    }

    // construtor vazio
    public Predio() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Andar[] getAndares() {
        return andares;
    }

    public void setAndares(Andar[] andares) {
        this.andares = andares;
    }   
}
