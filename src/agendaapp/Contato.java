/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendaapp;

/**
 *
 * @author Alexandre
 */
public class Contato {
    private String nome;
    private int telefone;
    private String email;
    
    public Contato(){
        
    }
    public Contato(String nome, int telefone, String email){
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return this.telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", telefone=" + telefone + ", email=" + email + "}\n";
    }
    
    
   
}
