public class Usuario {
    protected int id;
    protected String avatar;
    protected String nome;
    protected String telefone;
    protected String email;

    public Usuario(String avatar, String nome, String telefone, String email) {
        this.avatar = avatar;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
}
