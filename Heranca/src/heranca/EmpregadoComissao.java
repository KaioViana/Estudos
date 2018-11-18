package heranca;

public class EmpregadoComissao extends Empregado{ // herda funcionalidades de Empregado
    
    private double vendasBrutas;
    private double taxa;
    
    // Construtor padrão
    public EmpregadoComissao(){
        
    }
    
    // Construtor que permite inicialização a partir dele mesmo
    public EmpregadoComissao(String nome, String sobreNome, String numSegSocial,
            double vendasBrutas, double taxa){
        
        // Chama construtor do extends Empregado
        super(nome, sobreNome, numSegSocial);
        
        // Lança um erro caso vendasBrutas seja < 0.0
        if(vendasBrutas < 0.0){
            throw new IllegalArgumentException("VendasBrutas deve ser >= 0.0");
            
        }
        
        // Lança um erro caso a taxa seja <= 0 ou >=1.0
        if(taxa <= 0.0 || taxa >= 1.0){
            throw new IllegalArgumentException("Taxa deve ser > 0.0 e < 1.0");
            
        }
        
        this.taxa = taxa;
        this.vendasBrutas = vendasBrutas;
        
    }

    // Métodos getter's e setter's
    public double getVendasBrutas() {
        return vendasBrutas;
    }

    public void setVendasBrutas(double vendasBrutas) {
        
        if(vendasBrutas < 0.0){
            throw new IllegalArgumentException("VendasBrutas deve ser >= 0.0");
            
        }
        
        this.vendasBrutas = vendasBrutas;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        // Lança um erro se a ta for <= 0 e >= 1.0
        if(taxa <= 0.0 || taxa >= 1.0){
            throw new IllegalArgumentException("Taxa deve ser > 0.0 e < 1.0");
            
        }
        
        this.taxa = taxa;
    }
    
    // Método para calcular o ganho do empregado
    public double ganhos(){
        
        return getTaxa() * getVendasBrutas();
        
    }
    
    @Override // Indica a substituição
    public String toString(){
        
        return String.format("%s %n%s: R$%.2f%n%s: %.2f", super.toString(), 
                "VENDAS BRUTAS", getVendasBrutas(), "TAXA", getTaxa());
    }
}
