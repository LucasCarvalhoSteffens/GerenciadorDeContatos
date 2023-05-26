import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContatoStorage storage = new HashMapContatoStorage();
        GerenciadorDeContatos gerenciador = new GerenciadorDeContatos(storage);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelecione uma opção:");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato");
            System.out.println("4 - Listar contatos");
            System.out.println("0 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Digite a data de nascimento do contato (formato: AAAA-MM-DD): ");
                    LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
                    gerenciador.adicionarContato(nome, telefone, dataNascimento);
                    break;
                case 2:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    nome = scanner.nextLine();
                    gerenciador.removerContato(nome);
                    break;
                case 3:
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    nome = scanner.nextLine();
                    gerenciador.buscarContato(nome);
                    break;
                case 4:
                    Map<String, String> contatos = gerenciador.listarContatos();
                    if (contatos != null) {
                        System.out.println("Total de contatos: " + contatos.size());
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
