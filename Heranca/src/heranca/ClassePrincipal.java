
package heranca;

public class ClassePrincipal {
    
    public static void main(String[] args){
        
        // Demonstração da classe EmpregadoComissao que utiliza um extends Empregado
        EmpregadoComissao empregado1 = new EmpregadoComissao("Kaio", "Viana", "222222222",
        10000, .06);
        
        System.out.println("Empregado que ganha apenas comissão sobre as vendas:\n");
        
        // Método toString() do objeto empregado1
        System.out.println(empregado1);
        
        // Calcula o salário de empregado1
        System.out.printf("SALÁRIO FINAL: R$%.2f%n", empregado1.ganhos());
        
        System.out.println("\n==================================================================\n");
        
        // Demosntração da classe EmpregadoComissaoSalarioBase que utiliza um extends
        // EmpregadoComissao que utiliza um extends Empregado
        EmpregadoComissaoSalarioBase empregado2 = new EmpregadoComissaoSalarioBase("Jonas",
                "Duarte", "111111111", 10000, .06, 900);
        
        System.out.println("Empregado que ganha um salário base e comissão sobre as vendas:\n");
        
       // Método toString() do objeto empregado2
       System.out.println(empregado2);
       
       // Calcula o salário de empregado2
       System.out.printf("SALÁRIO FINAL: R$%.2f%n", empregado2.ganhos());
       
       System.out.println("\n==================================================================\n");
       
       // Denmonstração da classe EmpregadoHora que tem um Extends Empregado
       EmpregadoHora empregado3 = new EmpregadoHora("Maria", "Vieira", "333333333",
       100, 10);
       
       System.out.println("Empregada que ganha com base nas horas trabalhadas:\n");
       
       //Método toString() do objeto empregado3
       System.out.println(empregado3);
       
       // Calcula o salário de empregado3
       System.out.printf("SALÁRIO FINAL: R$%.2f%n", empregado3.ganhos());
        
    }
}
