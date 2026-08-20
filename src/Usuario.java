public class Usuario {
    private int id;
    private String avatar;
    private String nome;
    private String telefone;
    private String email;

    //CONSTRUTOR
    public Usuario(String avatar, String nome, String telefone, String email) {
        this.avatar = avatar;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    //GETTERS / SETTERS
    public int getId() {
        return id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
