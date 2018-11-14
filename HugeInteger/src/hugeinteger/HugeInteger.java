/*
  Classe HugeInteger que utiliza um array de 40 elementos de dígitos para armazenar
  inteiros com até 40 dígitos. Contêm os métodos parse, toString, add e subtract.
  O método parse recebe uma String, extrai cada dígito usando o método charAt e coloca
  o valor inteiro equivalente de cada dígito no array de inteiros.
 */
package hugeinteger;

public class HugeInteger {
    
    private String[] array = new String[40];
    
    static java.util.Scanner in = new java.util.Scanner(System.in);
    // Construtor vazio
    public HugeInteger(){
        
    }
    // Construtor com uma lista de argumentos de comprimento variável
    public HugeInteger(String... digitos) {
        // Caso a lista de argumentos passe de 40 elementos
        if(digitos.length > array.length){
            throw new IndexOutOfBoundsException("Identificado mais de 40 elementos:"
                    + digitos.length);
        }
        // Copia a lista de de argumentos para o array de dígitos
        System.arraycopy(digitos, 0, array, 0, digitos.length);
        // Verifica cada dígito de cada elemento no array
        for(int i = 0; i < array.length; i++){
            if(array[i] != null){
                verifDigitos(i);
                
            }   
        }
    }
    // Setter's e getter's
    public String[] getArray() {
        
        return array;
    }

    public void setArray(String[] array) {
        
        this.array = array;
    }

    public void setElement(int i, String x){
        
        array[i] = in.nextLine();
        verifDigitos(i);
        
    }
    
    public String getElement(int i){
        
        return array[i];
        
    }
    // Método para verificar os dígitos
    // Não pode ser mais de 40, se for é removido os dígitos a mais
    private void verifDigitos(int x){
        
        for(int i = 0; i < array[x].length(); i++){
            
            while(array[x].length() > 40){
                
                String substring = array[x].substring(0, array[x].length() - 1);
                
                array[x] = substring;
                
            }
            // Se o caracter não for um inteiro o altera para '0'
            if((array[x].charAt(i) != '1') && (array[x].charAt(i) != '2') &&
                    (array[x].charAt(i) != '3') && (array[x].charAt(i) != '4') &&
                    (array[x].charAt(i) != '5') && (array[x].charAt(i) != '6') &&
                    (array[x].charAt(i) != '7') && (array[x].charAt(i) != '8') &&
                    (array[x].charAt(i) != '9')){
                
                String replace = array[x].replace(array[x].charAt(i), '0');
                
                array[x] = replace;
               
            }
        }
    }
    // Método parse() recebe uma String de digitos e armazena seu valor equivalente
    // no array de inteiros
    public void parse(String x){
        
        System.out.println("Valor equivalente:");
        
        int[] arrayInt = new int[x.length()];
        
        for(int i = 0; i < x.length(); i++){
            
            arrayInt[i] = Character.getNumericValue(x.charAt(i));
            
            System.out.print(arrayInt[i]);
        }
        
        System.out.println();
        
    }
    // Método add recebe o índice do elemento que se deseja alterar e os dígitos
    // a serem adicionados
    public void add(int i, String x){
        // Adiciona os dígitos no elemento informado
        array[i] += x;
        // Verifica se são 40 dígitos, se for mais de 40 é eliminado os a mais
        // Se for um não inteiro é alterado para '0'
        verifDigitos(i);
        
    }
    // Método subtract() recebe o índice do elemento a ser subtraído
    // e a quantidade de dígitos a serem subtraídos
    public void subtract(int i, int x){
        // Subtraí a quantidade x de dígitos do elemento
        String substring = array[i].substring(0, array[i].length() - x);
        // Atribui o novo valor ao elemento i
        array[i] = substring;
        
    }
    
    // Método toString()
    @Override
    public String toString(){
        
        for(String digit : array){
            if(digit != null)
                System.out.print(digit + "  ");
           
        }
        
        System.out.println();
        
        return "";
    }
}
