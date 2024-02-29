
package Usuarios;


public class Administrador {
    private String acesso;
    private String login;
    private String senha;
    private int id;

    public Administrador( String login, String senha) {
        this.acesso = "administrador";
        this.login = login;
        this.senha = senha;
    }

    
    
    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        this.acesso = acesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
