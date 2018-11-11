package complex;

public class ComplexTest {
    
    public static void main (String[] args){
        
        java.util.Scanner in = new java.util.Scanner(System.in);
        
        // Inicializando a partir do construtor 
        Complex complexo = new Complex(2, 3, -4, 5);
        
        // Representação String de complexo
        System.out.println(complexo);
        
        // Soma números complexos z1 e z2
        System.out.printf("Soma: %s%n", complexo.somar());
        
        // Subtrai números complexos z1 e z2
        System.out.printf("Subtração: %s%n", complexo.subtrair());
    }
    
}
