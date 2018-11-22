package trabalgn2;

public class Principal {
    
    static java.util.Scanner in = new java.util.Scanner(System.in);
    
    static Predio p = new Predio("Edifício Jéssica", "Av. Princesa Patricia");
    
    public static void main(String[] args) {
        
        // Chama o menu de opções
        exibirMenu();
    }
    
    // Método exibirMenu(), exibe menu de opções
    public static void exibirMenu(){
        
        while(true){
            System.out.println("======================= SISTEMA =======================");
            System.out.println("1.Adicionar novo morador");
            System.out.println("2.Quantidade de apartamentos ocupados em cada andar");
            System.out.println("3.O andar com maior e menor número de moradores");
            System.out.println("4.Quantidade de moradores com idade inferior a 30 anos");
            System.out.println("Opção: ");
            int opcao = Integer.parseInt(in.nextLine());
            // switcth-case
            switch(opcao){
                case 1:
                    adicionarMor();
                    break;
                case 2:
                    aptsOcup();
                    break;
                case 3:
                    maiorMenor();
                    break;
                case 4:
                    idadeInferior();
                    break;
            }
        }
    }
    
    // Método adicionarMor(), adiciona novos moradores no prédio
    public static void adicionarMor(){
        
        // Pede o andar a ser inserido o novo morador
        System.out.println("\nInforme nº andar: ");
        int andar = Integer.parseInt(in.nextLine());
        
        // verifica o andar informado, se for <= 0 ou > 5, pede novamente
        while(andar <= 0 || andar > 5){
            System.out.println("\nInforme um andar de 1 a 5: ");
            andar = Integer.parseInt(in.nextLine());
            
        }
        
        // pede o apartamento a ser inserido o novo morador
        System.out.println("\nInforme apartamento: ");
        int apt = Integer.parseInt(in.nextLine());
        
        // verifica o apartamento informado, se for <= 0 ou > 10, pede novamente
        while(apt <= 0 || apt > 10){
            System.out.println("\nInforme um apatamento de 1 a 10: ");
            apt = Integer.parseInt(in.nextLine());
            
        }
        
        // se o apartamento informado no andar informado estiver livre, pede os dados
        if(p.getAndares()[andar - 1].getApartamentos()[apt - 1].getMorador() == null){
            
            System.out.println("\nNome: ");
            String nome = in.nextLine().toUpperCase();
            
            System.out.println("\nIdade: ");
            int idade = Integer.parseInt(in.nextLine());
            
            System.out.println("\nSexo: ");
            char sexo = in.next().toUpperCase().charAt(0);
            in.nextLine();
            
            System.out.println("\nTelefone: ");
            String tel = in.nextLine();
            
            // cria novo objeto morador
            Morador m = new Morador(nome, idade, sexo, tel);
            
            // armazena o nº do andar e do apartamento do novo morador
            m.setAndar(andar);
            m.setApartamento(apt);
            
            // armazena novo objeto morador no apartamento e andar informados
            p.getAndares()[andar - 1].getApartamentos()[apt - 1].setMorador(m);
            
            System.out.println("\nMORADOR INSERIDO COM SUCESSO!\n");
            
         // se morador for != null   
        }else{
            System.out.println("\nAPARTAMENTO OCUPADO!\n");
            
        }   
    }
    // Método aptsOcup(), Conta a quantidade de apartamentos ocupados em cada andar
    public static void aptsOcup(){
        
        int aptsOcup = 0;// variável contadora
        
        // varredura pelos apartamentos de cada andar
        for (Andar andar : p.getAndares()) {
            for (Apartamento apartamento : andar.getApartamentos()) {
                
                // se o apartamento estiver ocupado incrementa 1 à aptsOcup
                if (apartamento.getMorador() != null) {
                    
                    aptsOcup++;// incremento
                    
                }
                
            }
            // mostra o resultado do andar específico
            System.out.printf("Andar %d: %d%n", andar.getAndar(), aptsOcup);
            aptsOcup = 0; // renicia a variável
        }
    }
    // Método maiorMenor(), encontra os andares com maior e menor quantidade de moradores
    public static void maiorMenor(){
        
        int maior = 0; // conta o andar com o maior número de moradores
        int menor = 999; // conta o andar com o menor número de moradores
        int andarMaior = 0; // irá definir qual andar tem a maior quantidade de moradores
        int andarMenor = 0; // irá definir qual andar tem a menor quantidade de moradores
        
        for(Andar andar : p.getAndares()){
            
            // verifica se a quantidade de moradores é maior que a variável maior
            if(andar.getQuantMoradores() > maior){
                maior = andar.getQuantMoradores(); // se for, define maior com a quantidade de moradores do andar
                andarMaior = andar.getAndar(); // se nenhum outro andar tiver mais moradores que a variável maior,
                                               // define a variável andarMaior com o número do respectivo andar
            }
            
            // mesma idéia do primeiro if
            if(andar.getQuantMoradores() < menor){
                menor = andar.getQuantMoradores();
                andarMenor = andar.getAndar();
            }
            
        }
        // mostra na tela 
        System.out.println("Andar com a maior quantidade de moradores: " + andarMaior);
        System.out.println("Andar com a menor quantidade de moradores: " + andarMenor);
        
    }
    
    public static void idadeInferior(){
        
        int moradores = 0;
        
        for(Andar andar : p.getAndares()){
            for(Apartamento apartamento : andar.getApartamentos()){
                
                if((apartamento.getMorador() != null) &&
                        (apartamento.getMorador().getIdade() < 30)){
                    
                    moradores++;
                    
                }
            }
        }
        
        System.out.println("Quantidade de moradores com idade inferior a 30 anos: " + moradores);
        
    }
}
