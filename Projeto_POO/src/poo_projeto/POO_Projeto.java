package poo_projeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PC Multimédia
 */
public class POO_Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Empresa empresa = new Empresa();
        ArrayList<Empregado> listEmpregados = new ArrayList<Empregado>();
        Scanner menu = new Scanner (System.in);
        
        int opcao = 69;
		
        do{
		System.out.print("##-----------------------Empresa------------------------##\n\n");
		System.out.print("|--------------------------------------------------------|\n");
		System.out.print("| Opção 1 - Inserir Nova Ficha de Empregado              |\n");
		System.out.print("| Opção 2 - Verificar Cliente por Código                 |\n");
		System.out.print("| Opção 3 - Pesquisar Numero de Empregado                |\n");
                System.out.print("| Opção 4 - Inserir Lista no Registo Atual               |\n");
		System.out.print("| Opção 5 - Numero atual de Empregados (categoria)       |\n");
		System.out.print("| Opção 6 - Conjunto atual de Empregados                 |\n");
                System.out.print("| Opção 7 - Conjunto atual de Empregados (categoria)     |\n");
                System.out.print("| Opção 8 - Calcular o total de salário a pagar          |\n");
                System.out.print("| Opção 9 - Calcular custos Trimestrais/Semestrais/Anuais|\n");
                System.out.print("| Opção 10 - Guardar a Lista Atual de Empregados(TXT)    |\n");
                System.out.print("| Opção 0 -                  Sair                        |\n");
                System.out.print("|--------------------------------------------------------|\n");
		System.out.print("Digite uma opção: ");
		
		opcao = menu.nextInt();
                
		switch (opcao) {
		case 1:
                        empresa.criarEmpregado();
                        break;
		case 2:
                        System.out.println(empresa.empregadoRepetido(1));
                        break;
		case 3:
			empresa.pesquisaNumEmpregado(1);
                        break;
                case 4: 
                        empresa.adicionarEmpregados(empresa.LerFicheiro());
                        break;
                case 5:
                       System.out.println(empresa.consultarEmpregados("Normal") + " Empregados");
                       break;
                case 6:
                        empresa.fichasAtualEmpregado();
            
                       break;
                case 7:
                         empresa.fichasEmpregoCategoria("Gestor"); 
                        break;
                case 8:
                        empresa.salTotal();
                        System.out.println(empresa.salTotal());
                        break;
                case 9:
                        empresa.custoAnual();
                        empresa.custosSemestrais();
                        empresa.custosTrimestrais();
                        break;
                case 10:
                        empresa.guardarEmpregados();
                        break;
                default:
                    menu.close();
                    break;
					
		}
        }
        while(opcao!=0);
                
                
}
}