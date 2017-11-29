package agendaapp;

public class Contato {

    private String nome;
    private String telefone;
    private String email;
    private GrupoDeContatos grupo;

    public Contato() {

    }

    public Contato(String nome, String telefone, String email, String grupo) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.grupo = new GrupoDeContatos(grupo);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GrupoDeContatos getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoDeContatos grupo) {
        this.grupo = grupo;
    }
    
    @Override
    public String toString() {
        return getNome() + ";" + getTelefone() + ";" + getEmail() + ";" + getGrupo().getNome();
    }

}
