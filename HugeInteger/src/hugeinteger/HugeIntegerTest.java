/*
  Classe HugeInteger que utiliza um array de 40 elementos de dígitos para armazenar
  inteiros com até 40 dígitos. Contêm os métodos parse, toString, add e subtract.
  O método parse recebe uma String, extrai cada dígito usando o método charAt e coloca
  o valor inteiro equivalente de cada dígito no array de inteiros.
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
        // Converte o 1º elemento para int passando cada dígito para um elemento
        // no array de inteiros
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
