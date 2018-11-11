package fibonacci;
/*Classe Fibonacci.java
Calucula elementos do padrão fibonacci
*/

public class Fibonacci {
    
    private static int num;
    
    public static void main(String[] args){
        
        java.util.Scanner in = new java.util.Scanner(System.in);
        
        System.out.println("Informe quantos elementos você quer ver: ");
        num = in.nextInt();
        
        fibonacci();
    }
    
    // Método fibonacci()
    public static void fibonacci(){
        int c = 0;
        long t1 = 0;
        long t2 = 1;
        long t3 = 1;
        
        while(c < num){
            System.out.printf("%d ", t1);
            t1 = t2;
            t2 = t3;
            t3 = t1+t3;
            c++;
        }
        
        System.out.println("FIM.\n");
        
    }
}
