package retangulo;
//Classe Retangulo.java
//Cácula área e perímetro de um retângulo

public class Retangulo {
    
    private double comprimento;
    private double largura;
    
    //construtor iniciando com os valores 1.0 padrão
    public Retangulo(){
        this(1.0, 1.0);
    }
    
    //construtor inicializado fornecendo comprimento e largura
    public Retangulo(double comprimento, double largura){
        if((comprimento < 0.0 || comprimento >= 20.0) && (largura >= 20.0 || largura <= 0.0))
            throw new IllegalArgumentException("Comprimento e largura fora do intervalo.");
        
        this.comprimento = comprimento;
        this.largura = largura;
        
    }
    
    //métodos set e get
    //altera valores dos lados do retangulo
    public void setLados(double comprimento, double largura){
        if((comprimento <= 0.0 || comprimento >= 20.0)  && (largura <= 0.0 || largura >= 20.0))
            throw new IllegalArgumentException("Comprimento e largura fora do intervalo.");
        
        this.comprimento = comprimento;
        this.largura = largura;
        
    }
    
    //retorna valor comprimento
    public double getComprimento(){
        return comprimento;
    }   
    
    //retorna valor largura
    public double getLargura(){
        return largura;
    }
    
    //calculo da área do retangulo
    public String area(){
        double x = comprimento*largura;
        
        return String.format("Área = %.1f", x);
    }
    
    public String perimetro(){
        double x = (comprimento + largura)*2;
        
        return String.format("Perímetro = %.1f%n", x);
    }
    
    
    //Converte em String comprimento e largura
    @Override
    public String toString(){
        return String.format("Comprimento: %.1f%n"
                + "Largura: %.1f", getComprimento(), getLargura());
    }
}
