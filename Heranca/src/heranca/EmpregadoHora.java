package heranca;

public class EmpregadoHora extends Empregado{ // Herda funcionalidades de Empregado
    
    private double horas;
    private double valorPorHora;

    // Construtor padrão
    public EmpregadoHora() {
        
    }
    
    // Inicializa a partir do construtor
    public EmpregadoHora(String nome, String SobreNome, String numSegSocial,
            double horas, double valorPorHora){
        
        // Chama Construtor de Empregado
        super(nome, SobreNome, numSegSocial);
        
        // Lança um erro caso hora seja < 0 e > 168(que equivale às horas semanais) 
        if(horas < 0 || horas > 168){
            throw new IllegalArgumentException("Horas trabalhadas precisa estar entre 0 e 168.");
        }
        
        // Lança um erro caso o valor por hora seja < 0.0
        if(valorPorHora < 0.0){
            throw new IllegalArgumentException("ValorPorHora não pode ser negativo");
            
        }
        
        this.horas = horas;
        this.valorPorHora = valorPorHora;
        
    }

    // Métodos getter's e setter's
    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        
        if(horas < 0 || horas > 168){
            throw new IllegalArgumentException("Horas trabalhadas precisa estar entre 0 e 168.");
        }
        
        this.horas = horas;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        
         if(valorPorHora < 0.0){
            throw new IllegalArgumentException("ValorPorHora não pode ser negativo");
            
        }
        
        this.valorPorHora = valorPorHora;
    }
    
    public double ganhos(){
        
        return getHoras() * getValorPorHora();
        
    }
    
    @Override // Indica a substituição
    public String toString(){
        
        return String.format("%s%n%s: %.2f%n%s: %.2f", super.toString(), "HORAS TRABALHADAS",
                getHoras(), "VALOR POR HORA",
                getValorPorHora());
    }
}
