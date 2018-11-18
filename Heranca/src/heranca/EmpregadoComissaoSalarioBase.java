package heranca;

public class EmpregadoComissaoSalarioBase extends EmpregadoComissao { // herda funcionalidades de EmpregadoComissao
    
    private double salarioBase;
    
    // Construtor padrão
    public EmpregadoComissaoSalarioBase(){
        
    }
    // Inicialização pelo construtor 
    public EmpregadoComissaoSalarioBase(String nome, String sobreNome,
            String numSegSocial, double vendasBrutas, double taxa, double salarioBase){
        
        // Construtor de EmpregadoComissao
        super(nome, sobreNome, numSegSocial, vendasBrutas, taxa);
        
        // Lança um erro caso salario base seja < 0.0
        if(salarioBase < 0.0){
            throw new IllegalArgumentException("Salario inválido!");
            
        }
        
        this.salarioBase = salarioBase;
        
    }
    
    // Métodos getter's e setter's
    public double getSalarioBase() {
        return salarioBase;
    }

    
    public void setSalarioBase(double salarioBase) {
        
        if(salarioBase < 0.0){
            throw new IllegalArgumentException("Salario inválido!");
            
        }
        
        this.salarioBase = salarioBase;
    }
    
    @Override // Indica a substituição
    public double ganhos(){
        
        return salarioBase + super.ganhos();
        
    }
    
    @Override // Indica a substituição
    public String toString(){
        
        return String.format("%s%n%s: R$%.2f", super.toString(), "SALÁRIO BASE",
                getSalarioBase());
        
    }
}
