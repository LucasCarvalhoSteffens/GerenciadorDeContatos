import java.util.Map;
import java.time.LocalDate;

public class GerenciadorDeContatos {
    private ContatoStorage storage;

    public GerenciadorDeContatos(ContatoStorage storage) {
        this.storage = storage;
    }

    public void adicionarContato(String nome, String telefone, LocalDate dataNascimento) {
        storage.adicionarContato(nome, telefone, dataNascimento);
    }

    public void removerContato(String nome) {
        storage.removerContato(nome);
    }

    public void buscarContato(String nome) {
        storage.buscarContato(nome);
    }

    public Map<String, String> listarContatos() {
        storage.listarContatos();
        return null;
    }
}
