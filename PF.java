import java.time.LocalDate;

public class PF {

    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public PF() {
    }

    public PF(int id, String nome, String cpf, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate data) {
        this.dataNascimento = data;
    }

    @Override
    public String toString() {
        return "id=" + id + ", nome=" + nome + ", cpf=" + cpf
                + ", dataNascimento=" + dataNascimento;
    }
}