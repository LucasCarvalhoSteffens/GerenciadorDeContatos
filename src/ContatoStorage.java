import java.util.HashMap;
import java.time.LocalDate;

public interface ContatoStorage {
    void adicionarContato(String nome, String telefone, LocalDate dataNascimento);
    void removerContato(String nome);
    String buscarContato(String nome);
    HashMap<String, Contato> listarContatos();
}
