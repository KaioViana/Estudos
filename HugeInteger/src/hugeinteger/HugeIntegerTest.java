/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hugeinteger;

/**
 *
 * @author Computador
 */
public class HugeIntegerTest {
    
    public static void main(String[] args){
        // Objeto inicializado no Construtor de lista de argumentos de comprimento variável
        HugeInteger a = new HugeInteger("12345678910", "11121314151617181920",
        "");
        
        System.out.println("Vetor de dígitos:");
        System.out.println(a);
        System.out.println();
        
        System.out.println("MÉTODO parse():\n");
        a.parse(a.getElement(0));
        System.out.println("====================================================\n");
        
        System.out.println("MÉTODO add():\n");
        // Adiciona "123q" ao 3º elmento do array de dígitos
        a.add(2, "123q");
        System.out.println(a);
        System.out.println("====================================================\n");
        
        System.out.println("MÉTODO subtract():\n");
        // Subtraí 2 dígitos do 3º elemento do array de dígitos
        a.subtract(2, 2);
        System.out.println(a);
        System.out.println("====================================================\n");
    }
    
}
