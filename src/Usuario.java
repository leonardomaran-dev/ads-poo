public abstract class Usuario extends Pessoa {
    protected String email;
    protected String password;

    // CONSTRUTOR
    public Usuario(String avatar, String nome, String telefone, String documento, String email, String password) {
        super(avatar, nome, telefone, documento);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    // SETTERS

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
