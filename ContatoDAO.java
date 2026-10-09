import java.util.ArrayList;
import java.util.Comparator;

public class ContatoDAO implements DAO<Contato> {

    private ArrayList<Contato> lista = new ArrayList<>();
    private int proximoId = 1;

    @Override
    public void inserir(Contato obj) {
        obj.setId(proximoId++);
        lista.add(obj);
    }

    @Override
    public boolean atualizar(Contato obj) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == obj.getId()) {
                lista.set(i, obj);
                return true;
            }
        }
        return false;
    }

    @Override
    public Contato ler(int id) {
        for (Contato c : lista) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    @Override
    public boolean apagar(int id) {
        Contato c = ler(id);
        if (c == null) {
            return false;
        }
        lista.remove(c);
        return true;
    }

    // ----- Desafios -----

    public ArrayList<Contato> listarTodos() {
        return new ArrayList<>(lista);
    }

    public boolean existeCpf(String cpf) {
        for (Contato c : lista) {
            if (c.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Contato> buscarPorNome(String nome) {
        ArrayList<Contato> resultado = new ArrayList<>();
        for (Contato c : lista) {
            if (c.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public ArrayList<Contato> listarOrdenadoPorNome() {
        ArrayList<Contato> copia = new ArrayList<>(lista);
        copia.sort(Comparator.comparing(c -> c.getNome().toLowerCase()));
        return copia;
    }
}