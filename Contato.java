import java.time.LocalDate;

public class Contato extends PF {

    private String telefone;
    private String email;
    private String endereco;
    private String observacao;

    public Contato() {
        super();
    }

    public Contato(int id, String nome, String cpf, LocalDate dataNascimento,
                   String telefone, String email, String endereco, String observacao) {
        super(id, nome, cpf, dataNascimento);
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.observacao = observacao;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "Contato{" + super.toString()
                + ", telefone=" + telefone
                + ", email=" + email
                + ", endereco=" + endereco
                + ", observacao=" + observacao + "}";
    }

    
}