package agenda;

public class Agenda {

    private final Contato[] contatos = new Contato[1000];

    java.util.Scanner in = new java.util.Scanner(System.in);

    public Agenda() {

    }

    public void exibirMenu() {

        while (true) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(" ============================ OPCÕES =========================");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("1.Adicionar contato");
            System.out.println("2.Listar contatos");
            System.out.println("3.Editar contato");
            System.out.println("4.Apagar contato");
            System.out.println("5.Pesquisar contato");
            System.out.println("6.Sair");
            System.out.println("Opção: ");
            int opcao = Integer.parseInt(in.nextLine());

            switch (opcao) {

                case 1:
                    adicionarContato();
                    break;

                case 2:
                    listarContatos();
                    break;
                    
                case 3:
                    editarContato();
                    break;
                    
                case 4:
                    apagarContato();
                    break;
                    
                case 5:
                    pesquisarCont();
                    break;
                    
                case 6:
                    System.out.println("FINALIZADO.");
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("\nEntrada inválida!\n");
                    break;
                    
            }
        }
    }

    public void adicionarContato() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" ========================= ADICIONAR =========================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        boolean cheio = true;

        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] == null) {

                System.out.println("Nome: ");
                String nome = in.nextLine().toUpperCase();

                System.out.println("\nTelefone: ");
                String tel = in.nextLine();

                while (!verificarTel(tel)) {

                    System.out.println("\nTelefone no formato inválido, Informe novamente:");
                    tel = in.nextLine();

                }

                System.out.println("\nE-mail: ");
                String email = in.nextLine();
                
                contatos[i] = new Contato(nome, email, tel);
                
                System.out.println("\nCONTATO SALVO COM SUCESSO!\n");
                cheio = false;
                break;
                
            }
        }
        
        if(cheio)
            System.out.println("LISTA CHEIA!");
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();

    }

    public void listarContatos() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" ========================= CONTATOS ==========================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        boolean vazio = true;
        
        for(Contato contato : contatos){
            if(contato != null){
                System.out.println(contato);
                vazio = false;
            }
        }
        
        if(vazio)
            System.out.println("\nLISTA VAZIA!\n");
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
        
    }

    public boolean verificarTel(String tel) {
        
        boolean valido = true;
        
        for(int i = 0; i < tel.length(); i++){
            if((tel.charAt(i) != '0') && (tel.charAt(i) != '1')
                    && (tel.charAt(i) != '2') && (tel.charAt(i) != '3')
                    && (tel.charAt(i) != '4') && (tel.charAt(i) != '5')
                    && (tel.charAt(i) != '6') && (tel.charAt(i) != '7')
                    && (tel.charAt(i) != '8') && (tel.charAt(i) != '9')){
                
                valido = false;
                
            }
        }

        return valido;
        
    }
    
    public boolean verificarCont(String nome){
        
        boolean encontrado = false;
        
        for(Contato contato : contatos){
            if(contato != null && contato.getNome().equals(nome)){
                
                encontrado = true;
                break;
                
            }
        }
        
        return encontrado;
        
    }
    
    public void editarContato(){
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" ========================= EDITAR ============================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        System.out.println("Nome: ");
        String nome = in.nextLine().toUpperCase();
        
        if(verificarCont(nome)){
            
            for(Contato contato : contatos){
                if(contato != null && contato.getNome().equals(nome)){

                    System.out.println("\nTelefone: ");
                    contato.setTelefone(in.nextLine());

                    while (!verificarTel(contato.getTelefone())) {

                        System.out.println("\nTelefone no formato inválido, Informe novamente:");
                        contato.setTelefone(in.nextLine());

                    }

                    System.out.println("E-mail: ");
                    contato.setEmail(in.nextLine().toUpperCase());

                    System.out.println("\nCONTATO ATUALIZADO!\n");
                    break;
                }
            }
            
        }else{
            System.out.println("\nCONTATO NÃO ENCONTRADO!\n");
            
        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
        
    }
    
    public void apagarContato(){
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" ========================= APAGAR ============================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        System.out.println("Nome: ");
        String nome = in.nextLine().toUpperCase();
        
        if(verificarCont(nome)){
            for(int i = 0; i < contatos.length; i++){
                if(contatos[i] != null && contatos[i].getNome().equals(nome)){

                    contatos[i] = null;
                    break;

                }
            }
            
            System.out.println("\nContato apagado com sucesso!\n");
            
        }else{
            System.out.println("\nContato não encontrado!\n");
            
        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
        
    }
    
    public void pesquisarCont(){
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" ========================= BUSCAR ============================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        
        System.out.println("Nome: ");
        String nome = in.nextLine().toUpperCase();
        
        if(verificarCont(nome)){
            
            for(Contato contato : contatos){
                if(contato != null && contato.getNome().equals(nome)){
                    
                    System.out.println(contato);
                    break;
                    
                }
            }
            
        }else{
            System.out.println("\nCONTATO NÃO ENCONTRADO!\n");
            
        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
        
    }
}
