package cpg;

public class ClassePrincipal {
    
    public static void main(String[] args){
        // cria objeto CPG
        CPG portao = new CPG();
        
        System.out.println("SAÍDAS: \n");
        
        // tenta setar um comando inválido
        // o bloco try-catch trata o erro
        try{
            
            portao.setComando("----------");
          
        }catch(IllegalArgumentException e){
            
            System.out.println("Excecão: " + e.getMessage());
            System.out.println();
            
        }
        
        // comandos passados para o portão
        // eles são executados e retorno e mostrado na tela
        portao.setComando("..P...O.....");
        portao.executar();
        System.out.println(portao.getRetorno());
        
        
        portao.setComando(".P....");
        portao.executar();
        System.out.println(portao.getRetorno());
        
        
        portao.setComando("...P.P...P..");
        portao.executar();
        System.out.println(portao.getRetorno());
        
        
        portao.setComando("P..O..");
        portao.executar();
        System.out.println(portao.getRetorno());
        
        
        portao.setComando("P..P...PO...");
        portao.executar();
        System.out.println(portao.getRetorno());
        
        
        portao.setComando("P...O.O.P...P..");
        portao.executar();
        System.out.println(portao.getRetorno());
        
        
        portao.setComando("P.....P.P..P...");
        portao.executar();
        System.out.println(portao.getRetorno());
        
        
        
    }
    
}
