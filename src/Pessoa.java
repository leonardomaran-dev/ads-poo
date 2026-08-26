public abstract class Pessoa {
    protected int id;
    private static int nextId = 1;
    protected String avatar;
    protected String nome;
    protected String telefone;
    protected String documento;

    public Pessoa(String avatar, String nome, String telefone, String documento) {
        this.avatar = avatar;
        this.nome = nome;
        this.telefone = telefone;
        this.documento = documento;
    }

    protected void gerarId() {
        this.id = nextId++;
    }

    public int getId() {
        return this.id;
    }

    protected abstract void create();

    protected abstract void update(int id);

    protected abstract void delete(int id);

    // SETTERS
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
