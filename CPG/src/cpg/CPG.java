package cpg;

/*
Controlador de Portão de Garagem;

Passa comandos que o portão deve executar, como: abrir, fechar, parar e 
identificar obstáculos.

ESPECIFICAÇÃO:

A porta sempre começa fechada. O controle remoto possui exatamente um botão,
com o seguinte comportamento:

* Se a porta estiver fechada, ela começa a abrir. Se estiver aberta, começa
a fechar.

* Leva 5 segundos para a porta abrir ou fechar completamente.

Pra tornar a porta mais segura ela foi equipada com um detector de obstáculos.
Quando a porta detecta um obstáculo, ela deve imediatamente inverter o sentido
do seu movimento.

ENTRADA:

* A entrada do programa é uma String em que cada caracter representa o evento
ocorrido em um segundo, sendo os seguintes possíveis caracteres:

'.' Nenhum evento
'P' botão pressionado
'O' Obstáculo detectado

SAÍDA:

* Uma String onde cada caracter representa a posição da porta em um segundo (0
significa totalmente fechada e 5 totalmente aberta). A porta começa a se mover 
imediatamente, então sua posição muda no mesmo segundo em que receber um evento.

Ex: a entrada '..P...O.....' resultaria em '001234321000' como saída.


*/

public class CPG {
    
    private String comando;// comando passado Ex: (...P.P.O..)
    private String retorno;// retorno do comando Ex: (012345)
    private Estado porta;// Estados em que o portão pode atingir (ABERTO, FECHADO, etc)
    private int tempo;// intervalos do portão, indo de 0 a 5
     
    // Construtor padrão
    public CPG(){
        
    }
    
    // método set para informar o comando
    public void setComando(String comando){
        // faz um loop pelo comando para verifica-lo
        for(int i = 0; i < comando.length(); i++){
            // se algum caracter for inválido lança um erro
            if(comando.charAt(i) != '.' && comando.charAt(i) != 'P'
                    && comando.charAt(i) != 'O'){
                
                throw new IllegalArgumentException("Argumento passado inválido!");
                
            }
        }
        
        
        // atribui o argumento e inicializa as variáveis
        this.comando = comando;
        retorno = "";
        tempo = 0;
        porta = Estado.FECHADA;
        
    }
    
    // método get
    public String getComando(){
        
        return comando;
        
    }
    
    // método executar(), executa o comando e gera o retorno dele
    public void executar(){
        
        // loop for pelo comando, verifica cada comando isolado e o estado do 
        // portão e faz o procedimento necessário
        for(int i = 0; i < comando.length(); i++){
            if(comando.charAt(i) == '.' && porta == Estado.FECHADA){
                
                retorno += Integer.toString(tempo);
                
            }else if(comando.charAt(i) == '.' && (porta == Estado.ABRINDO || porta == Estado.ABERTA)){
                
                if(tempo == 5){
                    
                    retorno += Integer.toString(tempo);
                    porta = Estado.ABERTA;
                    
                }else{
                    
                    tempo++;
                    retorno += Integer.toString(tempo);
                }
                
            }else if(comando.charAt(i) == '.' && porta == Estado.FECHANDO){
                
                tempo--;
                retorno += Integer.toString(tempo);
                
                if(tempo == 0){
                    
                    porta = Estado.FECHADA;
                    
                }
                
            }else if(comando.charAt(i) == '.' && (porta == Estado.PARADA_A || porta == Estado.PARADA_F)){
                
                retorno += Integer.toString(tempo);
                
            }
            
            if(comando.charAt(i) == 'P' && porta == Estado.FECHADA){
                
                tempo++;
                retorno += Integer.toString(tempo);
                porta = Estado.ABRINDO;
                
                        
            }else if(comando.charAt(i) == 'P' && (porta == Estado.ABRINDO || porta == Estado.FECHANDO)){
                
                retorno += Integer.toString(tempo);
                
                if(porta == Estado.ABRINDO){
                    
                    porta = Estado.PARADA_A;
                    
                }else{
                    
                    porta = Estado.PARADA_F;
                }    
                
            }else if(comando.charAt(i) == 'P' && (porta == Estado.PARADA_A || porta == Estado.PARADA_F)){
                
                if(porta == Estado.PARADA_A){
                    
                    tempo++;
                    retorno += Integer.toString(tempo);
                    porta = Estado.ABRINDO;
                    
                }else{
                    
                    tempo--;
                    retorno += Integer.toString(tempo);
                    porta = Estado.FECHANDO;
                    
                }
                
                
            }else if(comando.charAt(i) == 'P' && porta == Estado.ABERTA){
                
                tempo--;
                retorno += Integer.toString(tempo);
                porta = Estado.FECHANDO;
                
            }
            
            if(comando.charAt(i) == 'O' && porta == Estado.ABRINDO){
                
                tempo--;
                retorno += Integer.toString(tempo);
                porta = Estado.FECHANDO;
                
            }else if(comando.charAt(i) == 'O' && porta == Estado.FECHANDO){
                
                tempo++;
                retorno += Integer.toString(tempo);
                porta = Estado.ABRINDO;
                
            }   
        }
    }
    
    // método getRetorno(), mostra o retorno gerado pelo comando passado para o portão
    public String getRetorno(){
        
        return retorno;
        
    }
    
}
