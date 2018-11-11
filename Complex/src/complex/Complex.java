package complex;

public class Complex {
    
    private double a;
    private double b;
    private double c;
    private double d;
    
    // Inicialização pelo construtor
    public Complex(double a, double b, double c, double d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        
    }
    
    // Construtor padrão
    public Complex(){
        this(0, 0, 0, 0);
        
    }
    
    // Métodos set e get de z1 e z2
    public void setZ1(double a, double b){
        this.a = a;
        this.b = b;
        
    }
    
    public String getZ1(){
        
        return String.format("(%.1f) + (%.1fi)", a, b);
        
    }
    
    public void setZ2(double c, double d){
        this.c = c;
        this.d = d;
        
    }
    
    public String getZ2(){
        
        return String.format("(%.1f) + (%.1fi)", c, d);
        
    }
    
    // Método para somar complexos
    public String somar(){
        
        double x = a + c;
        double y = b + d;
        
        return String.format("z1 + z2 = (%.1f) + (%.1fi)", x, y);
    }
    
    // Método para subtrair complexos
    public String subtrair(){
        
        double x = a - c;
        double y = b - d;
        
        return String.format("z1 - z2 = (%.1f) - (%.1fi)", x, y);
    }
    
    // Método toString()
    @Override
    public String toString(){
        
        return String.format("%s;%n%s;", getZ1(), getZ2());
        
    }
    
}
