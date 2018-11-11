package rational;
/*Classe Rational.java 
Realiza operações aritméticas com Racionais
*/

public class Rational {
    
    private int numerador;
    private int denominador;
    
    // Inicializando pelo construtor
    public Rational(int numerador, int denominador){
        if(denominador == 0)
            throw new RuntimeException("Denominador igual a zero!");
        
        int g = gcd(numerador, denominador);
        
        this.numerador = numerador / g;
        this.denominador = denominador / g;
        
    }
    
    // Redutor de frações stático privado
    private static int gcd(int m, int n){
        if(n == 0)
            return m;
        else
            return gcd(n, m % n);
        
    }
    
    // Método toString()
    @Override
    public String toString(){
        if(denominador == 1)
            return "" + numerador;
        else
            return numerador + "/" + denominador;
        
    }
    
    // Método soma
    public Rational soma(Rational b){
        int num = (this.numerador*b.denominador)+(this.denominador*b.numerador);
        int den = this.denominador * b.denominador;
        
        return new Rational(num, den);
        
    }
    
    // Método subtrair
    public Rational subtrair(Rational b){
        int num = (this.numerador*b.denominador)-(this.denominador*b.numerador);
        int den = this.denominador * b.denominador;
        
        return new Rational(num, den);
        
    }
    
    //Método multiplicar
    public Rational multiplicar(Rational b){
        
        return new Rational(this.numerador*b.numerador, 
                this.denominador*b.denominador);
        
    }
    
    //Método dividir
    public Rational dividir(Rational b){
        int num = this.numerador * b.denominador;
        int den = this.denominador * b.numerador;
        
        return new Rational(num, den);
        
    }
    
    
    /***************************************************************************
     * Cliente teste
     * @param args
     **************************************************************************/
    public static void main(String[] args){
        
        Rational x, y, z;
        
        // Soma
        x = new Rational(2, 3);
        y = new Rational(3, 6);
        z = x.soma(y);
        
        System.out.println(z);
        
        //Subtração
        x = new Rational(2, 3);
        y = new Rational(3, 6);
        z = x.subtrair(y);
        
        System.out.println(z);
        
        //Multiplicação
        x = new Rational(2, 2);
        y = new Rational(2, 3);
        z = x.multiplicar(y);
        
        System.out.println(z);
        
        //Divisão
        x = new Rational(1, 11);
        y = new Rational(2, 5);
        z = x.dividir(y);
        
        System.out.println(z);
        
        //Retornando uma representacão String de um Rational
        x = new Rational(5, 4);
        
        System.out.println(x);
        
}
    
    }
