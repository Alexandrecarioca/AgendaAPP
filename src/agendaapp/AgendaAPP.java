/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alexandre
 */
public class AgendaAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ArrayList<Contato> lista = new ArrayList<>();
        ArrayList<GrupoDeContatos> grupo = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);
        int op;
        boolean verdadeiro = true;

        do {
            System.out.println("Opção [1] Adicionar Contato");
            System.out.println("Opção [2] Excluir Contato");
            System.out.println("Opção [3] ver lista de Conattos");
            System.out.println("opção [4] Adicionar  grupo de Contatos");
            System.out.println("opçao [5] Exluir grupo de Contatos");
            System.out.println("Opção [6] ver grupos de Contatos");
            System.out.println("Opção [7] Sair");
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    //funções
                    Contato contato = new Contato();
                    System.out.println("Nome:");
                    contato.setNome(entrada.next());
                    System.out.println("Telefone");
                    contato.setTelefone(entrada.nextInt());
                    System.out.println("E-mail:");
                    contato.setEmail(entrada.next());
                    
                    lista.add(contato);
                    //salvarArquivo(contato);
                    gravaContatos(lista);
                    break;
                case 2:
                    //funções
                    System.out.println("Digite nome do Contato");
                    String nome = entrada.next();
                    for (int  i = 0;  i < lista.size(); i ++) {
                        if (lista.get(i).getNome().equals(nome)) {
                            lista.remove(i);
                            System.out.println("Contato excluido ..");   
                        }
                        else{
                            System.out.println("Contato não esta na lista de contatos");
                        }
                        
                        
                    }

                    break;
                case 3:
                    //funções
                    for(int i = 0; i < lista.size(); i++){
                        
                        System.out.println("Contato " + (i +1));
                        System.out.println("Nome: " + lista.get(i).getNome());
                        System.out.println("Telefone: " + lista.get(i).getTelefone());
                        System.out.println("Email: " + lista.get(i).getEmail());
                    }
                    break;
                case 4:
                    //funções
                    GrupoDeContatos gp = new GrupoDeContatos();
                    int i = 0;
                    System.out.println("Digite nome do grupo de contatos");
                    gp.setNome(entrada.next());
                    gp.setId(i);
                    i++;
                    

                    break;
                case 5:
                    //funções

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
    
    public void adicionaContato(){
        
    }
    
    public static void salvarArquivo(Contato c){
        File arquivo = new File("contatos.txt");
        //File dir = new File("C:/Users/Alexandre/Documents/NetBeansProjects/AgendaAPP/Arquivo");
        //dir.mkdir();
        
        try {
            BufferedWriter escrever = new BufferedWriter(new FileWriter(arquivo));
                escrever.write("Nome" + c.getNome() + "/");
                escrever.write("Telefone" + c.getTelefone() + "/");
                escrever.write("E-mail" + c.getEmail()+"/n");
                escrever.close();
            
        } catch (IOException e) {
            System.out.println("Erro ao salvar");
        }
    }
    
    public static void gravaContatos(ArrayList<Contato> lista) throws IOException{

        try (FileWriter arquivo = new FileWriter("C:/Users/Alexandre/Documents/NetBeansProjects/AgendaAPP/Arquivo/contatos.txt",true)) {
            PrintWriter gravarArquivo = new PrintWriter(arquivo);
            for (int i = 0; i < lista.size(); i++) {
                gravarArquivo.println(lista.get(i).toString());
            }
            arquivo.flush(); //libera a gravaçao
            arquivo.close();//fecha o arquivo
        }
}
}
