import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ContatoDAO dao = new ContatoDAO();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Inserir contato");
            System.out.println("2 - Listar contato (por id ou todos)");
            System.out.println("3 - Atualizar contato");
            System.out.println("4 - Apagar contato");
            System.out.println("5 - Buscar por nome");
            System.out.println("0 - Sair");
            opcao = lerInt("Escolha: ");

            switch (opcao) {
                case 1:
                    inserir();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    atualizar();
                    break;
                case 4:
                    apagar();
                    break;
                case 5:
                    buscarPorNome();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void inserir() {
        Contato c = lerDadosContato();
        if (dao.existeCpf(c.getCpf())) {
            System.out.println("Já existe um contato com esse CPF!");
            return;
        }
        dao.inserir(c);
        System.out.println("Contato inserido com id " + c.getId());
    }

    private static void listar() {
        System.out.println("1 - Por id");
        System.out.println("2 - Todos");
        System.out.println("3 - Todos ordenados por nome");
        int tipo = lerInt("Escolha: ");

        if (tipo == 1) {
            int id = lerInt("Id: ");
            Contato c = dao.ler(id);
            if (c == null) {
                System.out.println("Contato não encontrado.");
            } else {
                System.out.println(c);
            }
        } else if (tipo == 2) {
            imprimirLista(dao.listarTodos());
        } else if (tipo == 3) {
            imprimirLista(dao.listarOrdenadoPorNome());
        } else {
            System.out.println("Opção inválida!");
        }
    }

    private static void atualizar() {
        int id = lerInt("Id do contato a atualizar: ");
        if (dao.ler(id) == null) {
            System.out.println("Contato não encontrado.");
            return;
        }
        System.out.println("Informe os novos dados:");
        Contato novo = lerDadosContato();
        novo.setId(id);
        if (dao.atualizar(novo)) {
            System.out.println("Contato atualizado!");
        } else {
            System.out.println("Não foi possível atualizar.");
        }
    }

    private static void apagar() {
        int id = lerInt("Id do contato a apagar: ");
        if (dao.apagar(id)) {
            System.out.println("Contato removido!");
        } else {
            System.out.println("Contato não encontrado.");
        }
    }

    private static void buscarPorNome() {
        System.out.print("Nome (ou parte dele): ");
        String nome = sc.nextLine();
        imprimirLista(dao.buscarPorNome(nome));
    }

    // ----- Auxiliares -----

    private static Contato lerDadosContato() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        LocalDate data = lerData("Data de nascimento (aaaa-mm-dd): ");
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Endereço: ");
        String endereco = sc.nextLine();
        System.out.print("Observação: ");
        String observacao = sc.nextLine();

        return new Contato(0, nome, cpf, data, telefone, email, endereco, observacao);
    }

    private static void imprimirLista(ArrayList<Contato> contatos) {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato encontrado.");
            return;
        }
        for (Contato c : contatos) {
            System.out.println(c);
        }
    }

    private static int lerInt(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido.");
            }
        }
    }

    private static LocalDate lerData(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return LocalDate.parse(sc.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use o formato aaaa-mm-dd.");
            }
        }
    }
}