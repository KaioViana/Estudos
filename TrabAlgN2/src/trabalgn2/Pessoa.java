package trabalgn2;

public class Pessoa {
    private String nome;
    private int idade;
    private char sexo;

    // construtor cheio
    public Pessoa(String nome, int idade, char sexo) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
    }

    // construtor vazio
    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    @Override
    public String toString(){
        
        return String.format("Nome: %s%nIdade: %d%nSexo: %s", getNome(), 
                getIdade(), getSexo());
        
    }
}
