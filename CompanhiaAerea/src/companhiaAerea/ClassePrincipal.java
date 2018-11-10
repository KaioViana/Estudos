package companhiaAerea;

public class ClassePrincipal {

    static java.util.Scanner in = new java.util.Scanner(System.in);
    static Voo[] voos = new Voo[100];

    public static void main(String[] args) {

        exibirMenu();

    }

    // Método exibir menu()
    public static void exibirMenu() {
        while (true) {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println(" ============================ MENU ===========================");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("\n1.Cadastrar voo");
            System.out.println("2.Listar voos");
            System.out.println("3.Efetuar reserva");
            System.out.println("4.Cancelar voo");
            System.out.println("5.Atualizar voo");
            System.out.println("6.Cancelar reserva");
            System.out.println("7.Listar reservas de determinado voo");
            System.out.println("8.Pesquisar voo");
            System.out.println("9. Pesquisar passageiro de determinado voo");
            System.out.println("10.Sair");
            System.out.println("Sua opção: ");
            int opcao = Integer.parseInt(in.nextLine());

            System.out.println();

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;

                case 2:
                    listar();
                    break;

                case 3:
                    efetuarReserva();
                    break;

                case 4:
                    cancelarVoo();
                    break;

                case 5:
                    atualizarVoo();
                    break;

                case 6:
                    cancelarReserva();
                    break;

                case 7:
                    listarReserva();
                    break;

                case 8:
                    pesquisarVoo();
                    break;

                case 9:
                    pesquisarPassageiro();
                    break;
                    
                case 10:
                    System.out.println("FINALIZADO.");
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!\n");
                    break;

            }
        }
    }

    // Método cadastrar()
    public static void cadastrar() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" =================== CADASTRAMENTO DE VOOS =====================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        boolean cheio = true;

        for (int i = 0; i < voos.length; i++) {
            // Pega o primeiro espaço vazio no vetor voos e pede os dados
            if (voos[i] == null) {
                System.out.println("Número do voo: ");
                int num = Integer.parseInt(in.nextLine());

                System.out.println("\nOrigem: ");
                String orig = in.nextLine().toUpperCase();

                System.out.println("\nDestino: ");
                String dest = in.nextLine().toUpperCase();

                System.out.println("\nQuantidade de assentos: ");
                int quant = Integer.parseInt(in.nextLine());

                System.out.println();
                // Cria um objeto Voo
                voos[i] = new Voo(num, orig, dest, quant);
                cheio = false;
                
                System.out.println("VOO CADASTRADO COM SUCESSO!\n");
                break;

            }
        }
        // Se boolean cheio for true, acabou os espaços do vetor
        if (cheio) {
            System.out.println("SEM ESPAÇO PARA MAIS CADASTROS!\n");

        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
        
    }

    // Método listar()
    public static void listar() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" ============================ VOOS ===========================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        
        // Utiliza método toString() da classe Voo para mostrar as informações
        // armazenadas em cada objeto Voo
        boolean vazio = true;

        for (Voo voo : voos) {
            if (voo != null) {
                System.out.println(voo);
                System.out.println();
                vazio = false;
            }
        }

        if (vazio) {
            System.out.println("SEM VOOS CADASTRADOS!\n");

        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
            
    }

    // Método efetuarReserva()
    public static void efetuarReserva() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" =================== EFETUAR RESERVA ===========================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("\nInforme o número do voo desejado: ");
        int num = Integer.parseInt(in.nextLine());

        if (verificarVoo(num)) {

            assentos(num);

        } else {
            System.out.println("\nNÚMERO DO VOO ESPECIFICADO NÃO ENCONTRADO\n");

        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();

    }

    // Método verificarVoo(), recebe como parâmetro o número do voo desejado
    public static boolean verificarVoo(int x) {

        boolean encontrado = false;
        // Verifica a existência do voo desejado e retorna true ou false
        for (Voo voo : voos) {
            if (voo != null) {
                if (voo.getNumero() == x) {
                    encontrado = true;
                    break;
                }
            }
        }

        return encontrado;

    }

    // Método assentos(), recebe como parâmetro o número do voo
    public static void assentos(int x) {

        for (Voo voo : voos) {
            if (voo != null && voo.getNumero() == x) { // se encontrar o voo
                // especificado no método

                boolean allReservados = true;

                System.out.println("\nAssentos disponíveis: ");
                // Mostra assentos disponíveis
                for (Assento assentos : voo.getAssentos()) {
                    if (assentos.getPassageiro() == null) {
                        System.out.print(assentos.getNumero() + " ");
                        allReservados = false;
                    }

                }
                // Se allReservados for true, todos os assentos estão ocupados
                if (allReservados) {
                    System.out.println("\nDesculpe, todos assentos já foram reservados.");
                    break;
                }

                System.out.println("\nInforme o assento desejado: ");
                int assento = Integer.parseInt(in.nextLine());
                // Os dois if's verificam se a variável assento está dentro da
                // length de assentos e se o assento já está ocupado
                if ((assento > 0) && (assento <= voo.getAssentos().length)) {
                    if (voo.getAssentos()[assento - 1].getPassageiro() == null) {

                        System.out.println("\nNome: ");
                        String nome = in.nextLine().toUpperCase();

                        System.out.println("\nIdade: ");
                        int idade = Integer.parseInt(in.nextLine());

                        System.out.println("\nSexo M/F: ");
                        char sexo = in.next().toUpperCase().charAt(0);
                        // Cria objeto passageiro
                        Passageiro passageiro = new Passageiro(nome, idade, sexo);

                        voo.getAssentos()[assento - 1].setPassageiro(passageiro);
                        in.nextLine(); // Para limpar o buffer e evitar erro
                        // NumberFormatExeption

                        System.out.println("\nRESERVA EFEUADA COM SUCESSO!");

                    } else {
                        System.out.println("\nASSENTO JÁ RESERVADO!");
                        break;

                    }

                } else {
                    System.out.println("\nASSENTO INEXISTENTE!");
                    break;

                }
            }
        }
    }
    // Método cancelarVoo()
    public static void cancelarVoo() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" =================== CANCELAR VOO ==============================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("Infome o número do voo a ser cancelado: ");
        int num = Integer.parseInt(in.nextLine());
        // Verifica a existência do voo
        if (verificarVoo(num)) {
            // Se o voo existir definie o seu valor como null
            for (int i = 0; i < voos.length; i++) {
                if (voos[i] != null && voos[i].getNumero() == num) {
                    voos[i] = null;
                    break;

                }
            }

            System.out.println("\nVOO CANCELADO COM SUCESSO!");

        } else {
            System.out.println("\nNÚMERO DO VOO ESPECIFICADO NÃO ENCONTRADO!");

        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
    }
    // Método atualizarVoo()
    public static void atualizarVoo() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" =================== ATUALIZAR VOO =============================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("Informe o número do voo a ser atualizado: ");
        int num = Integer.parseInt(in.nextLine());

        verificarVoo(num);
        // Verifica a existência do voo
        if (verificarVoo(num)) {
            // Se existir, pede os novos dados para atualização
            System.out.println("\nOrigem: ");
            String orig = in.nextLine().toUpperCase();

            System.out.println("\nDestino: ");
            String dest = in.nextLine().toUpperCase();

            System.out.println("\nQuantidade de assentos: ");
            int quant = Integer.parseInt(in.nextLine());

            for (int i = 0; i < voos.length; i++) {
                if (voos[i] != null && voos[i].getNumero() == num) {
                    // Insere os novos dados do voo
                    voos[i] = new Voo(num, orig, dest, quant);

                }
            }

            System.out.println("\nVOO ATUALIZADO COM SUCESSO!");

        } else {
            System.out.println("\nNÚMERO DO VOO ESPECIFICADO NÃO ENCONTRADO!");

        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
    }
    // Método cancelarReserva()
    public static void cancelarReserva() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" =================== ATUALIZAR VOO =============================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("Informe o número do voo: ");
        int num = Integer.parseInt(in.nextLine());
        // Verifica a existência do voo
        if (verificarVoo(num)) {
            // Se existir, pede o numero do assento da reserva a ser cancelada
            System.out.println("Informe o número do assento: ");
            int assent = Integer.parseInt(in.nextLine());

            System.out.println();

            for (Voo voo : voos) {
                if ((voo != null) && (voo.getNumero() == num)) {

                    System.out.println(voo.getAssentos()[assent - 1]);
                    // Cancelar reserva ? 
                    System.out.println("CANCELAR ?");
                    String cancel = in.nextLine();

                    if (cancel.equalsIgnoreCase("sim")) {
                        // Se sim, difine o valor do assento como null
                        voo.getAssentos()[assent - 1] = null;

                        System.out.println("\nRESERVA CANCELADA COM SUCESSO!");

                    } else {
                        System.out.println("\nCANCELAMENTO DE RESERVA INTERROMPIDO.");

                    }
                }
            }

        } else {
            System.out.println("\nVOO NÃO ENCONTRADO!");

        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
    }
    // Método listarReserva
    public static void listarReserva() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" =================== RESERVAS VOO =============================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("Informe o número do voo: ");
        int num = Integer.parseInt(in.nextLine());
        // Verifica existência do voo
        if (verificarVoo(num)) {
            // Se existir, lista as reservas
            for (Voo voo : voos) {
                if ((voo != null) && (voo.getNumero() == num)) {

                    boolean vazio = true;

                    for (Assento assento : voo.getAssentos()) {

                        if (assento.getPassageiro() != null) {

                            System.out.println(assento.getPassageiro());
                            System.out.println("Assento: " + assento.getNumero());
                            vazio = false;

                        }
                    }

                    if (vazio) {
                        System.out.println("\nSEM RESERVAS PARA ESTE VOO!");

                    }
                }

                break;
            }

        } else {
            System.out.println("\nVOO NÃO ENCONTRADO!");

        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
    }
    // Método pesquisarVoo()
    public static void pesquisarVoo() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" =================== PESQUISAR VOO =============================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("Informe o número do voo: ");
        int num = Integer.parseInt(in.nextLine());
        
        System.out.println();
        // Verifica a existência do voo
        if (verificarVoo(num)) {
            // Se existir, lista seus dados
            for (Voo voo : voos) {
                if ((voo != null) && (voo.getNumero() == num)) {
                    System.out.println(voo);
                    System.out.println();
                    
                }
            }

        } else {
            System.out.println("\nNÚMERO DO VOO ESPECIFICADO NÃO ENCONTRADO!");

        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
    }
    // Método pesquisarPassageiro()
    public static void pesquisarPassageiro() {
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(" =================== PESQUISAR  PASSAGEIRO =====================");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        System.out.println("Informe o número do voo: ");
        int num = Integer.parseInt(in.nextLine());
        
        boolean vazio = true;
        // Verifica existência do voo
        if(verificarVoo(num)){
            
            System.out.println("Número do assento: ");
            int assent = Integer.parseInt(in.nextLine());
            
            for(Voo voo : voos){
                if((voo != null) && (voo.getNumero() == num)){
                    
                    for(Assento assento : voo.getAssentos()){
                        if((assento.getNumero() == assent) &&
                                (assento.getPassageiro() != null)){
                            
                            System.out.println(assento.getPassageiro());
                            vazio = false;
                            break;
                            
                        }
                    }
                    
                    if(vazio){
                        System.out.println("\nASSENTO VAZIO!");
                        break;
                     
                    }
                }
            }
            
        }else{
            System.out.println("VOO NÃO ENCONTRADO!");
            
        }
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println();
    }
}
