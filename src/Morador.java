import java.util.ArrayList;
import java.util.List;

public class Morador extends Usuario {
    private static List<Morador> moradores = new ArrayList<>();

    // CONSTRUTOR
    public Morador(String avatar, String nome, String telefone, String documento, String email, String password) {
        super(avatar, nome, telefone, documento, email, password);
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
    protected void delete(int id) {
        moradores.removeIf(m -> m.getId() == id);
    }

    @Override
    public String toString() {
        return "{id=" + getId() + ", avatar='" + avatar + "', nome='" + nome
                + "', telefone='" + telefone + "', documento='" + documento
                + "', email='" + email + "'}";
    }
}
