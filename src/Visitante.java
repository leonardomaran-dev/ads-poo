import java.util.ArrayList;
import java.util.List;

public class Visitante extends Pessoa {
    private static List<Visitante> visitantes = new ArrayList<>();

    // CONSTRUTOR
    public Visitante(String avatar, String nome, String telefone, String documento) {
        super(avatar, nome, telefone, documento);
    }

    // BUSCAR TODOS VISITANTES
    public static List<Visitante> getVisitantes() {
        return List.copyOf(visitantes);
    }

    // BUSCAR VISITANTE POR ID
    public static Visitante getById(int id) {
        for (Visitante v : visitantes) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    @Override
    protected void create() {
        gerarId();
        visitantes.add(this);
    }

    @Override
    protected void update(int id) {
        for (int i = 0; i < visitantes.size(); i++) {
            if (visitantes.get(i).getId() == id) {
                this.id = id;
                visitantes.set(i, this);
                return;
            }
        }
    }

    @Override
    protected void delete(int id) {
        visitantes.removeIf(v -> v.getId() == id);
    }

    @Override
    public String toString() {
        return "Visitante{id=" + getId() + ", avatar='" + avatar + "', nome='" + nome
                + "', telefone='" + telefone + "', documento='" + documento + "'}";
    }
}
