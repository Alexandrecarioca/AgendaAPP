package agendaapp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import pessoastream.Pessoa;

public class Agenda {

    private List<Contato> listaDeContatos;
    private Contato contato;
    private List<GrupoDeContatos> grupos;

    /*
    No construtor utilizamos o metodo lerArquivo para carregar os dados que estão
    no arquivo direto para a lista.
   
     */
    public Agenda() {

        lerArquivo();
    }

    public List<Contato> getListaDeContatos() {
        return listaDeContatos;
    }

    public void setListaDeContatos(List<Contato> listaDeContatos) {
        this.listaDeContatos = listaDeContatos;
    }

    /*
    No metodo salvarContato, pegamos os valores dos parametros e instanciamos
    um objeto do tipo Contato, para depois adicionar na lista de contatos, em
    seguinda passamos a lista de contato como parametro para o metodo salvarArquivo()
    para o mesmo salvar os dados na lista de contato    
     */
    public void salvarContato(String nome, String telefone, String email, String grupo) {
        contato = new Contato(nome, telefone, email, grupo);
        grupos.add(new GrupoDeContatos(grupo));
        listaDeContatos.add(contato);
        salvarArquivo(listaDeContatos);

    }

    /*
    Esse metodo e responsável por salvar a lista de contatos no arquivo, então
    como ja carregamos os dados do arquivo na lista, passaremos a lista atualizada
    para que seja rescrito no arquivo contatos.txt
     */
    public void salvarArquivo(List<Contato> lista) {
        try {
            FileOutputStream arquivo = new FileOutputStream("contato.txt");
            PrintWriter pw = new PrintWriter(arquivo);

            for (Contato c : lista) {
                pw.println(c);
            }
            pw.close();
            arquivo.close();

        } catch (Exception ex) {
            System.out.println("Erro ao salvar arquivo");
        }

    }
//Metodo usado para ler os dados do arquivo.

    public void lerArquivo() {

        listaDeContatos = new ArrayList<>();
        grupos = new ArrayList<GrupoDeContatos>();
        try {
            FileInputStream arquivo = new FileInputStream("contato.txt");
            InputStreamReader reader = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(reader);

            String linha;
            do {
                linha = br.readLine();
                if (linha != null) {
                    Contato c = new Contato();
                    String[] valores = linha.split(";");
                    c.setNome(valores[0]);
                    c.setTelefone(valores[1]);
                    c.setEmail(valores[2]);
                    GrupoDeContatos grupo = new GrupoDeContatos(valores[3]);
                    c.setGrupo(grupo);
                    grupos.add(grupo);
                    listaDeContatos.add(c);
                    limpaDuplicado(grupos);
                }
            } while (linha != null);

        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo");
        }

    }

    public boolean excluirContato(String valor) {
        boolean temContato = false;
        for (int i = 0; i < listaDeContatos.size(); i++) {
            if (listaDeContatos.get(i).getNome().equals(valor)) {
                listaDeContatos.remove(i);
                temContato = true;
                salvarArquivo(listaDeContatos);
            }
        }
        return temContato;
    }

//    public void carregarListaContatos() {
//        for (int i = 0; i < listaDeContatos.size(); i++) {
//            System.out.println("Contato " + (i + 1));
//            System.out.println("Nome: " + listaDeContatos.get(i).getNome());
//            System.out.println("Telefone: " + listaDeContatos.get(i).getTelefone());
//            System.out.println("Email: " + listaDeContatos.get(i).getEmail());
//            System.out.println("Grupo: " + listaDeContatos.get(i).getGrupo().getNome());
//        }
//    }
    public void carregarNomes(){
          System.out.println("AGENDA");
            for (int i = 0; i < listaDeContatos.size(); i++) {
            //System.out.println("Contato " + (i + 1));
            System.out.println("Nome: " + listaDeContatos.get(i).getNome());

        }

    }

    
//     public List<Contato> carregarContatos() {
//         
//         
//        return listaDeContatos;
//    }

    public boolean excluirGrupodeContatos(String valor) {
        boolean temContato = false;

        for (int i = 0; i < listaDeContatos.size(); i++) {
            if (listaDeContatos.get(i).getGrupo().getNome().equals(valor)) {
                listaDeContatos.get(i).getGrupo().setNome(null);
                
            }
        }
        salvarArquivo(listaDeContatos);
        limpaDuplicado(grupos);
        return temContato;
    }
    public void verContato(String nome){
       
        for (int i = 0; i < listaDeContatos.size(); i++) {
            if (listaDeContatos.get(i).getNome().equals(nome)) {
            System.out.println("Nome: " + listaDeContatos.get(i).getNome());
            System.out.println("Telefone: " + listaDeContatos.get(i).getTelefone());
            System.out.println("Email: " + listaDeContatos.get(i).getEmail());
            System.out.println("Grupo: " + listaDeContatos.get(i).getGrupo().getNome());
                
            } 
        }

    }
    public void listarGrupos(){
        
        grupos.stream()
                .forEach(grupo -> System.out.println(grupo.getNome()));
    }
    
    public void limpaDuplicado(List<GrupoDeContatos> lista){
        Set<GrupoDeContatos> set = lista.stream()
            .collect(Collectors.toCollection(() -> 
                 new TreeSet<>(Comparator.comparing(GrupoDeContatos::getNome))));
        lista.clear();
        lista.addAll(set);
        
    }
    public void listaContatosGrupo(String nomegrupo){
        for (Contato  c: listaDeContatos) {
            if (c.getGrupo().getNome().equals(nomegrupo)) {
                System.out.println("nome: " + c.getNome()+ " Telefone: " + c.getTelefone());
                
            }
            
        }
    
    }
}
