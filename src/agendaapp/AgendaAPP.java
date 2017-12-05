
package agendaapp;

import java.util.ArrayList;
import java.util.Scanner;

public class AgendaAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
               
        Agenda agenda = new Agenda();
        String nome, telefone, email, grupo;
        Scanner entrada = new Scanner(System.in);
        int op;
        boolean verdadeiro = true;
        agenda.carregarNomes();
        do {
            System.out.println("Opção [1] Adicionar Contato");
            System.out.println("Opção [2] Excluir Contato");
            System.out.println("Opção [3] ver Contato");
            System.out.println("Opção [4] ver grupos de Contatos");
            System.out.println("opçao [5] Exluir grupo de Contatos");
            System.out.println("Opção [6] Sair");
            op = Integer.valueOf(entrada.nextLine());
           
            switch (op) {
                case 1:
                    //Adicionar Contato
                    System.out.println("Nome:");
                    nome = entrada.nextLine();
                    System.out.println("Telefone");
                    telefone = entrada.nextLine();
                    System.out.println("E-mail:");
                    email = entrada.nextLine();
                    System.out.println("Qual o grupo?");
                    grupo = entrada.nextLine();
                    agenda.salvarContato(nome, telefone, email, grupo);
                    break;
                case 2:
                    //Excluir contato
                    System.out.println("Digite nome do Contato");
                    nome = entrada.nextLine();
                    if(agenda.excluirContato(nome)){
                        System.out.println("Contato excluido ..");
                    }else{
                        System.out.println("Contato não esta na lista de contatos");
                    }
                    break;
                case 3:
                    //Lista contatos
                    System.out.println("Digite nome do contato");
                    nome = entrada.nextLine();
                    agenda.verContato(nome);
                    System.out.println("Deseja Edita o Contato ?");
                    System.out.println("Sim [1]");
                    System.out.println("Não [2]");
                    int x;
                    x = entrada.nextInt();
                    if (x == 1) {
                        System.out.println("Digite novo nome");
                        nome=entrada.nextLine();
                        System.out.println("Digite novo telefone");
                        telefone = entrada.next();
                        System.out.println("Digite novo E-mail");
                        email=entrada.nextLine();
                        System.out.println("Digite novo Grupo");
                        grupo = entrada.nextLine();
                        
                    }
                    if (x == 2) {
                        System.out.println("Saindo");
                        
                    }
 
                    
                    break;
                    
                case 4:
                    agenda.listarGrupos();
                    System.out.println("Selecione um grupo");
                    grupo = entrada.nextLine();
                    agenda.listaContatosGrupo(grupo);

                    break;
                case 5:
                    //
                    System.out.println("Qual grupo a ser  excluido?");
                    grupo = entrada.nextLine();
                    if(agenda.excluirGrupodeContatos(grupo)){
                        System.out.println("Grupo excluido....");
                    }else{
                        System.out.println("Grupo inexistente");
                    }
                    break;
                case 6:
                    //funções

                    break;
                case 7:
                    //funções
                    verdadeiro = false;
                    break;

            }
        } while (verdadeiro);
    }
 
    

}
