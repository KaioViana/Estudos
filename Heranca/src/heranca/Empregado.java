/*
  Classe Empregado que recebe o nome, sobrenome
  e o seguro social de um empregado
*/

package heranca;

public class Empregado //Classe object é sempre herdada implicitamente
{

    private final String nome;
    private final String sobreNome;
    private final String numSegSocial;  
    
    // Construtor padrão
    public Empregado(){
        
        this.nome = null;
        this.sobreNome = null;
        this.numSegSocial = null;
    }
    
    
    // Construtor
    public Empregado(String nome, String sobreNome, String numSegSocial){
        if(numSegSocial.length() > 9 || numSegSocial.length() < 9){
            throw new IllegalArgumentException("Número do seguro social contêm 9 dígitos.");
            
        }
        
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.numSegSocial = numSegSocial;
        
    }
     // Métodos getter's e setter's
    public String getNome(){
        
        return nome;
        
    }
    
    public String getSobreNome(){
        
        return sobreNome;
        
    }
    
    public String getNumSegSocial(){
        
        return numSegSocial;
        
    }
    
    @Override // Substitui o método toString() da classe Object
    public String toString(){
        
        return String.format("%s: %s %s%n%s: %s", "EMPREGADO", getNome(), getSobreNome(),
                "SEGURO SOCIAL", getNumSegSocial());
        
    }
  
}
