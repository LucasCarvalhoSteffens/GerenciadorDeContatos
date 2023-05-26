import java.util.HashMap;
import java.io.*;
import java.time.LocalDate;

public class HashMapContatoStorage implements ContatoStorage, Serializable {
    private static final long serialVersionUID = 1L;
    private HashMap<String, Contato> contatos;
    private static final String ARQUIVO_CONTATOS = "contatos.ser";

    public HashMapContatoStorage() {
        contatos = new HashMap<>();
        carregarContatos();
    }

    @Override
    public void adicionarContato(String nome, String telefone, LocalDate dataNascimento) {
        Contato contato = new Contato(nome, telefone, dataNascimento);
        contatos.put(nome, contato);
        System.out.println("Contato adicionado: " + contato);
        salvarContatos();
    }

    @Override
    public void removerContato(String nome) {
        if (contatos.containsKey(nome)) {
            String telefone = String.valueOf(contatos.remove(nome));
            System.out.println("Contato removido: "+ telefone);
            salvarContatos();
        } else {
            System.out.println("Contato não encontrado: " + nome);
        }
    }

    @Override
    public String buscarContato(String nome) {
        if (contatos.containsKey(nome)) {
            String telefone = String.valueOf(contatos.get(nome));
            System.out.println("Contato encontrado: " + telefone);
            return telefone;
        } else {
            System.out.println("Contato não encontrado: " + nome);
            return null;
        }
    }

    @Override
    public HashMap<String, Contato> listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Lista de contatos vazia.");
            return null;
        } else {
            System.out.println("Lista de contatos:");
            for (String nome : contatos.keySet()) {
                String telefone = String.valueOf(contatos.get(nome));
                System.out.println(nome + " - " + telefone);
            }
            return contatos;
        }
    }

    private void salvarContatos() {
        try (FileOutputStream fileOut = new FileOutputStream(ARQUIVO_CONTATOS);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(contatos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar contatos: " + e.getMessage());
        }
    }

    private void carregarContatos() {
        try (FileInputStream fileIn = new FileInputStream(ARQUIVO_CONTATOS);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            contatos = (HashMap<String, Contato>) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de contatos não encontrado. Será criado um novo arquivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar contatos: " + e.getMessage());
        }
    }
}
