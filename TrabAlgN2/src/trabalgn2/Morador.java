package trabalgn2;

// a classe Morador herda de Pessoa
public class Morador extends Pessoa{
    private String telefone;
    private int andar; // número do andar
    private int apartamento; // número do apartamento
    
    // construtor cheio
    public Morador(String nome, int idade, char sexo, String telefone) {
        super(nome, idade, sexo); // chama o construtor da superclasse
        this.telefone = telefone; 
    }

    // construtor vazio
    public Morador() {
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getApartamento() {
        return apartamento;
    }

    public void setApartamento(int apartamento) {
        this.apartamento = apartamento;
    }
    
    @Override
    public String toString(){
        
        return String.format("%s%nTelefone: %s%nAndar: %d%nApartamento: %d%n",
                super.toString(), getTelefone(), getAndar(), getApartamento());
        
    }
}
