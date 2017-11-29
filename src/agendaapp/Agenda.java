
package agendaapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agenda {
    private List<Contato> listaDeContatos;
    
public Agenda(){
     listaDeContatos = new ArrayList<Contato>();
}

//metodo para instanciar o objeto contato.
public boolean salvarContato(String nome, String telefone, String email){
    Contato contato = new Contato(nome, telefone, email);
    salvarArquivo(contato);
    return true;
}

public void salvarArquivo(Contato c){
    try {
        FileOutputStream arquivo = new FileOutputStream("contato.txt");
        PrintWriter pw = new PrintWriter(arquivo);
        pw.println(c);
        pw.close();
        arquivo.close();
        
    } catch (Exception ex) {
        System.out.println("Erro ao salvar arquivo");
    }
    
}


public void lerDados(){
    
}
            
}
