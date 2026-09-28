import java.util.ArrayList;
import java.util.List;

public class Morador extends Usuario {
    private static List<Morador> moradores = new ArrayList<>();
    private String apartamento;
    private String bloco;

    // CONSTRUTOR
    public Morador(String avatar, String nome, String telefone, String documento, String email, String password, String apartamento, String bloco) {
        super(avatar, nome, telefone, documento, email, password);
        this.apartamento = apartamento;
        this.bloco = bloco;
    }

    // BUSCAR TODOS MORADORES
    public static List<Morador> getMoradores() {
        return List.copyOf(moradores);
    }

    // BUSCAR MORADOR POR ID
    public static Morador getById(int id) {
        for (Morador m : moradores) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    @Override
    protected void create() {
        gerarId();
        moradores.add(this);
    }

    @Override
    protected void update(int id) {
        for (int i = 0; i < moradores.size(); i++) {
            if (moradores.get(i).getId() == id) {
                this.id = id;
                moradores.set(i, this);
                return;
            }
        }
    }

    @Override
    public void delete(int id) {
        moradores.removeIf(m -> m.getId() == id);
    }

    @Override
    public String toString() {
        return "{id=" + getId()
                + ", avatar='" + avatar
                + "', nome='" + nome
                + "', telefone='" + telefone
                + "', documento='" + documento
                + "', email='" + email
                + "', apartamento='" + apartamento
                + "', bloco='" + bloco + "'}";
    }
}