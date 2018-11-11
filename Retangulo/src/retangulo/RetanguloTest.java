package retangulo;
/*Classe RetanguloTest.java
Utiliza classe Retangulo para calcular 
área e perímetro de um retângulo*/

public class RetanguloTest {
    
    public static void display(String cabecalho, Retangulo l){
        System.out.printf("%s%n%s%n", cabecalho,
                l.toString());
    }
    
    public static void main(String[] args){
        
        //iniciando construtor com valores padão (1.0)
        Retangulo retangulo1 = new Retangulo();
        Retangulo retangulo2 = new Retangulo(3, 4.5);//inserindo valores
        
        //valores padrão da classe Retangulo
        display("Valores retangulo1:", retangulo1);
        
        System.out.println("=========================================");
        
        display("Valores de retangulo2:", retangulo2);
        
        System.out.println("=========================================");
        
        //altera valores de retangulo2
        retangulo2.setLados(14.7, 10);
        
        //mostra os novos valores de retangulo2
        display("Novos valores de retangulo2:", retangulo2);
        
        //calcula e exibe área de retangulo2
        System.out.println(retangulo2.area());
        
        //calcula e exibe perímetro de retangulo2
        System.out.println(retangulo2.perimetro());
        
        System.out.println("=======================================================================");
        
        //tenta alterar os valores de retangulo2 por valores inválidos
        try{
            retangulo2.setLados(0, 0);
            
        }
        
        catch(IllegalArgumentException e){
            System.out.printf("Erro em setLados de retangulo2: %s%n",
                    e.getMessage());
        }
        
        System.out.println("=======================================================================");
        
        //mostra que os valores de retangulo2 não foram alterados
        display("Valores de retangulo2: ", retangulo2);
        
    }
    
}
