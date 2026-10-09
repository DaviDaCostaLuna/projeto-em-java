public interface DAO<T> {

    void inserir(T obj);

    boolean atualizar(T obj);

    T ler(int id);

    boolean apagar(int id);
}